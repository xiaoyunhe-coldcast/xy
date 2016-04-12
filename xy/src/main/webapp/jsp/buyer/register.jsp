<%@ page language="java" contentType="text/html;charset=utf-8"
    pageEncoding="utf-8"%>
<html lang="zh">
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
   	
	<script type="text/javascript" src="/xy/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/xy/easyui/jquery.easyui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/xy/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/xy/easyui/themes/icon.css">
	<script type="text/javascript">

		$(function(){
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
					url:"/xy/buyer/save",
					type:"post",
					data:$("#form1").serialize(),
					dataType:'json',
					success: function(result){
						alert(result.msg+"11");
						$.messager.show({
							title:'注册消息',
							msg:msg,
							timeout:5000,
							showType:'slide'
						});
						
					},
					error:function(result){
						alert(result.msg);
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
  <div style="position: absolute;left: 400px;top: 100px;width:600px;height:500px;">
     <div id="register" >
<form id="form1" action="#" method="post" >
	<table>
    	<tr>
        	<td><b>用户名：</b></td>
            <td><input type="text" name="buyername" id="username"/></td>
        </tr>
         <br/>
    	<tr>
        	<td><b>真实姓名：</b></td>
            <td>
            	<input name="realname" id="nickname" />
            </td>
        </tr>
        <tr>
        	<td><b>性&nbsp;&nbsp;&nbsp;&nbsp;别：</b></td>
            <td>
            	<input type="radio" name="sex" id="sex" value="男" />男
            	<input type="radio" name="sex" id="sex" value="女" />女
            	<input type="radio" name="sex" id="sex" value="unknown" checked />保密
           </td>
        </tr>		
    	<tr>
        	<td><b>密码：</b></td>
            <td><input type="password" name="buyerpsw" id="password" value="" /></td>
        </tr>
    	<tr>
        	<td><b>确认密码：</b></td>
            <td><input type="password" name="cpassword" id="cpassword" value="" /></td>
        </tr>		
    	<tr>
        	<td><b>手机号：</b></td>
            <td><input id="tel" type="text" name="telephone" /></td>
        </tr>
        <br/>
    	<tr>
        	<td><b>邮箱：</b></td>
            <td><input type="text" name="email"  id="mail" /></td>
        </tr>
        <tr>
        	<td><b>地址:</b></td>
        	<td><input type="text" name="address"  id="address" value="武汉"/></td>
        </tr>
        <tr>
        	<td><b>备注</b></td>
        	<td>
        		<textarea rows="3" cols="25" name="bz">
        		  123
        		</textarea>
        	</td>
        </tr>
         <tr>
        	<td>
        		<input type="hidden" name="status" value="0"> 
        		<input type="hidden" name="buyerjf" value="200"> 
        		<input type="hidden" name="" value=""> 
        	</td>
        </tr>
    	<tr align="center" >
        	<td colspan="2" ><a class="easyui-linkbutton" type="reset">重置</a>
        	<a class="easyui-linkbutton" id="btn">保存</a></td>
        </tr>
    </table>
</form>
</div>
  </div>
  </body>
</html>
