package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;
import persistence.DatabaseManager;
import persistence.dao.AccountDao;

public class Register extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String username = (String) req.getParameter("username");
			String password = (String) req.getParameter("password");
			AccountDao dao = DatabaseManager.getInstance().getDaoFactory().getAccountDAO();
			Account account = dao.findByPrimaryKey(username);
			if (account != null){
				req.setAttribute("succes", false);
				req.setAttribute("messaggio", "Username already used");
			}
			else {
				if (username.length() < 4 || username.length() > 20) {
					req.setAttribute("success", false);
					req.setAttribute("messaggio", "Invalid Username");
				}
				else{
					if (password.length() < 4 || password.length() > 20) {
						req.setAttribute("success", false);
						req.setAttribute("messaggio", "Invalid Password");
					}
					else {
						account = new Account(username, password);
						dao.save(account);
						req.setAttribute("success", true);
						req.setAttribute("messaggio", "Successfully Registered");
					}
				}
			}
			RequestDispatcher dispacher = req.getRequestDispatcher("Register.jsp");
			dispacher.forward(req, resp);
		}catch(Exception e) {e.printStackTrace();}
	}
	
}
