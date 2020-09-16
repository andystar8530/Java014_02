package forum.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import forum.model.ForumBean;
import forum.service.ForumService;


@WebServlet("/ForumHomeServlet")
public class ForumHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ForumHomeServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		ForumService fs=new ForumService();
		List<ForumBean> li=fs.selectAll();
		session.setAttribute("atitle", li);
		
		RequestDispatcher rd =request.getRequestDispatcher("/_forum/talk.jsp");
		rd.forward(request, response);
	}

}
