<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DIV+CSS布局教程</title>
	<script type="text/javascript" src="/xy/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/xy/easyui/jquery.easyui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/xy/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/xy/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/xy/css/buyerlogin.css">
</head>
 <script type="text/javascript">
    //图片轮换
	var t = n = 0, count;
	$(document).ready(function(){	
		count=$("#banner_list a").length;
		$("#banner_list a:not(:first-child)").hide();
		$("#banner_info").html($("#banner_list a:first-child").find("img").attr('alt'));
		$("#banner_info").click(function(){window.open($("#banner_list a:first-child").attr('href'), "_blank")});
			$("#banner li").click(function() {
				var i = $(this).text() - 1;//获取Li元素内的值，即1，2，3，4
				n = i;
				if (i >= count) return;
				$("#banner_info").html($("#banner_list a").eq(i).find("img").attr('alt'));
				$("#banner_info").unbind().click(function(){window.open($("#banner_list a").eq(i).attr('href'), "_blank")})
				$("#banner_list a").filter(":visible").fadeOut(500).parent().children().eq(i).fadeIn(1000);
				document.getElementById("banner").style.background="";
				$(this).toggleClass("on");
				$(this).siblings().removeAttr("class");
			});
		t = setInterval("showAuto()", 4000);
		$("#banner").hover(function(){
		   clearInterval(t)}, function(){
		t = setInterval("showAuto()", 4000);});
	});
	
	function showAuto()
	{
		n = n >=(count - 1) ? 0 : ++n;
		$("#banner li").eq(n).trigger('click');
	}
	//登录
	 function loginuyer(){
	    $.ajax({
			url:'/xy/buyer/login',
			type:'post',
			data:{
				"name" :$('#buyername').val(),
				"password" :$('#buyerpsw').val(),
			},
			dataType:'json',
			success:function(result){
				if (result.msg == "登录成功"){
					window.location.href = "/xy/jsp/other/index.jsp";
				} else{
					$.messager.show({
						title : '登录消息',
						msg : result.msg,
						timeout : 5000,
						showType : 'slide'
					});  
				}
			},
	});
}
</script>
<body>

<div id="Container">
    <div id="Header">
        <div id="logo">这里设置了padding属性介绍一下padding的用法,padding将设置文本与边框的距离。</div>
    </div>
    <div id="Content">
        <div id="Content-Left">
        	<div id="banner">	
			<div id="banner_bg">
			</div>  <!--标题背景-->
			<div id="banner_info">
			</div> <!--标题-->
			    <ul>
			        <li class="on">1</li>
			        <li>2</li>
			        <li>3</li>
			        <li>4</li>
			    </ul>
		   <div id="banner_list">
		        <a href="#" target="_blank"><img src="/xy/img/other/p1.jpg"  alt="图片标题1" /></a>
		        <a href="#" target="_blank"><img src="/xy/img/other/p5.jpg"  alt="橡树小屋的4blog" /></a>
		        <a href="#" target="_blank"><img src="/xy/img/other/p3.jpg" alt="图片标题3" /></a>
		        <a href="#" target="_blank"><img src="/xy/img/other/p4.jpg"  alt="橡树小屋的6blog" /></a>
			</div>
	    </div>
        </div>
        <div id="Content-Main">   
			<table id="login">
				<tr>
					<td>
						<b>用户名</b>
					</td>
					<td>
						<input type="text" id="buyername"/>
					</td>
				</tr>
				<tr height="30px"></tr>
				<tr>
					<td>
						<b>密码</b>
					</td>
					<td>
						<input type="password" id="buyerpsw"/>
					</td>
				</tr>
				<tr height="10px"></tr>
				<tr>
				  <td colspan="2">
				    <input id="btn" type="button"  class="easyui-linkbutton" style="width: 200px;color: red ;" onclick="loginuyer()" value="登录"/>
				  </td>
				</tr>
				<tr height="10px"></tr>
				<tr align="center">
					<td><a href="/xy/jsp/buyer/register.jsp">免费注册</a></td>
					<td><a href="#">找回密码</a></td>			
				</tr>
				<tr>
				   <td></td>
				</tr>
			</table>
        </div>
    </div>
    <div class="Clear"><!--如何你上面用到float,下面布局开始前最好清除一下。--></div>
    <div id="Footer">Footer</div>
</div>
</body>
</html>