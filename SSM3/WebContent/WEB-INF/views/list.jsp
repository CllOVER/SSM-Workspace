<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<span>当前登录：${session_in.username}</span>

	<a href="/SSM2/User/login">注销</a>
	<table border="1" >
	<a href="/SSM2/User/edit">保存</a>
	<tr>
	<td>id</td>
	<td>username</td>
	<td>password</td>
	<td>Date</td>
	<td>operate</td>
	</tr>
	<c:forEach items="${User}" var="e">
	<tr>
	<td>${e.id }</td>
	<td>${e.username }</td>
	<td>${e.password }</td>
	<td><fmt:formatDate value="${e.birthday }" pattern="yyyy-MM-dd"/></td>
	<td>
	<a href="/SSM2/User/edit">编辑</a>
	<a href="/SSM2/User/delete">删除</a>
	</td>
	</tr>
	</c:forEach>
	</table>
	</center>
</body>
</html>