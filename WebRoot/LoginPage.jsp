<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>登录页面</title>
</head>
<body>
	提示信息：<%=request.getParameter("Err_remind")%>
	<h2>登录</h2>
	<form action="LoginPro" method="get">
		姓名： <input type="text" name="username" /> <br /> 
		密码： <input type="password" name="password" /><br />
		免登陆？<input type="checkbox" name="nologin" value="nologin" checked="checked"> 
		<input type="submit" value="提交" />
	    <input type="reset" value="重置" />
	</form>

	<br />
	<br />
	<%
		if (application.getAttribute("allcount") == null) {
			application.setAttribute("allcount", new Integer(0));
		}
		Integer count = (Integer) application.getAttribute("allcount");
		application.setAttribute("allcount", new Integer(count.intValue() + 1));
		count = (Integer) application.getAttribute("allcount");
	%>
	该工程的访问次数为：<%=count.intValue()%>
</body>
</html>