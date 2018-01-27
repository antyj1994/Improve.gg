
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

	<head>
		
		<meta charset="ISO-8859-1">
		<title>improve.gg</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
		<link rel="stylesheet" href="common.css" type="text/css">
		<link rel="stylesheet" href="css//summoner.css" type="text/css">
		<link rel="stylesheet" href="css//tool.css" type="text/css">
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script src="js/Sum.js"></script>
	</head>
	
	<body>
		<div class="container-fluid body-container">
		<nav class="navbar navbar-expand-lg justify-content-between">
	 		<a href="home" class="navbar-brand">
	 			<img class="logo" src="images//im-prove.png" height="80" width="180">
	 			<div class="tooltip">YOU DIPSHIT</div>
	 		</a>
	  		<c:if test="${not loggato}">
	  			<a href="checkLogin" role="button" class="btn btn-primary" >Login</a>
  			</c:if>
  			<c:if test="${loggato}">
  				<div>
  					<p class="login-label"><b> ${messaggio} </b></p>
  					<a href="checkLogout" class="btn btn-danger" role="button">Logout</a>
  				</div>
  			</c:if>
		</nav>
			
		<nav class="navbar navbar-expand-lg navbar-dark">
 			<a class="navbar-brand text-light active"><b>Menu</b></a>
  			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    			<span class="navbar-toggler-icon"></span>
  			</button>
  			<div class="collapse navbar-collapse" id="navbarSupportedContent">
    			<ul class="navbar-nav mr-auto">
      				<li class="nav-item">
       					<a class="nav-link" href="home">Home <span class="sr-only">(current)</span></a>
      				</li>
      				<li class="nav-item">
        				<a class="nav-link" href="findFavourites">Favourites</a>
      				</li>
      				<li class="nav-item">
       					<a class="nav-link" href="ProPlayers.html">Pro Players</a>
      				</li>
    			</ul>	
  			</div>
		</nav>
		
		<c:if test="${trovato}">
			<div class="container-fluid main-container">
				<hr class="my-2">
				<div class="header">
					<div class="container-fluid row justify-content-around">
						<div class="col">
						</div>
						<div class="col">
							<h2><b id="sumName">${sumName}</b></h2>
							<p>Recent Matches</p>
						</div>
						<div class="col">
							<div class="container">
								<hr class="my-2">
								<form method="POST" action="findFavourites">
									<p>
									
										Add To Favourites
										<input type="submit" name="summonerName" value="${sumName}" class="btn btn-primary" role="button">
									</p>
								</form>
							</div>
						</div>
					</div>
				</div>
				<div>
				<div class="container-fluid matches-container">
					<c:if test="${not emptyMatches}">
						<c:forEach var="partita" items="${partita}">
							<hr class="my-3">
							<div class="jq-match-container">
							 	<div class="container-fluid row match-container justify-content-between">
							 		<div class="game-stats col-sm">
							 			<div>
							 				${partita.gameMode}
							 				<hr class="my-1">
							 				${partita.result}
							 				<hr class="my-1">
							 				${partita.gameDuration}
							 			</div>
							 		</div>
							 		<div class="summ-stats col">
							 			<div class="row">
								 			<div class="col">
								 				<img src="${partita.champUrl}" class="rounded champions-image" width="75" height="75" data-toggle="tooltip" title="<img src='${partita.champ}'>">
								 				<footer>
								 					${partita.champName}
								 				</footer>
								 			</div>
								 			<div class="col">
								 				<img src="${partita.spellUrl1}" class="rounded champions-image" width="50" height="50" title="<img src='${partita.spell1}'>" data-toggle="tooltip">
								 				<img src="${partita.spellUrl2}" class="rounded champions-image" width="50" height="50" title="<img src='${partita.spell2}'>" data-toggle="tooltip">
								 			</div>
							 			</div>
							 		</div>
							 		<div class="kda col">
							 			<div class="row">
							 				<div class="champ-level col">
									 			Level ${partita.champLevel}
									 			<hr class="my-1">
									 			${partita.cs} CS
									 			<hr class="my-1">
									 			${partita.golds} K
									 		</div>
							 				<div class="kda col">
							 					${partita.kda}
							 					<hr class="my-2">
							 					${partita.lane}
							 				</div>
							 			</div>
							 		</div>
							 		<div class="items col">
							 		
								 		<div class="container items1">
								 			<img src="${partita.itemUrl0}" class="rounded champion-image" width="30" height="30" title="<img src='${partita.item0}'>" data-toggle="tooltip" >
								 			<img src="${partita.itemUrl1}" class="rounded champion-image" width="30" height="30" title="<img src='${partita.item1}'>" data-toggle="tooltip" >
								 			<img src="${partita.itemUrl2}" class="rounded champion-image" width="30" height="30" title="<img src='${partita.item2}'>" data-toggle="tooltip" >
								 			<hr class="my-2">
								 		</div>
								 		<div class="container items2">
								 			<img src="${partita.itemUrl3}" class="rounded champion-image" width="30" height="30" title="<img src='${partita.item3}'>" data-toggle="tooltip" >
								 			<img src="${partita.itemUrl4}" class="rounded champion-image" width="30" height="30" title="<img src='${partita.item4}'>" data-toggle="tooltip" >
								 			<img src="${partita.itemUrl5}" class="rounded champion-image" width="30" height="30" title="<img src='${partita.item5}'>" data-toggle="tooltip" >
								 		</div>
								 	
								 	</div>
							 		<div class="teams col-md">
							 			<div class="team-row row">
								 			<div class="container team1">
												 <c:forEach var="champ" items="${partita.champs}">
													  <img src="${champ}" class="rounded champion-image" width="30" height="30">
												 </c:forEach>
								 				<hr class="my-2">
									 		</div>
									 		<div class="container team2">
									 			<c:forEach var="champ" items="${partita.champs2}">
													  <img src="${champ}" class="rounded champion-image" width="30" height="30">
												 </c:forEach>
									 		</div>
									 	</div>
							 		</div>
							 		
							 		
							 		
							 		
							 		
							 		
							 		<div class="btn-group dropdown">
								 		<button type="button" class="btn btn-secondary dropdown-toggle booldropdownt" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    								<span class="sr-only">Toggle Dropdown</span>
		  								</button>
	  								</div>
	  								
	  								
	  								
	  								
	  								
	  								
							 	</div>
							 	<div class="jq-dropdown-menu container-fluid">
							 		<div id="resultdiv">
							 			
							 		</div>
							 	</div>
						 	</div>
						</c:forEach>
					</c:if>
					<c:if test="${emptyMatches}">
						<hr class="my-2">
					 	<h2>
							<b>
								${causa}
							</b>
						</h2>
					</c:if>	
					<hr class="my-3">
					</div>
						<hr class="my-3">
						<div>
							<button type="button" class="btn btn-primary load-btn" id="loadbtn">Load More</button>
						</div>
						<hr class="my-3">
					<hr class="my-2">
				</div>
			</div>
		</c:if>
		<c:if test="${not trovato}">
			<div class="container-fluid main-container">
				<hr class="my-2">
				<div class="header">
					<h2>
						<b>
							${causa}
						</b>
					</h2>
				</div>
			</div>
		</c:if>
		
		<div class="container">
			<hr class="my-4">
		</div>
		
	  	<footer>
      		<div>
				<p>Page created by Limited Budget</p>
			</div>
		</footer>
		</div>
		
		<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
	</body>
	
</html>