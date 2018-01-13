package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckLogout extends HttpServlet{
	
	/*@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		PrintWriter out = resp.getWriter();
		if (username != null){
			req.setAttribute("loggato", false);
		}else{
			req.setAttribute("loggato", true);
		}
		req.setAttribute("messaggio", username);
		RequestDispatcher dispacher = req.getRequestDispatcher("Login.jsp");
		dispacher.forward(req, resp);
	}*/
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.setAttribute("username", null);
		session.setAttribute("logged", false);
		req.setAttribute("loggato", false);
		RequestDispatcher dispacher = req.getRequestDispatcher("Login.jsp");
		dispacher.forward(req, resp);
	}
	
}
