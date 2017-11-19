<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Animal Shelter Management</title>
		<link href="<c:url value='/static/css/style.css' />"  rel="stylesheet"></link>
		<link href="<c:url value='/static/css/skel.css' />" rel="stylesheet"></link>
		<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
		<script src="./static/js/jquery.min.js"></script>
		<script src="./static/js/jquery.dropotron.min.js"></script>
		<script src="./static/js/skel.min.js"></script>
		<script src="./static/js/skel-layers.min.js"></script>
		<script src="./static/js/init.js"></script>

</head>
</head>
<body class = "wrapper style1">
	<!-- Header Wrapper -->
			<div class="wrapper style1">
			
			<!-- Header -->
				<div id="header">
					<div class="container">
							
						<!-- Logo -->
							<h1><a href="<c:url value='/main' />" id="logo">Animal Shelter</a></h1>
						
						<!-- Nav -->
							<nav id="nav">
								<ul>
									<li class="active"><a href="#">Home</a></li>
									<li>
										<a href="">Main Menu</a>
										<ul>
											
											<li><a href="<c:url value='/addanimal' />" class="btn btn-success custom-width">Add an Animal</a></li>
											<li><a href="<c:url value='/animalslist' />">Adopt an Animal</a></li>
											<li>
												<a href="">List Animals</a>
												<ul>
													<li><a href="<c:url value='/animalslist' />">List Animals in Shelter</a></li>
													<li><a href="<c:url value='adoptedlist' />">List Adopted Animals</a></li>
													<li><a href="<c:url value='searchAnimal' />">Search Animals in Shelter</a></li>
												</ul>
											</li>
										</ul>
									</li>
									<li><a href="<c:url value='/no-sidebar' />">About</a></li>
								</ul>
							</nav>
	
					</div>
				</div>
				
			<!-- Banner -->
				<div id="banner">
					<section class="container">
						<h2>Animal Shelter Management</h2>
						<span>For the love of animals</span>
						<span>Dear <strong>${loggedinuser}</strong>, Welcome to AnimalShelter.</span>
					</section>
				</div>

			</div>
		
</body>
</html>