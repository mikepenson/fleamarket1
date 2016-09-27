<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@ include file="/public/head.jspf"%>
    <link rel="stylesheet" type="text/css" href="${fleamarket }/css/webstyle.css">
</head>
<body>
<%@ include file="/public/indexHead.jsp" %>

<div class="goodInfo">
    <div class="goodInfo_img"><img src="${fleamarket }/goodsImg/${requestScope.goods.imgUrl}"/></div>
    <div class="goodInfo_detail">
        <ul>
            <li>商品名称：${requestScope.goods.goodsName }</li>
            <li>数量：${requestScope.goods.count }</li>
            <li>价格：${requestScope.goods.price }元</li>
            <li>使用时间：${requestScope.goods.usetime }</li>
            <li>发布时间：${requestScope.goods.releaseDate }</li>
            <li>用户名称：${requestScope.goods.user.username}</li>
            <li>联系方式：${requestScope.goods.user.phoneNumber}</li>
            <li>交易地点：${requestScope.goods.address }</li>
        </ul>
        <a href="">点击收藏</a>
    </div>
</div><!--goodInfo end-->
</body>

</html>
