<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Witaj</title>
</head>
<body>
	<div class="text-center jumbotron">
	  <h1>Lista studentów:</h1>
	</div>
	<section class="container">
		<div class="row">
			<c:forEach items="${students}" var="student">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<h3>${student.imie}</h3>
							<p>${student.nazwisko}</p>
							<p>${student.adres}</p>
							<p>${student.pesel}</p>
							<p>${student.email}</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<h2><a href="students/add.html">Dodaj nowego studenta do bazy</a></h2>
	</section>
	
</body>
</html>