<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>重置登录密码</title>
    
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
		.down{height:400px;}
	</style>
    <script type="text/javascript">
    	
    	$(function(){
    	
	    	$("#btn").linkbutton({
	    		onClick:function(){
	    			if(($("#ff").form("validate") && $("#textCode").val() != '')) {
	    				$.ajax({
	    					url:"ResetPassServlet?method=check",
	    					type:"post",
	    					data:$("#ff").serialize(),
	    					dataType:"json",
	    					success:function(data){
	    						if(data.status) {
	    							$("#pp").panel("refresh",data.msg);
	    						} else {
	    							$.messager.alert("提示信息",data.msg,"info",function(){
	    								window.location.reload();
	    							});
	    						}
	    					}
	    				
	    				});
	    				
	    			} else {
	    				$.messager.alert("提示信息","请输入完整信息","info");
	    			}
	    		
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
<div class="easyui-panel" id="pp" title="找回密码" cache=false style="width:790px;height:400px;">

	<form id="ff" action="" method="post">
    <table style="margin-top:40px; margin-left:120px;font-size:11pt;" border="0" cellpadding="6px">
    	<tr>
        	<td><b>会员名称：</b></td>
            <td><input type="text" name="username" id="username" /></td>
        </tr>
        <tr>
        	<td><b>密码问题：</b></td>
            <td><input type="text" name="question" id="question" /></td>
        </tr>
        <tr>
        	<td><b>问题答案：</b></td>
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
            	<a href="javascript:void(0)" id="btn">找回密码</a>&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="index.jsp" class="easyui-linkbutton">返回首页</a>
         	</td>
        </tr>
    </table>
    </form>

    
</div>
</div>
    
  </body>
</html>
