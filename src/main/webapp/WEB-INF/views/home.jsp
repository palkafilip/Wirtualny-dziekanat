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
					<td class="col-md-2">Nadawca</td>
					<td class="col-md-2">Tytuł</td>
					<td class="col-md-6">Wiadomość</td>
					<td class="col-md-2">Data</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${messageResult}" var="message" varStatus="status">
					<tr>
						<td class="col-md-2">${sendersNames[status.index]}</td>
						<td class="col-md-2">${message.getTitle()}</td>
						<td class="col-md-6">${message.getContent()}</td>
						<td class="col-md-2">${message.getSend_date()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</tiles:putAttribute>
</tiles:insertDefinition>