<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="/xy/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/xy/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/xy/easyui/locale/easyui-lang-zh_CN.js"></script>
   
    <link rel="stylesheet" type="text/css" href="/xy/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/xy/easyui/themes/icon.css">
<style type="text/css">
#content{
width: 100%;

}
#content table{
width: 1000px;
height: 300px;
margin-top: 50px;
}
</style>
<title>订单展示</title>
</head>
<script type="text/javascript">

	//删除链接

</script>
<body bgcolor="yellow">
	<div id="top">
		<jsp:include page="/jsp/other/top.jsp"/>
	</div>
	<div id="content" align="center" >
		<table border="0">
			<tr height="50px" align="center">
				<td>订单号</td>
				<td>商品名称</td>
				<td>商品图片</td>
				<td>商品数量</td>
				<td>总金额</td>
				<td>下单时间</td>
				<td>操作</td>
			</tr>
			<tr height="160px">
				<td id="" align="center">${orders.orderid }</td>
				<td align="center">${orders.goods.name}</td>
				<td align="center"><img src="${orders.goods.picture}" alt="1" width="230px" height="130px;"></td>
				<td align="center">${orders.num }</td>
				<td align="center">${orders.total }</td>
				<td align="center">${orders.date }</td>
				<td align="center"><a href="/xy/orders/remove/${orders.orderid }">删除</a>
					&nbsp;&nbsp;
					<c:if test="${orders.status==1 }">
						<a href="#">付款</a>
					</c:if>
					<c:if test="${orders.status==2}">
						<a href="#">确认收货</a>
					</c:if>
					</td>
			</tr>
			<tr height="50px">
				<td colspan="2" align="center">收货地址：${orders.buyer.address}</td>
				<td colspan="2" align="center">卖家 ：${orders.boss.name}</td>
				<td align="center" colspan="3">总金额 ：${orders.total }&nbsp;元&nbsp;<a href="#">结账</a></td>
			</tr>
		</table>
		<div>
		</div>
	</div>
	<div id="buttom">
		<jsp:include page="/jsp/other/buttom.jsp"/>
	</div>
</body>
</html>