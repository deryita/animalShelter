<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value='/static/css/style.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/skel.css' />" rel="stylesheet"></link>
<link rel="stylesheet" type="text/css"
	href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
<script src="./static/js/jquery.min.js"></script>
<script src="./static/js/jquery.dropotron.min.js"></script>
<script src="./static/js/skel.min.js"></script>
<script src="./static/js/skel-layers.min.js"></script>
<script src="./static/js/init.js"></script>
</head>

<body class = "wrapper style1">
	<%@include file="header.jsp"%>
	<%@include file="authheader.jsp"%>


	<!-- Section Three -->
	<div class="wrapper style4">
		<section class="container">
			
			
				<div class="row flush">
				<c:forEach items="${adoptions}" var="adoptions">
					<div class="4u">

						<ul class="special-icons">
							<li><span class="fa fa-leaf"></span>
								<h3>${adoptions.aName}</h3>
								<table>
								<tr><td>Pet Age </td><td>${adoptions.age}</td></tr>
								<tr><td>Pet Species</td><td>${adoptions.species}</td></tr>
								<tr><td>Pet Breed</td><td>${adoptions.breed}</td></tr>
								<tr><td>Adopter Name</td><td>${adoptions.adopterName}</td></tr>
								<tr><td>Adopter Address</td><td>${adoptions.address}</td></tr>
								<tr><td width="50%">Adopter Telephone</td><td>${adoptions.telnum}</td></tr>
								</table>
								</li>
						</ul>
					</div>
					</c:forEach>
				</div>
			
		</section>
	</div>

	<%@include file="footer.jsp"%>

</body>
</html>