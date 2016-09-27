<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 引入公共的JSP片段 -->
	<%@ include file="/public/head.jspf"%>
	<link rel="stylesheet" type="text/css" href="${fleamarket }/css/webstyle.css">
	<style type="text/css">
		form div{
			margin: 10px;
		}
	</style>
	<script type="text/javascript">
		$(function(){
			// 自定义验证方法，向   validatebox.defaults.rules中注册函数
			$.extend($.fn.validatebox.defaults.rules, {    
				// 函数的名称：函数的实现体（又是一个json对象，里面包括函数的实现和错误消息设置）
			    format: {   
			    	// 函数实现 ，如果返回为false则验证失败
			        validator: function(value,param){  
			        	//alert(value+","+param.length);  
			        	// 获取当前文件的后缀名
			        	var ext=value.substring(value.lastIndexOf('.')+1);
			        	// 获取支持的的文件后缀名
			        	var arr=param[0].split(",");
			        	for(var i=0;i<arr.length;i++){
			        		if(ext==arr[i])
			        			return true;
			        	}
			            return false;    
			        },    
			        // 错误消息
			        message: '文件必须为：{0}'   
			    }    
			}); 
			
			// 对类别的下拉列表框进行远程加载
			$('#goodstype').combobox({    
			    url:'goodstype_query.action',    
			    valueField:'id',    
			    textField:'goodsTypeName',
			   	panelHeight:'auto',
			   	panelWidth:120,
			   	width:120,
			   	editable:false,
			   	required: true,
				missingMessage:'请选择所属类别',
				onSelect: function(rec){    
	            	var url = 'subtype_queryByGid.action?gid='+rec.id;    
	           	 	$('#subtype').combobox('reload', url);    
	        	}
			});
			
			$('#subtype').combobox({    
			    valueField:'id',    
			    textField:'subTypeName',
			   	panelHeight:'auto',
			   	panelWidth:120,
			   	width:120,
			   	editable:false,
			   	required: true,
				missingMessage:'请选择所属子类别'
			});
			
			$("input[name=goodsName]").validatebox({
				required: true,
				missingMessage:'请输入商品名称'
			});
			$("input[name=count]").numberbox({
				required: true,
				missingMessage:'请输入商品数量',
				min:0,    
			});
			$("input[name=price]").numberbox({
				required: true,
				missingMessage:'请输入商品价格',
				min:0,    
    			prefix:'￥'
			});
			$("input[name='fileImage.upload']").validatebox({
				//required: true,
				//missingMessage:'请上传商品图片',
				// 配置自定义方法
				validType:"format['gif,jpg,jpeg,png']"
			});
			// 当文件域内容发生变化时，则调用验证方法（默认是单击提交时调用验证方法）
			$("input[name='fileImage.upload']").change(function(){
				// 验证文本框是否有效
				$(this).validatebox("validate");
			});
			
			$("textarea[name=descriptionUrl]").validatebox({
				required: true,
				missingMessage:'请输入简单描述'
			});
			// 默认禁止验证功能
			$("#ff").form("disableValidation");
			// 注册button的事件
			$("#submit").click(function(){
				// 开启验证
				$("#ff").form("enableValidation");
				// 如果验证成功则提交数据
				if($("#ff").form("validate")){
					// 调用submit方法提交数据
					$("#ff").form('submit', {
						url: "goods_save.action",
						success: function(){
						   // 重置当前表单数据
						   $("#ff").form("reset");						   
						}
					});
				}
			});
			
			$("#reset").click(function(){
				// 重置当前表单数据
				$("#ff").form("reset");
			});
		});
	</script>
</head>

<body>
<%@ include file="/public/indexHead.jsp" %>
<div class="wrapper clearfix" style="background-color: #ccffff;height:450px;">
<form title="添加商品" id="ff" method="post" enctype="multipart/form-data">
	<div>
		<label>商品名称*:</label> <input type="text" name="goodsName" />
	</div>
	<div>
		<label>数量*:</label> <input type="text" name="count" />
	</div>
	<div>
		<label>价格*:</label> <input type="text" name="price" />
	</div>
	<div>
		<label>使用时间*:</label> <input type="text" name="usetime" />
	</div>
	<div>
		<label>希望交易地点*:</label> <input type="text" name="address" />
	</div>
	<div>
		<label>所属类别：</label> 
		<input id="goodstype" name="goodstype.id"/>
	</div>
	<div>
		<label>所属子类别：</label> 
		<input id="subtype" name="sid"/>
	</div>
	<div>
		<label>图片上传:</label> <input type="file" name="fileImage.upload" />
	</div>
	<div>
		<label>简单描述:</label>
		<textarea name="descriptionUrl" cols="40" rows="4"></textarea>
	</div>
	<div>
		<a id="submit" href="#" class="easyui-linkbutton">立即发布</a> 
	</div>
	<input type="hidden" name="bizType" value="0"/>
</form>
</div>
</body>
</html>
