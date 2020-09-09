package newlywed.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch01_h_register.model.MemberBean;
import ch01_h_register.service.MemberService;

@WebServlet("/_newlyWed/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		

		String email = request.getParameter("updateEmail").trim();
		String uppassword = request.getParameter("updatePswd").trim();
		String id = request.getParameter("updateId").trim();
		String phone = request.getParameter("updatePhone").trim();
		String name = request.getParameter("updateName").trim();
		String avTime = request.getParameter("avTime").trim();

		MemberService ls = new MemberService();
		MemberBean mb = (MemberBean) request.getSession().getAttribute("passMb");
		System.out.println(mb);

		mb.setM_Name(name);
		mb.setM_Phone(phone);
		ls.updateMember(mb);
		RequestDispatcher rd = request.getRequestDispatcher("/_newlyWed/newlywed.jsp");
		rd.forward(request, response);
		return;

	}

}
