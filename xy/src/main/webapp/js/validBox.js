/**
 * 用于输入框验证
 */

$(function(){
	$.extend($.fn.validatebox.defaults.rules, {    
		nameValid: {    
    		validator: function(value){
				var pattern = /^[a-zA-Z]\w{1,7}[a-zA-Z0-9]$/;
				return pattern.test(value);    
    		},    
   			message: '用户名格式不正确:<br>·只能以字母开头；长度为3-9个字符'
		},
		passValid: {
			validator:function(value){
				var pattern = /^[a-zA-Z0-9]{3,16}$/;
				return pattern.test(value);
			},
			message:'密码格式不正确'
		},
		cpassValid: {
			validator:function(value){
				var str = $("#password").val();
				return (str == value);
			},
			message:'前后密码不一致，请重新输入'
		},
		emailValid:{
			validator:function(value){
				var pattern = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
				return pattern.test(value);
			},
			message:'邮箱格式不正确'
		},
		phoneValid:{
			validator:function(value){
				var pattern = /^1\d{10}$/;
				return pattern.test(value);
			},
			message:'请输入正确的电话格式'
		}
	});  
		
		$("#username").textbox({
			iconCls:'icon-man',
			prompt:'用户名',
			width:'150px',
			required:true,
			validType:'nameValid'
		});
		
		$("#password").textbox({
			iconCls:'icon-lock',
			prompt:'111111',
			width:'150px',
			required:true,
			validType:'passValid'
		});
		
		$("#cpassword").textbox({
			iconCls:'icon-lock',
			prompt:'111111',
			width:'150px',
			required:true,
			validType:'cpassValid'
		});
		
		$("#email").textbox({
			prompt:'请输入电子邮箱',
			width:'150px',
			required:true,
			validType:'emailValid'
		});
		
		$("#phone").textbox({
			prompt:'请输入联系电话',
			width:'150px',
			required:true,
			validType:'phoneValid'
		});

		$("#IssueDate").datebox({
			width:'150px',
			required:true,
			editable:false
		});
		
		$("#question").combobox({
			url:"RegCusmtoerServlet?method=question",
			valueField:'id',
			textField:'content',
			width:'150px',
			panelHeight:'150px',
			required:true,
			missingMessage:'密码问题将用于后期找回密码，请牢记！',
			editable:false,
		});
		
		$("#result").textbox({
			width:'150px',
			required:true,
			missingMessage:'请输入密码问题答案'
		});
		
		$('#textType').combobox({
			width:'130px',
			panelWidth:'130px',
			panelHeight:'100px',
			editable:false
			
		});
		
		$('#textCode').textbox({
			width:'80px'
		});
		
});