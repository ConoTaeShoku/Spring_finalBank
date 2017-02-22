<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>[ modify.jsp ]</title>
<script type="text/javascript">
function formCheck() {
	var title = document.getElementById('title');
	var content = document.getElementById('content');
	if (title.value.length == 0) {
		alert("제목을 입력하세요");
		return false;
	}
	if (content.value.length == 0) {
		alert('내용을 입력하세요');
		return false;
	}
	return true;
}
</script>
</head>
<body>
<h2>[게시판 글 수정]</h2>
<br>
<form action="updateB" method="post">
	<input type="hidden" name="id" id="id" value="${loginId}" />
	<table>
	<tr>
		<td>boardnum</td>
		<td>${readB.boardnum}</td>
		<input type="hidden" name="boardnum" value="${readB.boardnum}" />
	</tr>
	<tr>
		<td>custid</td>
		<td>${readB.custid}</td>
	</tr>
	<tr>
		<td>title</td>
		<td><input type="text" name="title" id="title" value="${readB.title}"></td>
	</tr>
	<tr>
		<td>content</td>
		<td><textarea rows=5 name="content" id="content" style="width:98%;">${readB.content}</textarea></td>
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

	<input type="submit"value="수정" onclick="return formCheck()">

</form>
<div>
<a href="main">목록으로 돌아갈래</a>
</div>
</body>
</html>