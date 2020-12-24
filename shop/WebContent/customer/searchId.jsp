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
	<h1>find ID</h1>
</div>
<div id="inner">
	<form action="searchId.cu" method="post">	
		<label for="name">찾으실 이름</label>
			<input type="text" name="name" required="required"><br>
		<label for="tel">전화번호</label>
			<input type="text" name="tel" required="required"><br>
		<input type="submit" value="찾기">
	</form>
</div>
</body>
</html>