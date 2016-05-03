<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CSS3动态背景登录框代码 - 站长素材</title>
<link rel="stylesheet" type="text/css" href="/xy/css/styles.css">
<script src="/xy/js/easyui/jquery.min.js" type="text/javascript"></script>
</head>

<body>
<div class="htmleaf-container">
	<div class="wrapper">
		<div class="container">
			<form class="form">
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
		//alert("1");
		name = $('#bossname').val();
		password = $('#psaaword').val();
	    $.ajax({
			url:'/xy/boss/login',
			type:'post',
			data:{
				"name" :name,
				"password" :password,
			},
			dataType:'json',
			success:function(result){
			
				if (result.msg == "登录成功"){
					//event.preventDefault();
				//	$('form').fadeOut(500);
					//$('.wrapper').addClass('form-success');
					window.location.href = "/xy/jsp/other/index.jsp";
				} else {
					alert("22");
				}
			}
	});	
});
});
	
</script>
</body>
</html>