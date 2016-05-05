<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head id="Head1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>项目管理系统</title>
    <link href="/xy/css/default.css" rel="stylesheet" type="text/css" />
  	<link rel="stylesheet" type="text/css" href="/xy/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/xy/easyui/themes/icon.css">
    <script type="text/javascript" src="/xy/js/jquery.min.js"></script>
    <script type="text/javascript" src="/xy/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/xy/js/outlook2.js"> </script>
    <script type="text/javascript" src="/xy/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
	    //左侧菜单的选项
		 var _menus = {
		               "menus":[
				           {"menuid":"1",
				        	   "icon":"icon-large-chart",
				        	   "menuname":"买家管理",
					      "menus":[
							{"menuid":"12",
								"menuname":"查询买家",
								"icon":"icon-search",
								"url":"/xy/jsp/buyer/buyerlist.jsp"
								},
							{"menuid":"13",
									"menuname":"添加买家",
									"icon":"icon-man",
									"url":"/xy/jsp/buyer/register.jsp"
									},
							{"menuid":"14",
										"menuname":"账号管理",
										"icon":"icon-large-smartart",
										"url":"/xy/html/demo2.html"
									},
							{"menuid":"15",
										"menuname":"菜单",
										"icon":"icon-large-clipart",
										"url":"/xy/html/demo.html"
										},
							{"menuid":"16",
											"menuname":"菜单",
											"icon":"icon-large-clipart",
											"url":"/xy/html/demo1.html"
											}
						    ]},
				{"menuid":"8",
			    	"icon":"icon-large-shapes",
			    	"menuname":"商品管理",
					"menus":[{"menuid":"21",
						"menuname":"查询商品",
						"icon":"icon-search",
						"url":"/xy/jsp/goods/goodslist.jsp"
						},
							{"menuid":"22",
							"menuname":"添加商品",
							"icon":"icon-add",
							"url":"/xy/jsp/goods/goodadd.jsp"},
							{"menuid":"23",
								"menuname":"商品管理",
								"icon":"icon-tip",
								"url":"/xy/jsp/goods/goodsshow.jsp"}
						]
				},{"menuid":"56",
					"icon":"icon-large-files",
					"menuname":"订单管理",
					"menus":[{"menuid":"31",
						"menuname":"查看订单",
						"icon":"icon-search",
						"url":"/xy/jsp/orders/orderlist.jsp"
						},
							{"menuid":"32",
							"menuname":"添加订单",
							"icon":"icon-add",
							"url":"/xy/jsp/orders/orderadd.jsp"}
						,
						{"menuid":"32",
						"menuname":"操作订单",
						"icon":"icon-edit",
						"url":"/xy/html/demo2.html"}
						]
				},{"menuid":"28",
					"icon":"icon-no",
					"menuname":"库存管理",
					"menus":[{"menuid":"41",
						"menuname":"查看库存",
						"icon":"icon-ok",
						"url":"demo.html"
						},
							{"menuid":"42",
							"menuname":"进货",
							"icon":"icon-menu",
							"url":"demo1.html"},
							{"menuid":"43",
								"menuname":"商品分类",
								"icon":"icon-nav",
								"url":"/xy/html/demo2.html"}
						]
				},{"menuid":"39",
					"icon":"icon-sys",
					"menuname":"系统菜单",
					"menus":[{"menuid":"51",
						"menuname":"菜单1",
						"icon":"icon-nav",
						"url":"/xy/html/demo.html"
						},
							{"menuid":"52",
							"menuname":"菜单2",
							"icon":"icon-nav",
							"url":"/xy/html/demo1.html"
							},
							{"menuid":"53",
								"menuname":"菜单3",
								"icon":"icon-nav",
								"url":"/xy/html/treegrid.html"}
						]
				}
		]};
        //设置登录窗口
        function openPwd() {
            $('#w').window({
                title: '修改密码',
                width: 300,
                modal: true,
                shadow: true,
                closed: true,
                height: 160,
                resizable:false
            });
        }
        //关闭登录窗口
        function closePwd() {
            $('#w').window('close');
        }
        //修改密码
        function serverLogin() {
            var $newpass = $('#txtNewPass');
            var $rePass = $('#txtRePass');

            if ($newpass.val() == '') {
                msgShow('系统提示', '请输入密码！', 'warning');
                return false;
            }
            if ($rePass.val() == '') {
                msgShow('系统提示', '请在一次输入密码！', 'warning');
                return false;
            }

            if ($newpass.val() != $rePass.val()) {
                msgShow('系统提示', '两次密码不一至！请重新输入', 'warning');
                return false;
            }

            $.post('/xy/boss/updateps?newpass=' + $newpass.val(), function(msg) {
                msgShow('系统提示', '恭喜，密码修改成功！<br>您的新密码为：' + msg, 'info');
                $newpass.val('');
                $rePass.val('');
                close();
            })
            
        }

        $(function() {
            openPwd();
            $('#editpass').click(function() {
                $('#w').window('open');
            });

            $('#btnEp').click(function() {
                serverLogin();
            })

			$('#btnCancel').click(function(){
				closePwd();
				});
            $('#loginOut').click(function() {
                $.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {
                    if (r) {
                        location.href = '/xy/boss/logout';
                    }
                });
            })
        });
		
		
    </script>
    </head>
    <body class="easyui-layout" style="overflow-y: hidden" scroll="no">
<noscript>
    <div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;"> 
    <img src="/xy/images/noscript.gif" alt='抱歉，请开启脚本支持！'/> 
    </div>
</noscript>
<div region="north" split="true" border="false" style="overflow: hidden; height: 30px;
        background: url(/xy/images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体"> 
        <span style="float:right; padding-right:20px;" class="head">
 		欢迎 <a href="#">
 		<c:if test="${empty boss.name}">
 			管理员
 		</c:if>
 		<c:if test="${!empty boss.name}">
 			${boss.name}
 		</c:if>
 		</a> <a href="#" id="editpass">修改密码</a> 
        <a href="#" id="loginOut">安全退出</a></span>
        <span style="padding-left:10px; font-size: 16px; ">
        <img src="/xy/images/blocks.gif" width="20" height="20" align="absmiddle" />校易管理系统</span>
</div>
<div region="south" split="true" style="height: 30px; background: #D2E0F2; ">
		<div class="footer">版权所有，翻版必究</div>
</div>
<div region="west" hide="true" split="true" title="导航菜单" style="width:180px;" id="west">
      <div id="nav" class="easyui-accordion" fit="true" border="false"> 
    <!--  导航内容 --> 
 	</div>
</div>
<div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
      <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
	    <div title="欢迎使用" style="padding:20px;overflow:hidden; color:red; " >
	          <h1 style="font-size:24px;">欢迎使用校易管理系统</h1>
	     </div>
  	 </div>
    </div>
<div region="east" title="日期显示" split="true" style="width:180px;overflow:hidden;">
      <div class="easyui-calendar"></div>
    </div>
<!--修改密码窗口-->
<div id="w" class="easyui-window" title="修改密码" collapsible="false" minimizable="false"
   maximizable="false" icon="icon-save"  style="width: 300px; height: 150px; padding: 5px; background: #fafafa;">
 <div class="easyui-layout" fit="true">
    <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
          <table cellpadding=3>
        <tr>
              <td>新密码：</td>
              <td><input id="txtNewPass" type="Password" class="txt01" /></td>
            </tr>
        <tr>
              <td>确认密码：</td>
              <td><input id="txtRePass" type="Password" class="txt01" /></td>
            </tr>
      </table>
        </div>
    <div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;"> <a id="btnEp" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" > 确定</a> <a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a> </div>
  </div>
    </div>
<div id="mm" class="easyui-menu" style="width:150px;">
      <div id="mm-tabupdate">刷新</div>
      <div class="menu-sep"></div>
      <div id="mm-tabclose">关闭</div>
      <div id="mm-tabcloseall">全部关闭</div>
      <div id="mm-tabcloseother">除此之外全部关闭</div>
      <div class="menu-sep"></div>
      <div id="mm-tabcloseright">当前页右侧全部关闭</div>
      <div id="mm-tabcloseleft">当前页左侧全部关闭</div>
      <div class="menu-sep"></div>
      <div id="mm-exit">退出</div>
    </div>
</body>
</html>