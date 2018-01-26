
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
	
		<meta charset="ISO-8859-1">
		<title>improve.gg</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
		<link rel="stylesheet" href="common.css" type="text/css">
		<link rel="stylesheet" href="css//summoner.css" type="text/css">
		
	</head>
	
	<body>
		
		<div class="container-fluid body-container">
		<nav class="navbar navbar-expand-lg justify-content-between">
 			<a href="home" class="navbar-brand">
 				<img class="logo" src="images//im-prove.png" height="80" width="180">
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
	
		<c:if test="${loggato}">
			<div class="contianer-fluid main-container">
				<hr class="my-2">
				<div class="header">
					<h2><b>${message}</b></h2>
					<p>Favourite Summoners</p>
				</div>
				<div class="container-fluid matches-container">
					<c:forEach var="partita" items="${favourites}">
						<hr class="my-2">
					 	<div class="container row match-container justify-content-between">
					 		<div class="game-stats col">
								<form action="findSummoner" method="post">
								   <input type="hidden" name="summonerName" value="${partita.nome}" />
								   <input type="hidden" name="region" value="EUW" />
								   <a href="javascript:;" onclick="
								   		javascript:
									    $(this).parents('form').submit();">
									    
									    ${partita.nome}
									</a> 
								</form>
					 		</div>
					 	</div>
					</c:forEach>
					<hr class="my-2">
				</div>
			</div>
		</c:if>
		<c:if test="${not loggato}">
			<div class="contianer-fluid main-container">
				<hr class="my-2">
				<div class="header">
					<h2>
						<b>
							Please Login Before Accessing Favourites
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
		
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>	
	
	</body>
</html>