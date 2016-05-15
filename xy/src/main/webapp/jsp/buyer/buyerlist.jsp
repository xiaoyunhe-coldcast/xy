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
    <script type="text/javascript" src="/xy/easyui/locale/easyui-lang-zh_CN.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
//
function formaterdetail(val){
	return '<a href="/xy/goods/query/'+val+'?pageIndex=1&pagesize=20" target="_top">商品详细'
			+'</a>&nbsp; <input type="button" onclick="remove('+val+')" value="删除"/>';
	}

function formaterpic(val){
	return '<img src="'+val+'" style="width:100px;height:50px" alt ="1">';
}

$(function(){
	function remove(val){
		alert("e");
	    $.ajax({
			url:'/xy/buyer/remove/',
			type:'post',
			dataType:'json',
			success:function(result){
				$.messager.show({
					title : '系统消息',
					msg : result.msg,
					timeout : 5000,
					showType : 'slide'
					});  
				}
			});
		}
		
		
	
	
	//数据表格
	$("#buyer").datagrid({
		idField:'buyerid',
		url:'/xy/buyer/list',
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
				title:"买家用户名",
				width:100,
				checkbox :true,
				align :'center'
			},{
				field:"realname",
				title:"真实姓名",
				width:100,
				align :'center',
				formatter: function a(val){
					return val;
				}
			},{
				field:"email",
				title:"邮箱地址",
				width:100,
				align :'center',
				formatter:	function a(val){
					return val;
				}
			},{
				field:"sex",
				title:"性别",
				sortable :true,
				align :'center',
				width:100
			},{
				field:"address",
				title:"收货地址",
				align :'center',
				width:100
			},{
				field:"buyerpic",
				title:"用户头像",
				align :'center',
				formatter:formaterpic
			},{
				field:"buyerjf",
				title:"积分",
				align :'center',
				width:100
			},{
				field:"status",
				align :'center',
				title:"用户状态",
			},{
				field:"bz",
				title:"备注信息",
				align :'center',
				//formatter :formatertype,
			},{
				field:"buyerid",
				align :'center',
				title:"操作",
				formatter :formaterdetail,
			}
		]]
		
	});
});

</script>
<body>
	<div></div>
	<div id="buyer">
	
	</div>
</body>
</html>