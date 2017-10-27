package com.mo.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mo.dao.MassageDao;
import com.mo.po.Message;
import com.mo.util.DBCPUtil;

public class MassageDaoImpl implements MassageDao {

	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	
	public void insert(Message message) {
		try {
			qr.update("INSERT INTO message(userName,contend,pubDate) VALUES(?,?,?)",message.getUserName(),message.getContend(),message.getPubDate());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int findTotalCount() {
		try {
			return ((Long)qr.query("SELECT COUNT(*) FROM message", new ScalarHandler(1))).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Message> selectByIndex(int startIndex, int pageSize) {
		try {
			return qr.query("SELECT * FROM message  ORDER BY pubDate DESC LIMIT ?,?",new BeanListHandler<Message>(Message.class),startIndex,pageSize);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void delById(Integer messageId) {
		try {
			qr.update("DELETE FROM message WHERE messageId = ?",messageId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
