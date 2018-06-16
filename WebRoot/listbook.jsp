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
	<h1>书籍列表</h1>
	<table width="70%" border="1" align="center">
		<tr>
			<td>书名</td>
			<td>价格</td>
			<td>描述</td>
			<td>操作</td>
		</tr>

		<c:forEach var="entry" items="${requestScope.books}">
			<tr>
				<td>${entry.name }</td>
				<td>${entry.price }</td>
				<td>${entry.description }</td>
				<td><a href="AddBookServlet?id=${entry.id }" target="_blank">加入购物车</a>|<a href="SearchCommentServlet?itemname=${entry.id }" target="_blank">查看评论</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="listcart.jsp" target="_blank">查看购物车</a>
</body>
</html>