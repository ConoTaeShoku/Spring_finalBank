<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>main</title>
</head>
<body>

<c:if test="${not empty logoutresult}">
<h1>${logoutresult}</h1>
</c:if>

<h2>[springWeb5 - SE Bank Step4 ]</h2>

<c:if test="${not empty loginId}">${loginName}(${loginId})님 로그인 중 <br><br></c:if>

<ul>
	<c:if test="${empty loginId}">
		<li><a href="join">회원가입</a></li>
		<li><a href="login">로그인</a></li>
	</c:if>
	
	<c:if test="${not empty loginId}">
		<li><a href="logout">로그아웃</a></li>
		<li><a href="#">개인 정보 수정</a></li>
	</c:if>
	
	<li><a href="#">게시판</a></li>
</ul>

</body>
</html>