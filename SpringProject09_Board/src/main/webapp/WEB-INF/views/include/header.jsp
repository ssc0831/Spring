<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		
	<li class="nav-item"><a class="nav-link" href="/insert">BoardInsert</a>
	</li>
	
	<li class="nav-item"><a class="nav-link" href="/uploadFile">uploadFile</a>
	</li>
		
	<li class="nav-item"><a class="nav-link" href="/fileInsert">FileBoardInsert</a>
	</li>
<li class="nav-item"><a class="nav-link" href="/list">Board</a></li>
	</li>
	
</ul>
<ul class="navbar-nav">
	<c:choose>
	<c:when test="${empty sessionScope.sMember}">
		<li class="nav-item"><a class="nav-link" href="/member/login">로그인</a>
		</li>
		<li class="nav-item"><a class="nav-link" href="/member/join">회원가입</a>
		</li>
		</c:when>
		<c:otherwise>
		<li class="nav-item"><a class="nav-link" href="/member/logout">로그아웃(${sessionScope.sMember.name})</a>
		</li>
		<li class="nav-item"><a class="nav-link" href="/member/update">회원변경</a>
		</li>

		</c:otherwise>
		</c:choose>
	</ul>
</nav>