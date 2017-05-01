<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<header class="header">
			<div class="row">
				<div class="col-md-7">
					<div class="logo">Wirtualny Dziekanat</div>
				</div>
				<div class="col-md-3">
					<div class="username pull-right">${loggedInUser.firstname} ${loggedInUser.lastname}</div>
				</div>
				<div class="col-md-2"><a href="logout.html"><button type="button" name="button" class="button pull-right">Wyloguj</button></a></div>
			</div>
		</header>
	</div>
	<nav class="navbar" role="navigation">
		<div class="container">
			<ul class="menuList">
				<li class="menuItem"><a href="#">Plan zajęć</a></li>
				<li class="menuItem"><a href="#">Oceny</a></li>
				<li class="menuItem"><a href="#">Wiadomości</a></li>
				<li class="menuItem"><a href="#">Syllabus</a></li>
				<li class="menuItem"><a href="#">Finanse</a></li>
				<li class="menuItem"><a href="#">Podania</a></li>
				<li class="menuItem"><a href="#">Prowadzący</a></li>
				<li class="menuItem"><a href="#">Zmiana danych</a></li>
			</ul>
		</div>
	</nav>

	<div class="content">
		<div class="container">
			<h1 class="h1">Tablica ogłoszeń</h1>
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<td class="col-md-2">Nadawca</td>
						<td class="col-md-8">Wiadomość</td>
						<td class="col-md-2">Data</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="col-md-2">Dziekanat</td>
						<td class="col-md-8">Godziny dziekańskie / Dzień dobry, ogłaszam godziny dziekańskie od godziny 10:00.</td>
						<td class="col-md-2">20.05.2017</td>
					</tr>
					<tr>
						<td class="col-md-2">Dziekanat</td>
						<td class="col-md-8">Godziny dziekańskie / Dzień dobry, ogłaszam godziny dziekańskie od godziny 10:00.</td>
						<td class="col-md-2">20.05.2017</td>
					</tr>
					<tr>
						<td class="col-md-2">Dziekanat</td>
						<td class="col-md-8">Godziny dziekańskie / Dzień dobry, ogłaszam godziny dziekańskie od godziny 10:00.</td>
						<td class="col-md-2">20.05.2017</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<footer class="footer">
		<div class="container">
			<p class="copyright">Copyright by Wirtualny Dziekanat &copy. All rights reserved.</p>
		</div>
	</footer>


</body>

</html>
