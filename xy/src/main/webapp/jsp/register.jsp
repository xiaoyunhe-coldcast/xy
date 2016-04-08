<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
   	
	<script type="text/javascript" src="/hcnm/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/hcnm/easyui/jquery.easyui.min.js"></script>
    <link rel="stylesheet" type="text/css" href=" /hcnm/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/hcnm/easyui/themes/icon.css">
	<script type="text/javascript">

		$(function(){
			function loadimage(){
document.getElementById("randImage").src="/hcnm/view_other/number.jsp?"+Math.random();
} 
		$.extend($.fn.validatebox.defaults.rules, {    
    		username: {    
        		validator: function(value){
					var pattern = /^[a-zA-Z]{3,8}[a-zA-Z0-9]$/;
					return pattern.test(value);    
        		},    
       			message: '用户名格式不正确'   
    		},
    
    		nickname:{
    		      validator:function(value){
					var pattern = /^[a-zA-Z0-9]{4,10}$/;
					return pattern.test(value);
				},
				message:'昵称格式不正确'
    		},
			password: {
				validator:function(value){
					var pattern = /^[a-zA-Z0-9]{6,16}$/;
					return pattern.test(value);
				},
				message:'密码格式不正确'
			},
			cpassValid: {
				validator:function(value){
					var str = $("#password").val();
					return (str == value);
				},
				message:'前后密码不一致，请重新输入'
			},
			mail:{
			 validator:function(value){
					var pattern = /^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/;
					return pattern.test(value);
				},
				message:'邮箱输入格式不正确'
			},
			tel:{
			  validator:function(value){
					var pattern = /^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/;
					return pattern.test(value);
				},
				message:'手机输入格式不正确'
			}
		});
		
		$('#register').panel({
		  title:'新增用户',
		 
		  collapsible:true,
		  width:400,
		  maximizable:true,
		  openAnimation:'slider'
		});
	
		$("#username").textbox({
			required:true,
			validType:"username",
			iconCls:'icon-man',
			missingMessage:'用户名不能为空',
			width:"160px"
		});
		
		$("#password").textbox({
			required:true,
			validType:"password",
			missingMessage:'密码不能为空',
			width:"160px"
		});
		
		$("#cpassword").textbox({
			required:true,
			validType:"cpassValid",
			missingMessage:'确认密码不能为空',
			width:"160px"
		});
		$('#tel').numberbox({
			required:true,
			width:"160px",
			validType:"tel",
			missingMessage:'手机号不能为空！'
		});
		$("#nickname").textbox({
			required:true,
			validType:"nickname",
			width:"160px",
			missingMessage:'用户名不能为空'
		});
		$('#mail').textbox({
		    required:true,
			validType:"mail",
			width:"160px",
			missingMessage:'邮箱不能为空'
		})
		$('#btn').click(function(){
			if($('#form1').form('validate')) {
				$.ajax({
					url:"SaveServlet",
					type:"post",
					data:$("#form1").serialize(),
					dataType:'text',
					success: function(data){
						alert(data);
					},
					error:function(){
						alert('no');
					}
					
				});
			} else {
				alert('信息不完整，无法提交');	
				$.messager.show({
					title:'我的消息',
					msg:'信息不完整，无法提交',
					timeout:5000,
					showType:'slide'
				});

			}
		});
		
	});
	</script>
  </head>
  
  <body >
  <div style="position: absolute;left: 400px;top: 100px;width:600px;height:500px;background-color: green;">
     <div id="register" >
<form id="form1" action="#" method="post" >
	<table>
    	<tr>
        	<td >用户名：</td>
            <td><input type="text" name="username" id="username"/></td>
        </tr>
    	<tr>
        	<td>昵称：</td>
            <td>
            	<input name="User.nickname" id="nickname" />
            </td>
        </tr>		
    	<tr>
        	<td>密码：</td>
            <td><input type="password" name="password" id="password" value="" /></td>
        </tr>
    	<tr>
        	<td>确认密码：</td>
            <td><input type="password" name="cpassword" id="cpassword" value="" /></td>
        </tr>		
    	<tr>
        	<td>手机号：</td>
            <td><input id="tel" type="text" name="tel" /></td>
        </tr>
    	<tr>
        	<td>邮箱：</td>
            <td><input type="text" name="User.mail"  id="mail" /></td>
        </tr>
      <tr>
        	<td>验证码：</td>
            <td><img name="randImage" id="randImage" onclick="loadimage();" src="/hcnm/view_other/number.jsp">
            <input class="easyui-textbox" data-options="width:100" name="code"  />
            <a href="javascript:loadimage();"><font class=pt95>看不清点我</font></a>
            </td>
        </tr>
    	<tr align="center" >
        	<td colspan="2" ><a class="easyui-linkbutton" type="reset" >重置</a>
        	<a class="easyui-linkbutton" id="btn">保存</a></td>
        </tr>
    </table>
</form>
</div>
  </div>
  
  </body>
</html>
