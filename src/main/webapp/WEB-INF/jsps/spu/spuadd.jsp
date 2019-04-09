<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${PATH }/js/jquery-1.7.2.min.js"></script>
<title>硅谷商城</title>
<script type="text/javascript">
	function click_image(index){
		//file对象比较特殊
		$("#file_"+index).click();
	}
	
	//用图片替换成按钮
	function replace_image(index){
		//获取图片对象
		var blob_image = $("#file_"+index)[0].files[0];
		var url = window.URL.createObjectURL(blob_image);
		//替换image按钮
		$("#image_"+index).attr("src",url);
		
		var length = $(":file").length;
		
		if((index+1) == length){
			//追加图片
			add_image(index);
		}
	}
	
	//追加图片
	function add_image(index){
		var a = '<div id="d_'+(index+1)+'" style="float:left;margin-left:10px;border:1px red solid;">';
		var b = '<input id="file_'+(index+1)+'" type="file" name="files" style="display:none;" onChange="replace_image('+(index+1)+')"/><br/>';
		var c = '<img id="image_'+(index+1)+'" onclick="click_image('+(index+1)+')" style="cursor:pointer;" src="${PATH }/image/upload_hover.png" width="100px" height="100px"></img>';
		var d = '</div>';
		$("#d_"+index).after(a+b+c+d);
	}
</script>
</head>
<body>
	商品信息管理
	<form action="${PATH }/spu/spu_add.do" enctype="multipart/form-data" method="post">
		<input type="hidden" name="flbh1" value="${spu.flbh1 }"> 
		<input type="hidden" name="flbh2" value="${spu.flbh2 }"> 
		<input type="hidden" name="pp_id" value="${spu.pp_id }"> 
		商品名称:<input  type="text" name="shp_mch"/><br/>
		商品描述:<textarea  rows="10" cols="40" name="shp_msh"></textarea><br/>
		商品图片:<br/>
		<div id="d_0" style="float:left;margin-left:10px;border:1px red solid;">
				<input id="file_0" type="file" name="files" style="display:none;" onChange="replace_image(0)"/><br/>
				<img id="image_0" onclick="click_image(0)" style="cursor:pointer;" src="${PATH }/image/upload_hover.png" width="100px" height="100px"></img>
		</div>
			<input type="submit" value="提交">
	</form>
</body>
</html>