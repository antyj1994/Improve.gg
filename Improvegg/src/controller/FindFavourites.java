package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Favourite;
import persistence.DatabaseManager;
import persistence.dao.FavouriteDao;

public class FindFavourites extends HttpServlet{
	
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
			FavouriteDao dao = DatabaseManager.getInstance().getDaoFactory().getFavouriteDAO();
			List<Favourite> favourites = dao.findByAccount(username);
			req.setAttribute("favourites", favourites);
		}else {
			req.setAttribute("loggato", false);
		}
		req.setAttribute("messaggio", username);
		RequestDispatcher dispacher = req.getRequestDispatcher("Login.jsp");
		dispacher.forward(req, resp);
	}
	
}
