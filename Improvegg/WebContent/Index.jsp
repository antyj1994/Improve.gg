
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
	
		<meta charset="ISO-8859-1">
		<title>improve.gg</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
		<link rel="stylesheet" href="common.css" type="text/css">
		
	</head>
	
	<body>
		
		<nav class="navbar navbar-expand-lg justify-content-between">
 			<a href="home" class="navbar-brand">
 				<h1>
 					<b>improve.gg</b>
 				</h1>
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
        				<a class="nav-link" href="#">Favourites</a>
      				</li>
      				<li class="nav-item">
       					<a class="nav-link" href="#">Pro Players</a>
      				</li>
    			</ul>	
  			</div>
		</nav>
	
		<div class="jumbotron">
        	<div class="container">
          		<h1 class="display-3">improve.gg</h1>
          		<p><b>LoL Statistics and Tips</b></p>
          		<hr class="my-4">
          		<form method="post" action="findSummoner">
  					<div class="form-row align-items-center">
  						<div class="col-auto my-1">
    						<input name="summonerName" type="text" class="form-control" id="summonerName" aria-describedby="emailHelp" placeholder="Enter Summoner's Name">
  						</div>
    					<div class="col-auto my-1">
      						<select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="region">
        						<option selected>EUW</option>
        						<option value="EUNE">EUNE</option>
        						<option value="NA">NA</option>
        						<option value="KR">KR</option>
							</select>
						</div>
						<button name="submit" type="submit" class="btn btn-success">Submit</button>
					</div>
				</form>
        	</div>
        </div>
        
        <h3>
			FIRST TIME USER?
		</h3>
		
        <div class="container">
        	<div class="row first-time-user-row justify-content-between">
        		<div class="col-lg-4">
					<img class="rounded-circle" src="//opgg-static.akamaized.net/images/site/index/1@2x.png" alt="" height="200" width="250">
					<h2>LIVE GAMES</h2>
					<p>Check out stats for your games</p>
				</div>
				<div class="col-lg-4">
					<img class="rounded-circle" src="//opgg-static.akamaized.net/images/site/index/2@2x.png" alt="" height="200" width="250">
					<h2>MATCH DETAILS</h2>
					<p>Find out the best builds</p>
				</div>
				<div class="col-lg-4">
					<img class="rounded-circle" src="//opgg-static.akamaized.net/images/site/index/3@2x.png" alt="" height="200" width="250">
					<h2>CHAMP ANALYTICS</h2>
					<p>Add depth to your knowledge</p>
				</div>
			</div>
		</div>
		
		<div class="container">
			<hr class="my-4">
		</div>
		
	  	<footer>
      		<div>
				<p>Page created by AntyJ</p>
			</div>
		</footer>
		
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>	
	
	</body>
</html>