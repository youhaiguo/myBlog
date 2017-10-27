<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>删除留言</title>
</head>
<body>
	<c:forEach items="${page.records}" var="a">
		<font color="blue">内容:</font>${fn:substring(a.contend, 0, 22)}  发表时间:${a.year}-${a.month}-${a.day} 
		<a style='text-decoration:none;'
			href="${pageContext.request.contextPath}/Manage?op=delMessageById&pageNum=${page.pageNum}&messageId=${a.messageId}">
			<font color="red">删除</font>
		</a>
		<br />
	</c:forEach>
	<br/>第${page.pageNum }页
	<a
		href="${pageContext.request.contextPath}/Manage?op=delMessage&pageNum=${page.prePageNum}">上一页</a>
	<a
		href="${pageContext.request.contextPath}/Manage?op=delMessage&pageNum=${page.nextPageNum}">下一页</a>
	总${page.totalPageNum}页
	<a href="${pageContext.request.contextPath}/manage.jsp"><br /> <br />返回首页</a>
</body>
</html>