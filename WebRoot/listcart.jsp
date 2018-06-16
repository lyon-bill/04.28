<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车列表</title>
		<style>
			.box {
				display: none;
				/* 默认对话框隐藏 */
			}
		</style>
<script type="text/javascript">
    	function deleteItem(id){
    	var  b = window.confirm("确定要删除吗？");
           if(b){
				window.location.href="DeleteItemServlet?id="+id;        
           }
    	}
    	function clearcart(){
    	var  b = window.confirm("确定要清空您当前所选的商品吗？");
           if(b){
				window.location.href="ClearCartServlet";           
           }
    	}
    
    </script>
</head>
<body style="text-align: center;">
	<script>
		function msgbox(n) {
			document.getElementById('inputbox').style.display = n ? 'block' : 'none'; /* 点击按钮打开/关闭 对话框 */
		}
	</script>
	<jsp:include page="head.jsp"></jsp:include>
	<h1>购物车列表</h1>
	<c:if test="${empty(cartmap) }">
        您没有购买任何商品！！！
    </c:if>

	<c:if test="${!empty(cartmap)}">
		<table width="70%" border="1" align="center">
			<tr>
				<td>书编号</td>
				<td>书名</td>
				<td>单价</td>
				<td>数量</td>
				<td>小计</td>
				<td>操作</td>
			</tr>

			<c:set var="sum" value="0"></c:set>
			<c:forEach var="me" items="${cartmap}">
				
				<c:set var="sum" value="${sum+me.value.book.price*me.value.num}"></c:set>
				
				<tr>
					<td>${me.value.book.id }</td>
					<td>${me.value.book.name}</td>
					<td>${me.value.book.price}</td>
					<td>${me.value.num}</td>
					<td>${me.value.book.price*me.value.num}</td>
					<td><input type="button" onClick="msgbox(1)" value="评论">|<a href="javascript:deleteItem(${me.key })">删除</a>
					</td>
				</tr>
				<div id='inputbox' class="box">
					<a class='x' href='' onclick="msgbox(0); return false;">关闭</a>
					<form action="CommentHandleServlet" method="get">
						评论内容：<textarea cols="100" rows="3" name="content"></textarea>
						<input type="text" name="id" value="${me.value.book.id}" style="display: none;"/>
						<input type="submit" value="提交">
					</form>
				</div>
			</c:forEach>
			<tr>
				<td colspan="3">总价</td>
				<td colspan="2">${sum}</td>
				<td><a href="ClearCartServlet">清空购物车</a>
				</td>
			</tr>

		</table>
		

	</c:if>
</body>
</html>