package partner_h.partnerInfoEdit_h.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ch01_h_register.model.MemberBean;
import partner_h.partnerInfoEdit_h.model.PartnerBean;
import partner_h.partnerInfoEdit_h.service.PartnerService;
import partner_h.partnerInfoEdit_h.service.Impl.PartnerServiceImpl;


@WebServlet("/displayPartnerInfo.do")
public class DisplayPartnerInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 doGet(req, resp);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		if (session == null) {      // 使用逾時
			response.sendRedirect(getServletContext().getContextPath() + "/index.jsp");
			return;
		}
		PartnerService service = new PartnerServiceImpl();
		// 登入成功後，Session範圍內才會有LoginOK對應的MemberBean物件
//		MemberInfoBean mb = (MemberInfoBean) session.getAttribute("LoginOK");
		MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
		PartnerBean bean = service.getPartner(mb.getM_No());
		session.setAttribute("partnerBean",bean);
		RequestDispatcher rd = request.getRequestDispatcher("/partner_h/partner_h.jsp");
		rd.forward(request, response);
		return;
	}

}
