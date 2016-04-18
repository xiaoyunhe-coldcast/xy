<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="/xy/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/xy/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/xy/easyui/locale/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" type="text/css" href="/xy/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/xy/easyui/themes/icon.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	//转译函数
	function formatertype(val){
		if (val =="1"){
			return '手机';
		}
		if (val =="2"){
			return '服装';
		}
		if (val =="3"){
			return '资料';
		}
	}
	
	//
	function formaterdetail(val){
		return '<a href="/xy/orders/query/{'+val+'}" >商品详细</a>';
		}
	
	function formaterpic(val){
		return '<img src="'+val+'" style="width:100px;height:50px" alt=>';
	}
	
	$(function(){
		$("#goods").datagrid({
			idField:'goodsid',
			url:'/xy/orders/list',
			title:'订单信息',
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
					field:"name",
					title:"订单编号",
					width:100,
					checkbox :true,
					align :'center'
				},{
					field:"boss",
					title:"商品名称",
					width:100,
					align :'center',
					formatter:	function a(val){
						return val.name;
					}
				},{
					field:"storage",
					title:"商品数量",
				
					width:100,
					align :'center',
					formatter:	function a(val){
						return val.count;
					}
				},{
					field:"price",
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
					field:"picture",
					title:"商品图片",
					align :'center',
					formatter:formaterpic
				},{
					field:"description",
					title:"下单时间",
					align :'center',
					width:100
				},{
					field:"bz",
					align :'center',
					title:"订单状态",
				},{
					field:"type",
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
<body >
	<div>
		
	</div>
	<div id="goods" align="center">
		<div id="tb">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true"/a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true"/a>
	</div>
	</div>
</body>
</html>