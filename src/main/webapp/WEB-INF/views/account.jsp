<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    
    <h1>Zmiana danych kontaktowych:</h1>
    
    <form class="form" action="changeContact" method="post">
            <div class="form-group single-form">
            <p>Telefon: ${loggedInUser.getPhone()}</p>
                <input type="text" class="form-control" placeholder="Wprowadź nowy numer telefonu" onkeypress='return event.charCode >= 48 && event.charCode <= 57' name="phone">
            </div>
            <div class="form-group single-form">
            <p>E-mail: ${loggedInUser.getEmail()}</p>
                <input type="text" class="form-control" placeholder= "Wprowadź nowy e-mail" name="email">
            </div>
             <div class="form-group single-form">
             <p>Adres: ${loggedInUser.getAddress()}</p>
                <input type="text" class="form-control" placeholder= "Wprowadź nowy adres" name="address">
            </div>
             <div class="form-group single-form">
             <p>Miasto: ${loggedInUser.getCity()}</p>
                <input type="text" class="form-control" placeholder= "Wprowadź nowe miasto" name="city">
            </div>
             <div class="form-group single-form">
             <p>Kod pocztowy: ${loggedInUser.getPost_code()}</p>
                <input type="text" class="form-control" placeholder= "Wprowadź nowy kod pocztowy"  name="post_code">
            </div>
            <button type="submit" class="btn btn-default button">Zmień</button>
            
        </form>
        
        <h1 class="header1">Zmiana danych logowania:</h1>
    
    <form class="form" action="changePassword" method="post">
            <div class="form-group single-form">
                <input type="password" class="form-control" placeholder= "Wpisz obecne hasło" name="currentPassword">
            </div>
            <div class="form-group single-form">
                <input type="password" class="form-control" placeholder= "Wpisz nowe hasło(min. 6 znaków)" name="newPassword1">
            </div>
             <div class="form-group single-form">
                <input type="password" class="form-control" placeholder= "Powtórz nowe haslo(min. 6 znaków)" name="newPassword2">
            </div>
             
            <button type="submit" class="btn btn-default button">Zmień</button>
            <p>${ChangePasswordMsg}</p>
        </form>
        
    </tiles:putAttribute>
</tiles:insertDefinition>