<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${PATH }/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		//1、加载一级分类
		$.getJSON("${PATH}/js/json/class_1.js",function(data){
			$(data).each(function(i,json){
				$("#class_1_select").append("<option value="+json.id+">"+json.flmch1+"</option>");
			});
		});
		
	});
	
	//2、通过一级分类,去加载二级分类
	function get_class_2(class_1_id){
		$.getJSON("${PATH}/js/json/class_2_"+class_1_id+".js",function(data){
			//在添加之前清空所有
			$("#class_2_select").empty();			
			$(data).each(function(i,json){
				$("#class_2_select").append("<option value="+json.id+">"+json.flmch2+"</option>");
			});
		});
		
		get_tm(class_1_id);
	}
	
	//3、通过二级分类,去加载商品信息
	function get_tm(class_1_id){
		$.getJSON("${PATH}/js/json/tm_class_1_"+class_1_id+".js",function(data){
			//在添加之前清空所有
			$("#tm_select").empty();			
			$(data).each(function(i,json){
				$("#tm_select").append("<option value="+json.id+">"+json.ppmch+"</option>");
			});
		});
	}
	
	function goto_spu_add(){
		var class_1_id =  $("#class_1_select").val();
		var class_2_id = $("#class_2_select").val();
		var tm_id = $("#tm_select").val();
		
		window.location.href ="${PATH}/spu/goto_spu_add.do?flbh1="+class_1_id+"&flbh2="+class_2_id+"&pp_id="+tm_id;
	}
</script>
<title>硅谷商城</title>
</head>
<body>
	spu商品信息管理
	<hr/>
	一级:<select id="class_1_select" onchange="get_class_2(this.value)"><option>请选择</option></select >
	二级:<select id="class_2_select" ><option>请选择</option></select>
	品牌:<select id="tm_select"><option>请选择</option></select><br/>
	查询<br/>
	<a href="javascript:goto_spu_add();">添加</a><br/>
	删除<br/>
	编辑<br/>
</body>
</html>