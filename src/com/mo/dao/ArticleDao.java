package com.mo.dao;

import java.util.List;

import com.mo.po.Article;

public interface ArticleDao {

	/**
	 * @param id 文章的id
	 * @return 返回一个文章
	 */
	Article selectById(int id);

	/**
	 * 
	 * @param start 开始的索引
	 * @param end 结束索引
	 * @return 查询到的文章封装为List
	 */
	List<Article> findByIndex(int start, int size);

	/**
	 * 查询文章的总条数
	 * @return 文章的条数
	 */
	int findTotalCount();

	/**
	 * 添加文章
	 * @param article 
	 */
	void add(Article article);

	/**
	 * 根据文章的id删除文章
	 * @param articleId
	 */
	void delById(int articleId);

	/**
	 * 根据分类信息将文章查询出来
	 * @param categoryId
	 * @return
	 */
	List<Article> selectByCategoryId(Integer categoryId);

	/**
	 * 查询该分类有文章记录
	 * @return 总条数
	 */
	int findTotalCountByCategory(int categoryId);
	
	/**
	 * 根据分类信息将文章程序出来(用于分页)
	 * @param startIndex 
	 * @param pageSize
	 * @return
	 */
	List<Article> selectByIndexInCategory(int categoryId,int startIndex, int pageSize);

	/**
	 * 根据文章的id查询数据中的下一篇文章(用于显示上一篇和下一篇)
	 * @param articleId
	 * @return
	 */
	Article selectNext(int articleId);

	/**
	 * 根据文章的id查询数据中的下一篇文章(用于显示上一篇和下一篇)
	 * @param articleId
	 * @return
	 */
	Article selectPre(int articleId);
	
}
