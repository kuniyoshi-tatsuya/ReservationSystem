<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>reservation</title>
	</head>
	<body>
		<h1>予約</h1>
		<p><a href="http://localhost:8080/ReservationSystem/home">会議室一覧へ</a></p>
		
		<form:form modelAttribute="reservationForm">
			<table border="1">
				<tr><th>会議室</th><td>${location.building}</td></tr>
				<tr><th>予約者</th><td>${loginUser.name}</td></tr>
				<tr><th>日付</th><td>${reservationForm.reservedDate}</td></tr>
				<tr><th>時間帯</th>
					<td>
						<form:select path="reservedStart" items="${minutes}"/>～
						<form:select path="reservedEnd" items="${minutes}"/>
					</td>
				</tr>
			</table>
			<form:hidden path="userId"/>
			<form:hidden path="locationId"/>
			<form:hidden path="reservedDate"/>
			<p><input type="submit" value="予約"></p>
		</form:form>
		
		<p>${reservationForm.reservedDate}の予約一覧</p>
		<table border="1">
			<tr><th>会議室</th><th>予約者</th><th>時間帯</th></tr>
			<c:forEach items="${reservations}" var="reservation">
				<c:if test="${reservation.locationId == location.id	}">
					<tr>
						<td>${location.building}</td>
						<td>${reservation.userId}</td>
						<td>${reservation.reservedStart}~${reservation.reservedEnd}</td>
					</tr>
				</c:if>
			</c:forEach>
		</table>
		
	</body>
</html>