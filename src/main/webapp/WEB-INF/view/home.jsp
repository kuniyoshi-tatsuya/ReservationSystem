<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>home</title>
	</head>
	<body>
	
		<h1>ホーム</h1>
		<p>${date}</p>
		<table style="width : 300px; text-align : center;">
			<tr>
				<td>
					<form:form method="GET" modelAttribute="aroundDate">
						<form:hidden path="previousDate" />
						<input type="submit" value="<前日">
					</form:form>
				</td>
				<td>
					<c:out value="${selectedDate}の会議室"></c:out>
				</td>
			  	<td>
					<form:form method="GET" modelAttribute="aroundDate">
						<form:hidden path="nextDate" />
						<input type="submit" value="翌日>">
					</form:form>
				</td>
			</tr>
		</table><br>
		
		<table border="1">
			<tr><th>場所</th><th>予約</th></tr>
			<c:forEach items="${locations}" var="location">
				<tr>
					<td><c:out value="${location.building}"></c:out></td>
					<td>
						<form:form action="./reservation/${location.id}" method="GET" modelAttribute="aroundDate">
							<form:hidden path="selectedDate" />
							<input type="submit" value="編集">
						</form:form>
					</td>
				</tr>
			</c:forEach>
		</table>
		
		<p><a href="./login">ログアウト</a></p>
		
	</body>
</html>