<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>Dodaj studenta</title>
    <link rel='stylesheet' href='<c:url value="/resources/css/bootstrap.min.css" />' type='text/css' media='all' />
	<link rel='stylesheet' href='<c:url value="/resources/css/style.css" />' type='text/css' media='all' />
</head>

<body>
	<div class="container">
		<h1 class="header">Dodaj studenta do bazy</h1>
		<form:form method="POST" action="addStudent" modelAttribute="newStudent">
			<div class="form">
				<div class="form-group">
                    <form:input class="form-control" path="imie" placeholder="Wpisz imię"/>
                    </div>
                    <div class="form-group">
                    <form:input class="form-control" path="nazwisko" placeholder="Wpisz nazwisko"/>
                    </div>
                    <div class="form-group">
                    <form:input class="form-control" path="adres" placeholder="Wpisz adres"/>
                    </div>
                    <div class="form-group">
                    <form:input class="form-control" path="email" placeholder="Wpisz email"/>
                    </div>
                    <div class="form-group">
                    <form:input class="form-control" path="pesel" placeholder="Wpisz pesel"/>
                    </div>
                    <div class="form-group">
                    <form:input class="form-control" path="numerTel" placeholder="Wpisz numer telefonu"/>
                    </div>
                    <button type="submit" value="dodaj" class="btn btn-default button">Dodaj</button>
			</div>
		</form:form>

	</div>
</body>

</html>