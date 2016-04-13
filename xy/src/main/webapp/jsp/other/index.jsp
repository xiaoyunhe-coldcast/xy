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
			    headerWidth:150,
			    tabHeight:50,
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
			    <div title="电子产品">  
			    	<table>
			    		<tr>
			    			<td><a href="/xy/jsp/buyer/register.jsp">手机</a></td>
			    			<td><a href="#">手机配件</a></td>
			    		</tr>
			    		<tr>
			    			<td><a href="javascript:void(0)">平板</a></td>
			    			<td><a href="javascript:void(0)">耳机</a></td>
			    		</tr>
			    		<tr>
			    			<td><a href="javascript:void(0)">电脑</a></td>
			    			<td><a href="javascript:void(0)">主板</a></td>
			    		</tr>
			    		<tr>
			    			<td><a href="javascript:void(0)">智能手表</a></td>
			    			<td><a href="javascript:void(0)">手环</a></td>
			    		</tr>
			    	</table> 
			    </div>   
			    <div title="服装" >   
			    	<table>
			    		<tr>
			    			<td><a href="/xy/jsp/buyer/register.jsp">T袖衫</a></td>
			    			<td><a href="#">裙子</a></td>
			    		</tr>
			    		<tr>
			    			<td><a href="javascript:void(0)">春装</a></td>
			    			<td><a href="javascript:void(0)">休闲服</a></td>
			    		</tr>
			    		<tr>
			    			<td><a href="javascript:void(0)">牛仔裤</a></td>
			    			<td><a href="javascript:void(0)">卫衣</a></td>
			    		</tr>
			    		<tr>
			    			<td><a href="javascript:void(0)">西装</a></td>
			    			<td><a href="javascript:void(0)">特色服装</a></td>
			    		</tr>
			    	</table>          
			    </div>   
			    <div title="学习资料">
					<table>
			    		<tr>
			    			<td><a href="/xy/jsp/buyer/register.jsp">四六级资料</a></td>
			    			<td><a href="#">会计资格从业资料</a></td>
			    		</tr>
			    		<tr>
			    			<td><a href="javascript:void(0)">考研资料</a></td>
			    			<td><a href="javascript:void(0)">教师资格考试资料</a></td>
			    		</tr>
			    		<tr>
			    			<td><a href="javascript:void(0)">计算机专业书籍</a></td>
			    			<td><a href="javascript:void(0)">医学常识</a></td>
			    		</tr>
			    		<tr>
			    			<td><a href="javascript:void(0)">百科全书</a></td>
			    			<td><a href="javascript:void(0)">其他</a></td>
			    		</tr>
			    	</table>     
			    </div>   
			    <div title="二手交易">
					<table>
			    		<tr>
			    			<td><a href="/xy/jsp/buyer/register.jsp">数码产品</a></td>
			    			<td><a href="#">学习资料</a></td>
			    		</tr>
			    		<tr>
			    			<td><a href="javascript:void(0)">闲置物品</a></td>
			    			<td><a href="javascript:void(0)">生活用品</a></td>
			    		</tr>
			    		<tr>
			    			<td><a href="javascript:void(0)">文体用具</a></td>
			    			<td><a href="javascript:void(0)">旅游用品</a></td>
			    		</tr>
			    		<tr>
			    			<td><a href="javascript:void(0)">百科全书</a></td>
			    			<td><a href="javascript:void(0)">其他</a></td>
			    		</tr>
			    	</table>   
			    </div>   
			    <div title="">
				</div>
				<div title="">
				</div>
				<div title="">
				</div>
		</div>
			<div id="east">
				     <jsp:include page="/jsp/other/change.jsp"/>
			</div>
		</div>
	</div>
	<div id="product1">
		<table title="产品展示" >
			<tr  align="center">
				<td>苹果</td>
				<td>魅族</td>
				<td>小米</td>
				<td>华为</td>
			</tr>		
			<tr  align="center">
				<td><img alt="1" src="/xy/img/index/1.jpg" style="width:250px;height: 220px"></td>
				<td><img alt="1" src="/xy/img/index/1.jpg" style="width:250px;height: 220px"></td>
				<td><img alt="1" src="/xy/img/index/1.jpg" style="width:250px;height: 220px"></td>
				<td><img alt="1" src="/xy/img/index/1.jpg" style="width:250px;height: 220px"></td>
			</tr>
			<tr  align="center">
				<td><a href="#">价格 ￥1000</a></td>
				<td><a href="#">价格 ￥1000</a></td>
				<td><a href="#">价格 ￥1000</a></td>
				<td><a href="#">价格 ￥1000</a></td>
			</tr>
		</table>
	</div>
	<div id="product2">
		<table title="产品展示" >
			<tr  align="center">
				<td>苹果</td>
				<td>魅族</td>
				<td>小米</td>
				<td>华为</td>
			</tr>		
			<tr  align="center">
				<td><img alt="1" src="/xy/img/index/1.jpg" style="width:250px;height: 220px"></td>
				<td><img alt="1" src="/xy/img/index/1.jpg" style="width:250px;height: 220px"></td>
				<td><img alt="1" src="/xy/img/index/1.jpg" style="width:250px;height: 220px"></td>
				<td><img alt="1" src="/xy/img/index/1.jpg" style="width:250px;height: 220px"></td>
			</tr>
			<tr  align="center">
				<td><a href="#">价格 ￥1000</a></td>
				<td><a href="#">价格 ￥1000</a></td>
				<td><a href="#">价格 ￥1000</a></td>
				<td><a href="#">价格 ￥1000</a></td>
			</tr>
		</table>
	</div>
	<div id="product3">
		<table title="产品展示" >
			<tr  align="center">
				<td>苹果</td>
				<td>魅族</td>
				<td>小米</td>
				<td>华为</td>
			</tr>		
			<tr  align="center">
				<td><img alt="1" src="/xy/img/index/1.jpg" style="width:250px;height: 220px"></td>
				<td><img alt="1" src="/xy/img/index/1.jpg" style="width:250px;height: 220px"></td>
				<td><img alt="1" src="/xy/img/index/1.jpg" style="width:250px;height: 220px"></td>
				<td><img alt="1" src="/xy/img/index/1.jpg" style="width:250px;height: 220px"></td>
			</tr>
			<tr  align="center">
				<td><a href="#">价格 ￥1000</a></td>
				<td><a href="#">价格 ￥1000</a></td>
				<td><a href="#">价格 ￥1000</a></td>
				<td><a href="#">价格 ￥1000</a></td>
			</tr>
		</table>
	</div>
	<div id="south">
		<jsp:include page="/jsp/other/buttom.jsp"/>
	</div>
</body>
</html>