<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@ include file="/public/head.jspf" %>
	<style type="text/css">
		body{
			margin:1px;
		}
		.searchbox{
			margin:-3px;
		}
	</style>
	<script type="text/javascript">
		$(function(){
			$('#dg').datagrid({    
				// 请求数据的url
			    url:'user_queryByUsername.action', 
			    loadMsg:'请等待......',
			    queryParams:{username:''},  // 参数：为空代表显示所有
			    // 设置标识域：更新用到
			    idField:'id',
                //显示斑马线  
                striped:true,
                //当数据多的时候不换行  
                nowrap:true,
                //如果为true，则只允许选择一行。
                singleSelect:true,
                //分页
                pagination:true,
                // 初始化每页 行数   可选每页行数
                pageSize:10,
                pageList:[5,10,15,20],
                // 操作工具栏
                toolbar:[{
                	iconCls: 'icon-remove',
                	text:'删除用户',
                	handler: function(){
						// 1： 判断是否有选中记录
						var row=$("#dg").datagrid("getSelected");
						// row 返回被选中的行，如果没有任何的行被选中，则返回null
						if(row==null){
							// 弹出提示信息
							$.messager.show({
								title:'错误提示',
								msg:'请选择一条记录',
								timeout:2000,
								showType:'slide'
							});
						}else{
							// 提示是否确认删除，如果确认，执行删除的逻辑
							$.messager.confirm('删除确认对话框', '删除后该用户的收藏记录也会被删除，您确定？', function(r){
								if (r){
								    // 3: 发送ajax请求
								    $.post("user_delete.action",{id:row.id},function(result){
								    	if(result=="true"){
								    		// 取消选中行
						    				$('#dg').datagrid("uncheckAll");
								    		// 重新刷新当前页
								    		$('#dg').datagrid("reload");
								    		
								    	}else{
								    		// 取消选中行
						    				$('#dg').datagrid("uncheckAll");
								    		$.messager.show({
												title:'删除异常',
												msg:'删除失败，请检查操作',
												timeout:2000,
												showType:'slide'
											});
								    	}
								    },"text");
								}
							});
						}
					}
                },'-',{
                	text:"<input id='ss' name='search'/>"
                }],
                //同列属性，但是这些列将会冻结在左侧,大小不会改变，当宽度大于250时，会显示滚动条，但是冻结的列不在滚动条内  
                frozenColumns:[[
                	{field:'checkbox',checkbox:true},
                	{field:'id',title:'编号',width:200},
                ]],
			    columns:[[    
			        {field:'username',title:'用户名',width:100,
			        	//用来格式化当前列的值，返回的是最终的数据
			        	formatter:function(value,row,index){
			        		return "<span title="+value+">"+value+"</span>";
			        	}  
			        },    
			        {field:'phoneNumber',title:'手机号码',width:100,
			        	//用来格式化当前列的值，返回的是最终的数据
			        	formatter:function(value,row,index){
			        		if(value!=null){
			        			return "<span title="+value+">"+value+"</span>";
			        		}else{
			        			return "无";
			        		}
			        	}  
			        },   
			        {field:'qq',title:'QQ',width:100,
			        	//用来格式化当前列的值，返回的是最终的数据
			        	formatter:function(value,row,index){
			        		if(value!=null){
			        			return "<span title="+value+">"+value+"</span>";
			        		}else{
			        			return "无";
			        		}
			        	}  
			        },    
			        {field:'email',title:'邮箱',width:100,
			        	//用来格式化当前列的值，返回的是最终的数据
			        	formatter:function(value,row,index){
			        		if(value!=null){
			        			return "<span title="+value+">"+value+"</span>";
			        		}else{
			        			return "无";
			        		}
			        	}  
			        }
			        
			    ]]    
			}); 
			// 把普通文本框转化为搜索文本框
			$('#ss').searchbox({ 
				// 触发查询事件
				searcher:function(value,name){ 
					// 获取当前查询的关键字，通过dg加载相应的信息
					//alert(value + "," + name);
					$('#dg').datagrid('load',{username:value});
					$('#dg').datagrid('uncheckAll');
				}, 
				prompt:'请输入用户名...' 
			});
		});
	</script>
</head>
<body>
	<table id="dg"></table>  
</body>
</html>
