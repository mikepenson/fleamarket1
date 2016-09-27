<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@ include file="/public/head.jspf"%>
	<style type="text/css">
		body{
			margin-top: -10px;
		}
		.tree{
			margin-top:10px;
		}
	</style>
	<script type="text/javascript">
		$(function(){
			$('#tt').tree({    
			    url:'goodstype_queryOneToManySubtype.action',
			    animate:true,
			    
			    onDblClick:function(node){  
			       	// 不能编辑根节点
			    	if(node.id==0){
						$.messager.show({
							title:'错误提示',
							msg:'不能编辑根节点！',
							timeout:2000,
							showType:'slide'
						});
					}else{
		            	$(this).tree('beginEdit',node.target); 
		            } 
		        },
		        
		        onAfterEdit:function(node){  
		            if(node.text ==""){  
			            $.messager.show({
								title:'错误提示',
								msg:'编辑文本不能为空！',
								timeout:2000,
								showType:'slide'
						});
		            }
		            else{  
			         	// 判断是类别还是子类别
			         	if($('#tt').tree('getParent',node.target).id==0){
			         		// 直接ajax更新数据，不用回调函数
			                $.post("goodstype_update.action",{id:node.id,goodsTypeName:node.text});  
			         	}else{
			         		var typeId=$('#tt').tree('getParent',node.target).id;
			         		$.post("subtype_update.action",{id:node.id,gid:typeId,subTypeName:node.text});  
			         	}
		               
		            } 
		            
		             
		         }  
		        
		        
			});
		}); 
		
		function addNode(){
			var node = $('#tt').tree('getSelected');
			if(node.id==0){
				parent.$("#win").window({
					title:"添加类别",
					width:320,
					height:180,
					content:'<iframe src="send_goodstype_save.action" frameborder="0" width="100%" height="100%"/>'
				});
			}
			else if($('#tt').tree('getParent',node.target).id==0){
				// 添加子类别
				parent.$("#win").window({
					title:"添加子类别",
					width:320,
					height:180,
					content:"<iframe src='send_subtype_save.action?gid="+node.id+"' frameborder='0' width='100%' height='100%'/>"
				});
			}else{
				$.messager.show({
					title:'错误提示',
					msg:'子类别节点不能继续添加了！',
					timeout:2000,
					showType:'slide'
				});
			}
		}
		
		function deleteNode(){
			var node = $('#tt').tree('getSelected');
			if(node.id==0){
				$.messager.show({
					title:'错误提示',
					msg:'不能删除根节点！',
					timeout:2000,
					showType:'slide'
				});
			}
			// 删除类别
			else if($('#tt').tree('getParent',node.target).id==0){
				if(!$('#tt').tree('isLeaf',node.target)){
					$.messager.show({
						title:'删除提示',
						msg:'该类别下还有子类别，不能删除！',
						timeout:2000,
						showType:'slide'
					});
					return;
				}
				
				$.messager.confirm('删除确认对话框', '是否删除选中记录', function(r){
					if(r){
						$.post("goodstype_delete.action",{id:node.id},function(result){
							if(result=="true"){
								// 返回成功后不用重新加载数据，直接删除选中节点
								$("#tt").tree("remove",node.target);
							}else{
								$.messager.show({
									title:'删除异常',
									msg:'删除失败，请检查操作',
									timeout:2000,
									showType:'slide'
								});
							}
						});
					}
				});
			}
			// 删除子类别 
			else{
				// 提示是否确认删除，如果确认，执行删除的逻辑
				$.messager.confirm('删除确认对话框', '是否删除选中记录', function(r){
					if(r){
						$.post("subtype_delete.action",{id:node.id},function(result){
							if(result=="true"){
								// 返回成功后不用重新加载数据，直接删除选中节点
								$("#tt").tree("remove",node.target);
							}else{
								$.messager.show({
									title:'删除异常',
									msg:'删除失败，请检查操作',
									timeout:2000,
									showType:'slide'
								});
							}
						});
					}
				});
				
			}
		}
		
	</script>
</head>
<body>
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="addNode()">添加</a>
	<!-- <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="updateNode()">更改类别</a> -->
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="deleteNode()">删除</a>
	
	<ul id="tt"></ul> 
</body>
</html>
