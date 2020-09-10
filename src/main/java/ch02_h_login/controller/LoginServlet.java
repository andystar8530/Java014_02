package ch02_h_login.controller;

import java.io.IOException;
import java.util.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ch01_h_register.model.MemberBean;
import ch01_h_register.service.MemberService;

@WebServlet("/ch02_login/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Map<String, String> errorMsgMap = new HashMap<String, String>();
		request.setAttribute("ErrorMsgKey", errorMsgMap);
		String userId = request.getParameter("mEmail");
		String password = request.getParameter("mPassWord");
		String rm = request.getParameter("rememberMe");
		if (userId == null || userId.trim().length() == 0) {
			errorMsgMap.put("AccountEmptyError", "帳號欄必須輸入");
		}
		if (password == null || password.trim().length() == 0) {
			errorMsgMap.put("PasswordEmptyError", "密碼欄必須輸入");
		}
		if (!errorMsgMap.isEmpty()) {
			RequestDispatcher rd = request
					.getRequestDispatcher("/ch02_login/login.jsp");
			rd.forward(request, response);
			return;
		}
		MemberService ls = new MemberService();
		MemberBean mb = ls.checkIDPassword(userId, password);
		if (mb != null) {
			session.setAttribute("LoginOK", mb);
			request.getSession().setAttribute("passMb", mb);
		} else {
			errorMsgMap.put("LoginError", "該帳號不存在或密碼錯誤");
		}
		if (errorMsgMap.isEmpty()) {
			String contextPath = getServletContext().getContextPath();
			String target = (String) session.getAttribute("target");
			if (target != null) {
				session.removeAttribute("target");
				response.sendRedirect(contextPath + target);

			} else {
				if(mb.getM_Code()==0) {
					response.sendRedirect(contextPath + "/_newlyWed/newlywed.jsp");
				}else if(mb.getM_Code()==1) {
					response.sendRedirect(contextPath + "/displayPartnerInfo.do");
				}
			}
			return;
		} else {
			RequestDispatcher rd = request
					.getRequestDispatcher("/ch02_login/login.jsp");
			rd.forward(request, response);
			return;
		}
	}
}
