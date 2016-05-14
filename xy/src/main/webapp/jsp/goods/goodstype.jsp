<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品分类列表</title>
</head>
<style type="text/css">
#content td{
	width: 400px;

}

#content img{
	width :300px ;
	height :300px;

}
#content{
	position: absolute;
	left: 200px;
	
	
}
</style>
<body>
	<div id="top">
		<jsp:include page="/jsp/other/top.jsp"/>
	</div>
	<div id="content">
		<table bgcolor="yellow" border="1">
			
			<c:forEach  var ="bean"  varStatus="status" items="${good}">
					  <tr>
						  <td align="center">
						  	<img src="${bean.picture}" alt="1">
						  </td>
						  <td align="center">
						  	<a href="#">商品名称 ：${bean.name }</a><br>
						  	&nbsp;价格 ：${bean.price } 元
						  </td>
					  </tr>
			</c:forEach>
			<tr>
			 <td colspan="6" align="center" bgcolor="#5BA8DE">共${page.totalRecords}条记录 共${page.totalPages}页 当前第${page.pageNo}页<br>
		        <a href="/xy/goods/querytype/${type}?pageindex=${page.topPageNo }&pagesize=10">
		        <input type="button" name="fristPage" value="首页" />
		        </a>
		        <c:choose>
		          <c:when test="${page.pageNo!=1}">
		              <a href="/xy/goods/querytype/${type}?pageindex=${page.previousPageNo }&pagesize=10"><input type="button" name="previousPage" value="上一页" /></a>
		          </c:when>
		          <c:otherwise>
		              <input type="button" disabled="disabled" name="previousPage" value="上一页" />
		          </c:otherwise>
		        </c:choose>
		        <c:choose>
		          <c:when test="${page.pageNo != page.totalPages}">
		            <a href="/xy/goods/querytype/${type}?pageindex=${page.nextPageNo }&pagesize=10"><input type="button" name="nextPage" value="下一页" /></a>
		          </c:when>
		          <c:otherwise>
		              <input type="button" disabled="disabled" name="nextPage" value="下一页" />
		          </c:otherwise>
		        </c:choose>
		        <a href="/xy/goods/querytype/${type}?pageindex=${page.bottomPageNo }&pagesize=10"><input type="button" name="lastPage" value="尾页" /></a>
		    </td>
		</tr>
		</table>
	</div>
</body>
</html>