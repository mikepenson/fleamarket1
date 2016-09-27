<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@ include file="/public/head.jspf"%>
    <link rel="stylesheet" type="text/css" href="${fleamarket }/css/webstyle.css">
</head>
  
<body>
<%@ include file="/public/indexHead.jsp" %>

<div class="collect">
    <ul class="">
        <li class="coll_cell coll_title">&nbsp;</li>
        <li class="coll_cell coll_title">商品名称</li>
        <li class="coll_cell coll_title">商品价格</li>
        <li class="coll_cell coll_title">收藏时间</li>
        <li class="coll_cell coll_title">&nbsp;</li>
    </ul>
    <ul class="coll_item">
        <li class="coll_cell coll_con"><img src="img/good1.jpg" alt="商品图片"></li>
        <li class="coll_cell coll_con"><a href="">短袖&nbsp;韩版T恤&nbsp;女装</a></li>
        <li class="coll_cell coll_con">20元</li>
        <li class="coll_cell coll_con">2016/06/03&nbsp;08:12:11</li>
        <li class="coll_cell coll_con"><a href="">删除</a> </li>
    </ul>
</div><!--collect end-->
</body>
</html>
