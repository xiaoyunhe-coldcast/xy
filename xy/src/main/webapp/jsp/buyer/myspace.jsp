<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="/xy/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/xy/easyui/jquery.easyui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/xy/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/xy/easyui/themes/icon.css">
     <link rel="stylesheet" type="text/css" href="/xy/css/myspace.css">
<title>我的校易</title>
<script type="text/javascript">
	$(function(){
		$('#left').accordion({    
		    animate:true,
		    width:350,
		    height:650,
		});  
		//远程加载dioalog
	    var $addEvent = $("#addEvent");  
        // 初始化对话框  
        $('#open').click(function(){
        	 $("#edite").dialog('open')
        });
       $("#edite").dialog({  
            title: '修改个人信息',  
            width: 500,  
            //height: 250,  
            closed: true,  
            modal: true  ,
            cache: false,  
            href: "/xy/jsp/buyer/edite.jsp",
            buttons: [{  
                text: ' 确认 ',  
                iconCls:'icon-ok',
                handler: function () {  
                    $('#form1').form({    
                        url:'/xy/buyer/update',    
                        onSubmit: function(){    
                        $("#edite").window("close");  
                        },    
                        success:function(result){   
                        	$.messager.show({
                        		title:'消息提示',
                        		msg:'修改成功',
                        		timeout:4000,
                        		showType:'slide'
                        	});  
                        	//刷新页面
                        	window.location.reload();
                        }    
                    });  
                    $('#form1').submit(); 
                }  
            },  
                {  
                    text: '  取消  ',  
                    iconCls:'icon-clear',
                    handler: function () {  
                    	 $("#edite").window("close");  
                    }  
                }  
            ],  
        });  
		
		
	});

</script>
</head>
<body>
	<div id="top">
		<jsp:include page="/jsp/other/top.jsp"/>
	</div>
	<div id="edite">
	
	</div>
	<div id="content">
		<div id="left">
			<div title="个人资料">
				<table >
					<tr>
						<td colspan="2" style="background-color: yellow;" align="center"><b>我的个人信息</b></td>
					</tr>
					<tr>
						<td colspan="2">
							<img alt="1" src="${buyer.buyerpic}" width="300px;" height="200px">
						</td>
					</tr>
					<tr>
						<td><b>姓名</b></td>
						<td>${buyer.realname}</td>
					</tr>	
					<tr>
						<td><b>用户名</b></td>
						<td>${buyer.buyername}</td>
					</tr>	
					<tr>
						<td><b>收货地址</b></td>
						<td>${buyer.address}</td>
					</tr>	
					<tr>
						<td><b>联系方式</b></td>
						<td>${buyer.telephone}</td>
					</tr>	
					<tr>
						<td><b>邮箱</b></td>
						<td>${buyer.email}</td>
					</tr>		
					<tr>
						<td colspan="2" align="center">
							<a class="easyui-linkbutton"  style="width: 100px;height: 30px;" id="open">编辑信息</a></td>
					</tr>		
				</table>
			</div>
			<div title="我的购物车">
				<table>
					<tr>
						<td colspan="2" style="background-color: yellow;" align="center"><b>我的订单</b></td>
					</tr>
					<c:if test="${empty orderslist }">
						<tr>
							<td><a href="#">暂时没有订单</a></td>
							<td><a href="#">点击去购物</a></td>
						</tr>
					</c:if>
					<c:forEach items="${orderslist}" var="o" begin="1" end="3" >
						<tr>
							<td>商品名称</td>
							<td>${o.goods.name}</td>
						<tr>
						<tr>
							<td>总金额</td>
							<td>${o.total}</td>
						</tr>
						<tr>
							<td>订单状态</td>
							<c:if test="${o.status==1 }">
								<td><a href="#">未下单</a></td>
							</c:if>
							<c:if test="${o.status==2 }">
								<td><a href="#">已下单</a></td>
							</c:if>
							<c:if test="${o.status==3 }">
								<td><a href="#">待收货</a></td>
							</c:if>
							<c:if test="${o.status >= 3}">
								<td><a href="#">货已到</a></td>
							</c:if>
						</tr>
						<tr>
							<td>下单时间</td>
							<td>${o.date }</td>
						</tr>
						<tr height="2px">
							<td colspan="2">~~~~~~~~~~~~~~~~~~~~~~~~~~~</td>
						</tr>
				</c:forEach>
				<tr>
					<td colspan="2" align="center"><a href="/xy/jsp/orders/orderlist.jsp" target="main-center">查看所有订单</a></td>
				</tr>
				</table>
			</div>
			<div title="购买历史">
				<table>
					<tr>
						<td colspan="2" style="background-color: yellow;" align="center"><b>我的购买记录</b></td>
					</tr>
					<c:if test="${empty goodslist }">
						<tr>
							<td><a href="#">没有购买过</a></td>
							<td><a href="#">点击去购物</a></td>
						</tr>
					</c:if>
					<c:forEach items="${goodslist}" var="good" begin="1" end="4" >
						<tr>
							<td>商品名称</td>
							<td>${good.goods.name}</td>
						<tr>
						<tr>
							<td>商品价格</td>
							<td>${good.goods.price}</td>
						</tr>
						<tr>
							<td colspan="2">
								<a href="/xy/goods/query/${good.goods.goodsid}?pageIndex=1&pagesize=20" target="_top">商品详细</a>
							</td>
						</tr>
						<tr height="10px">
							<td>----------------------</td>
						</tr>
				</c:forEach>
				<tr>
					<td colspan="2" align="center"><a href="/xy/jsp/goods/goodslist.jsp" target="main-center">查看所有商品</a></td>
				</tr>
				</table>
			</div>
			<div title="评论过的商品" >
				<table>
					<tr>
						<td colspan="2" style="background-color: yellow;" align="center"><b>我的评论</b></td>
					</tr>
					<c:if test="${empty comlist }">
						<tr>
							<td><a href="#">没有评论过商品</a></td>
							<td><a href="#">点击去购物评论</a></td>
						</tr>
					</c:if>
					<c:forEach items="${comlist}" var="com" begin="1" end="4" >
						<tr>
							<td>商品名称</td>
							<td>${com.goods.name}</td>
						<tr>
						<tr>
							<td>评论内容</td>
							<td>${com.content}</td>
						</tr>
						<tr>
							<td>
								<a href="${com.comid}" target="">评论详细</a>
							</td>
							<td >
								<a href="${com.goods.goodsid}" target="">商品详细</a>
							</td>
						</tr>
						<tr height="10px">
							<td>----------------------</td>
						</tr>
				</c:forEach>
				<tr>
					<td colspan="2" align="center"><a href="#" target="">查看所有商品评论</a></td>
				</tr>
				</table>
			</div>
			<div title="我的账户">
			
			</div>
		</div>
		<div id="right">
			<iframe name="main-center" style="width:100%;height:100%;border:0px;" src=""></ifranme>
		</div>
	</div>
	<div id="buttom">
		<jsp:include page="/jsp/other/buttom.jsp"/>
	</div>
</body>
</html>