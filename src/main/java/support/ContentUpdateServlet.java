package support;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/support/ContentUpdateServlet.do")
public class ContentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String paid = request.getParameter("paid");
		String mytext = request.getParameter("mytext");
		MemberBean mb = new MemberBean();
		mb.setPAID(Integer.parseInt(paid));
		mb.setPACONTENT(mytext);
		MemberService service = new MemberService();
		boolean result = service.updatePACONTENT(mb);
		
		
//		String targetUrl = result ? "/AlterServlet.java" : "../index.jsp";
//		String targetUrl = result ? "../support/alterTable.jsp" : "../index.jsp";
//		response.sendRedirect(targetUrl);	這是學長教的三元訊算子	
		
		MemberBean bean = service.select(paid);
		request.setAttribute("plateannouncement", bean);
		request.getRequestDispatcher("alterTable.jsp").forward(request, response);
				
	}
}
