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
			//左侧菜单
			$('#west').tabs({    
			    border:false,    
			    width:380,
			    height:500,
			    pill:true,
			    justified:true,
			    tabPosition:'left',
			}); 
	});

</script>
<body >
	<div id="north">
		<jsp:include page="/jsp/other/top.jsp"/>
	</div>
	<div id="content">
		<div id="west">
				<div title="">
				</div>
			    <div title="电子产品" >   
					<ul class="ss">
						<li><a href="/xy/jsp/buyer/register.jsp">手机</a>
							&nbsp;&nbsp;<a href="#">手机配件</a>
						</li>
						<li>
							<a href="javascript:void(0)">平板</a>&nbsp;&nbsp;
							<a href="javascript:void(0)">耳机</a>
						</li>
						<li>
							<a href="javascript:void(0)">电脑</a>&nbsp;&nbsp;
							<a href="javascript:void(0)">主板</a>
						</li>
						<li>
							<a href="javascript:void(0)">智能手表</a>&nbsp;&nbsp;
							<a href="javascript:void(0)">手环</a>
						</li>
					</ul>
			    </div>   
			    <div title="服装" >   
					<ul class="ss">
						<li>
							<a href="javascript:void(0)" >男装</a>
						</li>
						<li>
							<a href="javascript:void(0)" >女装</a>
						</li>
						<li>
							<a href="javascript:void(0)" >儿童装</a>
						</li>
						<li>
							<a href="logistics/admin/cusmtoer.jsp">夏装</a>
						</li>
					</ul>		          
			    </div>   
			    <div title="学习资料">
					<ul class="ss">
						<li><a href="javascript:void(0)" id="logout">电子书</a></li>
						<li><a href="javascript:void(0)" id="logout">视频教程</a></li>
						<li><a href="javascript:void(0)" id="logout">论文期刊</a></li>
					</ul>
			    </div>   
			    <div title="二手交易">
					<ul class="ss">
						<li><a href="javascript:void(0)" id="logout">八成新</a></li>
						<li><a href="javascript:void(0)" id="logout">数码交易</a></li>
						<li><a href="javascript:void(0)" id="logout">闲置甩卖</a></li>
					</ul>
			    </div>   
			    
		</div>
			<div id="east">
				     <jsp:include page="/jsp/other/change.jsp"/>
			</div>
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