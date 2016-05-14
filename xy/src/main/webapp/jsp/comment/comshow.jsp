<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<c:forEach var="bean" items="${com}">
			<table>
				<tr>
					<td>商品信息：${bean.good.name }</td>
					<td>商品价格 ： ${bean.good.price }<td>
				</tr>
				<tr>
					<td>评论内容：${bean.content }</td>
				</tr>
				<tr>
					<td>${bean.date }</td>
					<td>评论星级  ${bean.score }</td>
				</tr>
			</table>
		</c:forEach>
	</div>
</body>
</html>