<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@ include file="/public/head.jspf"%>
	<style type="text/css">
		body{
			margin: 1px;
		}
		.searchbox {
		  margin: -3px;
		}
	</style>
	<script type="text/javascript">
		$(function(){
			$('#dg').datagrid({   
				//请求数据的url地址 
			    url:'goods_queryJoinUserBySubtypeIdAndGoodsName.action',
			    loadMsg:"请耐心等待...",
			    queryParams:{sid:0,goodsName:''},
			    // 指定id字段为标识字段，在更新删除的时候有用，在翻页的时候被选中的记录不会被丢失
			    idField:'id',
			    //是否显示斑马线效果。
			    striped:true, 
			    // 同行显示数据
			    nowrap:true,
			    //可以多选
			    singleSelect:false,
			    //自动适应列，如果设置此属性，则不会出现水平滚动条，在演示冻结列的时候此参数不要设置
			    fitColumns:true,
			    //设置分页	
			    pagination:true,
			    //同列属性，但是这些列将会被冻结在左侧。
			    frozenColumns:[[
			    	{field:'abc',checkbox:true},
			        {field:'id',title:'编号',width:100}  
			    ]],
			    //pagePosition:"both",
			    //初始化页面大小
			    pageSize:10,
			    // 初始化页面大小选择列表-
			    pageList:[5,10,15,20],
			    toolbar: [{
					iconCls: 'icon-remove',
					text:'删除商品',
					handler: function(){
						// 1： 判断是否有选中记录
						var rows=$("#dg").datagrid("getSelections");
						// rows 返回被选中的行，如果没有任何的行被选中，则返回空数组
						if(rows.length==0){
							// 弹出提示信息
							$.messager.show({
								title:'错误提示',
								msg:'至少选择一条记录',
								timeout:2000,
								showType:'slide'
							});
						}else{
							// 提示是否确认删除，如果确认，执行删除的逻辑
							$.messager.confirm('删除确认对话框', '是否删除选中记录', function(r){
								if (r){
								    // 1： 获取被选中的记录，然后从记录中获取相应的id
								    var ids="";
								    for(var i=0;i<rows.length;i++){
								    	ids += rows[i].id+",";
								    }
								    // 2: 拼接id的值发送给后台1,2,3,4
								    ids=ids.substring(0, ids.lastIndexOf(","));
								    // 3: 发送ajax请求
								    $.post("goods_deleteByIds.action",{ids:ids},function(result){
								    	if(result=="true"){
								    		// 取消选中所有行
								    		$("#dg").datagrid("uncheckAll");
								    		// 重新刷新当前页
								    		$('#dg').datagrid("reload");
								    	
								    	}else{
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
					text:"<input id='ss' name='search'/>",
				}],
			    
			    
			    // 配置dg的列字段 field：列字段名称与json的key捆绑 title：列标题   
			    columns:[[    
			        {field:'goodsName',title:'商品名称',width:100,
			        	// 用来格式化当前列的值，返回的是最终的数据
			        	formatter: function(value,row,index){
							return "<span title="+value+">"+value+"</span>";
						}
			        },    
			        {field:'releaseDate',title:'发布日期',width:100,
			        	// 用来格式化当前列的值，返回的是最终的数据
			        	formatter: function(value,row,index){
							return "<span title="+value+">"+value+"</span>";
						}
			        },    
			        {field:'count',title:'数量',width:100,
			        	// 用来格式化当前列的值，返回的是最终的数据
			        	formatter: function(value,row,index){
							return "<span title="+value+">"+value+"</span>";
						}
			        },    
			        {field:'price',title:'价格',width:100,
			        	// 用来格式化当前列的值，返回的是最终的数据
			        	formatter: function(value,row,index){
							return "<span title="+value+">"+value+"</span>";
						}
			        },    
			        {field:'hit',title:'点击量',width:100,
			        	// 用来格式化当前列的值，返回的是最终的数据
			        	formatter: function(value,row,index){
							return "<span title="+value+">"+value+"</span>";
						}
			        },    
			        {field:'usetime',title:'使用时间',width:100,
			        	// 用来格式化当前列的值，返回的是最终的数据
			        	formatter: function(value,row,index){
							return "<span title="+value+">"+value+"</span>";
						}
			        },    
			        {field:'address',title:'地址',width:100,
			        	// 用来格式化当前列的值，返回的是最终的数据
			        	formatter: function(value,row,index){
							return "<span title="+value+">"+value+"</span>";
						}
			        },    
			       /*  {field:'hot',title:'热点',width:100,align:'right',
			        	formatter: function(value,row,index){
			        		if(value){
			        			return "<input type='checkbox' checked='checked' disabled='true' />";
			        		}else{
			        			return "<input type='checkbox' disabled='true' />";
			        		}
						}
			        }, */
			        {field:'user.username',title:'所属用户',width:100,
			        	formatter: function(value,row,index){
			        		if(row.user!=null&&row.user.username!=null){
			        			return row.user.username;
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
					$('#dg').datagrid('load',{sid:0,goodsName:value});
				}, 
				prompt:'请输入商品名称...' 
			}); 
		});
	</script>
</head>
<body>
	<table id="dg"></table>
</body>
</html>
