<%@page import="customer_model.cusDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dto" class="customer_model.cusDTO" scope="page"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/KwonStyle.css">
</head>
<body>
<%
dto = (cusDTO)request.getAttribute("dto");
String name = dto.getName();
String id = dto.getId();
String pw = dto.getPw();
String addr = dto.getAddr();
String tel = dto.getTel();
%>
<div id="title">
	<h1>My page</h1>
</div>
<div id="inner">
	<form action="update.cu" method="post">
		<label for="name">이름 </label>
			<input type="text" id="name" name="name" readonly="readonly" value="<%=name%>"><br>
		<label for="id">ID </label>
			<input type="text" id="id" name="id" readonly="readonly" value="<%=id%>"><br>
		<label for="pw">Password </label>
			<input type="password" id="pw" name="pw" required="required" value="<%=pw%>"><br>
		<label for="addr">주소 </label>
			<input type="text" id="addr" name="addr" value="<%=addr%>"><br>
		<label for="tel">전화번호 </label>
			<input type="text" id="tel" name="tel" value="<%=tel%>"><br>
		<input type="submit" value="수정">
	</form>
	<form action="signout.cu" method="post" onsubmit="return confirm('정말로 탈퇴하시겠습니까?');">
		<input type="hidden" name="id" value="<%=id%>">
		<input type="submit" value="회원탈퇴">
	</form>
</div>
</body>
</html>