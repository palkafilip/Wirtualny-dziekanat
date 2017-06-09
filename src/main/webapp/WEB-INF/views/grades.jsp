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

			<button type="submit" class="btn btn-default button">Pokaż
				oceny</button>
		</form>

		<p class="pError">${error}
		<p>

			<c:choose>
				<c:when test="${grades.isEmpty() == false}">

					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<td class="col-md-6">Przedmiot</td>
								<td class="col-md-6">Ocena</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${grades}" var="grade">
								<tr>
									<td class="col-md-2">${grade.key}</td>
									<td class="col-md-2">${grade.value}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</c:when>
			</c:choose>
	</tiles:putAttribute>
</tiles:insertDefinition>