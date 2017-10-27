<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>删除分类</title>
</head>
<body>
	<c:forEach items="${categorysList}" var="a">
		<font color="blue">分类名称</font>:${a.name } <font color="blue">分类描述</font>:${a.description} 
		 <a style='text-decoration:none;' href="${pageContext.request.contextPath}/Manage?op=delCategorys&categoryId=${a.id}">
			<font color="red">删除</font>
		</a>
		<br />
	</c:forEach>
	<a href="${pageContext.request.contextPath}/manage.jsp">
		<br />
		返回首页
	</a>
</body>
</html>