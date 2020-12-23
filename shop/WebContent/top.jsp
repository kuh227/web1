<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<link rel="stylesheet" href="css/KwonStyle.css">
</head>
<body>
<div class="dropmenu">
		<ul id="menu_title">
			<li><a href="#">ALL product</a>
			</li>
			<li><a href="#">Categories</a>
				<ul>
					<li><a href="#">Top</a></li>
					<li><a href="#">Bottom</a></li>
					<li><a href="#">Acc</a></li>
					<li><a href="#">Other</a></li>
				</ul>
			</li>
			<li><a href="#">LookBook</a>
				<ul>
					<li><a href="#">2019</a></li>
					<li><a href="#">2020</a></li>
				</ul>
			</li>
		</ul>
</div>
	
<script type="text/javascript">
	$(".dropmenu ul li").hover(function(){
		$(this).find("ul").stop().fadeToggle(300);
	});
</script>

<div id=sidemenu>
	<a href="index.jsp">Home</a>
	<a href="#">Cart</a>
	<%
	if(session.getAttribute("id")==null){
		out.print("<a href='index.jsp?page=customer/login.jsp'>Login</a>");
		out.print("<a href='index.jsp?page=customer/join.jsp'>Join</a>");
	}else{
		out.print("<a href='logout.cu'>Logout</a>");
		out.print("<a href='mypage.cu'>My page</a>");
	}
	%>
	<a href="list.bo">Q&A</a>
</div>
</body>
</html>