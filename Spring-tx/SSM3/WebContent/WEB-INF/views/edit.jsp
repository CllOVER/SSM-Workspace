<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<form action="/SSM2/User/su" method="post">
	
	<!-- 隐藏id防止出现错误 -->
<input type="hidden" name="id" value="${user.id}" ><br/>
	用户名:<input type="text" name="username" value="${user.username} " ><br/>
	密码:<input type="password" name="password" value="${user.id}" ><br/>
	日期:<input type="text" name="birthday" value="${user.id}" ><br/>
		<input type="submit" name="保存" value="" >
</form>
</center>
</body>
</html>