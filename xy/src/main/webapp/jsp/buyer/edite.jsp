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
    <link rel="stylesheet" type="text/css" href="/xy/css/myspace.css">
<title>编辑信息</title>
</head>
<style>

</style>
<body>
<script type="text/javascript">
	$(function (){
		$('#reset').click(function(){
			$('#form1').form('clear');
		});
	})

</script>
<form id="form1" action="#" method="post" >
	<table id ="table" width="200px" align="center">
		<tr><td colspan="2"><h2>修改个人资料</h2></td></tr>
    	<tr>
        	<td><b>用户名：</b></td>
            <td><input type="text" name="buyername" id="username" value="${buyer.buyername}"/></td>
        </tr>
         <br/>
    	<tr>
        	<td><b>真实姓名：</b></td>
            <td>
            	<input name="realname" id="nickname" value="${buyer.realname }" />
            </td>
        </tr>		
    	<tr>
        	<td><b>密码：</b></td>
            <td><input type="password" name="buyerpsw" id="password" value="${buyer.buyerpsw}" /></td>
        </tr>	
    	<tr>
        	<td><b>手机号：</b></td>
            <td><input id="tel" type="text" name="telephone" value="${buyer.telephone }"/></td>
        </tr>
        <br/>
    	<tr>
        	<td><b>邮箱：</b></td>
            <td><input type="text" name="email"  id="mail" value="${buyer.email }"/></td>
        </tr>
        <tr>
        	<td><b>地址:</b></td>
        	<td><input type="text" name="address"  id="address" value="${buyer.address }"/></td>
        </tr>
         <tr>
        	<td>
        		<input type="hidden" name="status" value="${buyer.status }"> 
        		<input type="hidden" name="buyerjf" value="${buyer.buyerjf }"> 
        		<input type="hidden" name="sex" value="${buyer.sex} "> 
        		<input type="hidden" name="money" value="${buyer.money} "> 
        		<input type="hidden" name="buyerpic" value="${buyer.buyerpic} "> 
        		<input type="hidden" name="bz" value="${buyer.bz} "> 
        		<input type="hidden" name="buyerid" value="${buyer.buyerid} "> 
        	</td>
        </tr>
    	<tr align="center" >
        	<td colspan="2" >
        	<input class="easyui-linkbutton" id="reset" value="重置"/>
        	<a class="easyui-linkbutton" id="btn">修改</a></td>
        </tr>
    </table>
</form>
</body>
</html>