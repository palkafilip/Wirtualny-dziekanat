<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>Logowanie</title>
</head>

<body>
	<div class="container">
		<h1 class="header">Zaloguj się do dziekanatu</h1>
		<form:form method="POST" action="logIn" modelAttribute="activeStudent">
			<div class="form-container">
				<form:label path="pesel">Podaj pesel</form:label>
				<form:input path="pesel" />
				<input type="submit" value="Zaloguj"/>
			</div>
		</form:form>

	</div>
</body>

</html>