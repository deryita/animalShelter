<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value='/static/css/style.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/skel.css' />" rel="stylesheet"></link>
<script type="text/javascript" src="./static/js/jquery-3.2.1.min.js"></script>
<script src="./static/js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
<script src="./static/js/jquery.dropotron.min.js"></script>
<script src="./static/js/skel.min.js"></script>
<script src="./static/js/skel-layers.min.js"></script>
<script src="./static/js/init.js"></script>
<script type="text/javascript">
	function doSearch() {
		//make request to server
		$
				.getJSON(
						"looseSearch.do", //URL that will be invoked
						{
							CHARS : $('#searchBox').val()
						}, //key - value pair, we have only one! CHARS.

						function(data) {
							//Callback
							$('#results').text(''); //clear results first

							for ( var index in data) {//js loop in data
								$('#results')
										.append(
												'<div class="row flush"><div class="4u"><ul class="special-icons"><li><span class="fa fa-leaf"></span><h3>'
														+ data[index].aName
														+ '</h3><p>'
														+ data[index].age
														+ '</p><p>'
														+ data[index].species
														+ '</p><p>'
														+ data[index].breed
														+ '</p></li></ul>'); //append aname
							}
						});
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="wrapper style1">
	<%@include file="header.jsp"%>
	<input type="text" onKeyUp="doSearch();" id="searchBox" />

	<div class="wrapper style4">
		<h3>Please input pet name to search box above to see the results</h3>
		<section class="container">
		<div class="row flush">
			<div class="4u">
				<div id="results"></div>
			</div>
		</div>
		</section>
	</div>
	<%@include file="footer.jsp"%>

</body>
</html>