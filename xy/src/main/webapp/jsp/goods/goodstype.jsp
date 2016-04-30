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
			<c:forEach  var ="bean"  varStatus="status" step="1" items="${good}" end="16">
				<c:if test="${status.index % 2 !=0 }">
					  <tr>
						  <td >
						  	<img src="${bean.picture}" alt="2" />
						  </td>
				</c:if>
				<c:if test="${status.index % 2 ==0 }">
					  <td align="center">
					  	<img src="${bean.picture}" alt="1">
					  </td>
					  </tr>
					   <tr>
					  <td align="center">
					  	<a href="#">商品名称 ：${bean.name }</a><br>
					  	&nbsp;价格 ：${bean.price } 元
					  </td>
				</c:if>
				<c:if test="${status.index % 2 == 0 }">
					  <td align="center">
					  	<a href="#">商品名称 ：${bean.name }</a><br>
					  	&nbsp; 价格 ：${bean.price } 元
					  </td>
					  </tr>
				</c:if>
			</c:forEach>
		</table>
	</div>
	<div id="buttom">
	
	</div>
</body>
</html>