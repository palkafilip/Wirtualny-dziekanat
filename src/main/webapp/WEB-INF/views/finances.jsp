<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

		<h1>Finanse</h1>

		<c:forEach items="${transactions}" var="trans">
			<tr>
				<td>${trans.idTransaction}</td>
				<td>${trans.idFinance}</td>
				<td>${trans.transferData}</td>
				<td>${trans.transDate}</td>
				<td>${trans.status}</td>
				<td>${trans.amount}</td>
			</tr>
			<br>
		</c:forEach>

	</tiles:putAttribute>
</tiles:insertDefinition>