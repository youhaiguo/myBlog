package com.mo.dao;

import java.util.List;

import com.mo.po.Categorys;

public interface CategorysDao {

	/**
	 * 添加一条分类
	 * @param categorys
	 */
	void add(Categorys categorys);

	/**
	 * 查询所有的分类信息
	 * @return 所有分类的List
	 */
	List<Categorys> selectAll();

	/**
	 * 根据id删除分类
	 * @param categoryId 
	 */
	void delById(int categoryId);

	/**
	 * 根据id将分类查询出来
	 * @param categoryId
	 * @return
	 */
	Categorys selectById(int categoryId);

}
