<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="/xy/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/xy/easyui/jquery.easyui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/xy/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/xy/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/xy/css/myspace.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
$(function(){
	$("#buyer").datagrid({
		idField:'uyerid',
		url:'/xy/buyer/list?page=1&rows=20',
		title:'买家信息',
		width:790,
		fitColumns:true,
		rownumbers:true,
		singleSelect:true,
		striped:true,
		//工具栏
		toolbar:"#tb",
		//分页信息
		pagination:true,
		pageSize:10,
		pageList:[5,10,15,20],
		columns:[[
			{
				field:"buyername",
				title:"订单编号",
				width:100,
				checkbox :true,
				align :'center'
			},{
				field:"realname",
				title:"商品名称",
				width:100,
				align :'center',
				formatter:	function a(val){
					return val.name;
				}
			},{
				field:"email",
				title:"商品数量",
			
				width:100,
				align :'center',
				formatter:	function a(val){
					return val.count;
				}
			},{
				field:"sex",
				title:"商品价格",
				sortable :true,
				align :'center',
				width:100
			},{
				field:"address",
				title:"总金额",
				align :'center',
				width:100
			},{
				field:"buyerpic",
				title:"商品图片",
				align :'center',
				formatter:formaterpic
			},{
				field:"buyerjf",
				title:"下单时间",
				align :'center',
				width:100
			},{
				field:"status",
				align :'center',
				title:"订单状态",
			},{
				field:"bz",
				title:"店家",
				align :'center',
				formatter:formatertype,
			},{
				field:"goodsid",
				align :'center',
				title:"订单详细",
				formatter:formaterdetail
			}
		]]
		
	});
});

</script>
<body>
	<div id="buyer">
	
	</div>
</body>
</html>