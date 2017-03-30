<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>Dodaj studenta</title>
</head>

<body>
	<div class="container">
		<h1 class="header">Dodaj studenta do bazy</h1>
		<form:form method="POST" action="addStudent" modelAttribute="newStudent">
			<div class="form-container">
				<div class="form-section">
                    <form:label path="imie">Imie</form:label>
                    <form:input path="imie"/>
                    </div>
                    <div class="form-section">
                    <form:label path="nazwisko">Nazwisko</form:label>
                    <form:input path="nazwisko"/>
                    </div>
                    <div class="form-section">
                    <form:label path="adres">Adres</form:label>
                    <form:input path="adres"/>
                    </div>
                    <div class="form-section">
                    <form:label path="email">Email</form:label>
                    <form:input path="email"/>
                    </div>
                    <div class="form-section">
                    <form:label path="pesel">Pesel</form:label>
                    <form:input path="pesel"/>
                    </div>
                    <div class="form-section">
                    <form:label path="numerTel">Numer telefonu</form:label>
                    <form:input path="numerTel"/>
                    </div>
                    <input type="submit" value="Dodaj"/>
			</div>
		</form:form>

	</div>
</body>

</html>