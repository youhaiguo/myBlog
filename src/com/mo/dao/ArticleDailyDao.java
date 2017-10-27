package com.mo.dao;

import java.util.List;

import com.mo.po.ArticleDaily;

public interface ArticleDailyDao {

	/**
	 * @param id 文章的id
	 * @return 返回一个文章
	 */
	ArticleDaily selectById(int id);

	/**
	 * 
	 * @param start 开始的索引
	 * @param end 结束索引
	 * @return 查询到的文章封装为List
	 */
	List<ArticleDaily> findByIndex(int start, int size);

	/**
	 * 查询文章的总条数
	 * @return 文章的条数
	 */
	int findTotalCount();

	/**
	 * 添加文章
	 * @param article 
	 */
	void add(ArticleDaily article);

	/**
	 * 根据文章的id删除文章
	 * @param articleId
	 */
	void delById(int articleId);

	/**
	 * 根据文章的id查询数据中的下一篇文章(用于显示上一篇和下一篇)
	 * @param articleId
	 * @return
	 */
	ArticleDaily selectNext(int articleId);

	/**
	 * 根据文章的id查询数据中的上一篇文章(用于显示上一篇和下一篇)
	 * @param articleId
	 * @return
	 */
	ArticleDaily selectPre(int articleId);

}
