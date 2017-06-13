<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    
    <h1>Podania</h1>

   
    <ul class="list">
		<li class="listItem"><a href="<c:url value='resources/applications/dkEnergetyka.doc' /> " >Dług kredytowy Energetyka:<img src="<c:url value='resources/icons/doc_icon.png' /> " alt=""></a></li>
		<li class="listItem"><a href="<c:url value='resources/applications/dkInformatyka.doc' /> ">Dług kredytowy Informatyka:<img src="<c:url value='resources/icons/doc_icon.png' /> " alt=""></a></li>
		<li class="listItem"><a href="<c:url value='resources/applications/przepisanie.doc' /> " >Przepisanie oceny:<img src="<c:url value='resources/icons/doc_icon.png' /> " alt=""></a></li>
	</ul>
    
    
    <h1 class="header1">Wstaw podanie</h1>
    <form id="appForm" class="form" method="POST" action="upload" enctype="multipart/form-data">
    <input type="file" class="fileInput" name="file" />
    <input type="submit" class="btn btn-default button" value="Wyślij" />
</form>
    
    <p class="pError"> ${message}</p>
    
    </tiles:putAttribute>
</tiles:insertDefinition>