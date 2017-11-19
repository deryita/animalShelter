<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="./static/js/jquery-3.2.1.min.js"></script>
<script src="./static/js/jquery.min.js"></script>
<script type="text/javascript">
	function doSearch(){
		//make request to server
		$.getJSON("looseSearch.do", //URL that will be invoked
				{	CHARS: $('#searchBox').val()}, //key - value pair, we have only one! CHARS.
					
				function(data){ //
					//Callback
					alert('response received '+ data);
				});
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Search</h1>
	<input type="text" onKeyUp="doSearch();" id="searchBox"/>
	<div id="results">Results will appear here.</div>
</body>
</html>