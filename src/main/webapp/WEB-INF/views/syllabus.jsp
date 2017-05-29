<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel='stylesheet' href='<c:url value="/resources/css/bootstrap.min.css" />'>
    
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    
    
    <h1>Syllabus:</h1>
    <div class="form-group">
    <a href="<c:url value='resources/syllabus/syllabus.pdf' /> " > Syllabus:<img src="<c:url value='resources/icons/pdf_icon.png' /> "style= "width:50px;height:50px;"></a>
    </div>
        
    </tiles:putAttribute>
</tiles:insertDefinition>