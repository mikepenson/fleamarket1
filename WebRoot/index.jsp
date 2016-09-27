<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@ include file="/public/head.jspf"%>
    <link rel="stylesheet" type="text/css" href="${fleamarket }/css/webstyle.css">
</head>
<body>
<%@ include file="/public/indexHead.jsp" %>

<div class="wrapper clearfix">
     <div class="goodType">
     	<c:forEach items="${applicationScope.goodstypeList }" var="goodstype">
			<dl class="goodType_item" style="clear:both;">
	            <dt>${goodstype.goodsTypeName }</dt>
	            	<c:forEach items="${goodstype.subtypes }" var="subtype">
	            	<dd style="float:left;"><a href="${fleamarket }/goods_queryBySid.action?sid=${subtype.id}">${subtype.subTypeName }
	            	</a></dd> 
	            	</c:forEach>
	        </dl>
     	</c:forEach>
    </div> 
    <div class="publish">
        <a href="${fleamarket }/user/release.jsp" target="_blank" class="publish_btn btn">发布闲置</a>
        <a href="${fleamarket }/user/need.jsp" target="_blank" class="publish_btn btn">我要求购</a>
        <a href="" class="ad"><img src="img/ad.png" alt="广告"/></a>
    </div>
</div><!--wrapper end-->

<div class="hotGood clearfix">
    <div class="good_title">
        <h3>热门商品</h3>
    </div>
    <c:forEach items="${applicationScope.hotList }" var="hot">
    <div class="good_item">
        <div class="img_item">
            <a href="${fleamarket }/goods_get.action?id=${hot.id}&hit=${hot.hit}" target="_blank"><img src="${fleamarket }/goodsImg/${hot.imgUrl}" alt=""/> </a>
        </div>
        <p><a href="${fleamarket }/goods_get.action?id=${hot.id}&hit=${hot.hit}" target="_blank">${hot.goodsName }</a></p>
        <p class="money">￥${hot.price }</p>
    </div>
    </c:forEach>
    
</div><!--hotGood end-->

<c:forEach items="${applicationScope.goodsList }" var="list">
<c:if test="${list[0].goodstype.goodsTypeName }!=null"></c:if>
<div class="hotGood clearfix">
    <div class="good_title">
        <h3>${list[0].goodstype.goodsTypeName }</h3>
    </div>
    <c:forEach items="${list }" var="goods">
    <div class="good_item">
        <div class="img_item">
            <a href="${fleamarket }/goods_get.action?id=${goods.id}&hit=${goods.hit}" target="_blank"><img src="${fleamarket }/goodsImg/${goods.imgUrl}" alt=""/> </a>
        </div>
        <p><a href="${fleamarket }/goods_get.action?id=${goods.id}&hit=${goods.hit}" target="_blank">${goods.goodsName }</a></p>
        <p class="money">￥${goods.price }</p>
    </div>
    </c:forEach>
</div><!--hotGood end-->
</c:forEach>

<div class="footer">
    <p>Copyright@2016 melonydi All right reserved.</p>
    <p>【版权所有&nbsp;违者必究】</p>
</div><!--footer end-->
</body>
</html>