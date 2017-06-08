<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

		<h1 class="h1">Tablica ogłoszeń</h1>
		<p>${errorMessage}</p>

		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<td class="col-md-1">Nadawca</td>
					<td class="col-md-2">Tytuł</td>
					<td class="col-md-7">Wiadomość</td>
					<td class="col-md-2">Data</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${messageResult}" var="message">
					<tr>
						<td class="col-md-1">${message.getNiu_sender()}</td>
						<td class="col-md-2">${message.getTitle()}</td>
						<td class="col-md-7">${message.getContent()}</td>
						<td class="col-md-2">${message.getSend_date()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</tiles:putAttribute>
</tiles:insertDefinition>