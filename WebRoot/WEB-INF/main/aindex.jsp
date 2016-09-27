<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@ include file="/public/head.jspf" %>
	<style type="text/css">
		ul{
			list-style: none;
			
			padding: 0px;
			margin:0px;
		}
		ul li{
			border-bottom: 1px solid #fff;
		}
		ul li a{
			/* 先将a标签转换成块级元素，才能设置  */
			display:block;
			background-color: #00a6ac;
			color:#fff;
			padding:5px;
			text-decoration: none;
		}
		ul li a:hover{
			background-color: #008792;
		}
	</style>
	
	<script type="text/javascript">
		$(function(){
			$("a[title]").click(function(){
				var text=$(this).text();
				var href=$(this).attr("title");
				// 判断右边是否有相应的tab
				if($("#tt").tabs("exists",text)){
					$("#tt").tabs("select",text);
				}else{
					//如果没有则创建一个新的tab，否则切换到当前tag 
					$('#tt').tabs('add',{    
					    title:text,    
					    content:'<iframe title=' +text+ ' src=' +href+ ' frameborder="0" width="100%" height="100%"/>',
						closable:true,    
					});  

				}
			});
		});
	</script>
</head>
<body class="easyui-layout" >
    <div data-options="region:'north',title:'欢迎来到跳蚤市场后台交易系统',split:true" style="height:100px;"></div> 
      
    <div data-options="region:'west',title:'系统操作',split:true" style="width:200px;">
    	<!-- 此处显示系统菜单 -->
    	<ul>
    		<li><a href="#" title="send_goodstype_query.action">类别管理</a></li>
    		<li><a href="#" title="send_goods_query.action">商品管理</a></li>
    		<li><a href="#" title="send_user_query.action">用户管理</a></li>
    	</ul>
    </div>   
    
    <div data-options="region:'center',title:'后台操作页面'" style="padding:5px;background:#fff;">
    	<div id="tt" class="easyui-tabs" data-options="fit:true">   
		    <div title="系统缺省页面" style="padding:10px;">   
		      	  此处以后显示相应的系统类型（当前的操作系统类型，包括当前的域名 硬件的相关配置 或者显示报表）    
		    </div>   
		</div> 
    </div>  
     
    <div id="win" data-options="collapsible:false,minimizable:false,maximizable:false,modal:true"></div>
     
</body>
</html>
