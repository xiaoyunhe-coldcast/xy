<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>管理员登录</title>

<link rel="stylesheet" type="text/css" href="/xy/css/styles.css">
<script src="/xy/js/easyui/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="/xy/easyui/jquery.easyui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/xy/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/xy/easyui/themes/icon.css">
</head>

<body>

<div class="htmleaf-container">
	<div class="wrapper">
		<div class="container">
			<h1>校易后台登录</h1>
			<form class="form" action="javascript:void(0)">
				<input type="text" placeholder="Username" id="bossname">
				<input type="password" placeholder="Password" id="psaaword">
				<button type="submit" id="login-button">登陆</button>
				<br>
				<a href="#">注册</a> &nbsp;<a href="#">找回密码</a>
			</form>
		</div>
		<ul class="bg-bubbles">
			<li>校园商城</li>
			<li>闲置交换</li>
			<li>二手市场</li>
			<li>资料全面</li>
			<li>不二选择</li>
			<li>靠谱网站</li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
	</div>
</div>
<script>
$(function(){
	$('#login-button').click(function () {
		name = $('#bossname').val();
		password = $('#psaaword').val();
	    $.ajax({
			url:'/xy/boss/login',
			type:'post',
			data:{
				'name': name,
				'password': password,
			},
			dataType:'json',
			success:function(result){
				if (result.msg == "登录成功"){
					$.messager.show({
						title : '登录消息',
						msg : result.msg+"2秒后自动跳转",
						timeout : 5000,
						showType : 'slide'
					}); 
					setTimeout('window.location.href = "/xy/jsp/manage/manage.jsp"',3000);
				} else {
					$.messager.show({
						title : '登录消息',
						msg : result.msg,
						timeout : 2000,
						showType : 'slide'
					});  
				}
			}
	});	
});
});
	
</script>
</body>
</html>