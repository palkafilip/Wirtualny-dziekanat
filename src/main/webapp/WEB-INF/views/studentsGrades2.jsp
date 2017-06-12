<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    
    <h1>Oceny studentów</h1>
    
    
			
				
	<form class="form" action="saveGrades" method="post">
				
		<div class="form-group">
			<c:forEach items="${studentsMarks}" var="studentMark">
			<tr>				
				<td>  ${studentMark.firstname} ${studentMark.lastname} <input type="text" class="form-control"
					placeholder="${studentMark.mark}" name="studentMark" >
				</td>
				
			</tr>
			<br>
			</c:forEach>
		</div>
		
		<button type="submit" id="save" name="save" class="btn btn-default button">Zapisz oceny</button>
		
	</form>
		
	
	
	
        
    </tiles:putAttribute>
</tiles:insertDefinition>