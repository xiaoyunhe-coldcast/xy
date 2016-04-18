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
    <title>车辆信息</title>
	
	<style type="text/css">
		.top,.down{width:790px; margin:0px auto;}
		.top{height:150px;}
		.down{height:400px;}
		.down .datagrid-btable tr{height:30px;}/*设置datagrid行高*/
	</style>
	<script type="text/javascript">
			
			var flag; //标示用户操作
			
			/**
			* 查看详细信息的方法
			*/
			function detail(index) {
				flag = "edit";
				$("#car_info").datagrid("unselectAll"); //先清除所有已选中的行
				$("#car_info").datagrid("selectRow",index); //再选中刚才用户点击的行
				var row = $("#car_info").datagrid("getSelected");
				if(row != null) {
					//重新定义dialog标题
					$("#dlg").dialog('setTitle','详细信息');
					//打开dialog窗口
					$("#dlg").dialog("open");
					//reset表单
					$("#ff").form("reset");
					//加载form表单
					$("#ff").form('load',{
						tradeMark:row.tradeMark,
						brand:row.brand,
						style:row.style,
						carLoad:row.carLoad,
						usedTime:row.usedTime,
						driverName:row.driverName,
						driverTime:row.driverTime,
						licenceNumber:row.licenceNumber,
						licenceStyle:row.licenceStyle,
						transpotStyle:row.transpotStyle,
						linkMan:row.linkMan,
						linkPhone:row.linkPhone,
						remark:row.remark,
						issueDate:row.issueDate
						//userName:row.userName,
					});
					$("#show_user").html(row.userName);
					if(row.userName != "${sessionScope.user}") {
						//将form表单元素设置为不可编辑
						$("#ff input").attr("readOnly",true);
						
						$("#dialog-ok").linkbutton("disable");
					} else {
						//将form表单元素设置为可编辑
						$("#ff input").attr("readOnly",false);
						
						$("#dialog-ok").linkbutton("enable");
					}
				}
			}
			
			function formatOper(val,row,index){
				return '<a  href="javascript:void(0)" onclick="detail('+index+')">详细</a>';
			}
			
			function searchOp(value,name){
				$("#car_info").datagrid("load",{
					value:value,
					name:name
				});
			}
			
	$(function(){
			
			
			
			/**
			* 提交表单按钮
			*/
			$("#dialog-ok").linkbutton({
				iconCls:'icon-ok',
				onClick:function(){
					$.ajax({
						url:flag=="add" ? "CarMessageServlet?method=save" : "CarMessageServlet?method=update",
						type:'post',
						data:$('#ff').serialize(),
						dataType:'json',
						success: function(result){
							//1.关闭dialog窗口
							$("#dlg").dialog("close");
							//2.刷新datagrid表格
							$("#car_info").datagrid('reload');
							//3.提示信息
							$.messager.show({
								title:result.status,
								msg:result.msg
							});
						},
						error:function(){
							$.messager.show({
								title:result.status,
								msg:result.msg
							});
						}
					});
				}
			});
			
			/**
			* 取消按钮
			*/
			$("#dialog-cancel").linkbutton({
				iconCls:"icon-cancel",
				onClick:function(){
					$("#dlg").dialog('close');
				}
			});
			
			
			/**
			* 为发布信息按钮绑定函数
			*/
			$("#create").click(function(){
				flag = "add";
				//重新定义dialog标题
				$("#dlg").dialog('setTitle','添加信息');
				$("#ff input").attr("readOnly",false);
				//reset表单
				$("#ff").form("reset");
				$("#show_user").html($("#userName").val());
				//打开dialog窗口
				$("#dlg").dialog("open");
				$("#dialog-ok").linkbutton("enable");
			});
		});
		
		$(function(){
		
			$("#car_info").datagrid({
				idField:'id',
				url:'CarMessageServlet?method=getlist',
				columns:[[
					{
						field:"tradeMark",
						title:"车牌号码",
						width:100
					},{
						field:"brand",
						title:"生产厂家",
						width:100
					},{
						field:"style",
						title:"车辆类型",
						width:100
					},{
						field:"carLoad",
						title:"车辆载重",
						width:100
					},{
						field:"usedTime",
						title:"使用时间",
						width:100
					},{
						field:"driverName",
						title:"驾驶员姓名",
						hidden:true
					},{
						field:"driverTime",
						title:"驾驶时间",
						width:100
					},{
						field:"licenceNumber",
						title:"驾照号码",
						hidden:true
					},{
						field:"licenceStyle",
						title:"驾照类型",
						hidden:true
					},{
						field:"transpotStyle",
						title:"运输类型",
						width:100
					},{
						field:"linkMan",
						title:"联系人",
						hidden:true
					},{
						field:"linkPhone",
						title:"联系电话",
						hidden:true
					},{
						field:"remark",
						title:"备注",
						hidden:true
					},{
						field:"issueDate",
						title:"发布时间",
						hidden:true
					},{
						field:"userName",
						title:"发布人",
						hidden:true
					},{
						field:"_operate",
						title:"详细",
						width:90,
						formatter:formatOper
					}
				]],
				title:'车辆信息',
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
				pageList:[5,10,15,20]
				
			});
		});
		
	</script>
	
  </head>
  
  <body>
  
<div class="top">
    <jsp:include page="/jsp/other/top.jsp" />
</div>

<div class="down">
	<!-- 验证用户是否登录 -->
	<javaweb:checkLogin />
	<table id="car_info"></table>
</div>
<!-- datagrid工具栏 -->
<div id="tb" style="text-align:right">
	<a href="javascript:void(0)" id="create" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">发布信息</a>
	<input class="easyui-searchbox" data-options="prompt:'输入车牌号查询',searcher:searchOp,menu:'#mm'" style="width:200px"></input>
</div>
<!-- 搜索框 -->
<div id="mm">
	<div data-options="name:'tradeMark'">车牌号码</div> 
	<div data-options="name:'brand'">生产厂家</div>
	<div data-options="name:'licenceNumber'">驾照号码</div>
</div>
<div id="dlg" class="easyui-dialog" style="width:700px;padding:20px;" data-options="title:'发布信息',closed:true,modal:true,buttons:'#dialog-btn'">
<div id="dialog-btn">
	<a href="javascript:void(0)" id="dialog-ok" >保存</a>
	<a href="javascript:void(0)" id="dialog-cancel" >取消</a>
</div>
<form id="ff" method="post">
	<table style="font-size:14px;">
		<tr>
			<td>车牌号码：</td><td><input class="easyui-textbox" type="text" name="tradeMark" /></td><td style="width:100px;"></td>
			<td>车牌品名：</td><td><input class="easyui-textbox" type="text" name="brand" /></td>
		</tr>
		<tr>
			<td>车牌类型：</td><td><input class="easyui-textbox" type="text" name="style" /></td><td style="width:100px;"></td>
			<td>车牌载重：</td><td><input class="easyui-textbox" type="text" name="carLoad" /></td>
		</tr>
		<tr>
			<td>使用时间：</td><td><input class="easyui-textbox" type="text" name="usedTime" /></td><td style="width:100px;"></td>
			<td>驾驶员姓名：</td><td><input class="easyui-textbox" type="text" name="driverName" /></td>
		</tr>
		<tr>
			<td>驾驶时间：</td><td><input class="easyui-textbox" type="text" name="driverTime" /></td><td style="width:100px;"></td>
			<td>驾照号码：</td><td><input class="easyui-textbox" type="text" name="licenceNumber" /></td>
		</tr>
		<tr>
			<td>驾照类型：</td><td><input class="easyui-textbox" type="text" name="licenceStyle" /></td><td style="width:100px;"></td>
			<td>运输类型：</td><td><input class="easyui-textbox" type="text" name="transpotStyle" /></td>
		</tr>
		<tr>
			<td>联系人：</td><td><input class="easyui-textbox" type="text" name="linkMan" /></td><td style="width:100px;"></td>
			<td>联系电话：</td><td><input class="easyui-textbox" type="text" name="linkPhone" /></td>
		</tr>
		<tr>
			<td rowspan="2">备注：</td><td rowspan="2"><input class="easyui-textbox" name="remark" data-options="multiline:true" style="height:60px"></td>
			<td rowspan="2" style="width:100px;"></td>
			<td>发布日期：</td><td><input type="text" name="issueDate"  class="easyui-datebox" /></td>
		</tr>
		<tr>
			<td>发布人：</td>
			<td>
				<span id="show_user"></span>
				<input type="hidden" name="userName" id="userName" value="${sessionScope.user }" />
			</td>
		</tr>
	</table>
</form>
</div>

  </body>
</html>
