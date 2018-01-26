
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

	<head>
	
		<meta charset="ISO-8859-1">
		<title>Login - improve.gg</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
		<link rel="stylesheet" href="common.css" type="text/css">
	
	</head>
	
	<body>
		
		<div class="container-fluid body-container">
		<nav class="navbar navbar-expand-lg justify-content-between">
 			<a href="home" class="navbar-brand">
 				<img class="logo" src="images//im-prove.png" height="80" width="180">
 			</a>
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
		
  		<c:if test="${not loggato}">
			<div class="jumbotron">
	        	<div class="container">
	          		<h1 class="display-3">Login</h1>	
	          		<hr class="my-4">
	          		<p><b>Enter Account and Password </b></p>
	          		<form method="post" action="checkLogin">
	  					<div class="form-row align-items-center">
	  						<div class="col-auto my-1">
	    						<input name="username" type="text" class="form-control" id="summonerName" aria-describedby="emailHelp" placeholder="Enter Username">
	  						</div>
	    					<div class="col-auto my-1">
	      						<input name="password" type="password" class="form-control" id="summonerName" aria-describedby="emailHelp" placeholder="Enter Password">
							</div>
							<button name="submit" type="submit" class="btn btn-primary">Login</button>
						</div>
					</form>
	          		<hr class="my-4">
	          		<p><b>Don't have an Account?</b></p>
	          		<form method="post" action="register">
	  					<div class="form-row align-items-center">
	  						<div class="col-auto my-1">
	    						<input name="username" type="text" class="form-control" id="summonerName" aria-describedby="emailHelp" placeholder="Enter Username">
	  						</div>
	    					<div class="col-auto my-1">
	      						<input name="password" type="password" class="form-control" id="summonerName" aria-describedby="emailHelp" placeholder="Enter Password">
							</div>
							<button name="submit" type="submit" class="btn btn-warning">Register</button>
						</div>
					</form>
	        	</div>
	        </div>
        </c:if>
        
        <c:if test="${loggato}">
	        <div class="jumbotron">
	        	<div class="container">
	          		<h1 class="display-3">Logged as: ${messaggio}</h1>
	          		<hr class="my-4">
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
	</body>
	
</html>