package ch01_h_register.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch01_h_register.model.MemberBean;
import ch01_h_register.service.MemberService;

@WebServlet("/ch01_register/member.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> errorMessage = new HashMap<String, String>();
		request.setAttribute("ErrorMsgKey", errorMessage);
		
		request.setCharacterEncoding("UTF-8");
		Integer m_NO = null;
		String id = request.getParameter("mEmail");
		if(id==null || id.trim().length()==0) {
			errorMessage.put("AccountEmptyError","請輸入EMAIL");
		}
		String password = request.getParameter("mPassWord");
		if(password==null || id.trim().length()==0) {
			errorMessage.put("PasswordEmptyError", "密碼欄必須輸入");
		}
		String cpassword = request.getParameter("cPassWord");
		if(!cpassword.equals(password)) {
			errorMessage.put("MustbeSamePassword", "密碼欄與確認密碼欄必須一致");
		}
		String code = request.getParameter("identity");
		Integer codeint = null;
		if(code==null || id.trim().length()==0) {
			errorMessage.put("MustCheckIden", "請勾選身份");
		}else {
			codeint = Integer.valueOf(code);
		}
		if (errorMessage.isEmpty()) {
			MemberBean mb = new MemberBean(m_NO, id, password, codeint);
			try {
				MemberService service = new MemberService();
				service.persist(mb);
				request.setAttribute("memberBean", mb);
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
				return;
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			RequestDispatcher rd = request
					.getRequestDispatcher("/ch01_register/quickReg.jsp");
			rd.forward(request, response);
			return;
		}
	}

}
