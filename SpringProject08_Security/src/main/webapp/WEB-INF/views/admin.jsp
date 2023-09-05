<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<body>
<div class="container mt-3">
<h1>ADMIN</h1>
<p>principal : <sec:authentication property="principal"/></p>
<p>Member : <sec:authentication property="principal.member"/></p>
<p>사용자 이름 : <sec:authentication property="principal.member.username"/></p>
<p>사용자 ID : <sec:authentication property="principal.member.userid"/></p>
<p>사용자 ID(username) : <sec:authentication property="principal.username"/></p>
<p>권한 : <sec:authentication property="principal.member.authList"/></p>
<a href="/app08/customlogout">로그아웃</a>
</div>
</body>
</html>
