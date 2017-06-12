<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

		<h1>Finanse</h1>
		
		<p>${errorMessage}</p>
		
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<td class="col-md-2">Id transakcji</td>
					<td class="col-md-3">Dane</td>
					<td class="col-md-3">Data</td>
					<td class="col-md-2">Status</td>
					<td class="col-md-2">Kwota</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${transactions}" var="trans">
					<tr>
						<td class="col-md-2">${trans.idTransaction}</td>
						<td class="col-md-3">${trans.transferData}</td>
						<td class="col-md-3">${trans.transDate}</td>
						<td class="col-md-2">${trans.status}</td>
						<td class="col-md-2">${trans.amount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</tiles:putAttribute>
</tiles:insertDefinition>