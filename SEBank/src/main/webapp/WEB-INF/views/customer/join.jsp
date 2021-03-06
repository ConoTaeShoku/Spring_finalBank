<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>[ join.jsp ]</title>

<script type="text/javascript">
function formCheck() {
	var id = document.getElementById('custid');
	var pw = document.getElementById('password');
	var pw2 = document.getElementById('password2');
	var nm = document.getElementById('name');
	var idno = document.getElementById('idno');
	
	if (id.value.length < 3 || id.value.length > 10) {
		alert('ID는 3~10자로 입력하세요.');
		return false;
	}
	if (pw.value.length < 3 || pw.value.length > 10) {
		alert("비밀번호는 3~10자로 입력하세요.");
		return false;
	}
	if (pw.value != pw2.value) {
		alert('비밀번호를 정확하게 다시 입력하세요.');
		return false;
	}
	if (nm.value == '') {
		alert('이름을 입력하세요.');
		return false;
	}
	if (idno.value == '') {
		alert('식별번호를 입력하세요.');
		return false;
	}
	return true;
}
function idCheckOpen() {
	window.open("${pageContext.request.contextPath}/idcheck","idCheckWin", "top=200, left=400, width=400, height=250");
}
</script>
</head>
<body>

<form action="join" method="post">

<table>
<tr>
	<th>ID</th>
	<td>
		<input type="text" id="custid" name="custid" placeholder="ID 중복확인 이름">
		<input type="button" value="ID 중복 확인" onClick="return idCheckOpen()">
	</td>
</tr>
<tr>
	<th rowspan="2">비밀번호</th>
	<td><input type="password" id="password" name="password" placeholder="비밀번호 입력"></td>
</tr>
<tr>
	<td><input type="password" id="password2" name="password2" placeholder="비밀번호 다시 입력"></td>
</tr>
<tr>
	<th>이름</th>
	<td><input type="text" id="name" name="name" placeholder="이름 입력"></td>
</tr>
<tr>
	<th>이메일</th>
	<td><input type="text" id="email" name="email" placeholder="이메일 입력"></td>
</tr>
<tr>
	<th>고객구분</th>
	<td>
		<input type="radio" id="division" name="division" value="personal" checked>개인
		<input type="radio" id="division" name="division" value="company">기업
	</td>
</tr>
<tr>
	<th>식별번호</th>
	<td><input type="text" id="idno" name="idno" placeholder="개인 : 주민번호, 기업: 사업자번호"></td>
</tr>
<tr>
	<th>주소</th>
	<td><input type="text" id="address" name="address" placeholder="주소 입력"></td>
</tr>
</table>
	<input type="submit" value="가입" onclick="return formCheck()">
	<input type="reset" value="초기화">
</form>
</body>
</html>