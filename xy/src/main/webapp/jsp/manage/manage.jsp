<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="/xy/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/xy/easyui/jquery.easyui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/xy/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/xy/easyui/themes/icon.css">
     <link rel="stylesheet" type="text/css" href="/xy/css/index.css">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	$(function(){  
		$('#west').tabs({    
		    border:false,    
		    width:280,
		    height:600,
		    pill:true,
		    justified:true,
		    tabPosition:'left',
		    onSelect:function(){    
		    }    
		});  
	});

</script>
<body >
	<div id="north">
		
	</div>
	<div id="content">
		<div id="west">
				<div title="">
				</div>
			    <div title="会员信息管理" >   
					<ul class="ss">
						<li><a href="/xy/jsp/buyer/register.jsp" target="main-center">车辆信息</a></li>
						<li><a href="javascript:void(0)">添加会员</a></li>
						<li><a href="javascript:void(0)">查看会员</a></li>
						<li><a href="javascript:void(0)">账号管理</a></li>
					</ul>
			    </div>   
			    <div title="卖家信息管理" >   
					<ul class="ss">
						<li><a href="javascript:void(0)" >添加卖家</a></li>
						<li><a href="logistics/admin/cusmtoer.jsp" target="main-center">查看卖家</a></li>
					</ul>		          
			    </div>   
			    <div title="商品信息管理">
					<ul class="ss">
						<li><a href="javascript:void(0)" id="logout">查看商品</a></li>
						<li><a href="javascript:void(0)" id="logout">添加</a></li>
						<li><a href="javascript:void(0)" id="logout">xiu</a></li>
					</ul>
			    </div>   
		</div>
		<div id="east">
			<iframe name="main-center" style="width:100%;height:100%;border:0px;" src="">
				<div>
					
				</div>
			</ifranme>
		</div>
	</div>
	<div id="product1">
		1
	</div>
	<div id="product2">
		2
	</div>
	<div id="south">
		<jsp:include page="/jsp/other/buttom.jsp"/>
	</div>
</body>
</html>