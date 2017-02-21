<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>[ main.jsp ]</title>
<style>
.wrapper {
	width : 700px;
	margin : 0 auto;
	<!-- text-align:center; -->
}

</style>
<script>
function pagingForSubmit(currentPage) {
	var form = document.getElementById("pagingForm");
	var page = document.getElementById("page");
	page.value = currentPage;
	form.submit();
}
</script>
</head>
<body>

<c:if test="${not empty resultB}">
<script>alert('${resultB}');</script>
<c:remove var="resultB" scope="session" />
</c:if>

<h5>total : ${total}</h5>
<h5>searchTitle : ${searchTitle}</h5>
<h5>searchText : ${searchText}</h5>
<h5>navi : ${navi}</h5>

<div class="wrapper">
<form id="pagingForm" action="main" method="get">
	<select name="searchTitle">
		<option value="" >검색할래?</option>
		<option value="title" >제목</option>
		<option value="custid">작성자</option>
		<option value="content">내용</option>
	</select>
	<input type="hidden" name="page" id="page"/>
	<input type="text" name="searchText" value="${searchText}" />
	<input type="button" onclick="pagingForSubmit(1)" value="검색" />
</form>

	<h2>[ 게시글 목록]</h2>
	
	<table border="1">
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
				<td>${board.boardnum}</td>
				<td><a href="selectB?boardnum=${board.boardnum}">${board.title}</a></td>
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
<a href="javascript:pagingForSubmit(1)">◁◁</a> &nbsp;
<a href="javascript:pagingForSubmit(${navi.currentPage - 1})">◀</a> &nbsp;
<c:forEach var="counter" begin="${navi.startPageGroup}" end="${navi.endPageGroup}">
	<a href="javascript:pagingForSubmit(${counter})">${counter}</a> &nbsp;
</c:forEach>
<a href="javascript:pagingForSubmit(${navi.currentPage + 1})">▶</a> &nbsp;
<a href="javascript:pagingForSubmit(${navi.totalPageCount})">▷▷ </a>
</div>

<div>
<a href="${pageContext.request.contextPath}/">돌아갈래용</a><br>
<a href="insertB">글쓸래용</a>
</div>

</div>
</body>
</html>