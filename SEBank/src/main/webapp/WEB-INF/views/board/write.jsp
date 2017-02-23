<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>[ write.jsp ]</title>
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
<h2>[게시판 글 쓰기]</h2>
<br>
<form action="insertB" method="post" enctype="multipart/form-data">
	
	<table>
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" id="title" style="width:98%;"/></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea rows=5 name="content" id="content" style="width:98%;"></textarea></td>
		</tr>
		<tr>
			<td>파일첨부</td>
			<td><input type="file" name="upload" id="upload" /></td>
		</tr>
	</table><br>
	<div class="center">
		<input type="submit"value="저장" onclick="return formCheck()">
		<input type="reset" value="초기화">
	</div>
</form>
<div>
<a href="main">목록으로 돌아갈래</a>
</div>
</body>
</html>