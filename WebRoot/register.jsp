<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@ include file="/public/head.jspf"%>
	<link href="${fleamarket }/css/login.css" rel="stylesheet" type="text/css" />
	
	<style type="text/css">
        .con_main .form{margin: 20px auto;width:650px;}
        .con_main .input_row{margin: 5px 0;height:45px;}
        .con_main .input_row .input_tip{ width:200px;height: 25px;line-height: 25px;font-size: 12px;}
        .con_main .input_row .warning{width:350px;height:22px;line-height:22px; padding-left:100px; font-size:12px;}
        .pwdStrength{height:20px;line-height: 20px;color:#5e5e5e;padding-left: 100px;font-size: 14px;}
        .pwdStrength b{display:inline-block;padding-left:95px;vertical-align:middle; background: url(img/loginbg.png) no-repeat -516px -44px;}
    </style>
    <script type="text/javascript" src="${fleamarket }/js/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="${fleamarket }/js/verifyReg.js"></script>
  </head>
<body>
<div class="header">
    <a href="${fleamarket }/index.jsp" class="hd_logo"><img src="img/logo.png" alt="logo"/></a>
    <div class="hd_login_nav"><a href="index.jsp">首页&gt;</a><a href="login.jsp">登录&gt;</a><a href="register.jsp">注册新用户</a></div>
</div><!--header end-->
<div class="con">
    <div class="con_title">注册新用户</div><!--con_title end-->
    <div class="con_main">
        <div class="form">
            <form action="user_register.action" method="post">
                <div class="input_row"><label>用户名*：</label><input id="username" type="text" class="input_text" name="username">
                	<span style="display: none" class="input_tip"></span>
					<div style="display: none" class="warning"></div>
                </div>
                <div class="input_row"><label>密码*：</label><input id="regPass1" type="password" class="input_text" name="password">
                	<span style="display: none" class="input_tip">6-16位字符，可由英文、数字和符号组成</span>
					<div style="display: none" class="warning">密码应为6-16位字符</div>
					<p id="pwdInfo" class="pwdStrength pwdStrengthA">密码强度：<b id="s_passinfo">弱</b></p>
                </div>
                <div class="input_row"><label>确认密码*：</label><input id="regPass2" type="password" class="input_text" name="password1">
                	<span style="display: none" class="input_tip">请再次输入密码</span>
					<div style="display: none" class="warning">您两次输入的密码不一致</div>
                </div>
                <div class="input_row"><label>手机号码：</label><input id="phoneNumber" type="text" class="input_text" name="phoneNumber">
                	<span style="display: none" class="input_tip">请输入您的手机号码</span>
					<div style="display: none" class="warning"></div>
                </div>
                <div class="input_row"><label>QQ号码：</label><input id="qq" type="text" class="input_text" name="qq">
                	<span style="display: none" class="input_tip">请输入您的QQ号码</span>
					<div style="display: none" class="warning"></div>
                </div>
                <div class="input_row"><label>邮箱地址*：</label><input id="useremail" type="text" class="input_text" name="email">
                	<span style="display: none" class="input_tip">验证过的邮箱可用来找回密码、接收订单处理信息</span>
					<div style="display: none" class="warning">请输入正确的邮箱地址</div>
                </div>
                <div class="input_row"><label>验证码*：</label><input id="regCode" type="text" class="input_text" name="veryCode"/>
					<span style="display: none" class="input_tip">请输入图形中的验证码</span>
					<div style="display: none" class="warning">验证码错误</div>
                </div>
                <div class="veryCode"><!-- 生成验证码 -->
					<img id="loginVcode" src="user_createImage.action" 
					onclick="this.src='user_createImage.action?timestamp='+ new Date().getTime()" 
					title="点击图片刷新验证码" /><a id="changecode" style="cursor: pointer;text-decoration: underline;">换一张</a><!-- 点击触发img的onclick -->
					<!-- <s:actionerror cssStyle="color:red"/> -->
				</div>
                <input id="input_sub" type="submit" class="input_sub" value="提交">
            </form>
        </div>

    </div><!--con_main end-->
</div>
<div class="footer">
    <p>Copyright@2016 melonydi All right reserved.</p>
    <p>【版权所有&nbsp;违者必究】</p>
</div>
</body>

</html>
