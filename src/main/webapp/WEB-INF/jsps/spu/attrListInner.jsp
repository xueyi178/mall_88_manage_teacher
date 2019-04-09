<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>硅谷商城</title>
</head>
<body>
	属性列表的内嵌页<br/>
	<c:forEach items="${list_attr}" var="attr">
		 ${attr.shxm_mch}
		<c:forEach items="${attr.list_value}" var="val">
			${val.shxzh }${val.shxzh_mch}
		</c:forEach>		
	</c:forEach>
</body>
</html>