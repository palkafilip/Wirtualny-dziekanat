<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    
    <h1>Oceny studentów</h1>
    
    <form class="form" action="showSubjects" method="post">
			<div class="form-group">
				<input type="text" class="form-control"
					placeholder="Wpisz kod semestru" name="semesterCode">
			</div>

			<button type="submit" class="btn btn-default button">Pokaż listę przedmiotów</button>
			
			
		</form>
		
		<p> ${error} <p>
		
	<form class="form" action="cSubject" method="post">
		<div class="form-group">
			<c:forEach items="${instructorSubjects}" var="subject">
			<tr>				
				<td><button type="submit" class="btn btn-default button" value="${subject.acronym_subject}" name="cSub">${subject.name}</button><br></td>
			</tr>
			<br>
			</c:forEach>
		</div>
		
	</form>
	
	<form class="form" action="cGroups" method="post">
		<div class="form-group">
			<c:forEach items="${groupsList}" var="group">
			<tr>				
				<td><button type="submit" class="btn btn-default button" value="${group.group_id}" name="cGroup">${group.group_id}</button><br></td>
				
			</tr>
			<br>
			</c:forEach>
		</div>
		
	</form>
		
				
	
	
        
    </tiles:putAttribute>
</tiles:insertDefinition>