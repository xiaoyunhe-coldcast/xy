<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
#content tr{


}



</style>
<title>Insert title here</title>
</head>

<body>
	<div id="top">
		<jsp:include page="/jsp/other/top.jsp"/>
	</div>
	<div id="content" align="center">
		<table border="1">
			<tr height="50px" align="center">
				<td>订单号</td>
				<td>商品名称</td>
				<td>商品数量</td>
				<td>总金额</td>
				<td>下单时间</td>
				<td>操作</td>
			</tr>
			<tr>
				<td>${orders.orderid }</td>
				<td>${orders.goods.name}</td>
				<td>${orders.num }</td>
				<td>${orders.total }</td>
				<td>${orders.date }</td>
				<td><a href="">删除</a><a href="#">其他</a></td>
			</tr>
			<tr height="50px">
				<td colspan="2">收货地址：${orders.buyer.address}</td>
				<td colspan="2">卖家 ：${orders.boss.name}</td>
				<td>结账 ：<a href="#"></a></td>
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