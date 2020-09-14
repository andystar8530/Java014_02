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

import forum.model.ForumBean;
import forum.service.ForumService;


@WebServlet("/ForumServlet")
public class ForumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String> errorMessage =new HashMap<>();
		HttpSession session = request.getSession();
		request.setAttribute("ErrorMsgKey",errorMessage);
		request.setCharacterEncoding("UTF-8");
		Integer f_Id=null;
		String f_Title =request.getParameter("title");
		if(f_Title ==null || f_Title.trim().length()==0) {
			errorMessage.put("TitleEmpty", "(為你的文章 想個吸引人的標題吧)");
		}
		String f_Text =request.getParameter("text");
		if(f_Text ==null || f_Text.trim().length()==0) {
			errorMessage.put("TextEmpty", "(沒內容 你別鬧了)");
		}
		if(errorMessage.isEmpty()){
			ForumBean fb =new ForumBean(f_Id,f_Title, f_Text);
			try {
				ForumService service=new ForumService();
				service.persist(fb);
				request.setAttribute("ForumBean", fb);
				ForumBean mb= service.getMB(1);
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
			RequestDispatcher rd =request.getRequestDispatcher("/_forum/publish.jsp");
			rd.forward(request, response);
			return;
		}
	}

}
