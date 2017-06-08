<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    
	<h1>Syllabus:</h1>
    <ul class="list">
		<li class="listItem"><a href="<c:url value='resources/syllabus/syllabus.pdf' /> " > Syllabus:<img src="<c:url value='resources/icons/pdf_icon.png' /> "></a></li>
	</ul>
        
    </tiles:putAttribute>
</tiles:insertDefinition>