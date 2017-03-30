<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Witaj</title>
<link rel='stylesheet' href='<c:url value="/resources/css/style.css" />' type='text/css' media='all' />
</head>
<body>
	<div class="text-center jumbotron">
	  <h1>Dziękujemy za zalogowanie ${activeStudent.imie}</h1>
    <h3><a href="">Kliknij, aby zobaczyć listę studentów</a></h3>
	</div>
</body>
</html>