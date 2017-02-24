<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">

<meta http-equiv="refresh" content="5;url=${pageContext.request.contextPath}" />

<title> [ error.jsp ] </title>

<style type="text/css">
div.wrapper {
	width:1100px;
	text-align:center;
	margin:0 auto;
}
</style>

</head>
<body>

<div class="wrapper">
	<h1>[ 오류 발생 ]</h1>
	<div><img src="${pageContext.request.contextPath}/resources/images/error.jpg" /></div>
	<p>5초 후 첫 화면으로 이동합니다. 다시 이용해주시기 바랍니다. </p>
</div>


</body>
</html>