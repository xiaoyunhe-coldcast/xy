<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="/xy/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/xy/easyui/jquery.easyui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/xy/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/xy/easyui/themes/icon.css">
     <link rel="stylesheet" type="text/css" href="/xy/css/myspace.css">
<title>我的校易</title>
<script type="text/javascript">
	$(function(){
		$('#left').accordion({    
		    animate:true,
		    width:350,
		    height:800,
		});  
	});

</script>
</head>
<body>
	<div id="top">
		<jsp:include page="/jsp/other/top.jsp"/>
	</div>
	<div id="content">
		<div id="left">
			<div title="个人资料">
				<table >
					<tr>
						<td colspan="2" style="background-color: yellow;" align="center"><b>我的个人信息</b></td>
					</tr>
					<tr>
						<td><b>姓名</b></td>
						<td>${buyer.realname}</td>
					</tr>	
					<tr>
						<td><b>用户名</b></td>
						<td>${buyer.buyername}</td>
					</tr>	
					<tr>
						<td><b>收货地址</b></td>
						<td>${buyer.address}</td>
					</tr>	
					<tr>
						<td><b>联系方式</b></td>
						<td>${buyer.telephone}</td>
					</tr>	
					<tr>
						<td><b>邮箱</b></td>
						<td>${buyer.email}</td>
					</tr>		
					<tr>
						<td colspan="2" align="center">
							<a  class="easyui-linkbutton"  style="width: 100px;height: 50px;" target="main-center" href="#">编辑信息</a></td>
					</tr>		
				</table>
			</div>
			<div title="我的购物车">
				
			</div>
			<div title="购买历史">
			
			</div>
			<div title="评论过的商品">
			
			</div>
			<div title="我的账户">
			
			</div>
		</div>
		<div id="right">
			<iframe name="main-center" style="width:100%;height:100%;border:0px;" src=""></ifranme>
		</div>
	</div>
	<div id="buttom">
		<jsp:include page="/jsp/other/buttom.jsp"/>
	</div>
</body>
</html>