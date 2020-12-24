<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="title">
	<h1>find PW</h1>
</div>
<div id="inner">
	<form action="searchPw.cu" method="post">
		<label for="id">아이디</label>
			<input type="text" name="id" required="required"><br>
		<label for="name">이름</label>
			<input type="text" name="name" required="required"><br>
		<label for="tel">전화번호</label>
			<input type="text" name="tel" required="required"><br>
		<input type="submit" value="찾기">
	</form>
</div>
</body>
</html>