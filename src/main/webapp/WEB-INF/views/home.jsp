<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    
    <h1 class="h1">Tablica ogłoszeń</h1>
    
    
    <p>${errorMessage}</p>
    
    <c:forEach items="${messageResult}" var="message">
    <tr>      
        <td>${message.getNiu_sender()}</td>
        <td>${message.getTitle()}</td>
        <td>${message.getContent()}</td>
        <td>${message.getSend_date()}</td>
    </tr>
    <br>
</c:forEach>
    
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<td class="col-md-2">Nadawca</td>
						<td class="col-md-8">Wiadomość</td>
						<td class="col-md-2">Data</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="col-md-2">Dziekanat</td>
						<td class="col-md-8">Godziny dziekańskie / Dzień dobry, ogłaszam godziny dziekańskie od godziny 10:00.</td>
						<td class="col-md-2">20.05.2017</td>
					</tr>
					<tr>
						<td class="col-md-2">Dziekanat</td>
						<td class="col-md-8">Godziny dziekańskie / Dzień dobry, ogłaszam godziny dziekańskie od godziny 10:00.</td>
						<td class="col-md-2">20.05.2017</td>
					</tr>
					<tr>
						<td class="col-md-2">Dziekanat</td>
						<td class="col-md-8">Godziny dziekańskie / Dzień dobry, ogłaszam godziny dziekańskie od godziny 10:00.</td>
						<td class="col-md-2">20.05.2017</td>
					</tr>
				</tbody>
			</table>
    
    </tiles:putAttribute>
</tiles:insertDefinition>