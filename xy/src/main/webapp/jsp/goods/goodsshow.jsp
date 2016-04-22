<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="/xy/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/xy/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/xy/easyui/locale/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" type="text/css" href="/xy/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/xy/easyui/themes/icon.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">

	$(function (){
		$('#comment').tabs({    
		    border:false,    
		    width:900,
		    height:600 ,
		   
		}); 
		//
		$('#pp').pagination({ 
			total:2000, 
			pageSize:10 ,
			 displayMsg :'第{from} 到 {to} 总共 {total} 条记录'
			}); 
		
	});


</script>
<style>
#content{
	float: left;
	width: 100%;
	height: 1800px;
}
#comment{
	margin-left: 200px;
	
}

#chan{
	height :500px;
	width: 100%;
	font-size: 12pt;
}

#product{
	margin-left: 200px;
	float: left;
	width: 1000px;
	height: 400px;
}
#product table{
	width: 900px;
	height: 400px;
}
#buttom{
	float: left;
	width: 100%;
	height: 200px;
}
</style>
<body>
	<div id="top">
		<jsp:include page="/jsp/other/top.jsp"/>
	</div>
	<div id="content">
		<div id="product" >
			<table border="1">
				<tr>
					<td rowspan="6" width="70%">
						<img src="${good.picture }" alt="1" width="600px" height="400px">
					</td>
					<td >商品名称 :${good.name }</td>
				</tr>
				<tr>
					<td>商品价格 :	${good.price }</td>
				</tr>
				<tr>
					<td>发货地址 :${good.address }</td>
				</tr>
				<tr>
					<td>库存 :${good.storage.count }</td>
				</tr>
				<tr height="100px">
					<td>商品描述信息 :${good.description }</td>
				</tr>
				<tr>
					<td><a href="#">加入购物车</a></td>
				</tr>
			</table>
		</div>
		<div id="comment">
			<div title="商品介绍">
				<table id="chan">
					<tr>
						<td>商品名称 :${good.name}</td>
						<td>商品产地 :${good.address}</td>
					</tr>
					<tr>
						<td>商品库存${good.storage.count }</td>
						<td>商品价格${good.price}</td>
					</tr>
					<tr>
						<td>卖家 :${good.boss.name}</td>
						<td>综合评价 :很好~</td>
					</tr>
					<tr>
						<td>生产时间:</td>
						<td>商品描述:${good.description }</td>
					</tr>
					<tr>
						<td>备注:${good.bz}</td>
						<td>卖家联系方式:${good.boss.tel}</td>
					</tr>
					<tr>
						<td>发货地址:${good.boss.adresse }</td>
					</tr>
				</table>
			</div>
			<div title="商品评价">
				<div>
					<c:if test="${empty comlist }">
						<ul>暂时没有评论</ul>
					</c:if>
					<c:forEach items="${comlist}" var="com">
						<ul>
							<oi>评论用户   ${com.buyer.buyername }</oi>
							<oi>
								等级 ：
								<c:if test="${com.score ==1 }">
								★☆☆☆☆	
								</c:if>
								<c:if test="${com.score ==2 }">
								★★☆☆☆	
								</c:if>
								<c:if test="${com.score ==3 }">
								★★★☆☆	
								</c:if>
								<c:if test="${com.score ==4 }">
								★★★☆☆
								</c:if>
								<c:if test="${com.score ==5 }">
								★★★★☆	
								</c:if>
								<c:if test="${com.score == 0}">
								☆☆☆☆☆									</c:if>
							</oi>
						</ul>
						<ul>
							<oi>${com.content }</oi>
							<oi >${com.date }</oi>
						</ul>
					
					</c:forEach>
					<div id="pp" class="easyui-pagination"  style="background:#efefef;border:1px solid #ccc;"></div> 
				</div>
			</div>
			<div title="其他">
				111
			</div>
		</div>
	</div>
	<div id="buttom">
		<jsp:include page="/jsp/other/buttom.jsp"/>
	</div>
</body>
</html>