<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="gb2312">
<title>小城青年</title>
<meta name="keywords" content="个人博客" />
<meta name="description" content="个人博客" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/mo/skin/2017/css/base.css" rel="stylesheet">
<link href="/mo/skin/2017/css/about.css" rel="stylesheet">
<link href="/mo/skin/2017/css/m.css" rel="stylesheet">
<!--[if lt IE 9]>
<script src="/skin/2017/js/modernizr.js"></script>
<![endif]-->
<script src="/mo/skin/2017/js/scrollReveal.js"></script>
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

			<div class="about left">

				<ul>
					<h4 class="atitle">
						<span>${article.year }-${article.month }-${article.day }</span>
						${article.title }
					</h4>
					<p class="newsnav">
						您现在的位置是:
						<a href="index.jsp">首页</a>
						&nbsp;>&nbsp;
						<a href="${pageContext.request.contextPath}/Client?op=article">技术宅</a>
						&nbsp;>&nbsp;
						<a href="${pageContext.request.contextPath}/Client?op=articleByCategory&categoryId=${category.id }&num=1">${category.name}
						</a>
					</p>
					<p>${article.content }</p>
					<div class="nextinfo">
						<p>
							上一篇：
							<a href="${pageContext.request.contextPath}/Client?op=articleById&articleId=${article.nextArticle.articleId}">
								<font color="yellow">${article.nextArticle.title }</font>
							</a>
						</p>
						<p>
							下一篇：
							<a href="${pageContext.request.contextPath}/Client?op=articleById&articleId=${article.preArticle.articleId}">
								<font color="yellow">${article.preArticle.title }</font>
							</a>
						</p>
					</div>
			</div>
		</div>
		</div>
		</aside>
	</article>
	<footer>
		design by wenLong
		<a href="#">粤</a>
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
	<script src="/e/public/onclick/?enews=donews&classid=38&id=787"></script>
</body>
</html>
