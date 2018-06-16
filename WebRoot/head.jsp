<%@ page language="java" contentType='text/html' pageEncoding='utf-8'%>
<jsp:useBean id="student" class="login.Do.Student" scope="session"></jsp:useBean>
当前登录的用户是：<jsp:getProperty property="name" name="student"/><br/>
登录的时间是：<jsp:getProperty property="loginTime" name="student"/><br/>
<div style="text-align: center;">
	<a href="LoginSuccessMainPage.jsp">|主页|</a><a href="listcart.jsp">购物车|</a><a href="ListBookServlet">商店|</a><a href="LoginPage.jsp">登录|</a><a href="#">注销|</a>
</div>

