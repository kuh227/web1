<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/KwonStyle">
</head>
<body>
<div id="title">
	<h1>Q&A</h1>
</div>
<div id="register">
<form action="register.bo" method="post">
	<label for="title">제목</label>
	<input type="text" name="title"><br>
	<label for="author">작성자</label>
	<input type="text" name="author"><br>
	<label for="content">내용</label>
	<textarea rows="40" cols="40" name="content"></textarea><br>
	<label for="nal">날짜</label>
	<input type="date" name="nal" id="now_date" readonly="readonly"><br>
	<input type="hidden" name="readCount" value="0">
	<input type="submit" value="등록">
</form>
</div>
<script>
	document.getElementById('now_date').value = new Date().toISOString().substring(0, 10);;
</script>
</body>
</html>