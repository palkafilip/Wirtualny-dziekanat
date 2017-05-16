<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Logowanie</title>
    
    <link rel='stylesheet' href='<c:url value="/resources/css/bootstrap.min.css" />'>
    <link rel='stylesheet' href='<c:url value="/resources/css/style.css" />'>
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
    
</head>

<body>
    <div class="container">
        <h1 class="header-page header">Zaloguj się do dziekanatu</h1>
        <form class="form" action="login" method="post">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Wpisz swóje NIU" name="niu">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Wpisz swoje hasło" name="password">
            </div>
            <button type="submit" class="btn btn-default button">Zaloguj</button>
            <p>${loginError}</p>
        </form>
    </div>
</body>

</html>

