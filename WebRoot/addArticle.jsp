<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>添加文章</title>
</head>
<body>
<br/>
<form action="/mo/Manage?op=addArticle" method="post">
	标题:<input name="title" type="text"><br><br>
	内容:<textarea name="content" rows="5" cols="60"></textarea><br><br>
	类别:
	<c:forEach items="${categorysList}" var="c">	
	<input name="categoryId" type="radio" value="${c.id }">${c.name }&nbsp;
	</c:forEach>
	<br/><br/>
	<input type="submit" value="提交">
</form>
<br/>
<a href="${pageContext.request.contextPath}/manage.jsp">返回首页</a>
</body>
</html>