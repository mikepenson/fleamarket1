<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@ include file="/public/head.jspf"%>
	<link href="${fleamarket }/css/login.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
		$(function() {
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
				// ajax验证
				var veryCode=$("#veryCode").val();
				$.post("user_checkCode.action",{veryCode:veryCode},function(res){
					if(res=="true"){
						$("#loginForm").submit();
						return;
					}
					$("#msg_error").html("验证码不正确，请重新输入！");
				},"text");
			});    	
			
		});
    </script>
</head>

<body>
	<div class="header">
		<a href="${fleamarket }/index.jsp" class="hd_logo"><img src="img/logo.png" alt="logo" /></a>
		<div class="hd_login_nav">
			<a href="#">首页&gt;</a><a href="#">用户登录</a>
		</div>
	</div>
	<!--header end-->
	<div class="con">
		<div class="con_title">用户登录</div>
		<!--con_title end-->
		<div class="con_main">
			<div class="leftArea">
				<div class="form">
					<form id="loginForm" action="${fleamarket }/user_login.action" method="post">
						<!-- 小提示 -->
						<div class="msg_error" id="msg_error">${sessionScope.error }
						</div>
						<div class="input_row">
							<label>用户名：</label><input id="username" type="text" class="input_text" name="username" />
						</div>
						<div class="input_row">
							<label>密码：</label><input id="pass" type="password"
								class="input_text" name="password" />
						</div>
						<div class="input_row">
							<label>验证码：</label><input id="veryCode" type="text" class="input_text" 
								name="veryCode" />
						</div>
						<div class="imgCode"><!-- 生成图片验证码 -->
						<img src="${fleamarket }/user_createImage.action"
							onclick="this.src='user_createImage.action?timestamp='+ new Date().getTime()" title="点击图片刷新验证码" />
						</div> 
						<a id="input_login" class="input_sub">提交</a>
					</form>
				</div>
			</div>
			<!-- leftArea end -->
			<div class="hr_1"></div>
			<div class="rightArea">
				<div class="content">
					<h4>不是跳蚤市场的用户？</h4>
					<p>还等什么赶紧加入吧，享受和同学们分享物品的乐趣。</p>
					<a href="register.jsp" class="btn">注册新用户</a>
				</div>
			</div>
			<!-- rightArea end -->
		</div>
		<!--con_main end-->
	</div>
	<div class="footer">
		<p>Copyright@2016 melonydi All right reserved.</p>
		<p>【版权所有&nbsp;违者必究】</p>
	</div>
</body>

</html>
