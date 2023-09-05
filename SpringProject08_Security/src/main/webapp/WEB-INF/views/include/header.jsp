<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Header</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-success navbar-dark">
		<!-- Brand/logo -->
<a class="navbar-brand" href="/">HOME(Board)</a>

<!-- Links -->
<ul class="navbar-nav mr-auto">
		
	<li class="nav-item"><a class="nav-link" href="/app08/board/insert">BoardInsert</a>
	</li>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
	<li class="nav-item"><a class="nav-link" href="#">Product</a>
	</sec:authorize>
</ul>
	<sec:authentication property="principal" var="pinfo"/>
	<sec:authorize access="isAnonymous()">
<ul class="navbar-nav">
	<li class="nav-item"><a class="nav-link" href="/app08/customlogin">로그인</a></li>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
	<li class="nav-item"><a class="nav-link" href="/app08/customlogout">
	로그아웃(<sec:authentication property="principal.member.username"/>)</a></li>
	</sec:authorize>
	</ul>
</nav>