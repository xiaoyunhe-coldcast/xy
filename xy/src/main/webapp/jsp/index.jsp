<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
pageContext.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>广运物流-管理平台</title>
    
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
	<style type="text/css">
		.ss{line-height:28px; padding-left:20px;}
		.ss a{text-decoration: none; color:#676767;}
	</style>
	<script type="text/javascript">
	
		
	</script>
  </head>
  
<body class="easyui-layout">
	<div data-options="region:'north',border:false" style="height:80px;background:#B3DFDA;padding:10px">
		<h2>物流管理平台</h2>
	</div>
	<div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;"></div>
	<div data-options="region:'west',split:true,title:'管理工具'" style="width:15%;">
		<div id="aa" class="easyui-accordion" fit=true >
		    <div title="信息管理" data-options="iconCls:'icon-mini-edit',selected:true" style="overflow:auto;padding:10px;">   
				<ul class="ss">
					<li><a href="logistics/admin/CarMessage2.jsp" target="main-center">车辆信息</a></li>
					<li><a href="javascript:void(0)">货物信息</a></li>
					<li><a href="javascript:void(0)">物流信息</a></li>
					<li><a href="javascript:void(0)">企业信息</a></li>
				</ul>
		    </div>   
		    <div title="网站管理" data-options="iconCls:'icon-mini-edit'" style="padding:10px;">   
				<ul class="ss">
					<li><a href="javascript:void(0)" >公告管理</a></li>
					<li><a href="logistics/admin/cusmtoer.jsp" target="main-center">会员管理</a></li>
				</ul>		          
		    </div>   
 
		    <div title="退出" data-options="iconCls:'icon-mini-edit'" style="padding:10px;">
				<ul class="ss">
					<li><a href="javascript:void(0)" id="logout">退出</a></li>
				</ul>
		    </div>   
		</div> 
	</div>
	<div data-options="region:'center'" >
		<iframe name="main-center" style="width:100%;height:100%;border:0px;" src=""></ifranme>
	</div>
</body>

</html>
