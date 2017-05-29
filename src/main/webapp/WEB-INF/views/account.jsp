<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
	
	<link rel='stylesheet' href='<c:url value="/resources/css/bootstrap.min.css" />'>
    <link rel='stylesheet' href='<c:url value="/resources/css/style.css" />'>
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">


<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    
    <h2>Zmiana danych kontaktowych:</h2>
    
    <form class="form" action="changeContact" method="post">
            <div class="form-group">
            Telefon: 
            ${loggedInUser.getPhone()}
                <input type="text" class="form-control" placeholder="Wprowadź nowy numer telefonu" onkeypress='return event.charCode >= 48 && event.charCode <= 57' name="phone">
            </div>
            <div class="form-group">
            E-mail: 
            ${loggedInUser.getEmail()}
                <input type="text" class="form-control" placeholder= "Wprowadź nowy e-mail" name="email">
            </div>
             <div class="form-group">
             Adres:
             ${loggedInUser.getAddress()}
                <input type="text" class="form-control" placeholder= "Wprowadź nowy adres" name="address">
            </div>
             <div class="form-group">
             Miasto:
             ${loggedInUser.getCity()}
                <input type="text" class="form-control" placeholder= "Wprowadź nowe miasto" name="city">
            </div>
             <div class="form-group">
             Kod pocztowy:
             ${loggedInUser.getPost_code()}
                <input type="text" class="form-control" placeholder= "Wprowadź nowy kod pocztowy"  name="post_code">
            </div>
            <button type="submit" class="btn btn-default button">Zmień</button>
            
        </form>
        
        <h2>Zmiana danych logowania:</h2>
    
    <form class="form" action="changePassword" method="post">
            <div class="form-group">
                <input type="password" class="form-control" placeholder= "Wpisz obecne hasło" name="currentPassword">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder= "Wpisz nowe hasło(min. 6 znaków)" name="newPassword1">
            </div>
             <div class="form-group">
                <input type="password" class="form-control" placeholder= "Powtórz nowe haslo(min. 6 znaków)" name="newPassword2">
            </div>
             
            <button type="submit" class="btn btn-default button">Zmień</button>
            <p>${ChangePasswordMsg}</p>
        </form>
        
    </tiles:putAttribute>
</tiles:insertDefinition>