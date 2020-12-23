<%@page import="java.sql.ResultSet"%>
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
	<h1>Detail</h1>
</div>
<div id="boDetail">
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
	readCount = rs.getString("readCount");
}
%>
<table>
	<tr><td>제목</td><td><%=title %></td></tr>
	<tr><td>작성자</td><td><%=author %></td></tr>
	<tr><td>내용</td><td><%=content %></td></tr>
	<tr><td>작성일자</td><td><%=nal %></td></tr>
	<tr><td>조회수</td><td><%=readCount %></td></tr>
</table>
<input type="button" value="수정" onclick="location.href='update.bo?no=<%=no%>'">
<input type="button" value="삭제" onclick="location.href='delete.bo?no=<%=no%>'">
<input type="button" value="목록으로" onclick="location.href='list.bo'">
</div>

</body>
</html>