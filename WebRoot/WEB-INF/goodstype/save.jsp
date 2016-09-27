<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@ include file="/public/head.jspf"%>
	<style type="text/css">
		form div{
			margin:5px;
		}
	</style>
	<script type="text/javascript">
		$(function(){
			$("input[name=goodsTypeName]").validatebox({
				required: true,
				missingMessage:'请输入类别名称'
			});
			// 禁用验证
			$("#ff").form("disableValidation");
			// 注册button的事件
			$("#btn").click(function(){
				// 开启验证
				$("#ff").form("enableValidation");
				// 如果验证成功则提交数据
				if($("#ff").form("validate")){
					// 调用submit方法提交数据
					$("#ff").form('submit', {
						url: "goodstype_save.action",
						success: function(){
						   // 关闭当前窗体
						   parent.$("#win").window("close");
						   // 刷新页面   aindex-->iframe-->dg    dom-->jquery-->easyui
						   /// 重新查询加载类别信息数据
						  /*  parent.$("iframe[title='类别管理']").get(0).contentWindow.$('#tt').tree({    
							    url:'goodstype_query.action',
							    animate:true
							}); */
						}
					});
				}
			});
		});
	</script>
</head>
<body>
	<form id="ff" method="post">   
	    <div>   
	        <label for="goodsTypeName">类别名称:</label>   
	        <input class="easyui-validatebox" type="text" name="goodsTypeName" />   
	    </div>   
	    <div>
	    	<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加类别</a>
	    </div>  
</form>  
</body>
</html>
