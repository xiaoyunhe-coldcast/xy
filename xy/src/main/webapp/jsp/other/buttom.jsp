<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<script type="text/javascript" src="/xy/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/xy/easyui/jquery.easyui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/xy/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/xy/easyui/themes/icon.css">
<title>Insert title here</title>
<script type="text/javascript">
	$(function(){
		$("#admin").click(function(){
			$.messager.confirm('确认','您确认想要进入后台吗？',function(r){   
			    if (r){    
			    	setTimeout('window.location.href="/xy/jsp/boss/bosslogin.jsp"',1000);   
			    }  
		});
	});
});
</script>
</head>
<body>
	<div align="center" style="background-color: lime;">
			<p><a href="#">关于本网站</a>&nbsp;&nbsp;
			<a href="#">联系我们 027-0000-0000</a>&nbsp;&nbsp;
			<a href="#">意见反馈 </a> &nbsp;<a href="#">招聘信息</a></p>
		<p>运营许可证<a href="#">鄂A2-2016-04-11-22</a>&nbsp;&nbsp;
		</p>
		<p>
			<a id="admin" class="easyui-linkbutton">管理员登录</a>
		</p>
	</div>
</body>
</html>