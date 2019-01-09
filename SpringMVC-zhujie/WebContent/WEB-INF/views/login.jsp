<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<span>${msg}</span>
<%
	session.invalidate();
%>
<hr/>
<form action="/SpringMVC-Case/User/login" method="post">
账号：<input type="text" name="username" ><br>
密码：<input type="password" name="password"><br>
<input type="submit"><br>
</form>
</center>
</body>
</html>