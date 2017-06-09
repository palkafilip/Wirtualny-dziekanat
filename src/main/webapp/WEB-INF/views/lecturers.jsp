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
			<p class="pError">${errorMessage}</p>
		</form>


		<c:choose>
			<c:when test="${lecturersResult.isEmpty() == false}">
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<td class="col-md-3">Imię</td>
							<td class="col-md-3">Nazwisko</td>
							<td class="col-md-3">Email</td>
							<td class="col-md-3">Numer tel</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${lecturersResult}" var="lecturer">
							<tr>
								<td class="col-md-3">${lecturer.getFirstname()}</td>
								<td class="col-md-3">${lecturer.getLastname()}</td>
								<td class="col-md-3">${lecturer.getEmail()}</td>
								<td class="col-md-3">${lecturer.getPhone()}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
		</c:choose>


	</tiles:putAttribute>
</tiles:insertDefinition>