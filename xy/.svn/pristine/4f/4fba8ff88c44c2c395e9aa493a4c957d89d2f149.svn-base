<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String backURL = request.getHeader("Referer");
pageContext.setAttribute("backURL", backURL);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/easyui/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css" />
	<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/validBox.js"></script>
	<style type="text/css">
		.top,.down{width:790px; margin:0px auto;}
		.top{height:150px;}
		.down{height:500px;}
	</style>
	
	<script type="text/javascript">
		$(function(){
			
			$("#checkName").linkbutton({
				onClick:function(){
					$.ajax({
						url:'RegCusmtoerServlet?method=check',
						type:'post',
						data:{"name":$("#username").val()},
						dataType:'text',
						success:function(data){
							if(data != "")
								$.messager.alert('警告',data,'warning',function(){
									$("#username").textbox('clear');
								});
						},
						error:function(data){
							
						}
					});
				}
			});
			
			$('#btn').linkbutton({
				onClick:function(){
					if($("#regForm").form('validate') && $("textCode").val() !='') {
						$.ajax({
							url:'RegCusmtoerServlet?method=reg',
							type:'post',
							data:$("#regForm").serialize(),
							dataType:'text',
							success:function(data){
								if(data == "")
									$.messager.alert('','注册成功！','info',function(){
										window.location.href = "${backURL}";
									});
								else
									$.messager.alert('注册失败',data,'info',function(){
										window.location.reload();
									});
							},
							error:function(){
								
							}
						});
					}
					else {
						//验证不通过
						$.messager.alert('注册失败','请填写完整注册信息','info');
					}
				}
			});
			
		});

	
	</script>

  </head>
  
  <body>

<div class="top">

</div>
<div class="down">
<div class="easyui-panel" title="用户注册" style="width:790px;height:500px;">
	<form id="regForm" action="" method="post">
    <table style="margin-top:20px; margin-left:120px;font-size:11pt;" border="0" cellpadding="6px">
    	<tr>
        	<td><b>用户名：</b></td>
            <td><input type="text" name="username" id="username" />
            <a id="checkName">检查</a></td>
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
        	<td><b>密&nbsp;&nbsp;&nbsp;&nbsp;码：</b></td>
            <td><input type="password" name="password" id="password" /></td>
        </tr>
        <tr>
        	<td><b>确认密码：</b></td>
            <td><input type="password" name="cpassword" id="cpassword" /></td>
        </tr>
        <tr>
        	<td><b>email：</b></td>
            <td><input type="text" name="email" id="email" /></td>
        </tr>
        <tr>
        	<td><b>联系电话：</b></td>
            <td><input type="text" name="phone" id="phone" /></td>
        </tr>
        <tr>
        	<td><b>申请日期：</b></td>
            <td><input type="text" name="IssueDate" id="IssueDate" /></td>
        </tr>
        <tr>
        	<td><b>密码问题：</b></td>
            <td><input type="text" name="question" id="question" /></td>
        </tr>
        <tr>
        	<td><b>密码答案：</b></td>
            <td><input type="text" name="result" id="result" /></td>
        </tr>
        <tr>
        	<td><b>验证码：</b></td>
            <td>
            	<input type="text" id="textCode" name="textCode" />
            	<img id="code" src="logistics/cusmtoer/checkCode.jsp" alt="看不清换一张" onclick="this.src='logistics/cusmtoer/checkCode.jsp?'+new Date().getTime()" />
            </td>
        </tr>
    	<tr>
            <td colspan="2">
            	<a href="javascript:void(0)" id="btn">注册</a>&nbsp;&nbsp;&nbsp;&nbsp;
            	<a class="easyui-linkbutton" href="index.jsp">返回首页</a>
         	</td>
        </tr>
    </table>
    </form>
   </div>
  </div>
</body>
</html>