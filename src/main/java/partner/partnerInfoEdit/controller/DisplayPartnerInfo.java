package partner.partnerInfoEdit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _01_register.model.MemberInfoBean;
import partner.partnerInfoEdit.dao.PartnerDao;
import partner.partnerInfoEdit.dao.Impl.PartnerDaoImpl_Jdbc;
import partner.partnerInfoEdit.model.PartnerBean;


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
		PartnerDao dao = new PartnerDaoImpl_Jdbc();
		// 登入成功後，Session範圍內才會有LoginOK對應的MemberBean物件
		MemberInfoBean mb = (MemberInfoBean) session.getAttribute("LoginOK");
		PartnerBean bean = dao.getPartner(mb.getM_No());
		session.setAttribute("partnerBean",bean);
		RequestDispatcher rd = request.getRequestDispatcher("/partner/partner.jsp");
		rd.forward(request, response);
		return;
	}

}
