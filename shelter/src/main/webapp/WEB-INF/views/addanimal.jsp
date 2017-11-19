<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

	<div>
		<%@include file="authheader.jsp"%>
		<!-- Main -->
		<div id="main" class="wrapper style4">

			<!-- Content -->
			<div id="content" class="container">
				<section>
					<header class="major">
						<h2>Add</h2>
						<span class="byline">Please fill in the form to add a pet.</span>
					</header>
				</section>
				<form:form method="POST" modelAttribute="animal"
					class="form-horizontal">
					<form:input type="hidden" path="id" id="id" />

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="aName">Pet
								Name</label>
							<div class="col-md-7">
								<form:input type="text" path="aName" id="aName"
									class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="aName" class="help-inline" />
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="age">Pet Age</label>
							<div class="col-md-7">
								<form:input type="text" path="age" id="age"
									class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="age" class="help-inline" />
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="species">Species</label>
							<div class="col-md-7">
								<c:choose>
									<c:when test="${edit}">
										<form:input type="text" path="species" id="species"
											class="form-control input-sm" disabled="true" />
									</c:when>
									<c:otherwise>
										<form:input type="text" path="species" id="species"
											class="form-control input-sm" />
										<div class="has-error">
											<form:errors path="species" class="help-inline" />
										</div>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>


					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="breed">Breed</label>
							<div class="col-md-7">
								<form:input type="text" path="breed" id="breed"
									class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="breed" class="help-inline" />
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-actions floatRight">
							<c:choose>
								<c:when test="${edit}">
									<input type="submit" value="Update"
										class="btn btn-primary btn-sm" /> or <a
										href="<c:url value='/main' />">Cancel</a>
								</c:when>
								<c:otherwise>
									<input type="submit" value="Register"
										class="btn btn-primary btn-sm" /> or <a
										href="<c:url value='/main' />">Cancel</a>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</form:form>
			</div>
		</div>

	</div>
	<%@include file="footer.jsp"%>
</body>
</html>