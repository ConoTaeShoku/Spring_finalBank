<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>[ read.jsp ]</title>
<script>
function deleteCheck(bnum) {
	var answer = confirm("글을 삭제하시겠습니까?");
	if(answer) {
		location.href = "deleteB?bnum="+bnum;
	}
}
</script>
</head>
<body>

<c:if test="${not empty resultR}">
<script>alert('${resultR}');</script>
<c:remove var="resultR" scope="session" />
</c:if>

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
		<td><pre>${readB.content}</pre></td>
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
<c:if test ="${readB.originalfile != null}">
	<tr>
		<td rowspan="2"><a href="download?boardnum=${readB.boardnum}">첨부파일 다운받기</a></td>
	</tr>	
</c:if>	 
</table><br>

<div class="menu">
	<c:if test="${readB.custid == loginId}">
		<a href="updateB?boardnum=${readB.boardnum}">수정하기</a><br>
		<a href="javascript:deleteCheck(${readB.boardnum})">제대로 삭제하기</a><br>
		<a href="deleteB?bnum=${readB.boardnum}">대충 삭제하기</a><br>
		<a href="main">목록으로</a><br>
	</c:if>
</div>

<form action="insertR" method="post">
	<input type="text" name="text" id="text" />
	<input type="hidden" name="boardnum" id="boardnum" value="${readB.boardnum}" />
	<input type="submit" value="댓글등록" />
</form>

<table>
	<tr>
		<th>custid</th>
		<th>text</th>
		<th>inputdate</th>
		<th>actions</th>
	</tr>
<c:if test="${empty rlist}">
	<tr>
		<td colspan="4">댓글이 없어용~~~~~~~</td>
	</tr>
</c:if>
<c:if test="${not empty rlist}">
	<c:forEach var="reply" items="${rlist}">
	<tr>
		<td>${reply.custid}</td>
		<td>${reply.text}</td>
		<td>${reply.inputdate}</td>
		<td>
			<input type="button" value="수정" />
			<input type="button" value="삭제" />
		</td>
	</tr>
	</c:forEach>
</c:if>
</table>

</body>
</html>