<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    
    <h1>Ogłoszenia do wysłania</h1>
    
      <form class="form" action="sendAnnon" method="post">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Wprowadź id grupy" name="idGroup">
            </div>
             <div class="form-group">
                <input type="text" class="form-control" placeholder="Tytuł" name="title">
            </div>
            <div class="form-group">
                <textarea class="form-control" name="annonText" cols="10" rows="5" placeholder="Treść ogłoszenia"></textarea>
            </div>
            
            <button type="submit" class="btn btn-default button">Wyślij</button>
            
        </form>
        
        
        <p>${message}</p>
        
    </tiles:putAttribute>
</tiles:insertDefinition>