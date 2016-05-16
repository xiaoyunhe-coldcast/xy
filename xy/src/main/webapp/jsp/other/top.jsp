<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
	<script type="text/javascript" src="/xy/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/xy/easyui/jquery.easyui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/xy/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/xy/easyui/themes/icon.css">
<style type="text/css">  
    a{  
        text-decoration: none;  
    }  
    .topnav {  
        list-style: none;  
        margin: 0;  
        top:0;
        background: #333;  
        font-size: 14px;  
        float: left;  
        width: 97%; 
    }  
      
    .topnav li {  
        float: left;  
        margin: 0;  
        padding: 0 15px;  
        position: relative;  
    }  
      
    .topnav li a {  
        padding: 10px 5px;  
        display: block;  
        float: left;  
        color: green;  
         font-size: 15pt;
    }  
    .subnav {  
        list-style: none;  
        position: absolute;  
        left: 0;  
        top: 35px;  
        display:none;  
        margin: 0;  
        padding: 0;  
    }  
      
    .subnav li {  
        margin: 0;  
        padding: 0;  
        width:100px;  
        clear: both;  
        white-space:nowrap;  
        width:100%;  
        font-size: 15pt;
    }  
    .subnav li a{  
        float: left;  
         font-size: 15pt;
    }  
</style>  
<script type="text/javascript">  

    $(function(){  
        	var myDate = new Date();
       		myDate.toLocaleDateString();     //获取当前日期
        	var mytime=myDate.toLocaleTimeString();     //获取当前时间
        	var time= myDate.toLocaleString();        //获取日期与时间
        	
         	$('#time').text(time);
   
        $('.topnav li a').hover(function(){  
            var topnavLi = $(this).parent();  
            var subnavUl = topnavLi.find('.subnav');  
            subnavUl.slideDown('fast').show();  
            topnavLi.hover(function(){},function(){  
                subnavUl.slideUp('slow');  
            });  
        },function(){
        	$("#goout").click(function(){
        		$.messager.confirm('确认','您确认想要注销记录吗？',function(r){    
        		    if (r){    
        		    	$.messager.show({
        		    		title:'提示消息',
        		    		msg:'注销成功',
        		    		timeout:2000,
        		    		showType:'slide'
        		    	});
        		    	setTimeout('window.location.href="/xy/buyer/logout"',2000);
        		    }  
        	});
        	
        });  
    });  
 });
</script> 
<body>
	<div style="width: 100%" >
		<marquee scrollAmount=2 width=100% behavior=alternate bgcolor="pink" >
		<p style="font-size: 12pt; color: black;">欢迎来到校园易购商城！ 欢迎来到校园易购商城！ 欢迎来到校园易购商城！</p>
		</marquee>
	</div>
	<div style="width: 100%;height: 200px; background: url(/xy/img/other/banner.jpg)">  
		<ul class="topnav">  
		    <li style="width: 250px">
		   		<c:if test="${empty buyer}">
		   			<a href="/xy/jsp/buyer/buyerlogin.jsp" style="color: yellow;" >登录</a>
		   			<a href="/xy/jsp/buyer/register.jsp" style="color: yellow;">注册</a>
		   		</c:if>
		   		<c:if test="${!empty buyer}">
		   			<a href="/xy/buyer/query/${buyer.buyerid }" style="color: yellow;">欢迎你，${buyer.buyername}</a>
		   			<a  style="color: yellow;" id ="goout">注销</a>
		   		</c:if>
		    </li>
		     <li style="width: 120px">  
		        <a href="/xy/jsp/other/index.jsp">主页</a>  
		    </li>  
		    <li style="width: 120px">  
		        <a href="/xy/goods/all?pageindex=1&pagesize=10&search=">全部商品</a>  
		        <ul class="subnav">  
		            <li><a href="#">学习资料</a></li>  
		            <li><a href="#">电子产品</a></li>  
		            <li><a href="#">生活用品</a></li>  
		        </ul>  
		    </li>  
		    <li style="width: 120px">  
		        <a href="#">全部店家</a>  
		        <ul class="subnav">  
		            <li><a href="#">聚划算</a></li>  
		            <li><a href="#">名誉卖家</a></li>  
		            <li><a href="#">子菜单3</a></li>  
		        </ul>  
		    </li>  
		    <li style="width: 120px">  
		        <a href="#">菜单3</a>  
		        <ul class="subnav">  
		            <li><a href="#">子菜单1</a></li>  
		            <li><a href="#">子菜单2</a></li>  
		            <li><a href="#">子菜单3</a></li>  
		        </ul>  
		    </li>  
		    <li style="float: right">
		    	<a id="time" style="color: white"></a>
		    </li>
		</ul>  
	</div>
</body>
</html>