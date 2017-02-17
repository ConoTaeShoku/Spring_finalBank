<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>[ main.jsp ]</title>
</head>
<body>

<div class="wrapper">

<form action="" method="post">
<select>
	<option>제목</option>
	<option>작성자</option>
	<option>내용</option>
</select>
<input type="text" name="">
<input type="submit" value="검색">
</form>




	<h2>[ 게시글 목록]</h2>
	
	<table board="1">
		<tr>
			<th>글 번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:if test="${not empty blist}">
			<c:forEach var="board" items="${blist}">
			<tr>
				<td><a href="selectB=${board.boardnum}">${board.boardnum}</a></td>
				<td>${board.title}</td>
				<td>${board.custid}</td>
				<td>${board.inputdate}</td>
				<td>${board.hits}</td>
			</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty blist}">
			<tr>
				<td colspan="5">아직 등록된 글이 없어요~</td>
			</tr>
		</c:if>
	</table>

<div>
paging 처리할 부분
</div>

<div>
<a href="${pageContext.request.contextPath}/">돌아갈래용</a><br>
<a href="insertB">글쓸래용</a>
</div>
	
</div>
</body>
</html>