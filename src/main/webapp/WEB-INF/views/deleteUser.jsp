<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

		<h1>Usuwanie konta</h1>

		<form class="form" action="deleteUser" method="post">
		<div class="form-group single-form">
				<p>Niu:</p>
				<input type="text" class="form-control"
					placeholder="wprowadź niu"
					name="niu">
			</div>
			<button type="submit" class="btn btn-default button">Usuń konto</button>
		</form>

<p class="pError">${message}<p>

	</tiles:putAttribute>
</tiles:insertDefinition>