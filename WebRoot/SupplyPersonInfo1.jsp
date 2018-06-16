<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>完善个人信息1</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <jsp:include page="head.jsp"></jsp:include>
     <form id="ddddd" method="get" action="NewRegister">
			
		年龄：<input  id="ageid"  type='text' name='age'/><br>
    	性别：<input  id="sexid1"  type='radio' name='sex' checked='checked' value='女'/>女
    		  <input  id="sexid2"  type='radio' name='sex' value='男'/>男<br>
    	家庭住址：<input id="address"  type='text' name='address'/><br>
    	联系方式：<input id="tel"     type='text' name='tel'/><br>
    	email：<input  id="email"  type='text' name='email'/><br>
    	
    		<input type='button' value='下一步' onclick="getaa()" /><br />

			<div id="twi">
			</div>
		</form>
		<script type="text/javascript">
			var inputA = document.getElementById('ageid'); 
			var inputB = document.getElementsByName('sex');
			var inputC = document.getElementById('address');
			var inputD = document.getElementById('tel');
			var inputF = document.getElementById('email');

			function getaa() {
				if(inputA.value != ''&&inputB.value != ''&&inputC.value != ''&&inputD.value!=''&&inputF.value!='') {
					twice();
				} else {
					alert("请补全信息在进行下一步");
				}
			}
			function getbb(){
				if(document.getElementsByName('highestEducation')!=''&&document.getElementsByName('graduateSchool')!=''&&document.getElementById('major')!=''){
					document.getElementById('ddddd').submit();
				}else{
					alert('请补全信息在进行下一步');
				}
			}
			function twice(){
				document.getElementById('twi').innerHTML="最高学历：<select name='highestEducation'><option value='学士'>学士</option><option value='硕士'>硕士</option>"
				+"<option value='博士'>博士</option><option value='其他'>其他</option></select><br>毕业院校：<select name='graduateSchool'><option value='北京大学'>北京大学</option>"
				+"<option value='清华大学'>清华大学</option><option value='其他院校'>其他院校</option></select><br>所学专业：<input id='major' type='text' name='major'/><br>"
				+"<input type='submit' onclick='getbb()'  value='保存'>";
			}
		</script>
  </body>
</html>
