<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ idCheck.jsp ]</title>

<script type="text/javascript">
function formCheck() {
	var id = document.getElementById('id');
	
	if (id.value.length < 3 || id.value.length > 10) {
		alert('ID는 3~10자로 입력하세요.');
		return false;
	}
	return true;
}
function isSelected(id) {
	opener.document.getElementById("custid").value=id;
	this.close();
}
</script>

</head>
<body>

<form action="idcheck" method="post" onsubmit="return formCheck()">
	<input type="text" name="id" id="id" placeholder="검색할 아이디 입력" />
	<input type="submit" value="검색" />
</form><br>
<c:if test="${not empty check}">
	<c:if test="${empty sameid}">
		${id} : 사용할 수 있는 ID입니다.
		<input type="button" value="use" onClick="isSelected('${id}')">
	</c:if>
	<c:if test="${not empty sameid}"> 
		${id} : 이미 사용 중인 ID입니다.
	</c:if>
</c:if>
</body>
</html>