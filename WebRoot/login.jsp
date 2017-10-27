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
	</header>
	<article>
		<div class="container">
			<br />
			<div class="about left">
				<h2>后台登录</h2>
				<ul>
					<br />
					<br />

					<form action="${pageContext.request.contextPath}/ManageLogin?op=login" method="post">
						<div style="text-indent:4em">
							<font size="4">
								用户名:
								<input type="text" name="username">
								<br />
								<br />
								<div style="text-indent:4em">
									密码:
									<input type="password" name="password">
									<br />
									<br />
									<div style="text-indent:5em">
										<input type="submit" value="登录">
									</div>
								</div>
							</font>
					</form>
					<br />
					<div style="text-indent:6em">
						<a href="${pageContext.request.contextPath}"><<&nbsp;返回首页</a>
						<br />
						<br />
				</ul>
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
