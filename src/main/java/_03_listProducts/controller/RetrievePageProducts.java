package _03_listProducts.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _01_register.model.MemberInfoBean;
//import _01_register.model.MemberBean;
import _03_listProducts.model.ProductBean;
import _03_listProducts.service.ProductService;
import _03_listProducts.service.impl.ProductServiceImpl;

@WebServlet("/_03_listProducts/DisplayPageProducts")
//本控制器負責進行必要的前置作業，以便Dao取回某一頁的商品資料
public class RetrievePageProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 先取出session物件
		HttpSession session = request.getSession(false);

		// 如果session物件不存在
		if (session == null) {
			// 請使用者登入
			response.sendRedirect(response.encodeRedirectURL(
					request.getContextPath() + "/_02_login/login.jsp"));
			return;
		}
		// 登入成功後，Session範圍內才會有LoginOK對應的MemberBean物件
		MemberInfoBean mb = (MemberInfoBean) session.getAttribute("LoginOK");
		// 取出使用者的m-No，後面的Cookie會用到 
		int m_No = mb.getM_No();
		// BookService介面負責讀取資料庫內Book表格內某一頁的書籍資料，並能新增、修改、刪除
		// 書籍資料等。
		
		// 讀取瀏覽送來的 pageNo
		String pageNoStr = request.getParameter("pageNo");
		// 如果讀不到，直接點選主功能表的『購物』就不會送 pageNo給後端伺服器
		if (pageNoStr == null) {  
			pageNo = 1;
			// 讀取瀏覽器送來的所有 Cookies
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				// 逐筆檢視Cookie內的資料
				for (Cookie c : cookies) {
//					if (c.getName().equals(M_Id + "pageNo")) {
					if (c.getName().equals(m_No + "pageNo")) {
						try {
							pageNo = Integer.parseInt(c.getValue().trim());
						} catch (NumberFormatException e) {
							;
						}
						break;
					}
				}
			}
		} else {
			try {
				pageNo = Integer.parseInt(pageNoStr.trim());
			} catch (NumberFormatException e) {
				pageNo = 1;
			}
		}
		ProductService service = new ProductServiceImpl(); 
		//
		// 讀取一頁的書籍資料之前，告訴service，現在要讀哪一頁
		// service.setPageNo(pageNo);
		request.setAttribute("baBean", service);
		// service.getPageBooks()方法開始讀取一頁的書籍資料
		Map<Integer, ProductBean> bookMap = service.getPageProducts(pageNo);
		session.setAttribute("pageNo", String.valueOf(pageNo));
		request.setAttribute("totalPages", service.getTotalPages());
		// 將讀到的一頁資料放入request物件內，成為它的屬性物件
		session.setAttribute("products_DPP", bookMap);

		// 使用Cookie來儲存目前讀取的網頁編號，Cookie的名稱為memberId + "pageNo"
		// -----------------------
		Cookie pnCookie = new Cookie(m_No + "pageNo", String.valueOf(pageNo));
	    // 設定Cookie的存活期為30天
		pnCookie.setMaxAge(30 * 24 * 60 * 60);
	    // 設定Cookie的路徑為 Context Path		
		pnCookie.setPath(request.getContextPath());
		// 將Cookie加入回應物件內
		response.addCookie(pnCookie);
		// -----------------------
		// 交由listBooks.jsp來顯示某頁的書籍資料，同時準備『第一頁』、
		// 『前一頁』、『下一頁』、『最末頁』等資料
		RequestDispatcher rd = request.getRequestDispatcher("listProducts.jsp");
		rd.forward(request, response);
		return;

	}
}
