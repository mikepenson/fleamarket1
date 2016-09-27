<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@ include file="/public/head.jspf"%>
    <link rel="stylesheet" type="text/css" href="${fleamarket }/css/webstyle.css">
</head>
 <body>
<%@ include file="/public/indexHead.jsp" %>
<div class="sort">
    <div class="sort_con clearfix">
        <div class="sort_btn"><a href="">按时间</a><a href="">按价格</a></div>
        <form action="" method="post">
            <span class="lr">价格区间</span><span class="center">
            ￥<input type="text"/>-<input type="text"/></span>
            <input type="submit" value="确定" class="sub_sort_btn" style="float:right;width: 71px;height:32px;border:#000000 solid 1px;background-color: #FF6868;"/>
        </form>
    </div>
</div><!--sort end-->
<div class="list">
    <ul class="">
        <li class="list_cell list_title">&nbsp;</li>
        <li class="list_cell list_title">商品名称</li>
        <li class="list_cell list_title">商品价格</li>
        <li class="list_cell list_title">发布时间</li>
    </ul>
    <c:forEach items="${requestScope.goodsList }" var="goods">
    <ul class="list_item">
        <li class="list_cell list_con"><img src="${fleamarket }/goodsImg/${goods.imgUrl}" alt="" style="width:200px;height:150px;"></li>
        <li class="list_cell list_con"><a href="${fleamarket }/goods_get.action?id=${goods.id}&hit=${goods.hit}">${goods.goodsName}</a></li>
        <li class="list_cell list_con">${goods.price}元</li>
        <li class="list_cell list_con">${goods.releaseDate}</li>
    </ul>
    </c:forEach>
    
</div><!--list-->
</body>

</html>
