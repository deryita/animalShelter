<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<body class="wrapper style1">
	<%@include file="header.jsp"%>
	<%@include file="authheader.jsp"%>

	<div class="wrapper style4">
		<section class="container">


		<div class="row flush">
			<div class="4u">

				<ul class="special-icons">
					<li><span class="fa fa-leaf"></span>
						<h3>${animal.aName}</h3>
						<p>${animal.age}</p>
						<p>${animal.species}</p>
						<p>${animal.breed}</p></li>
				</ul>
			</div>
		</div>
		</section>
	</div>
	<div id="main" class="wrapper style4">

		<!-- Content -->
		<div id="content" class="container">
		<section>
					<header class="major">
						<h2>Adopt</h2>
						<span class="byline">Please fill in the form to adopt a pet.</span>
					</header>
				</section>
			 <form:form method="POST"
				modelAttribute="adoption" class="form-horizontal">
				<form:input type="hidden" path="id" id="id" />
				<input type="hidden" id="aName" name="aName" value=${animal.aName}>
				<input type="hidden" id="age" name="age" value=${animal.age}>
				<input type="hidden" id="species" name="species"
					value=${animal.species}>
				<input type="hidden" id="breed" name="breed" value=${animal.breed}>

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="adopterName">Adopter
							Name</label>
						<div class="col-md-7">
							<form:input type="text" path="adopterName" id="adopterName"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="adopterName" class="help-inline" />
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="address">Adopter
							Address</label>
						<div class="col-md-7">
							<form:input type="text" path="address" id="address"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="address" class="help-inline" />
							</div>

						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="telnum">Telephone
							Number</label>
						<div class="col-md-7">
							<form:input type="text" path="telnum" id="telnum"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="telnum" class="help-inline" />
							</div>
						</div>
					</div>
				</div>


				<div class="row">
					<div class="form-actions floatRight">
						<input type="submit" value="Adopt" class="btn btn-primary btn-sm" />
						or <a href="<c:url value='/main' />">Cancel</a>

					</div>
				</div>
			</form:form>
		</div>
	</div>
	
	<%@include file="footer.jsp"%>
</body>
</html>