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

	
	$(function(){
		//转译函数
		function formatertype(val){
			if (val =="1"){
				return '<a href="">待付款</a>';
			}
			if (val =="2"){
				return '<a href="#">已发货</a>';
			}
			if (val =="3"){
				return '<a href="#">确认收货</a>';
			}
			if (val >="4"){
				return '<a href="#">w</a>';
			}
		}
		
		//详情函数
		function detail(value){
			return '<a href="/xy/orders/query/'+value+'">订单详细</a>';
			}
		//数据表格
		
		$("#order").datagrid({
			idField:'orderid',
			url:'/xy/orders/list',
			title:'订单信息',
			width:850,
			height:500,
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
					field:"num",
					title:"商品数量",
					width:80,
					align :'center',
				},{
					field:"total",
					title:"总金额",
					align :'center',
					width:100
				},{
					field:"date",
					title:"下单时间",
					align :'center',
					width:100
				},{
					field:"status",
					align :'center',
					title:"订单状态",
					formatter:formatertype,
					width :80
					
				}
				,{
					field:"orderid",
					align :'center',
					title:"订单详细",
					formatter:detail
				}
			]]
			
		});
	});
</script>
<body >
	<div>
		
	</div>
	<div id="order" align="center">
	</div>
	</div>
</body>
</html>