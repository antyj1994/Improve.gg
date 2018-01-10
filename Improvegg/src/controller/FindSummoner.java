package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.*;
import net.rithms.riot.api.RiotApi;

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
		    is.close();
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<head><meta charset=\"ISO-8859-1\"><title>Summoner:</title>"
					+ "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css\" integrity=\"sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb\" crossorigin=\"anonymous\">"
					+ "<link rel=\"stylesheet\" href=\"css//common.css\" type=\"text/css\">"
					+ "</head>");
			out.println("<body>" +
					"<nav class=\"navbar navbar-expand-lg justify-content-between\">\r\n" + 
					" 			<a class=\"navbar-brand\">\r\n" + 
					" 				<h1>\r\n" + 
					" 					<b>improve.gg</b>\r\n" + 
					" 				</h1>\r\n" + 
					" 			</a>\r\n" + 
					"  			<button class=\"btn btn-primary\">Login</button>\r\n" + 
					"		</nav>\r\n" + 
					"		\r\n" + 
					"		<nav class=\"navbar navbar-expand-lg navbar-dark\">\r\n" + 
					" 			<a class=\"navbar-brand text-light active\"><b>Menu</b></a>\r\n" + 
					"  			<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n" + 
					"    			<span class=\"navbar-toggler-icon\"></span>\r\n" + 
					"  			</button>\r\n" + 
					"  			<div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n" + 
					"    			<ul class=\"navbar-nav mr-auto\">\r\n" + 
					"      				<li class=\"nav-item\">\r\n" + 
					"       					<a class=\"nav-link\" href=\"Index.html\">Home <span class=\"sr-only\">(current)</span></a>\r\n" + 
					"      				</li>\r\n" + 
					"      				<li class=\"nav-item\">\r\n" + 
					"        				<a class=\"nav-link\" href=\"#\">Champions</a>\r\n" + 
					"      				</li>\r\n" + 
					"      				<li class=\"nav-item\">\r\n" + 
					"       					<a class=\"nav-link\" href=\"Summoner.html\">Pro Players</a>\r\n" + 
					"      				</li>\r\n" + 
					"    			</ul>	\r\n" + 
					"  			</div>\r\n" + 
					"		</nav>");
			out.println("<div class=\"jumbotron\">" + 
					"        	<div class=\"container\">");
			out.println("<h1>We are retrieving data for the summoner</h1>"
						+ "<hr class=\"my-4\">");
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
