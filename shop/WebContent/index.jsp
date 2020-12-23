<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
String pagefile=request.getParameter("page");
if(pagefile==null){
	pagefile="main_center.jsp";
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>inputstream4</title>
<link rel="stylesheet" href="css/KwonSytle.css">
</head>
<body>
	<div>
		<jsp:include page="top.jsp"></jsp:include>
	</div>
	<div>
		<jsp:include page="<%= pagefile %>"></jsp:include>
	</div>
</body>
</html>