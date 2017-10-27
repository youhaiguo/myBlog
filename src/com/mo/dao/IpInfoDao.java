package com.mo.dao;

import com.mo.po.IpInfo;

public interface IpInfoDao {

	/**
	 * 增加一个新的ip用户
	 * 
	 */
	void add(IpInfo ipInfo);
	
	/**
	 * 更新ip信息
	 */
	void update(IpInfo ipInfo);
	
	/**
	 * 根据IP地址查看是不是有一个IP存在
	 * @return
	 */
	IpInfo findByIp(String ip);

	/**
	 * 统计ip库
	 */
	int findTotalCount();

}
