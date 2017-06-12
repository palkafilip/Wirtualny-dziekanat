<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    
    <h1>Plany zajęć:</h1>
    <ul class="list">
		<li class="listItem"><a href="<c:url value='resources/timetables/timeTableINF.pdf' /> ">Plan zajeć Informatyka:<img src="<c:url value='resources/icons/pdf_icon.png' /> " alt=""></a></li>
		<li class="listItem"><a href="<c:url value='resources/timetables/timeTableENE.pdf' /> ">Plan zajeć Energetyka:<img src="<c:url value='resources/icons/pdf_icon.png' /> " alt=""></a></li>
		<li class="listItem"><a href="<c:url value='resources/timetables/timeTableELE.pdf' /> ">Plan zajeć Elektrotechnika:<img src="<c:url value='resources/icons/pdf_icon.png' /> " alt=""></a></li>
	</ul>
	
    </tiles:putAttribute>
</tiles:insertDefinition>