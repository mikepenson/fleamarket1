<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@ include file="/public/head.jspf"%>
    <link rel="stylesheet" type="text/css" href="${fleamarket }/css/webstyle.css">
    <script type="text/javascript">
    	function changeTag(id){
    		$.messager.confirm('确认','您确认改为已经出售吗？',function(r){    
			    if (r){    
			    	$.post("goods_updateTag.action",{id:id,tag:"1"},function(res){
			    		if(res=="true"){
			    			$("#goodsTag"+id).html("本商品已经出售");
			    		}
			    	},"text");
			    }    
			});
    	}
    </script>
</head>
  
<body>
<%@ include file="/public/indexHead.jsp" %>

<div class="collect">
    <ul class="">
        <li class="coll_cell coll_title">&nbsp;</li>
        <li class="coll_cell coll_title">商品名称</li>
        <li class="coll_cell coll_title">商品价格</li>
        <li class="coll_cell coll_title">发布时间</li>
        <li class="coll_cell coll_title">&nbsp;</li>
    </ul>
    <c:forEach items="${requestScope.goodsList }" var="goods">
    <ul class="coll_item">
        <li class="coll_cell coll_con"><img src="${fleamarket }/goodsImg/${goods.imgUrl}" alt="商品图片"></li>
        <li class="coll_cell coll_con"><a href="${fleamarket }/goods_getById.action?id=${goods.id}">${goods.goodsName}</a></li>
        <li class="coll_cell coll_con">${goods.price}元</li>
        <li class="coll_cell coll_con">${goods.releaseDate}</li>
        <li class="coll_cell coll_con" id="goodsTag${goods.id}">
        	<c:choose>
        		<c:when test="${goods.tag==0}"><a href="#" onclick="changeTag(${goods.id})">改为已经出售</a></c:when>
        		<c:otherwise>本商品已经出售</c:otherwise>
        	</c:choose></li>
    </ul>
    </c:forEach>
</div><!--collect end-->
</body>
</html>
