
//自定义的方法
function checkLoginState() {
	$.ajax({
		url:'CheckStateServlet',
		type:'post',
		dataType:'text',
		success:function(data){
			if(data != '') {
				alert(data);
			}
		}
	});
}



//事件绑定
$(function(){
	
	/**
	 * indexlogin.jsp
	 */
	$(".btn[name='submit1']").click(function(){
		var namePattern = /^[a-zA-Z]\w{1,16}[a-zA-Z0-9]$/i;
		var passPattern = /^\w{3,16}$/;
		if($("#username").val()=='' || $("#password").val()=='') {
				$("#msgDiv").html("用户名或密码不能为空");
		} else if(!namePattern.test($('#username').val())) {
			$("#msgDiv").html("用户名输入不符合规范");
			$('#username').focus();
		} else if(!passPattern.test($('#password').val())) {
			$("#msgDiv").html("密码输入不符合规范");
			$('#password').focus();
		}
		else {
			$("#msgDiv").html("");
			//用户登录
			$.ajax({
				url:"LoginServlet?method=index",
				type:"POST",
				data:$("form[name='form1']").serialize(),
				dataType:"text",
				success:function(data){
					if(data != "")
						alert(data);
					else
						window.location.reload();
				}
				
			});
		}
	});
	$("a[name='logout']").click(function(){
		//退出登录
		$.ajax({
			url:'LogoutServlet?id=1',
			type:'post',
			dataType:'text',
			success:function(data){
				alert(data);
				window.location.reload();
			}
		});
	});

	
	
	
});


//加载时执行的语句
$(function(){
	
	/**
	 * CarMessage.jsp
	 */
	$.getJSON("CarMessageServlet?method=view",function(data){
		$.each(data,function(i,item){
			$("#car_view").append("<span>"+item.tradeMark+"--"+item.brand+"</span><span>"+
					item.style+"--"+item.carLoad+"</span><span>"+item.transpotStyle+"</span><br />");
		});
	});
	
	/**
	 * Goods_show.jsp
	 */
	$.getJSON("GoodsMsgServlet?method=view",function(data){
		$.each(data,function(i,item){
			$("#goods_view").append("<span>"+item.goodsStyle+"--"+item.goodsName+"</span><span>"+
					item.startOmit+"&nbsp;"+item.startCity+"--"+item.endOmit+"&nbsp;"+item.endCity+
					"</span><span>"+item.style+"</span><br />");
		});
	});
	
	/**
	 * enterprise.jsp
	 */
	$.getJSON("EnterpriseServlet?method=view",function(data){
		$.each(data,function(i,item){
			$("#en_view").append("<span><b><a href='"+item.eHttp+"'>"+item.enterpriseName+"</a></b></span><br />");
		});
	});
	
	/**
	 * Placard.jsp
	 */
	$.getJSON("PlacardServlet?method=view",function(data){
		$.each(data,function(i,item){
			$("#placard_view").append("<span><b><a href='logistics/Placard/placard_show.jsp?id="+item.id+"'>"+item.title+"</a></b></span><br />");
			if(i>=2)
				return false;
		});
	});
	
	
	
});