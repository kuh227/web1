<%@page import="java.sql.ResultSet"%>
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
	<h1>게시글 수정</h1>
</div>
<div id="register">
<%
ResultSet rs = (ResultSet)request.getAttribute("rs");
int no=0;
String title=null;
String author=null;
String content=null;
String nal=null;
String readCount=null;
if(rs.next()){
	no = rs.getInt("no");
	title = rs.getString("title");
	author = rs.getString("author");
	content = rs.getString("content");
	nal = rs.getString("nal");
}
%>
<form action="updateAcc.bo" method="post">
	<label for="title">제목</label>
	<input type="text" name="title" value="<%=title%>"><br>
	<label for="author">작성자</label>
	<input type="text" name="author" value="<%=author%>"><br>
	<label for="content">내용</label>
	<textarea rows="40" cols="40" name="content"><%=content %></textarea><br>
	<label for="nal">날짜</label>
	<input type="date" name="nal" value="<%=nal %>"><br>
	<input type="hidden" name="no" value="<%=no%>">
	<input type="submit" value="수정">
	<input type="button" value="취소" onclick="location.href='list.bo'">
</form>
</div>
</body>
</html>