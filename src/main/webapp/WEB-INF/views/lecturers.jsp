<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

		<h1>Prowadzący</h1>

		<form class="form" action="lecturers" method="post">
			<div class="form-group">
				<input type="text" class="form-control"
					placeholder="Wpisz nazwisko prowadzącego" name="lastname">
			</div>
			<button type="submit" class="btn btn-default button">Wyszukaj</button>
			<p>${errorMessage}</p>
		</form>

<c:forEach items="${lecturersResult}" var="lecturer">
    <tr>      
        <td>${lecturer.getFirstname()}</td>
        <td>${lecturer.getLastname()}</td>
        <td>${lecturer.getEmail()}</td>
        <td>${lecturer.getPhone()}</td>
    </tr>
    <br>
</c:forEach>
	

	</tiles:putAttribute>
</tiles:insertDefinition>