package com.mo.dao;

import java.util.List;

import com.mo.po.Message;

public interface MassageDao {

	/**
	 * 添加一条留言
	 * @param message
	 */
	void insert(Message message);

	/**
	 * 查询留言总条数
	 * @return
	 */
	int findTotalCount();

	/**
	 * 根据开始索引和size查询留言(用于分页)
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	List<Message> selectByIndex(int startIndex, int pageSize);

	/**
	 * 根据留言的id删除留言
	 * @param messageId
	 */
	void delById(Integer messageId);

}
