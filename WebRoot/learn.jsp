<%@ page language="java" import="com.mo.po.Article,java.util.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype html>
<html>
<head>
<meta charset="gb2312">
<title>小城青年</title>
<meta name="keywords" content="个人博客" />
<meta name="description" content="个人博客" />
<link href="css/base.css" rel="stylesheet">
<link href="css/learn.css" rel="stylesheet">
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
				<b>${category.name }</b>
				<span>不要轻易放弃。学习成长的路上，我们长路漫漫，只因学无止境。</span>
			</h2>
			<div class="rnav">
				<ul>
					<c:forEach items="${categorysList }" var="c">
						<li>
							<a href="${pageContext.request.contextPath}/Client?op=articleByCategory&categoryId=${c.id}&num=1">${c.name }</a>
						</li>
					</c:forEach>
				</ul>
			</div>
			<ul class="cbp_tmtimeline">
				<c:forEach items="${articlePage.records}" var="a">
					<li>
						<time class="cbp_tmtime">
							<span>${a.month }-${a.day }</span>
							<span>${a.year}</span>
						</time>
						<div class="cbp_tmicon"></div>
						<div class="cbp_tmlabel" data-scroll-reveal="enter right over 1s">
							<h2>${a.title}</h2>
							<p>
								<!-- <span class="blogpic"><a href="/"><img src="images/t03.jpg"></a></span> -->
								${fn:substring(a.content, 0, 50)}...
							</p>
							<a href="${pageContext.request.contextPath}/Client?op=articleById&articleId=${a.articleId}" class="readmore">阅读全文&gt;&gt;</a>
						</div>
					</li>
				</c:forEach>
			</ul>
			<div class="page">
				<a
					href="${pageContext.request.contextPath}/Client?op=${articlePage.url }&categoryId=${articlePage.categoryId }&num=1">&lt;&lt;
				</a>
				<a
					href="${pageContext.request.contextPath}/Client?op=${articlePage.url }&categoryId=${articlePage.categoryId }&num=${articlePage.prePageNum }">&lt;
				</a>
				<b>${articlePage.pageNum }</b>
				<a
					href="${pageContext.request.contextPath}/Client?op=${articlePage.url }&categoryId=${articlePage.categoryId }&num=${articlePage.nextPageNum }">&gt;
				</a>
				<a
					href="${pageContext.request.contextPath}/Client?op=${articlePage.url }&categoryId=${articlePage.categoryId }&num=${articlePage.totalPageNum }">&gt;&gt;
				</a>
				共${articlePage.totalPageNum }页
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
