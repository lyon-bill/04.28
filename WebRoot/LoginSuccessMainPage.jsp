<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="student"  class="login.Do.Student" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录成功</title>
</head>
<body>
	<%! int count=1; %>
	<%
	ServletContext SC = getServletContext();
	Integer allcount = (Integer) SC.getAttribute("allcount");
	if (allcount == null) {
		SC.setAttribute("allcount", allcount);
		allcount = 1;
	} else {
		SC.setAttribute("allcount", allcount+1);
	}
	%>
	<div style="text-align: center;">
		thisClass:<%=this.getClass() %>
		提示信息：<%=request.getParameter("Succ_remind")%><br>
		当前的用户信息为：<br />
		当前用户名：<jsp:getProperty property="name" name="student"/><br>
		当前用户密码：<jsp:getProperty property="password" name="student"/><br>
		当前用户登录时间：<jsp:getProperty property="loginTime" name="student"/><br>
		<a href='PersonalMainPage'>个人主页</a><br />
		<a href='SupplyPersonInfo1.jsp'>完善个人信息</a><br />
		<a href='SeePersonInfo'>查看个人信息</a><br />
		<a href='ListBookServlet'>查看SD</a><br />
		<a href='listcart.jsp'>查看GWC</a><br />
		当前页面访问次数：<%=(count++)%>
		当前的工程的访问次数为：<%=allcount%>
	</div>
	
	
</body>
</html>