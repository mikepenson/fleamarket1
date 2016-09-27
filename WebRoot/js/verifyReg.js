/**
 * 注册验证行为
 */

// 获得字符串的长度
function getStringLength(str) {
	var t = 0;
	for (var i = 0; i < str.length; i++) {
		if (str.charCodeAt(i) > 255) {
			t += 2;
		} else {
			t++;
		}
	}
	return t;
}

//页面渲染完成后执行以下行为
$(function() {
	(function() {
		//正则表达式
		var regName = /^[\u4e00-\u9fa5_a-z0-9\-]+$/i;
		var regPhone = /^(13[0-9]|15[0-9]|18[0-9]|147)\d{8}$/;
		var regQQ=/^[1-9][0-9]{4,}$/;
		var regEmail = /^[0-9a-z\.\-_]+@([0-9a-z\-_]*\.*)([0-9a-z\-_]+)\.[a-z\.]+$/i;
		
		/* 聚焦和光标移出事件 */
		$("#username").focus(
				function() {
					//使点击生效
					$("#input_sub").attr("disabled",false);
					$(this).siblings(".warning").hide();
					$(this).siblings(".input_tip").show().html(
							"4-20位字符，可由中英文、数字、_和-组成");
				}).blur(
				function() {
					$(this).siblings(".input_tip").hide();
					var username = $.trim($("#username").val());
					if (username == "") {//用户名为空不提示
						$(this).siblings(".warning").css({
							"display" : ""
						}).html("用户名不能为空！");
						//使点击失效
						$("#input_sub").attr("disabled",true);
						return false;
					}
					if (getStringLength(username) < 4
							|| getStringLength(username) > 20) {
						$(this).siblings(".warning").css({
							"display" : ""
						}).html("用户名长度只能在4-20个字符之间");
						//使点击失效
						$("#input_sub").attr("disabled",true);
						return false;
					}
					if (!regName.test(username)) {
						$(this).siblings(".warning").css({
							"display" : ""
						}).html("4-20位字符，可由中英文、数字、_和-组成");
						//使点击失效
						$("#input_sub").attr("disabled",true);
						return false;
					}
					if (regPhone.test(username)) {
						$(this).siblings(".warning").css({
							"display" : ""
						}).html("用户名不能为手机号码");
						//使点击失效
						$("#input_sub").attr("disabled",true);
						return false;
					}
					/*
					 * re = /admin|库巴|coo8|客服|维护|售后|工作|咨询|c008|世纪电器|51mdq/i; if
					 * (re.test(username)) {
					 * $(this).siblings(".input_tip").css({ "display" : ""
					 * }).html("已被注册的用户名！"); return false; }
					 */
					var flag = true;
					$.post(
						"user_validateName.action",
						"username="+ encodeURIComponent(encodeURIComponent(username)),
						function(result) {// 返回值result
							if (result == "false") {
								$("#username").siblings(".warning").hide();
							} else if (result == "true") {
								$("#username").siblings(".warning").css({
									"display" : ""
								}).html("已被注册的用户名！");
								//使点击失效
								$("#input_sub").attr("disabled",true);
								flag = false;
							}
					});
					// 鼠标移出后警示关闭
					$(this).siblings(".warning").hide();
				});

		/* 聚焦和光标移出事件 */
		$("#regPass1").focus(function() {
			//使点击生效
			$("#input_sub").attr("disabled",false);
			$(this).siblings(".warning").hide();
			$(this).siblings(".input_tip").show();
		}).blur(function() {
			$(this).siblings(".input_tip").hide();
			var pass = $("#regPass1").val();
			if (pass == "" || $.trim($(this).val()) == "") {
				$(this).siblings(".warning").css({
					"display" : ""
				}).html("密码不能为空！");
				return false;
			}
			if (pass.length < 6 || pass.length > 16) {
				$(this).siblings(".warning").css({
					"display" : ""
				}).html("密码应为6-16位字符");
				//使点击生效
				$("#input_sub").attr("disabled",true);
				return false;
			}
			// 鼠标移出后警示关闭
			$(this).siblings(".warning").hide();
		});
		
		/* 聚焦和光标移出事件 */
		$("#regPass2").focus(function() {
			$(this).siblings(".warning").hide();
			$(this).siblings(".input_tip").show();
		}).blur(function() {
			$(this).siblings(".input_tip").hide();
			var pass = $(this).val();
			var pass1 = $("#regPass1").val();
			if (pass == "" || $.trim($(this).val()) == "") {
				$(this).siblings(".warning").css({
					"display" : ""
				}).html("");
				return false;
			}
			/*if (pass.length < 6 || pass.length > 16) {
				$(this).siblings(".warning").css({
					"display" : ""
				}).html("密码应为6-16位字符");
				return false;
			}*/
			
			if (pass != pass1) {
				$(this).siblings(".warning").css({
					"display" : ""
				}).html("两次输入的密码不一致！");
				$(this).focus();
				return false;
			}
			$(this).siblings(".warning").hide();
		});
		
		$("#phoneNumber").focus(function() {
			
			$(this).siblings(".warning").hide();
			$(this).siblings(".input_tip").show();
		}).blur(function() {
			$(this).siblings(".input_tip").hide();
			var phoneNumber = $("#phoneNumber").val();
			if (phoneNumber == "") {
				$(this).siblings(".warning").css({
					"display" : ""
				}).html("手机号不能为空！");
				return false;
			}
			if (phoneNumber == "" || $.trim($(this).val()) == "") {
				$(this).siblings(".warning").css({
					"display" : ""
				}).html("");
				return false;
			}
			
			if (!regPhone.test(phoneNumber)) {
				$(this).siblings(".warning").css({
					"display" : ""
				}).html("手机号码格式不正确，请重新输入");
				return false;
			}
			$(this).siblings(".warning").hide();
		});
		
		$("#qq").focus(function() {
			
			$(this).siblings(".warning").hide();
			$(this).siblings(".input_tip").show();
		}).blur(function() {
			$(this).siblings(".input_tip").hide();
			var qq = $("#qq").val();
			if (qq == "" || $.trim($(this).val()) == "") {
				$(this).siblings(".warning").css({
					"display" : ""
				}).html("");
				return false;
			}
			
			if(!regQQ.test(qq)){
				$(this).siblings(".warning").css({
					"display" : ""
				}).html("QQ号码格式不正确，请重新输入");
				return false;
			}
			$(this).siblings(".warning").hide();
		});
		
		$("#useremail").focus(function() {
			$(this).siblings(".warning").hide();
			$(this).siblings(".input_tip").show().html(
					"验证过的邮箱可用来找回密码、接收订单处理信息");
		}).blur(function() {
			$(this).siblings(".input_tip").hide();
			var email = $.trim($("#useremail").val());
			if (email == "") {
				$(this).siblings(".warning").css({
					"display" : ""
				}).html("邮箱不能为空！");
				return false;
			}
			if (!regEmail.test(email)) {
				$(this).siblings(".warning").css({
					"display" : ""
				}).html("邮箱地址格式不正确，请重新输入");
				return false;
			}
			var flag = true;
			$.post(
					"user_validateEmail.action",
					"email=" + email,
					function(backEmail) {
						if (backEmail == "false") {
							$("#useremail").siblings(
								".warning").hide();
								flag = true;
						} else {
							$("#useremail").siblings(
								".warning").css({
										"display" : ""
							}).html("该邮箱已被使用，请更换其它邮箱！");
							$("#useremail").val("");
							flag = false;
						}
					});
			if (!flag) {
				return false;
			}
		});
		/* 换一张 绑定click事件触发img的onclick事件 */
		$("#changecode").bind("click", function() {
			$("#loginVcode").trigger("click");
		});
		$("#regCode").focus(function() {
			$(this).siblings(".warning").hide();
			$(this).siblings(".input_tip").show();
		}).blur(function(){
			$(this).siblings(".input_tip").hide();
			var regcode = $.trim($("#regCode").val());
			if(regcode==""){
				$(this).siblings(".warning").css({
					"display" : ""
				}).html("验证码不能为空！");
				return false;
			}
			var flag = true;
			$.post(
					"user_checkCode.action",
					"veryCode=" + regcode,
					function(result) {
//						alert(result);
						if (result=="true") {
							$("#regCode").siblings(
								".warning").hide();
								flag = true;
						} else {
							$("#regCode").siblings(
								".warning").css({
										"display" : ""
							}).html("验证码错误，请重新输入");
							$("#regCode").val("");
							flag = false;
						}
					});
			if (!flag) {
				return false;
			}
		});
		
		//点击提交
		$("#input_sub").click(function(){
			var username = $.trim($("#username").val());
			var regcode = $.trim($("#regCode").val());
			var email = $.trim($("#useremail").val());
			var pass1 = $("#regPass1").val();
			var pass2 = $("#regPass2").val();
			
			var flag=true;
			
			if (username == "") {//用户名为空不提示
				$("#username").siblings(".warning").css({
					"display" : ""
				}).html("用户名不能为空！");
				//使点击生效
				$(this).attr("disabled",false);
				flag=false;
			}
			if (pass1 == "" || $.trim($(this).val()) == "") {
				$("#regPass1").siblings(".warning").css({
					"display" : ""
				}).html("密码不能为空！");
				//使点击生效
				$(this).attr("disabled",false);
				flag=false;
			}
			if (email == "") {
				$("#useremail").siblings(".warning").css({
					"display" : ""
				}).html("邮箱不能为空！");
				//使点击生效
				$(this).attr("disabled",false);
				flag=false;
			}
			if(regcode==""){
				$("#regCode").siblings(".warning").css({
					"display" : ""
				}).html("验证码不能为空！");
				//使点击生效
				$(this).attr("disabled",false);
				flag=false;
			}
			
			if (pass2 != pass1) {
				$("#regPass2").siblings(".warning").css({
					"display" : ""
				}).html("两次输入的密码不一致！");
				$("#regPass2").val("");
				//使点击生效
				$(this).attr("disabled",false);
				flag=false;
			}
			return flag;
		});
		
	})();
});
