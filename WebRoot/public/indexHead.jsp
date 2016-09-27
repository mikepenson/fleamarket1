<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="top">
    <div class="leftArea">你好，
	<c:choose>
    <c:when test="${sessionScope.user!=null }">
    	<a href="${fleamarket }/home.jsp" target="_top" class="color">${sessionScope.user.username }
    </a> 欢迎回来！<a href="${fleamarket }/user_logout.action">退出</a>
   </c:when>
    <c:otherwise>
    <a href="${fleamarket }/login.jsp" target="_self">请登录</a>&nbsp;<a href="${fleamarket }/register.jsp" target="_self" class="color">注册</a>
    </c:otherwise>
    </c:choose>
    </div>
    <div class="rightArea"><a href="#">收藏夹</a>&nbsp;<a href="${fleamarket }/user/release.jsp" target="_blank">我要出售</a>&nbsp;
    <a href="${fleamarket }/user/release.jsp" target="_blank">我要求购</a></div>
</div><!--top end-->
<div class="header">
    <a href="${fleamarket }/index.jsp" class="hd_logo"><img src="${fleamarket }/img/logo.png" alt="logo"/></a>
    <div class="hd_search">
    	<form action="goods_queryByGoodsName.action" method="post">
        <input type="text" class="input_text" name="goodsName"/>
        <input type="submit" value="搜索" class="btn"/></form>
        <div class="tip"><a href="#">高级搜索</a>&nbsp;<a href="#">使用帮助</a></div>
    </div>
</div><!--header end-->

<div class="nav">
    <div class="nav_con clearfix">
        <ul>
            <li><a href="${fleamarket }/index.jsp" class="active">首页</a></li>
            <li><a href="${fleamarket }/goods_queryByReleaseDate.action">最新发布</a></li>
            <li><a href="${fleamarket }/goods_queryByBizType.action">最新求购</a></li>
            <li><a href="">以旧换新</a></li>
            <li><a href="">最新留言</a></li>
        </ul>
        <a href="${fleamarket }/goods_queryByUid.action?uid=${sessionScope.user.id}" target="_blank" class="xianzhi">我的闲置<img src="img/xianzhi.png" alt="我的闲置"/></a>
    </div><!--nav_con end-->
</div><!--nav end-->