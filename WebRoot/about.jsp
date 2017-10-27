<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="gb2312">
<title>小城青年</title>
<meta name="keywords" content="个人博客" />
<meta name="description" content="个人博客" />
<link href="css/base.css" rel="stylesheet">
<link href="css/about.css" rel="stylesheet">
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
				<span>技术宅 </span>
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
			<br /> <br /> <br />
			<div class="about left">
				<h2>about me</h2>
				<ul>
					<br />
					<font size="3">
						<div style="text-indent:4em">
							<p>
								<font size="3px">小城青年一枚，就读于广东某大学 
							</p>
							<div style="text-indent:4em">
								<p>关注后端、web</p>
								<div style="text-indent:4em">
									<p></p>
									<div style="text-indent:4em">
										<p>偶尔打打桌球、篮球</p>
										<div style="text-indent:4em">
											<p>如果你对我网站感兴趣，可以通过下面方式联系我</p>
											<div style="text-indent:4em">
												<p>Email : wenlongmo01@gmail.com</p>
												<div style="text-indent:4em">
													<p>
														CSDN :
														<a target="_blank" href="http://blog.csdn.net/weixin_38104426">
															<font color="#aa2116">http://blog.csdn.net/weixin_38104426</font>
															<a />
													</p>
													<div style="text-indent:4em">
														<p>
															GitHub :
															<a target="_blank" href="https://github.com/wenlongMo">
																<font color="#aa2116">https://github.com/wenlongMo</font>
															</a>
															&nbsp;(托管着我看书的大量笔记)
														</p>
					</font>
					<br />
				</ul>
				<h2>about website</h2>
				<br />
				<p>
				<div style="text-indent:4em">
					域 名：
					</p>
					<br />
					<p>服务器：</p>
					<br />
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
