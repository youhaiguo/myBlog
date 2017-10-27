package com.mo.service;

import java.util.List;

import com.mo.po.Article;
import com.mo.po.ArticleDaily;
import com.mo.po.Categorys;
import com.mo.po.IpInfo;
import com.mo.po.Message;

public interface BusinessService {
	
	/**
	 * 把文章的内容显示出来
	 * @return 文章的list数据
	 */
	Article findArticleById(int id);
	
	/**
	 * 把文章的内容显示出来
	 * @return 文章的list数据
	 */
	ArticleDaily findArticleDailyById(int id);

	/**
	 * @param start 开始的索引
	 * @param end 结束的索引
	 * @return 查询出文章的list
	 */
	List<Article> findListArticleByIndex(int start,int size);
	
	/**
	 * @param start 开始的索引
	 * @param end 结束的索引
	 * @return 查询出文章的list
	 */
	List<ArticleDaily> findListArticleDailyByIndex(int start,int size);
	
	
	
	/**
	 * 查询文章的总条数
	 * @return 文章的总条数
	 */
	int findTotalCount();

	/**
	 * 查询日常文章的总条数
	 * @return 文章的总条数
	 */
	int findDailyTotalCount();

	
	/**
	 * 添加一篇文章
	 * @param article 
	 */
	void addArticle(Article article);

	/**
	 * 添加一个分类
	 * @param c
	 */
	void addCategorys(Categorys c);

	/**
	 * 根据文章的ID删除文章
	 * @param articleId
	 */
	void delArticleById(int articleId);

	/**
	 * 根据文章的ID删除文章
	 * @param articleId
	 */
	void delArticleDailyById(int articleId);
	
	/**
	 * 查询所有分类
	 * @return 分类的list
	 */
	List<Categorys> selectAllCategorys();

	/**
	 * 根据id删除分类
	 * @param categoryId 
	 */
	void delCategorysById(int categoryId);

	/**
	 * 根据分类的id将分类查询出来
	 * @param categoryId 
	 */
	Categorys selectCategoryById(int categoryId);

	/**
	 * 根据分类信息将文章程序出来
	 * @param categoryId
	 */
	List<Article> selectArticleByCategoryId(Integer categoryId);

	/**
	 * 查询该分类有文章记录
	 * @return
	 */
	int findArticleTotalCountByCategory(int categoryId);

	/**
	 * 根据分类信息将文章程序出来(用于分页)
	 * @param startIndex 开始的地方
	 * @param pageSize 截取几个
	 * @return
	 */
	List<Article> selectArticleByIndexInCategory(int categoryId,int startIndex, int pageSize);

	/**
	 * 根据文章的id查询数据中的下一篇文章(用于显示上一篇和下一篇)
	 * @param articleId
	 * @return
	 */
	Article selectNextArticle(int articleId);

	/**
	 * 根据文章的id查询数据中的下一篇文章(用于显示上一篇和下一篇)。用于日常类型
	 * @param articleId
	 * @return
	 */
	ArticleDaily selectDailyNextArticle(int articleId);
	
	/**
	 * 根据文章的id查询数据中的上一篇文章(用于显示上一篇和下一篇)
	 * @param articleId
	 * @return
	 */
	Article selectPreArticle(int articleId);

	/**
	 * 根据文章的id查询数据中的上一篇文章(用于显示上一篇和下一篇)。用于日常类型
	 * @param articleId
	 * @return
	 */
	ArticleDaily selectDailyPreArticle(int articleId);

	
	/**
	 * 添加一条留言,业务层已经做添加了日期了
	 */
	void insertMessage(Message message);

	/**
	 * 查询留言总条数
	 * @return
	 */
	int findMessageTotalCount();

	/**
	 * 根据开始索引和size查询留言(用于分页)
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	List<Message> selectMessageByIndex(int startIndex, int pageSize);

	/**
	 * 根据留言的id号删除留言
	 * @param messageId
	 */
	void delMessageById(Integer messageId);

	/**
	 * 添加日常文章
	 * @param article
	 */
	void addArticleDaily(ArticleDaily article);

	/**
	 * 根据ip查找一个ip
	 * @param ip
	 * @return
	 */
	IpInfo findIpInfoByIP(String ip);

	/**
	 * 新增一条ip信息
	 * @param ipInfo
	 */
	void addIpInfo(IpInfo ipInfo);

	/**
	 * 更新一个IP信息，只要是更新最后一个访问时间 和 点击次数
	 * @param ipInfo
	 */
	void updateIpInfo(IpInfo ipInfo);

	/**
	 * ip库有多少ip
	 * @return
	 */
	int findTotalIp();

	
	
}
