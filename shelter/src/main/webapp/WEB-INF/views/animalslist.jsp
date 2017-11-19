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
				<c:forEach items="${animals}" var="animals">
					<div class="4u">

						<ul class="special-icons">
							<li><span class="fa fa-leaf"></span>
								<h3>${animals.aName}</h3>
								<p>${animals.age}</p>
								<p>${animals.species}</p>
								<p>${animals.breed}</p> <sec:authorize
									access="hasRole('ADMIN') or hasRole('DBA')">
									<p>
										<a href="<c:url value='/edit-user-${animals.id}' />"
											class="btn btn-success custom-width">edit</a>
									</p>
								</sec:authorize> <sec:authorize access="hasRole('ADMIN')">
									<p>
										<a href="<c:url value='/delete-user-${animals.id}' />"
											class="btn btn-danger custom-width">delete</a>
									</p>
								</sec:authorize>
									<p>
										<a href="<c:url value='/adopt-pet-${animals.id}' />"
											class="btn btn-danger custom-width">Adopt</a>
									</p>
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