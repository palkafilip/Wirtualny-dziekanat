<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Logowanie</title>
    <link rel='stylesheet' href='<c:url value="/resources/css/style.css" />' type='text/css' media='all' />
    <link rel='stylesheet' href='<c:url value="/resources/css/bootstrap.min.css" />' type='text/css' media='all' />
    
</head>

<body>
    <div class="container">
        <h1 class="header-page">Zaloguj się do dziekanatu</h1>
        <form class="form" action="login" method="post">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Wpisz swój pesel" name="pesel">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Wpisz swoje imie" name="imie">
            </div>
            <button type="submit" class="btn btn-default button">Zaloguj</button>
            <p>${loginError}</p>
        </form>

    </div>
</body>

</html>

