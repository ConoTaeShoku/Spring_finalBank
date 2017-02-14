<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>

<table>

<tr>
	<th>ID</th>
	<td>
		<input type="text" id="id" name="id" placeholder="ID 중복확인 이름">
		<input type="button" value="ID 중복 확인">
	</td>
</tr>
<tr>
	<th colspan="2">비밀번호</th>
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
		<input type="checkbox" id="division" name="division" value="personal">개인
		<input type="checkbox" id="division" name="division" value="company">기업
	</td>
</tr>
<tr>
	<th>식별번호</th>
	<td><input type="text" id="id" name="id" placeholder="개인 : 주민번호, 기업: 사업자번호"></td>
</tr>
<tr>
	<th>주소</th>
	<td><input type="text" id="address" name="address" placeholder="주소 입력"></td>
</tr>
</table>

	<input type="submit" value="가입">
	<input type="reset" value="초기화">

</form>

</body>
</html>