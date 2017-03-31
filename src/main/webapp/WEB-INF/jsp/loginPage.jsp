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
		<form class="form" action="login" method="post">
			<div class="form-section">
				<label for="pesel">Pesel</label> <input type="text" id="pesel"
					name="pesel">
			</div>
			<div class="form-section">
				<label for="imie">Imie</label> <input type="text" id="imie"
					name="imie">
			</div>
			<input type="submit" value="Zaloguj" />
			<p>${loginError}</p>
		</form>

	</div>
</body>

</html>
