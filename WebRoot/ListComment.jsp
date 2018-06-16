<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书籍列表</title>
</head>
<body style="text-align: center;">
	<jsp:include page="head.jsp"></jsp:include>
	<h1>评论列表</h1>
	<table width="70%" border="1" align="center">
		<tr>
			<td>评论物品</td>
			<td>评论人</td>
			<td>时间</td>
			<td>评论内容</td>
		</tr>

		<c:forEach var="entry" items="${requestScope.coms}">
			<tr>
				<td>${entry.c_item }</td>
				<td>${entry.c_username}</td>
				<td>${entry.c_time }</td>
				<td>${entry.c_comment }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="ListBookServlet" target="_blank">查看商店</a>
</body>
</html>