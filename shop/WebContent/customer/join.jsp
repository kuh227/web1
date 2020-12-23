<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/Kwonsytle">
</head>
<body>
<div id="title">
	<h1>Join</h1>
</div>
<div id="inner">
	<form action="join.cu" method="get">
		<label for="name">이름 </label>
			<input type="text" id="name" name="name" required="required"><br>
		<label for="id">ID </label>
			<input type="text" id="id" name="id" required="required"><br>
		<label for="pw">Password </label>
			<input type="password" id="pw" name="pw" required="required"><br>
		<label for="addr">주소 </label>
			<input type="text" id="addr" name="addr"><br>
		<label for="tel">전화번호 </label>
			<input type="text" id="tel" name="tel"><br>
		<input type="submit" value="가입">
	</form>
</div>
</body>
</html>