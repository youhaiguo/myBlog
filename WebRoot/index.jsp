<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="gb2312">
<title>小城青年</title>
<meta name="keywords" content="个人博客" />
<meta name="description" content="个人博客" />
<link href="css/base.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
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
			<a href="/mo/index.jsp">
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
			<div class="blog" data-scroll-reveal="enter top">
				<div>
					<p align="center">
						<font size="2">目前首页只有模板，更多功能正在开发中...</font>
					</p>
				</div>
				<br />
				<figure>
					<ul>
						<a href="#">
							<img src="daily/20171017135631.jpg">
						</a>
					</ul>
					<p>
						<a href="#">关于泛型擦除机制</a>
					</p>
					<figcaption>
						<div style="text-indent:2em">泛型是JDK 5引入的一个特性，它允许我们定义类和接口的时候使用参数类型，泛型在集合框架中被广泛使用。类型擦除是泛型中最让人困惑的部分...
					</figcaption>
				</figure>

				<figure>
					<ul>
						<a href="#">
							<img src="daily/1508220038(1).jpg">
						</a>
					</ul>
					<p>
						<a href="#">你真的理解Java的按引用传递吗？</a>
					</p>
					<figcaption>
						<div style="text-indent:2em">传引用到底是什么意思？学过C/C++的人理解起来可能会容易一点，在一个函数里面修改一个变量的值就要传递该变量的地址...
					</figcaption>
				</figure>

				<figure>
					<ul>
						<a href="#">
							<img src="daily/20171017122702.jpg">
						</a>
					</ul>
					<p>
						<a href="#">风景</a>
					</p>
					<figcaption>
						<div style="text-indent:2em">在浩大的宇宙里，每一寸空间都藏着风景，美，萦绕人间，用善于发现的眼光去关注生活，你会感叹人间何处无风景...
					</figcaption>
				</figure>


			</div>
			<ul class="cbp_tmtimeline">
				<li>
					<time class="cbp_tmtime">
						<span>08-08</span>
						<span>2017</span>
					</time>
					<div class="cbp_tmicon"></div>
					<div class="cbp_tmlabel" data-scroll-reveal="enter right over 1s">
						<h2>shiro缓存</h2>
						<p>
							<span class="blogpic">
								<a href="#">
									<img src="daily/22222222.png">
								</a>
							</span>
							shiro中提供了对认证信息和授权信息的缓存。shiro默认是关闭认证信息缓存的，对于授权信息的缓存shiro默认开启的。主要研究授权信息缓存，因为授权的数据量大...
						</p>
						<a href="#" class="readmore">阅读全文&gt;&gt;</a>
					</div>
				</li>
			</ul>
			<br />
			<br />
		</div>
	</article>
	<footer>
		Design By wenLong
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
</body>
</html>
