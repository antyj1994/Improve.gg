package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.parser.*;
import org.json.simple.parser.JSONParser;;

public class FindSummoner extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("summonerName");
		String region = req.getParameter("region");
		String reg = "euw1";
		switch (region) {
			case "EUW":
				reg = "euw1"; break;
			case "NA":
				reg = "na1"; break;
			
		}
		URL url = new URL("https://" + reg 
				+ ".api.riotgames.com/lol/summoner/v3/summoners/by-name/" +
				name + "?api_key=RGAPI-799f2900-0ce2-48fe-83e7-5531f919ac23");
		try {
			InputStream is = url.openStream();
		    JSONParser parser = new JSONParser();
		    
//			date = format.parse(dataNascita);			
//			Studente stud = new Studente(matricola, nome, cognome, date);
//			
//			IndirizzoDao indirizzoDao = DatabaseManager.getInstance().getDaoFactory().getIndirizzoDAO();
//			Indirizzo indir = indirizzoDao.findByPrimaryKey(Long.parseLong(indirizzo));			
//			stud.setIndirizzo(indir);
//			
//			StudenteDao studenteDao = DatabaseManager.getInstance().getDaoFactory().getStudenteDAO();
//			
//			studenteDao.save(stud);
//			studenteDao.setPassword(stud, password);
		    is.close();
//			
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<head><meta charset=\"ISO-8859-1\"><title>Summoner:</title><link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css\" integrity=\"sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb\" crossorigin=\"anonymous\"></head>");
			out.println("<body>"
					+ "<nav class=\"navbar navbar-expand-lg nav-light bg-light justify-content-between\"><a class=\"navbar-brand\"><b>improve.gg</b></a></nav>"
					+ "<nav class=\"navbar navbar-expand-lg navbar-dark bg-secondary\">" + 
					" 			<a class=\"navbar-brand text-light active\"><b>Menu</b></a>" + 
					"  			<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">" + 
					"    			<span class=\"navbar-toggler-icon\"></span>" + 
					"  			</button>" + 
					"  			<div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">" + 
					"    			<ul class=\"navbar-nav mr-auto\">" + 
					"      				<li class=\"nav-item\">" + 
					"       					<a class=\"nav-link\" href=\"#\">Home <span class=\"sr-only\">(current)</span></a>\r\n" + 
					"      				</li>" + 
					"      				<li class=\"nav-item\">" + 
					"        				<a class=\"nav-link\" href=\"#\">Champions</a>" + 
					"      				</li>" + 
					"      				<li class=\"nav-item\">" + 
					"       					<a class=\"nav-link\" href=\"#\">Pro Players</a>" + 
					"      				</li>" + 
					"    			</ul>" + 
					"  			</div>" + 
					"		</nav>");
			out.println("<div class=\"jumbotron\">" + 
					"        	<div class=\"container\">");
			out.println("<h1>We are retrieving data for the summoner</h1>");
			out.println(name);
			out.println(region);
			out.println("</div>" + url.toString() + "</div>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			e.printStackTrace();
		}	
			
	}
}
