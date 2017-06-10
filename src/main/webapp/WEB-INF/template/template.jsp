<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<title>Student - Strona główna</title>
	<link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.min.css" />'>
	<link rel="stylesheet" href='<c:url value="/resources/css/main.css" />'>
	<link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
</head>

<body>

	<div class="container">
		<tiles:insertAttribute name="header" />
	</div>
	<tiles:insertAttribute name="menu" />

	<div class="middle">
		<div class="container">
			<tiles:insertAttribute name="body" />
		</div>
	</div>

	<tiles:insertAttribute name="footer" />


</body>

</html>
