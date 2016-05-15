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
		//分页
		$('#comment').tabs({    
		    border:false,    
		    width:900,
		    height:600 ,
		   
		}); 

		//微调数字
		$('#ss').numberspinner({    
		    //required:true,    
		    width :50,
		    increment:1,
		    min: 0,    
		    max: 20, 
		});  
		
		//添加购物车
		$("#addorders").click(function(){
		 buyerid = $("#buyerid").val();
		 goodsid = $("#goodsid").val();
		 bossid = $("#bossid").val();
		 num = $('#ss').numberspinner('getValue');  
		 total = $("#price").val()*num;
		 bz = $("#bz").val();
		 status = 1;
		 var myDate = new Date();
		 date = myDate.toLocaleTimeString();
		
		$.ajax({    
			url: "/xy/orders/add",   
			type: "post",     
			data: ({
				"buyerid" :buyerid ,
				"goodsid" : goodsid,
				"bossid" : bossid,
				"date" : date,
				"total" : total,
				"num" : num,
				"bz" : bz,
				"status" : status,
					}),  
			dataType: "json",    
			async:false,     
			success:function(result){
				if (result.msg != null){
					$.messager.show({
						msg:result.msg+'2秒后自动跳转',
						timeout:5000,
						showType:'slide'
				});
		 	setTimeout('window.location="/xy/jsp/other/index.jsp"',6000)
				}
			},
			error: function(result){
				$.messager.show({
					title:'购物车消息',
					msg:result.msg,
					timeout:5000,
					showType:'slide'
				});
			}
		} );
	});
					
		//
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
	height: 600px;
}
#product table{
	width: 900px;
	height: 500px;
}
#buttom{
	float: left;
	width: 100%;
	height: 200px;
}
#com{
	width: 500px;
	
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
					<td rowspan="7" width="70%">
						<img src="${good.picture }" alt="1" width="600px" height="400px">
					</td>
					<td align="center">商品名称 :${good.name }</td>
				</tr>
				<tr>
					<td align="center">商品价格 :	${good.price }</td>
				</tr>
				<tr>
					<td align="center">发货地址 :${good.address }</td>
				</tr>
				<tr>
					<td align="center">库存 :${good.storage.count }</td>
				</tr>
				<tr height="100px">
					<td align="center">商品描述信息 :${good.description }</td>
				</tr>
				<tr>
					<td align="center">购买数量 ：<input id="ss" value="2"></td>
				</tr>
				<tr>
					<td align="center">
						<a class="easyui-linkbutton" id="addorders" style="background-color: red">加入购物车</a>
					</td>
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
						<td>生产时间:${good.date }</td>
						<td>商品描述:${good.description }</td>
					</tr>
					<tr>
						<td>备注:${good.bz}</td>
						<td>卖家联系方式:${good.boss.tel}</td>
					</tr>
					<tr>
						<td>发货地址:${good.boss.adresse }</td>
					</tr>
					<tr>
						<td>
							<input type="hidden" id="buyerid" value="${buyer.buyerid}"/>
							<input type="hidden" id="goodsid" value="${good.goodsid}"/>
							<input type="hidden" id="bossid" value="${good.boss.bossid}"/>
							<input type="hidden" id="price" value="${good.price}"/>
							<input type="hidden" id="bz" value="1"/>
						</td>
					</tr>
				</table>
			</div>
			<div title="商品评价" id ="c">
					<c:if test="${empty comlist }">
						<ul>暂时没有评论</ul>
					</c:if>
					<c:forEach items="${comlist}" var="com">
						<table id="com">
							<tr>
								<td>评论用户  </td>
								<td>${com.buyer.buyername }</td>
							</tr>
							<tr>
								<td>等级 ：</td>
								<td><c:if test="${com.score ==1 }">
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
								☆☆☆☆☆		
								</c:if></td>
							</tr>
							<tr>
								<td align="center" colspan="2">${com.content }</td>
							</tr>
							<tr>
								<td>评论时间：</td>
								<td>${com.date }</td>
							</tr>
						</table>
					</c:forEach>
					<div id="pp"">
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