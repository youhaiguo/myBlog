<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>添加留言</title>
</head>
<body>

<form action="/mo/Manage?op=addMessage" method="post">
	<br/>添加留言:<br/><br/><textarea name="content" rows="5" cols="60"></textarea><br><br>
	<input type="submit" value="提交">
</form><br/>
<a href="${pageContext.request.contextPath}/manage.jsp">返回首页</a>
</body>
</html>