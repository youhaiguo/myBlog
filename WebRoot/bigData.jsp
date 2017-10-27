<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="gb2312">
<title>小城青年</title>
<meta name="keywords" content="个人博客" />
<meta name="description" content="个人博客" />
<link href="css/base.css" rel="stylesheet">
<link href="css/book.css" rel="stylesheet">
<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
<script src="js/scrollReveal.js"></script>
</head>
<body>
	<header>
		<div class="logo" data-scroll-reveal="enter right over 1s">
			<a href="#">
				<font size="6.5">小城青年</font>
			</a>
		</div>
		<nav class="topnav" data-scroll-reveal="enter bottom over 1s after 1s">
			<a href="index.jsp">
				<span>首页</span>
				<span class="en">Home</span>
			</a>
			<a href="about.jsp">
				<span>关于我</span>
				<span class="en">About</span>
			</a>
			<a href="${pageContext.request.contextPath}/Client?op=article">
				<span>技术宅</span>
				<span class="en">Technology</span>
			</a>
			<a href="${pageContext.request.contextPath}/Client?op=articleDaily">
				<span>扯日常</span>
				<span class="en">Life</span>
			</a>
			<a href="${pageContext.request.contextPath}/Client?op=showMessage&pageNum=1">
				<span>留言板</span>
				<span class="en">Saying</span>
			</a>
			<a href="bigData.jsp">
				<span>网站大数据</span>
				<span class="en">BigData</span>
			</a>
		</nav>
	</header>
	<article>
		<div class="container">
			<h2 class="ctitle">
				<b>网站大数据</b>
				<span>
					welcome, come from ${ipInfo}
					<br />
					${lastVisitTime }
				</span>
			</h2>
			<div class="gbook">

				<div class="about">
					<div style="text-indent:4em">
						<font size="3">本站点击量:&nbsp;${totalVisit}</font>
					</div>
					<br />
					<div style="text-indent:4em">
						<font face="微软雅黑" size="3">本站的访客数:&nbsp;${applicationTotal }</font>
					</div>
					<br />
					<div style="text-indent:4em">
						<font size="3">更多功能，v2.0 Loading...</font>
					</div>
				</div>
			</div>

		</div>
		</aside>
	</article>
	<footer>
		Design By wenLong
		<a href="/">粤</a>
		<a href="${pageContext.request.contextPath}/login.jsp">管理员登录</a>
	</footer>
	<script>
		if (!(/msie [6|7|8|9]/i.test(navigator.userAgent))) {
			(function() {
				window.scrollReveal = new scrollReveal({
					reset : true
				});
			})();
		};
	</script>
</body>
</html>
