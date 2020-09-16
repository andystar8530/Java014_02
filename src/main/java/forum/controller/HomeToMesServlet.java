package forum.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import forum.model.ForumBean;
import forum.service.ForumService;


@WebServlet("/HomeToMes")
public class HomeToMesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public HomeToMesServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		request.setCharacterEncoding("UTF-8");
		int f_id;
		try {
			f_id=Integer.valueOf(request.getParameter("f_id"));
		}catch(NumberFormatException e){
			f_id=1;
		}
		session.setAttribute("f_id", f_id);
		ForumService fs =new ForumService();
		ForumBean fb = fs.selectOne(f_id);
		session.setAttribute("fb", fb);

		RequestDispatcher rd =request.getRequestDispatcher("/_forum/messageboard.jsp");
		rd.forward(request, response);
		return;
	}

}
