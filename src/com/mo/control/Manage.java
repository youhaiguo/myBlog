package com.mo.control;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mo.po.Article;
import com.mo.po.ArticleDaily;
import com.mo.po.Categorys;
import com.mo.po.Message;
import com.mo.po.Page;
import com.mo.service.BusinessService;
import com.mo.service.BusinessServiceImpl;

public class Manage extends HttpServlet {
	
	private BusinessService s = BusinessServiceImpl.getInstance();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String op = req.getParameter("op");
		if("showArticle".equals(op)) {
			showArticle(req,resp);
		}else if("delArticle".equals(op)) {
			delArticle(req,resp);
		}else if("showAllCategorys".equals(op)) {
			showAllCategorys(req,resp);
		}else if("delCategorys".equals(op)) {
			delCategorysById(req,resp);
		}else if ("toAddArticle".equals(op)) {
			toAddArticle(req,resp);
		}else if ("delMessage".equals(op)) {
			delMessage(req,resp);
		}else if("delMessageById".equals(op)) {
			delMessageById(req,resp);
		}else if ("showArticleDaily".equals(op)) {
			showArticleDaily(req,resp);
		}else if("delArticleDaily".equals(op)) {
			delArticleDaily(req,resp);
		}else if("logoff".equals(op)) {
			logoff(req,resp);
		}
	}


	/**
	 * 退出登录
	 * @param req
	 * @param resp
	 */
	private void logoff(HttpServletRequest req, HttpServletResponse resp) {
		req.getSession().removeAttribute("isLogin");
		try {
			resp.sendRedirect("/mo/manage.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * 删除日常文章
	 * @param req
	 * @param resp
	 */
	private void delArticleDaily(HttpServletRequest req,
			HttpServletResponse resp) {
		String articleIdStr = req.getParameter("articleId");
		Integer articleId = Integer.valueOf(articleIdStr);
		s.delArticleDailyById(articleId);
		try {
			resp.sendRedirect(req.getContextPath().toString() + "/Manage?op=showArticleDaily&num=" + req.getParameter("num"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * 显示日常文章出来
	 * @param req
	 * @param resp
	 */
	private void showArticleDaily(HttpServletRequest req,
			HttpServletResponse resp) {
		String num = req.getParameter("num");
		int pageNum = Integer.valueOf(num);
		//构建page对象(需要总的条数，和每页显示的条数)
		int totalRecordsNum = s.findDailyTotalCount();
		Page<ArticleDaily> page = new Page<ArticleDaily>(pageNum, totalRecordsNum);
		List<ArticleDaily> list = s.findListArticleDailyByIndex(page.getStartIndex(),page.getPageSize());
		page.setRecords(list);
		req.setAttribute("page", page);
		try {
			req.getRequestDispatcher("/showArticleDaily.jsp").forward(req, resp);//转发
		} catch (Exception e) {
			System.err.println("Manage.showArticleDaily出错了");
		}
		
	}



	private void delMessageById(HttpServletRequest req, HttpServletResponse resp) {
		String messageIdStr = req.getParameter("messageId");
		Integer messageId = Integer.valueOf(messageIdStr);
		String pageNumStr = req.getParameter("pageNum");
		Integer pageNum = Integer.valueOf(pageNumStr);
		s.delMessageById(messageId);
		try {
			resp.sendRedirect(req.getContextPath().toString() + "/Manage?op=delMessage&pageNum=" + pageNum);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 后台管理，用于转发显示要删除的留言
	 * @param req
	 * @param resp
	 */
	private void delMessage(HttpServletRequest req, HttpServletResponse resp) {
		String numStr = req.getParameter("pageNum");
		Integer pageNum = Integer.valueOf(numStr);
		
		//计算总的留言数，构建page对象
		int totalCount = s.findMessageTotalCount();
		Page page = new Page(pageNum,totalCount);
		List<Message> records = s.selectMessageByIndex(page.getStartIndex(), page.getPageSize());
		page.setRecords(records);
		
		req.setAttribute("page", page);
		
		try {
			req.getRequestDispatcher("/delMessage.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 去到添加文章的页面
	 * @param req
	 * @param resp
	 */
	private void toAddArticle(HttpServletRequest req, HttpServletResponse resp) {
		List<Categorys> categorysList = s.selectAllCategorys();
		req.setAttribute("categorysList",categorysList);
		try {
			req.getRequestDispatcher("/addArticle.jsp").forward(req,resp);
		} catch (Exception e) {
			System.err.println("Manage.toAddArticlech出错了");
		}
	}

	/**
	 * 根据分类的id号将其分类删除
	 * @param req
	 * @param resp
	 */
	private void delCategorysById(HttpServletRequest req,
			HttpServletResponse resp) {
		String str = req.getParameter("categoryId");
		int categoryId = Integer.valueOf(str);
		s.delCategorysById(categoryId);
		try {
			resp.sendRedirect(req.getContextPath().toString() + "/Manage?op=showAllCategorys");
		} catch (IOException e) {
			System.err.println("Manage.delCategorysById出错了");
			e.printStackTrace();
		}
	}

	
	
	
	/**
	 * 显示所有的分类
	 * @param req
	 * @param resp
	 */
	private void showAllCategorys(HttpServletRequest req,
			HttpServletResponse resp) {
		List<Categorys> categorysList = s.selectAllCategorys();
		req.setAttribute("categorysList", categorysList);
		try {
			req.getRequestDispatcher("/showCategorys.jsp").forward(req, resp);//转发
		} catch (Exception e) {
			System.err.println("Manage.showAllCategorys出错了");
		}
	}

	/**
	 * 根据文章的id删除文章
	 * @param req
	 * @param resp
	 */
	private void delArticle(HttpServletRequest req, HttpServletResponse resp) {
		String articleIdStr = req.getParameter("articleId");
		Integer articleId = Integer.valueOf(articleIdStr);
		s.delArticleById(articleId);
		try {
			resp.sendRedirect(req.getContextPath().toString() + "/Manage?op=showArticle&num=" + req.getParameter("num"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 把文章信息显示出后台
	 * @param req
	 * @param resp
	 */
	private void showArticle(HttpServletRequest req, HttpServletResponse resp) {
		String num = req.getParameter("num");
		int pageNum = Integer.valueOf(num);
		//构建page对象(需要总的条数，和每页显示的条数)
		int totalRecordsNum = s.findTotalCount();
		Page<Article> page = new Page<Article>(pageNum, totalRecordsNum);
		List<Article> list = s.findListArticleByIndex(page.getStartIndex(),page.getPageSize());
		page.setRecords(list);
		req.setAttribute("page", page);
		try {
			req.getRequestDispatcher("/showArticle.jsp").forward(req, resp);//转发
		} catch (Exception e) {
			System.err.println("Manage.showArticle出错了");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String op = req.getParameter("op");
		if ("addArticle".equals(op)) {
			addArticle(req, resp);
		}else if ("addCategory".equals(op)) {
			addCategory(req, resp);
		}else if("addMessage".equals(op)) {
			addMessage(req, resp);
		}else if("login".equals(op)) {
			login(req, resp);
		}else if("addArticleDaily".equals(op)) {
			addArticleDaily(req,resp);
		}
	}


	/**
	 * 添加日常的文章
	 * @param req
	 * @param resp
	 */
	private void addArticleDaily(HttpServletRequest req,
			HttpServletResponse resp) {
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		content = content.replaceAll("　","&nbsp;&nbsp;").replaceAll("\r","<br/>").replaceAll("\n","<br/>");
		ArticleDaily article = new ArticleDaily();
		article.setTitle(title);
		article.setContent(content);
		//还有日期和用户的id在业务层处理
		s.addArticleDaily(article);
		try {
			resp.sendRedirect("/mo/manage.jsp");//重定向
		} catch (Exception e) {
			System.err.println("Manage.addArticleDaily出错了");
		}
	}



	/**
	 * 登录操作
	 * @param req
	 * @param resp
	 */
	private void login(HttpServletRequest req, HttpServletResponse resp) {
		//验证账户密码
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if("manage".equals(username) && "123".equals(password)) {
			HttpSession session = req.getSession();
			try {
				
				session.setAttribute("isLogin", "true");
				resp.sendRedirect("/mo/manage.jsp");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			try {
				resp.sendRedirect("/mo/login.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 添加一条留言
	 * @param req
	 * @param resp
	 */
	private void addMessage(HttpServletRequest req, HttpServletResponse resp) {
		String content = req.getParameter("content");
		Message message = new Message("站主",content);
		//添加时间在业务层处理
		s.insertMessage(message);
		try {
			resp.sendRedirect("/mo/manage.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 添加一个分类信息
	 * @param req
	 * @param resp
	 */
	private void addCategory(HttpServletRequest req, HttpServletResponse resp) {
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		Categorys c = new Categorys();
		c.setName(name);
		c.setDescription(description);
		s.addCategorys(c);
		try {
			resp.sendRedirect("/mo/manage.jsp");
		} catch (Exception e) {
			System.err.println("Manage.addCategory出错了");
		}	
	}

	/**
	 * 添加一个文章
	 * @param req
	 * @param resp
	 */
	private void addArticle(HttpServletRequest req, HttpServletResponse resp) {
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String categoryIdStr = req.getParameter("categoryId");
		int categoryId = Integer.valueOf(categoryIdStr);
		content = content.replaceAll("　","&nbsp;&nbsp;").replaceAll("\r","<br/>").replaceAll("\n","<br/>");
		Article article = new Article();
		article.setTitle(title);
		article.setContent(content);
		article.setCategoryId(categoryId);
		//还有日期和用户的id在业务层处理
		s.addArticle(article);
		try {
			resp.sendRedirect("/mo/manage.jsp");//重定向
		} catch (Exception e) {
			System.err.println("Manage.addArticle出错了");
		}	
	}
	
}
