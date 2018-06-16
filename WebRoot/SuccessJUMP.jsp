<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	var time = 2;
	function returnUrlByTime() {
		window.setTimeout('returnUrlByTime()', 1000);
		time = time - 1;
		document.getElementById("layer").innerHTML = time;
	}
</script>
<title>成功页~</title>
</head>
<body onload="returnUrlByTime()">
	<h3> 完善个人信息成功~~</h3>  
    <b><span id="layer">2</span>秒后,进入个人首页。</b>  
    <%  
        response.setHeader("Refresh", "3;URL=Main.jsp");  
    %>  
</body>
</html>