<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    
    <h1>Wiadomości</h1>
    
     <form class="form" action="sendMessage" method="post">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Wprowadź niu adresata" onkeypress='return event.charCode >= 48 && event.charCode <= 57' name="niu">
            </div>
            <div class="form-group">
                <textarea class="form-control" name="messageText" cols="10" rows="5" placeholder="Treść wiadomości"></textarea>
            </div>
            
            <button type="submit" class="btn btn-default button">Wyślij</button>
            
        </form>
        
        
        <p>${message}</p>
        
    </tiles:putAttribute>
</tiles:insertDefinition>