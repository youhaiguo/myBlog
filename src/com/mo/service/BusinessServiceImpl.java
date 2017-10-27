package com.mo.service;

import java.util.Date;
import java.util.List;

import com.mo.dao.ArticleDailyDao;
import com.mo.dao.ArticleDao;
import com.mo.dao.CategorysDao;
import com.mo.dao.IpInfoDao;
import com.mo.dao.MassageDao;
import com.mo.dao.impl.ArticleDailyDaoImpl;
import com.mo.dao.impl.ArticleDaoImpl;
import com.mo.dao.impl.CategorysDaoImpl;
import com.mo.dao.impl.IpInfoDaoImpl;
import com.mo.dao.impl.MassageDaoImpl;
import com.mo.po.Article;
import com.mo.po.ArticleDaily;
import com.mo.po.Categorys;
import com.mo.po.IpInfo;
import com.mo.po.Message;

/**
 * 设计为单列模式
 * @author Admin
 *
 */
public class BusinessServiceImpl implements BusinessService {
	
	//饿汉式单例类.在类初始化时，已经自行实例化
	private BusinessServiceImpl() {}  
	private static final BusinessService s = new BusinessServiceImpl();  
	//静态工厂方法
	public static BusinessService getInstance() {  
		return s;  
	}  
	
	private ArticleDao articleDao = new ArticleDaoImpl();
	private CategorysDao categorysDao = new CategorysDaoImpl();
	private MassageDao massageDao = new MassageDaoImpl();
	private ArticleDailyDao articleDailyDao = new ArticleDailyDaoImpl();
	private IpInfoDao ipInfoDao = new IpInfoDaoImpl();
	
	public Article findArticleById(int id) {
		return articleDao.selectById(id);
	}
	
	public List<Article> findListArticleByIndex(int start, int end) {
		return articleDao.findByIndex(start,end);
	}

	public int findTotalCount() {
		return articleDao.findTotalCount();
	}

	public void addArticle(Article article) {
		article.setPubDate(new Date());
		articleDao.add(article);
	}

	public void addCategorys(Categorys categorys) {
		categorysDao.add(categorys);
	}

	public void delArticleById(int articleId) {
		articleDao.delById(articleId);
	}

	public List<Categorys> selectAllCategorys() {
		return categorysDao.selectAll();
	}

	public void delCategorysById(int categoryId) {
		categorysDao.delById(categoryId);
	}

	public Categorys selectCategoryById(int categoryId) {
		return categorysDao.selectById(categoryId);
	}

	public List<Article> selectArticleByCategoryId(Integer categoryId) {
		return articleDao.selectByCategoryId(categoryId);
	}

	public int findArticleTotalCountByCategory(int categoryId) {
		return articleDao.findTotalCountByCategory(categoryId);
	}

	public List<Article> selectArticleByIndexInCategory(int categoryId,int startIndex,
			int pageSize) {
		return articleDao.selectByIndexInCategory(categoryId,startIndex,pageSize);
	}

	public Article selectNextArticle(int articleId) {
		return articleDao.selectNext(articleId);
	}

	public Article selectPreArticle(int articleId) {
		return articleDao.selectPre(articleId);
	}

	public void insertMessage(Message message) {
		//添加时间
		message.setPubDate(new Date());
		massageDao.insert(message);
	}

	public int findMessageTotalCount() {
		return massageDao.findTotalCount();
	}

	public List<Message> selectMessageByIndex(int startIndex, int pageSize) {
		return massageDao.selectByIndex(startIndex,pageSize);
	}

	public void delMessageById(Integer messageId) {
		massageDao.delById(messageId);
	}

	public void addArticleDaily(ArticleDaily article) {
		//添加时间
		article.setPubDate(new Date());
		articleDailyDao.add(article);
	}

	public int findDailyTotalCount() {
		return articleDailyDao.findTotalCount();
	}

	public List<ArticleDaily> findListArticleDailyByIndex(int start, int size) {
		return articleDailyDao.findByIndex(start, size);
	}

	public void delArticleDailyById(int articleId) {
		articleDailyDao.delById(articleId);
	}

	public ArticleDaily selectDailyNextArticle(int articleId) {
		return articleDailyDao.selectNext(articleId);
	}

	public ArticleDaily selectDailyPreArticle(int articleId) {
		return articleDailyDao.selectPre(articleId);
	}

	public ArticleDaily findArticleDailyById(int id) {
		return articleDailyDao.selectById(id);
	}

	public IpInfo findIpInfoByIP(String ip) {
		return ipInfoDao.findByIp(ip);
	}

	public void addIpInfo(IpInfo ipInfo) {
		//添加时间
		ipInfo.setFirstTime(new Date());
		ipInfoDao.add(ipInfo);
	}

	public void updateIpInfo(IpInfo ipInfo) {
		//添加时间
		ipInfo.setLastTime(new Date());
		ipInfoDao.update(ipInfo);
	}

	public int findTotalIp() {
		return ipInfoDao.findTotalCount();
	}

	
}
