<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="/xy/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/xy/easyui/jquery.easyui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/xy/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/xy/easyui/themes/icon.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有商品</title>
</head>
<style type="text/css">
#content {
	width: 100%;
	background-color: #eff50a;
	float: left;
}
#left{
	float: left;
	width: 300px;
	
}
#data{
	float: left;
}
#reader{
	color: blue;
}
</style>
<script type="text/javascript">
		$(function(){
			//查询
			$("#search2").click(function(){
			 search = $("#search1").val();
			$.post("/xy/goods/all", {"search": search, "pageindex" :1, "pagesize" :10} );
		});
			//
			
			//
			
			
	});

</script>
<body>
	<div id="top">
		<jsp:include page="/jsp/other/top.jsp"/>
	</div>
<div id="content" >
		<div title="列表" id="left" align="center">
			<ul> <h3>商品分类<h3></h3></ul>
				<a href="/xy/goods/querytype/1?pagesize=10&pageindex=1">
							电子产品
					</a><br><a href="/xy/goods/querytype/2?pagesize=10&pageindex=1">
							生活用品
					</a><br><a href="/xy/goods/querytype/3?pagesize=10&pageindex=1">
							体育器材
					</a><br><a href="/xy/goods/querytype/4?pagesize=10&pageindex=1">
							学习资料
					</a><br><a href="/xy/goods/querytype/5?pagesize=10&pageindex=1">
							虚拟点券
					</a><br><a href="/xy/goods/querytype/6?pagesize=10&pageindex=1">
							零食
							</a>
							
		</div>
	<div id ="data" align="center" title="展示">
		<ul id ="search" align="center">
			<label>请输入商品名称：</label>
			<input type="text" id="search1">
			<input type="button" value="查询" id="search2">
		</ul>
		<c:forEach var="bean" items="${good }">
			<table>
				<tr align="center">
					<td colspan="2"><img src="${bean.picture }" width="400px" height="300px"></td>
				</tr>
				<tr align="center">
					<td>商品名称：${bean.name } &nbsp;
					商品价格：${bean.price}</td>
					<td>商品类别：
						<c:if test="${bean.type == 1}">
							电子产品
						</c:if>
						<c:if test="${bean.type == 2}">
							生活用品
						</c:if>
						<c:if test="${bean.type == 3}">
							体育器材
						</c:if>
						<c:if test="${bean.type == 4}">
							学习资料
						</c:if>
					</td>
				</tr>
				<tr align="center">
					<td colspan="2"><a href="/xy/goods/query/${bean.goodsid }?pageIndex=1&pagesize=20">查看详情</a></td>
				</tr>
			</table>
		</c:forEach>
		<table>
			<tr>
			 <td colspan="6" align="center" bgcolor="#5BA8DE">共${page.totalRecords}条记录 共${page.totalPages}页 当前第${page.pageNo}页<br>
		        <a href="/xy/goods/all?pageindex=1&pagesize=10&search=">
		        <input type="button" name="fristPage" value="首页" />
		        </a>
		        <c:choose>
		          <c:when test="${page.pageNo!=1}">
		              <a href="/xy/goods/all?pageindex=${page.previousPageNo }&pagesize=10&search=">
		              <input type="button" name="previousPage" value="上一页" /></a>
		          </c:when>
		          <c:otherwise>
		              <input type="button" disabled="disabled" name="previousPage" value="上一页" />
		          </c:otherwise> 
		        </c:choose>
		        <c:choose>
		          <c:when test="${page.pageNo != page.totalPages}">
		            <a href="/xy/goods/all?pageindex=${page.nextPageNo }&pagesize=10&search="><input type="button" name="nextPage" value="下一页" /></a>
		          </c:when>
		          <c:otherwise>
		              <input type="button" disabled="disabled" name="nextPage" value="下一页" />
		          </c:otherwise>
		        </c:choose>
		        <a href="/xy/goods/all?pageindex=${page.bottomPageNo }&pagesize=10&search="><input type="button" name="lastPage" value="尾页" /></a>
		   	 </td>
			</tr>
		</table>
	</div>
	<div title="公告" id="right" align="center">
		<h3>商品公告</h3>	
		<table id="reader">
			<tr>
				<td><h4>公告标题</h4></td>
				<td align="center"><h4>公告内容</h4></td>
				<td><h4>发布时间</h4></td>
			<tr>
			<tr>
				<td>商品售罄公告</td>
				<td><p>由于考研，四六级考试，计算机考试</p>
					<p>许多资料书面临缺货</td>
				<td>2016-03-01</td>
			</tr>
			<tr>
				<td>新增公告</td>
				<td><p>二手市场已经更新大量产品</p>
					<p>欢迎大家浏览</p>
				</td>
				<td>2016-03-12</td>
			</tr>
			<tr>
				<td>修改通知</td>
				<td><p>即将开放支付宝支付和微信支付</p>
					<p>敬请期待</p>
				</td>
				<td>2016-04-01</td>
			</tr>
		</table>
	</div>
</div>
	<div id="buttom">
		<jsp:include page="/jsp/other/buttom.jsp"/>
	</div>
</body>
</html>