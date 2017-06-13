<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

		<h1>Dodawanie konta:</h1>

		<form class="form" action="addUser" method="post">
		<div class="form-group single-form">
				<p>Imię:</p>
				<input type="text" class="form-control"
					placeholder="Wprowadź imię"
					name="firstName">
			</div>
			<div class="form-group single-form">
				<p>Nazwisko:</p>
				<input type="text" class="form-control"
					placeholder="Wprowadź nazwisko"
					name="lastName">
			</div>
			<div class="form-group single-form">
				<p>Pesel:</p>
				<input type="text" class="form-control"
					placeholder="Wprowadź pesel"
					onkeypress='return event.charCode >= 48 && event.charCode <= 57'
					name="pesel">
			</div>
			<div class="form-group single-form">
				<p>Adres:</p>
				<input type="text" class="form-control" placeholder="Wprowadź adres"
					name="address">
			</div>
			<div class="form-group single-form">
				<p>Miasto:</p>
				<input type="text" class="form-control"
					placeholder="Wprowadź miasto" name="city">
			</div>
			<div class="form-group single-form">
				<p>Kod pocztowy:</p>
				<input type="text" class="form-control"
					placeholder="Wprowadź kod pocztowy" name="post_code">
			</div>
			<div class="form-group single-form">
				<p>E-mail:</p>
				<input type="text" class="form-control"
					placeholder="Wprowadź e-mail" name="email">
			</div>
			<div class="form-group single-form">
				<p>Telefon:</p>
				<input type="text" class="form-control"
					placeholder="Wprowadź numer telefonu"
					onkeypress='return event.charCode >= 48 && event.charCode <= 57'
					name="phone">
			</div>
			
			<div class="form-group single-form">
				<p>Typ konta:</p>
				<input type="text" class="form-control"
					placeholder="Wprowadź typ konta"
					name="type">
			</div>
			
			<div class="form-group single-form">
			<p>Hasło:</p>
				<input type="password" class="form-control"
					placeholder="Wpisz nowe hasło(min. 6 znaków)" name="password1">
			</div>
			<div class="form-group single-form">
			<p>Powtórz hasło:</p>
				<input type="password" class="form-control"
					placeholder="Powtórz nowe haslo(min. 6 znaków)" name="password2">
			</div>

			<button type="submit" class="btn btn-default button">Dodaj</button>
		</form>

<p class="pError">${message}<p>

	</tiles:putAttribute>
</tiles:insertDefinition>