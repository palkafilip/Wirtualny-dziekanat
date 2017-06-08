<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

		<h1>Oceny</h1>

		<form class="form" action="showMarks" method="post">
			<div class="form-group">
				<input type="text" class="form-control"
					placeholder="Wpisz kod semestru" name="semesterCode">
			</div>

			<button type="submit" class="btn btn-default button">Pokaż oceny</button>
		</form>
		
		<p> ${error} <p>

	<c:forEach items="${grades}" var="grade">
			<tr>
				<td>${grade}</td>
			</tr>
			<br>
	</c:forEach>

	</tiles:putAttribute>
</tiles:insertDefinition>