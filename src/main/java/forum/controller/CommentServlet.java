package forum.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import forum.model.CommentBean;
import forum.service.CommentService;



@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	 public CommentServlet() {
	        super();
	        
	    }
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String> errorMessage =new HashMap<>();
		HttpSession session = request.getSession();
		request.setAttribute("ErrorMsgKey",errorMessage);
		request.setCharacterEncoding("UTF-8");
		Integer c_Id=null;
		Integer c_Postid=1;
		String c_Text =request.getParameter("ctext");
		if(c_Text ==null || c_Text.trim().length()==0) {
			errorMessage.put("TitleEmpty", "(為你的文章 想個吸引人的標題吧)");
		}
		
		if(errorMessage.isEmpty()){
			CommentBean cb =new CommentBean(c_Id,c_Postid,c_Text);
			try {
				CommentService service=new CommentService();
				service.persist(cb);
				request.setAttribute("CommentBean", cb);
				CommentBean mb= service.getMB(c_Id);
				session.setAttribute("messageBoard", mb);
				RequestDispatcher rd =request.getRequestDispatcher("/_forum/messageboard.jsp");
				rd.forward(request, response);
				return;
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			RequestDispatcher rd =request.getRequestDispatcher("/_forum/messageboard.jsp");
			rd.forward(request, response);
			return;
		}
	}

}