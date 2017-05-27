<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar" role="navigation">
	<div class="container">
		<ul class="menuList">
			<c:choose>
				<c:when test="${loggedInUser.getAccount_type().equals('student')}">
					<li class="menuItem"><a href="timetable.html">Plan zajęć</a></li>
					<li class="menuItem"><a href="grades.html">Oceny</a></li>
					<li class="menuItem"><a href="messages.html">Wiadomości</a></li>
					<li class="menuItem"><a href="syllabus.html">Syllabus</a></li>
					<li class="menuItem"><a href="finances.html">Finanse</a></li>
					<li class="menuItem"><a href="application.html">Podania</a></li>
					<li class="menuItem"><a href="lecturers.html">Prowadzący</a></li>
					<li class="menuItem"><a href="account.html">Zmiana danych</a></li>
				</c:when>
				<c:when test="${loggedInUser.getAccount_type().equals('prowadzacy')}">
					<li class="menuItem"><a href="timetable.html">Plan zajęć</a></li>
					<li class="menuItem"><a href="studentsGrades.html">Wystaw oceny</a></li>
					<li class="menuItem"><a href="messages.html">Wiadomości</a></li>
					<li class="menuItem"><a href="announcements.html">Zarządzaj ogłoszeniami</a></li>
					<li class="menuItem"><a href="account.html">Zmiana danych</a></li>
				</c:when>
			</c:choose>
		</ul>
	</div>
</nav>