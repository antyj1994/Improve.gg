package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import persistence.AccountCredenziali;
import persistence.DatabaseManager;
import persistence.dao.AccountDao;

public class CheckLogin extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		boolean isLogged = false;
		if (session.getAttribute("logged") != null) {
			isLogged = (boolean) session.getAttribute("logged");
		}
		if (username != null && isLogged){
			req.setAttribute("loggato", true);
		}else {
			req.setAttribute("loggato", false);
		}
		req.setAttribute("messaggio", username);
		RequestDispatcher dispacher = req.getRequestDispatcher("Login.jsp");
		dispacher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String username = (String) req.getParameter("username");
		String password = (String) req.getParameter("password");
		AccountDao dao = DatabaseManager.getInstance().getDaoFactory().getAccountDAO();
		Account account = dao.findByPrimaryKey(username);
		boolean isLogged = false;
		try {
			isLogged = (boolean)session.getAttribute("logged");
		} catch (NullPointerException e) {}
		if (!isLogged) {
			req.setAttribute("giaLoggato", false);
			if (account != null){
				if (password.equals(account.getPassword())){
					session.setAttribute("username", username);
					session.setAttribute("logged", true);
					req.setAttribute("loggato", true);
					req.setAttribute("messaggio", username);
				}
				else {
					req.setAttribute("loggato", false);
					req.setAttribute("messaggio", "Wrong Password!");
				}
			}
			else {
				req.setAttribute("loggato", false);
				req.setAttribute("messaggio", "Account Not Found!");
			}
		}
		else {
			req.setAttribute("loggato", true);
			req.setAttribute("messaggio", ((String)session.getAttribute("username")));
			req.setAttribute("giaLoggato", true);
		}
		RequestDispatcher dispacher = req.getRequestDispatcher("CheckLogin.jsp");
		dispacher.forward(req, resp);
	}
}
