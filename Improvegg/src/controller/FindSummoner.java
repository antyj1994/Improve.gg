package controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.*;

import model.Champion;
import model.Item;
import model.Spell;
import model.jsp.Partita;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.match.dto.Match;
import net.rithms.riot.api.endpoints.match.dto.MatchList;
import net.rithms.riot.api.endpoints.match.dto.MatchReference;
import net.rithms.riot.api.endpoints.match.dto.Participant;
import net.rithms.riot.api.endpoints.match.dto.ParticipantStats;
import net.rithms.riot.api.endpoints.match.dto.Rune;
import net.rithms.riot.api.endpoints.match.dto.TeamStats;
import net.rithms.riot.api.endpoints.static_data.dto.Passive;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;
import net.rithms.riot.constant.Platform;
import persistence.DAOFactory;
import persistence.DatabaseManager;
import persistence.dao.ChampionDao;
import persistence.dao.FavouriteDao;
import persistence.dao.ItemDao;
import persistence.dao.SpellDao;

public class FindSummoner extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
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
			
		try {
			
			ApiConfig config = new ApiConfig().setKey("RGAPI-bee3b60a-75df-48ed-80c1-72fb6466df8c");
			RiotApi api = new RiotApi(config);
			String name = req.getParameter("summonerName");
			String region = req.getParameter("region");
			Summoner summoner = null;
			boolean trovato = true;
			Platform pl = Platform.EUW;
			switch (region) {
				case "EUW":
					pl = Platform.EUW; break;
				case "NA":
					pl = Platform.NA; break;
			}
			try {
				summoner = api.getSummonerByName(pl, name);
			}catch(RiotApiException e) {
				req.setAttribute("trovato", false);
				trovato = false;
				String message = e.getMessage();
				if (message.startsWith("404")) {
					req.setAttribute("causa", "Summoner Not Found!");
				}
				else if (message.startsWith("40")) {
					req.setAttribute("causa", "Sorry! We currently can't retrieve any data");
				}
			}
			if (trovato) {
				req.setAttribute("trovato", true);
				long id = summoner.getAccountId();
				MatchList ml = null;
				boolean matchTrovati = true;
				try {
					ml = api.getRecentMatchListByAccountId(pl, id); //GETS THE RECENT MATCHLIST  BUG #1
				} catch (RiotApiException e) {
					req.setAttribute("emptyMatches", true);
					req.setAttribute("causa", "Sorry! We currently can't retrieve your matches");
					matchTrovati = false;
				}
				if (matchTrovati) {
					List<MatchReference> l = ml.getMatches();
					List<Partita> partite = new LinkedList<>();
					Partita partita = null;
					int onlyLast = 0; //GETS ONLY THE LAST GAME
					for(Iterator<MatchReference> it = l.iterator(); it.hasNext() && onlyLast < 5;){
						MatchReference m = it.next();
						
						long gameId = m.getGameId();
						Match match = api.getMatch(pl, gameId); //GET THE MATCH
						Participant part = match.getParticipantByAccountId(id); //GET THE PLAYER
						ParticipantStats ps = part.getStats(); //GET THE PLAYER STATS
						
						String wonOrLost = null;
						List<TeamStats> lts = match.getTeams();
						for (TeamStats ts : lts) {
							if (ts.getTeamId() == part.getTeamId()) {
								wonOrLost = ts.getWin();
							}
						}
						
						onlyLast++;
						
						//WORKING ON
						
						
						DAOFactory daoFactory = DatabaseManager.getInstance().getDaoFactory();
						ChampionDao championDao = daoFactory.getChampionDAO();
						Champion champion = championDao.findByPrimaryKey(part.getChampionId());
					
						ItemDao itemDao = daoFactory.getItemDAO();
						Item item0 = itemDao.findByPrimaryKey(ps.getItem0());
						Item item1 = itemDao.findByPrimaryKey(ps.getItem1());
						Item item2 = itemDao.findByPrimaryKey(ps.getItem2());
						Item item3 = itemDao.findByPrimaryKey(ps.getItem3());
						Item item4 = itemDao.findByPrimaryKey(ps.getItem4());
						Item item5 = itemDao.findByPrimaryKey(ps.getItem5());
						SpellDao spellDao = daoFactory.getSpellDAO();
						Spell spell1 = spellDao.findByPrimaryKey(part.getSpell1Id());
						Spell spell2 = spellDao.findByPrimaryKey(part.getSpell2Id());
						
						partita = new Partita();
						partita.setGameMode(match.getGameMode());
						partita.setResult(wonOrLost);
						partita.setGameDuration(match.getGameDuration());
						partita.setChampName(champion.getNome());
						partita.setChampLevel(ps.getChampLevel());
						partita.setKda(ps.getKills()+"/"+ps.getDeaths()+"/"+ps.getAssists());
						partita.setGolds(ps.getGoldEarned());
						partita.setCs(ps.getTotalMinionsKilled());
						partita.setVisionScore((int)ps.getVisionScore());
						partita.setLane(m.getLane());
						partita.setChampUrl(champion.getUrl());
						partita.setSpellUrl1(spell1.getUrl());
						partita.setSpellUrl2(spell2.getUrl());
						
						partita.setSpell1(spell1.getTooltip());
						partita.setSpell2(spell2.getTooltip());
						
						if (item0!=null) {
						partita.setItemUrl0(item0.getUrl());
						partita.setItem0(item0.getTooltip());
						}
						else {
							partita.setItemUrl0("items//No_item.png");
							partita.setItem0("items//No_item.png");
						}
						
						if (item1!=null) {
							partita.setItemUrl1(item1.getUrl());
							partita.setItem1(item1.getTooltip());
						}
						else {
							partita.setItemUrl1("items//No_item.png");
							partita.setItem1("items//No_item.png");
						}
						
						if(item2!=null) {
							partita.setItemUrl2(item2.getUrl());
							partita.setItem2(item2.getTooltip());
						}
						else {
							partita.setItemUrl2("items//No_item.png");
							partita.setItem2("items//No_item.png");
						}
						
						if(item3!=null) {
							partita.setItemUrl3(item3.getUrl());
							partita.setItem3(item3.getTooltip());
						}
						else {
							partita.setItemUrl3("items//No_item.png");
							partita.setItem3("items//No_item.png");
						}
						
						if(item4!=null) {
							partita.setItemUrl4(item4.getUrl());
							partita.setItem4(item4.getTooltip());
						}
						else {
							partita.setItemUrl4("items//No_item.png");
							partita.setItem4("items//No_item.png");
						}
						
						if(item5!=null) {
							partita.setItemUrl5(item5.getUrl());
							partita.setItem5(item5.getTooltip());
						}
						else {
							partita.setItemUrl5("items//No_item.png");
							partita.setItem5("items//No_item.png");
						}
						
						
						partite.add(partita);
					}
					req.setAttribute("partita", partite);
				}
				req.setAttribute("sumName", summoner.getName());
				req.setAttribute("sumLevel", summoner.getSummonerLevel());
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		RequestDispatcher dispacher = req.getRequestDispatcher("Summoner.jsp");
		dispacher.forward(req, resp);
			
	}
	
}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*String name = req.getParameter("summonerName");
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
				name + "?api_key=RGAPI-a65bada1-52a8-4ef1-a893-72fc35ce3264");
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
		}*/	
		
