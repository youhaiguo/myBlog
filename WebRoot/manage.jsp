<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>后台管理</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/Manage?op=toAddArticle">添加文章</a>
	<a href="${pageContext.request.contextPath}/Manage?op=showArticle&num=1">删除文章</a>
	<a href="${pageContext.request.contextPath}/addCategory.jsp">添加分类</a>
	<a href="${pageContext.request.contextPath}/Manage?op=showAllCategorys">删除分类</a>
	<a href="${pageContext.request.contextPath}/addMessages.jsp">添加留言</a>
	<a href="${pageContext.request.contextPath}/Manage?op=delMessage&pageNum=1">删除留言</a>
	<a href="${pageContext.request.contextPath}/addArticleDaily.jsp">添加日常文章</a>
	<a href="${pageContext.request.contextPath}/Manage?op=showArticleDaily&num=1">删除日常文章</a>
	<a href="${pageContext.request.contextPath}/Manage?op=logoff">注销</a>
</body>
</html>