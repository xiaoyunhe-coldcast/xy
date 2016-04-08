<%@ page language="java" contentType="text/html;charset=utf-8"
    pageEncoding="utf-8"%>
<html lang="zh">

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户登录</title>
	
	<script type="text/javascript" src="/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/easyui/themes/icon.css">   
	<link rel="stylesheet" type="text/css" href="/easyui/themes/default/easyui.css" />
	<style type="text/css">
		a{font-size: 10pt;	text-decoration: none; padding-left:10px;}
		.top,.down{width:790px; margin:0px auto;}
		.top{height:150px;}
		.down{height:400px;}
	</style>
	
	<script type="text/javascript">
		
		//事件绑定
		$(function(){
			$("#btn").linkbutton({
				iconCls:'icon-ok',
				onClick:function(){
					if($('#ff').form('validate') && $('#textCode').val()!='')
						//alert('ok');
						$.ajax({
							url:'LoginServlet?method=login',
							type:'post',
							data:$("#ff").serialize(),
							dataType:'text',
							success:function(data){
								if(data != "")
									$.messager.alert('登录失败',data,'info',function(){
										window.location.reload();
									});
								else
									//$.messager.alert('','登录成功','info',function(){
										window.location.href = "${backURL}";
									//});
							}
							
						});
					else
						$.messager.alert('登录失败','请填写完整登录信息','info');
				}
			});
			
			$("#logout").linkbutton({
				onClick:function(){
					$.ajax({
						url:'LogoutServlet?id=1',
						type:'post',
						dataType:'text',
						success:function(data){
							$.messager.alert('ok',data,'info',function(){
								window.location.href = "${basePath}";
							});
						}
					});
				}
			});
			
		});
	
	</script>

  </head>
  
  <body>

<div class="top">
    <jsp:include page="/jsp/top.jsp" flush="true" />
</div>
<div class="down">
<div class="easyui-panel" title="用户登录" style="width:790px;height:400px;">
	<form id="ff" action="" method="post">
    <table style="margin-top:60px; margin-left:120px;" border="0" cellpadding="6px">
    	<tr>
        	<td><b>用户名：</b></td>
            <td><input type="text" name="username" id="username" /></td>
        </tr>
        <tr>
        	<td><b>密&nbsp;&nbsp;&nbsp;&nbsp;码：</b></td>
            <td><input type="password" name="password" id="password" /></td>
        </tr>
        <tr>
        	<td><b>类&nbsp;&nbsp;&nbsp;&nbsp;型：</b></td>
            <td><select name="textType" id="textType">
            	<option value="0" selected>普通用户</option>
            	<option value="1">管理员</option>
            </select></td>
        </tr>
        <tr>
        	<td><b>验证码：</b></td>
            <td>
            	<input type="text" id="textCode" name="textCode" />
            	<img id="code" src="logistics/cusmtoer/checkCode.jsp" alt="看不清换一张" onclick="this.src='logistics/cusmtoer/checkCode.jsp?'+new Date().getTime()" />
            </td>
        </tr>
    	<tr>
            <td colspan="2"  style="padding-left:20px;">
            	<a href="javascript:void(0)" id="btn">登录</a>
                <a href="logistics/cusmtoer/regCusmtoer.jsp">用户注册</a>
                <a href="logistics/cusmtoer/seekcode.jsp">找回密码</a>
         	</td>
        </tr>
    </table>
    </form>
</div>
</div>
    
    
  </body>
</html>
