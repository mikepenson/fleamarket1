/**
 * 登录验证行为
 */

//页面渲染完成后执行以下行为
$(function() {
	(function() {
		$("#input_login").click(function(){
			var username = $.trim($("#username").val());
			var pass=$("#pass").val();
			var verycode=$.trim($("#veryCode").val());
			
			if (username == ""&&pass=="") {//用户名和密码为空提示
				$(".msg_error").html("请输入用户名和密码");
				return false;
			}
			if (username == "") {//用户名为空提示
				$(".msg_error").html("请输入用户名");
				return false;
			}
			if (pass=="") {//用户名和密码为空提示
				$(".msg_error").html("请输入密码");
				return false;
			}
			if (verycode=="") {//验证码为空提示
				$(".msg_error").html("请输入验证码");
				return false;
			}
			
			//判断验证码是否正确
			/*var flag = true;
			$.post(
					"verifycode_checkVerifyCode",
					"verycode=" + verycode,
					function(result) {
						
						if (result=="1") {
							flag = true;
						} else {
							$("#msg_error").html("请输入验证码");
							flag = false;
						}
					});
			if (!flag) {
				return false;
			}*/
		});
		
	})();
});