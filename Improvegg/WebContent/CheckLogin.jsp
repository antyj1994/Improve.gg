
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
        				<a class="nav-link" href="findFavourites">Favourites</a>
      				</li>
      				<li class="nav-item">
       					<a class="nav-link" href="#">Pro Players</a>
      				</li>
    			</ul>	
  			</div>
		</nav>
		
  		<c:if test="${not loggato}">
			<div class="jumbotron">
	        	<div class="container">
	          		<h1 class="display-3"> ${messaggio} </h1>
	          		<hr class="my-4">
	        	</div>
	        </div>
        </c:if>
        
        <c:if test="${loggato}">
	        <div class="jumbotron">
	        	<div class="container">
	        		<c:if test="${not giaLoggato}">
	          			<h1 class="display-3">Successfully Logged As ${messaggio}</h1>
	          			<hr class="my-4">
	          		</c:if>
	          		<c:if test="${giaLoggato}">
	          			<h1 class="display-3">You Are Already Logged As ${messaggio}</h1>
	          			<hr class="my-4">
	          		</c:if>
	        	</div>
	        </div>
        </c:if>
		
		<div class="container">
			<hr class="my-4">
		</div>
		
	  	<footer>
      		<div>
				<p>Page created by AntyJ</p>
			</div>
		</footer>
		
	</body>
	
</html>