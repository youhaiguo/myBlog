package com.mo.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mo.po.Article;
import com.mo.po.ArticleDaily;
import com.mo.po.Categorys;
import com.mo.po.Message;
import com.mo.po.Page;
import com.mo.service.BusinessService;
import com.mo.service.BusinessServiceImpl;

public class Client extends HttpServlet {
	
	private BusinessService s = BusinessServiceImpl.getInstance();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String op = req.getParameter("op");
		if ("article".equals(op)) {
			showArticle(req,resp);
		}else if ("articleById".equals(op)) {
			showArticleById(req,resp);
		}else if ("articleByCategory".equals(op)) {
			articleByCategory(req,resp);
		}else if ("showMessage".equals(op)) {
			showMessage(req,resp);
		}else if ("articleDaily".equals(op)) {
			showArticleDaily(req,resp);
		}else if("articleDailyById".equals(op)) {
			showArticleDailyById(req,resp);
		}
		
	}

	/**
	 * 根据id查询出日常文章
	 * @param req
	 * @param resp
	 */
	private void showArticleDailyById(HttpServletRequest req,
			HttpServletResponse resp) {
		String articleId = req.getParameter("articleId");
		Integer id = Integer.valueOf(articleId);
		ArticleDaily article = s.findArticleDailyById(id);
		
		//将下一篇显示出来
		ArticleDaily nextArticle = s.selectDailyNextArticle(article.getArticleId());
		ArticleDaily preArticle = s.selectDailyPreArticle(article.getArticleId());
		
		article.setNextArticle(nextArticle);
		article.setPreArticle(preArticle);
		
		//将数据保存在request中，这样就可以同时打开很多文章，打开的时候就不会从session中获取最新的数据了。不要保存在session，会被覆盖
		req.setAttribute("article", article);
		try {
			req.getRequestDispatcher("/articleDaily.jsp").forward(req,resp);
		} catch (Exception e) {
			System.out.println("Client.showArticleById()出错");
		}		
	}

	/**
	 * 把扯日常的文章加载出来
	 * @param req
	 * @param resp
	 */
	private void showArticleDaily(HttpServletRequest req, HttpServletResponse resp) {
		//当前的页数
		String pageNum = req.getParameter("num");
		int pageNumInt;
		//如果是第一次访问
		if (pageNum == null) {
			pageNumInt = 1;
		}else {
			pageNumInt = Integer.valueOf(pageNum);
		}
		//查询总页数
		int totalCount = s.findDailyTotalCount();
		//构造Page对象
		Page<ArticleDaily> articlePage = new Page<ArticleDaily>(pageNumInt, totalCount);
		articlePage.setUrl("articleDaily");
		//把该页的数据查询出来
		List<ArticleDaily> records = s.findListArticleDailyByIndex(articlePage.getStartIndex(),articlePage.getPageSize());
		articlePage.setRecords(records);
		req.setAttribute("articlePage", articlePage);
		try {
			req.getRequestDispatcher("/manshenghuo.jsp").forward(req,resp);
		} catch (Exception e) {
			System.err.println("Client.showArticleDaily()出错");
		}

	}

	//第一次访问留言板，显示留言信息出来
	private void showMessage(HttpServletRequest req, HttpServletResponse resp) {
		String pageNumStr = req.getParameter("pageNum");
		Integer pageNum = Integer.valueOf(pageNumStr);
		
		//查询留言总条数
		int messageTotalCount = s.findMessageTotalCount();
		Page pageMessage = new Page(pageNum,messageTotalCount);
		
		List<Message> records = s.selectMessageByIndex(pageMessage.getStartIndex(),pageMessage.getPageSize());
		pageMessage.setRecords(records);
		
		req.setAttribute("pageMessage", pageMessage);
		try {
			req.getRequestDispatcher("/gbook.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}



	//根据分类查询文章列表 出来 (用于分页)
	private void articleByCategory(HttpServletRequest req,
			HttpServletResponse resp) {
		String categoryIdStr = req.getParameter("categoryId");
		Integer categoryId = Integer.valueOf(categoryIdStr);
		int totalTotal = s.findArticleTotalCountByCategory(categoryId);
		String pageNumStr = req.getParameter("num");
		Integer pageNum = Integer.valueOf(pageNumStr);
		
		//封装page对象
		Page articlePage = new Page(pageNum,totalTotal);
		articlePage.setCategoryId(categoryId);
		List<Article> records = s.selectArticleByIndexInCategory(articlePage.getCategoryId(),articlePage.getStartIndex(),articlePage.getPageSize());
		articlePage.setRecords(records);
		articlePage.setUrl("articleByCategory");
		
		//把当前分类信息查询出来
		Categorys category = s.selectCategoryById(categoryId);
		req.setAttribute("category", category);
		
		//将全部分类信息查询出来
		List<Categorys> categorysList = s.selectAllCategorys();
		req.setAttribute("categorysList",categorysList);
		
		req.setAttribute("articlePage", articlePage);
		
		try {
			req.getRequestDispatcher("/learn.jsp").forward(req,resp);
		} catch (Exception e) {
			System.err.println("Client.showArticle()出错");
		}
	}

	//根据文章的ID将文章信息查询出来,同时将上一篇和下一篇的标题查询出来
	private void showArticleById(HttpServletRequest req,
			HttpServletResponse resp) {
		String articleId = req.getParameter("articleId");
		Integer id = Integer.valueOf(articleId);
		Article article = s.findArticleById(id);
		
		//将下一篇显示出来
		Article nextArticle = s.selectNextArticle(article.getArticleId());
		Article preArticle = s.selectPreArticle(article.getArticleId());
		
		article.setNextArticle(nextArticle);
		article.setPreArticle(preArticle);
		
		//将类型信息查询出来
		int categoryId = article.getCategoryId();
		Categorys category = s.selectCategoryById(categoryId);
		req.setAttribute("category", category);
		
		//将数据保存在request中，这样就可以同时打开很多文章，打开的时候就不会从session中获取最新的数据了
		req.setAttribute("article", article);
		try {
			req.getRequestDispatcher("/article.jsp").forward(req,resp);
		} catch (Exception e) {
			System.out.println("Client.showArticleById()出错");
		}
	}

	//处理文章:把文章列表加载出来
	private void showArticle(HttpServletRequest req, HttpServletResponse resp) {
		
		//将分类信息查询出来
		List<Categorys> categorysList = s.selectAllCategorys();
		req.setAttribute("categorysList",categorysList);
		
		//把模块信息显示出来
		Categorys category = new Categorys();
		category.setName("技术宅");
		req.setAttribute("category", category);
		
		//当前的页数
		String pageNum = req.getParameter("num");
		int pageNumInt;
		//如果是第一次访问
		if (pageNum == null) {
			pageNumInt = 1;
		}else {
			pageNumInt = Integer.valueOf(pageNum);
		}
		//查询总页数
		int totalCount = s.findTotalCount();
		//构造Page对象
		Page<Article> articlePage = new Page<Article>(pageNumInt, totalCount);
		articlePage.setUrl("article");
		//把该页的数据查询出来
		List<Article> records = s.findListArticleByIndex(articlePage.getStartIndex(),articlePage.getPageSize());
		articlePage.setRecords(records);
		req.setAttribute("articlePage", articlePage);
		try {
			req.getRequestDispatcher("/learn.jsp").forward(req,resp);
		} catch (Exception e) {
			System.err.println("Client.showArticle()出错");
		}
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		//统计网站的访问量
		ServletContext context = getServletContext();
		Integer totalVisit = null;
		synchronized(context) {
			totalVisit = (Integer)context.getAttribute("totalVisit");
			//如果还没有人访问就没有这个内容，要新建一个
			if(totalVisit == null) {
				totalVisit = 1;
				context.setAttribute("totalVisit", totalVisit);
			}
			totalVisit = totalVisit + 1;
			context.setAttribute("totalVisit", totalVisit);
		}
		
		String op = req.getParameter("op");
		if("addMessageClient".equals(op)) {
			addMessageClient(req,resp);
		}
	}

	//客户端添加一条留言
	private void addMessageClient(HttpServletRequest req,
			HttpServletResponse resp) {
		String content = req.getParameter("content");
		
		//获取用户的id将其地址查询出来
//		String ip = req.getLocalAddr();
//		String address = IpAddress.changeIpToAddressOnlyProAndCity(ip);
		Message message = new Message("游客:来自 广东 珠海",content);
		s.insertMessage(message);
		try {
			resp.sendRedirect(req.getContextPath().toString() + "/Client?op=showMessage&pageNum=1");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
