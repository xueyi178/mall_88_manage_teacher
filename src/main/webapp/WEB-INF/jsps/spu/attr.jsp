<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${PATH }/js/jquery-1.7.2.min.js"></script>
<title>硅谷商城</title>
<script type="text/javascript">
$(function(){
	//1、加载一级分类
	$.getJSON("${PATH}/js/json/class_1.js",function(data){
		$(data).each(function(i,json){
			$("#attr_class_1_select").append("<option value="+json.id+">"+json.flmch1+"</option>");
		});
	});
	
});

//2、通过一级分类,去加载二级分类
function get_attr_class_2(class_1_id){
	$.getJSON("${PATH}/js/json/class_2_"+class_1_id+".js",function(data){
		//在添加之前清空所有
		$("#attr_class_2_select").empty();			
		$(data).each(function(i,json){
			$("#attr_class_2_select").append("<option value="+json.id+">"+json.flmch2+"</option>");
		});
	});
}

//添加商品属性
function goto_attr_add(){
	var class_2_id = $("#attr_class_2_select").val();
	window.location.href ="${PATH}/attr/goto_attr_add.do?flbh2="+class_2_id;
}

//异步查询显示商品属性数据
function get_attr_list(flbh2){
	alert(flbh2)
	$.ajax({
		type:"POST",
		url:"${PATH}/attr/get_attr_list.do",
		data:{"flbh2":flbh2},	
		success:function(data){
			//异步查询
			$("#attrListInner").html(data);
		}
	});
	
}
</script>
</head>
<body>
	spu商品属性信息管理
	<hr/>
	一级:<select id="attr_class_1_select" onchange="get_attr_class_2(this.value)"><option>请选择</option></select >
	二级:<select id="attr_class_2_select" onchange="get_attr_list(this.value)"><option>请选择</option></select>
	查询<br/>
	<a href="javascript:goto_attr_add();">添加</a><br/>
	删除<br/>
	编辑<br/>
	<hr/>
	<div id="attrListInner"></div>
</body>
</html>