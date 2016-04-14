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
				<table>
					<tr>
						<td colspan="2" style="background-color: yellow;" align="center"><b>我的订单</b></td>
					</tr>
					<c:if test="${empty orderslist }">
						<tr>
							<td><a href="#">暂时没有订单</a></td>
							<td><a href="#">点击去购物</a></td>
						</tr>
					</c:if>
					<c:forEach items="${orderslist}" var="o" begin="1" end="4" >
						<tr>
							<td>商品名称</td>
							<td>${o.goods.name}</td>
						<tr>
						<tr>
							<td>总金额</td>
							<td>${o.total}</td>
						</tr>
						<tr>
							<td>订单状态</td>
							<c:if test="${o.status==1 }">
								<td><a href="#">未下单</a></td>
							</c:if>
							<c:if test="${o.status==2 }">
								<td><a href="#">已下单</a></td>
							</c:if>
							<c:if test="${o.status==3 }">
								<td><a href="#">待收货</a></td>
							</c:if>
						</tr>
						<tr height="10px">
							<td>----------------------</td>
						</tr>
				</c:forEach>
				<tr>
					<td colspan="2" align="center"><a href="#">查看所有订单</a></td>
				</tr>
				</table>
				
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