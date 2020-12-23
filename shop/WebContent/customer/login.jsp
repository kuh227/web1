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
	<h1>Log In</h1>
</div>
<div id="inner">
	<form action="login.cu" method="post">	
		<label for="id">ID </label>
			<input type="text" name="id" required="required"><br>
		<label for="pw">Password </label>
			<input type="password" name="pw" required="required"><br>
		<input type="submit" value="로그인">
	</form>
</div>
</body>
</html>