<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@ include file="/public/head.jspf"%>
	<link href="${fleamarket }/css/login.css" rel="stylesheet" type="text/css" />
<%-- 	<script type="text/javascript" src="${fleamarket }/js/jquery-2.1.1.min.js"></script>
 --%>	
    <script type="text/javascript" src="${fleamarket }/js/verifyLogin.js"></script>
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
					<form action="user_doUserlogin" method="post">
						<!-- 小提示 -->
						<div class="msg_error" id="msg_error">
						</div>
						<div class="input_row">
							<label>用户名：</label><input id="username" type="text" class="input_text" name="user.username" />
						</div>
						<div class="input_row">
							<label>密码：</label><input id="pass" type="password"
								class="input_text" name="user.password" />
						</div>
						<div class="input_row">
							<label>验证码：</label><input id="veryCode" type="text" class="input_text" 
								name="checkCode" />
						</div>
						<div class="veryCode"><!-- 生成验证码 -->
						<img src="verifycode_createVerifyCode"
							onclick="this.src='verifycode_createVerifyCode?timestamp='+ new Date().getTime()"
							title="点击图片刷新验证码" />
							<a id="changecode" style="cursor: pointer;text-decoration: underline;">换一张</a><!-- 点击触发img的onclick -->
						</div> 
						<input id="input_login" type="submit" value="提交" class="input_sub" />
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
