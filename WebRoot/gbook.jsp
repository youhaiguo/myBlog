<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
				<b>留言板</b>
				<span>你，生命中最重要的过客，之所以是过客，因为你未曾为我停留。</span>
			</h2>
			<form action="/mo/Client?op=addMessageClient" method="post">
				<div class="gbook">
					<div style="text-indent:6em">
						<textarea onfocus="if(value=='请输入文字...'){value=''}" onblur="if (value ==''){value='请输入文字...'}"
							style="background:#DDDDDD" rows="6" cols="50" name="content">请输入文字...</textarea>
						&nbsp;&nbsp;
						<input type="submit" value="留言">
					</div>
			</form>
			<div class="gbook">

				<c:forEach items="${pageMessage.records }" var="c">
					<div class="about">
						<hr style="height:1px;border:none;border-top:1px solid #555555;" />
						<br />
						<br />
						<div style="text-indent:4em">
							<p align="justify">${c.contend }</p>
							<br />
							<p align="right">
								<font size="1">${c.userName}&nbsp;&nbsp;${c.year }-${c.month }-${c.day }</font>
							</p>
						</div>
					</div>
				</c:forEach>
				<hr style="height:1px;border:none;border-top:1px solid #555555;" />
			</div>

			<div class="page">
				<a href="${pageContext.request.contextPath}/Client?op=showMessage&pageNum=1">&lt;&lt; </a>
				<a href="${pageContext.request.contextPath}/Client?op=showMessage&pageNum=${pageMessage.prePageNum}">&lt; </a>
				<b>${pageMessage.pageNum }</b>
				<a href="${pageContext.request.contextPath}/Client?op=showMessage&pageNum=${pageMessage.nextPageNum}">&gt; </a>
				<a href="${pageContext.request.contextPath}/Client?op=showMessage&pageNum=${pageMessage.totalPageNum }">&gt;&gt;
				</a>
				共${pageMessage.totalPageNum }页
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
