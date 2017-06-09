<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head>
	<body>
		<h1>${message}</h1>
		<p>${errorMessages}</p>
		<c:remove var="errorMessages" scope="session"/>

		<form:form modelAttribute="userForm">
			<p>ログインID: <form:input path="account" /></p>
			<p>パスワード: <form:input path="password" /></p>	
			<input type="submit">
		</form:form>
	</body>
</html>