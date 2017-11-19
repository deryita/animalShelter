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
<body>
	<%@include file="header.jsp"%>
	<%@include file="authheader.jsp"%>

	<!-- Header Wrapper -->
	<div class="wrapper style1">


		<!-- Main -->
		<div id="main" class="wrapper style4">

			<!-- Content -->
			<div id="content" class="container">
				<section>
					<header class="major">
						<h2>About page</h2>
						<span class="byline">About Animal Shelter</span>
					</header>
					<img src="<c:url value='/static/images/pug.gif' />" alt="">
					<p>You can offer assistance to the stray cats and dogs
						wandering on the streets by getting in touch with the animal
						shelters in various districts of the town. After the necessary
						shots, rehabilitation and neutering operations, they try to find
						families to look after those animals. Those wishing to keep a cat
						or a dog can find purebred, half-bred or stray dogs and cats at
						these shelters. If you don't wish to keep them at home you can
						take responsibility for one as a "protective family". This means
						commiting to the adopted animals' expenses in the shelter and
						visiting them from time to time and to play. Besides the shelters
						there are several groups working for the benefit of stray animals
						in Istanbul and following are some of them. You can be sure they
						will be grateful for any kind of assistance.</p>
				</section>
			</div>
		</div>

		<!-- Team -->
		<div class="wrapper style5">
			<section id="team" class="container">
				<header class="major">
					<h2>Contributors</h2>
					<span class="byline">Thanks to all of the contributors</span>
				</header>
				<div class="row">
					<div class="3u">
						<a href="#" class="image"><img
							src="<c:url value='/static/images/placeholder.png' />" alt=""></a>
						<h3>Derya Oz</h3>
						<p>A humble software engineer.</p>
					</div>
					<img src="<c:url value='/static/images/tenor.gif' />" alt="" height="300" width="500">

				</div>
			</section>
		</div>
</body>
</html>