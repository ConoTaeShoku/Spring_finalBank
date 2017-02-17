<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>[ read.jsp ]</title>
</head>
<body>


<h2>[게시판 글 읽기]</h2>

<table>
	<tr>
		<td>boardnum</td>
		<td>${readB.boardnum}</td>
	</tr>
	<tr>
		<td>custid</td>
		<td>${readB.custid}</td>
	</tr>
	<tr>
		<td>title</td>
		<td>${readB.title}</td>
	</tr>
	<tr>
		<td>content</td>
		<td><textarea rows=5 name="content" id="content" style="width:98%;" readonly>${readB.content}</textarea></td>
	</tr>
	<tr>
		<td>inputdate</td>
		<td>${readB.inputdate}</td>
	</tr>
	<tr>
		<td>hits</td>
		<td>${readB.hits}</td>
	</tr>
	<tr>
		<td>originalfile</td>
		<td>${readB.originalfile}</td>
	</tr>
	<tr>
		<td>savedfile</td>
		<td>${readB.savedfile}</td>
	</tr>
</table><br>

<div>
	<c:if test="${readB.custid == loginId}">
		<a href="updateB?boardnum=${readB.boardnum}">수정하기</a><br>
		<a href="deleteB?b=${readB}">삭제하기</a>
	</c:if>
</div>

<a href="main">목록으로</a><br>
</body>
</html>