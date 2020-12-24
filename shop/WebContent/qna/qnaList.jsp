<%@page import="board_model.boDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dto" class="board_model.boDTO" scope="page"></jsp:useBean>
<jsp:useBean id="dao" class="board_model.boDAO" scope="page"></jsp:useBean>
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
<div id="list">
	<table>
		<tr><th>제목</th><th>작성자</th><th>날짜</th><th>조회수</th></tr>
		<%
		ArrayList<boDTO> boList = (ArrayList<boDTO>)request.getAttribute("boList");
		for(int i=0; i<boList.size(); i++){
			dto = boList.get(i);
		out.print("<tr><td><a href='detail.bo?no="+dto.getNo()+"'>"+dto.getTitle()+"</a></td>");
		out.print("<td>"+dto.getAuthor()+"</td>");
		out.print("<td>"+dto.getNal()+"</td>");
		out.print("<td>"+dto.getReadCount()+"</td></tr>");
		}
		%>
	</table>
	<form action="" method="post">
		<input type="text" name="searchTitle">
		<input type="submit" value="search">
	</form>
	<input type="button" value="글쓰기" onclick="location.href='index.jsp?page=qna/qna.jsp'">
</div>
</body>
</html>
