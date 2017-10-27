package com.mo.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mo.dao.CategorysDao;
import com.mo.po.Categorys;
import com.mo.util.DBCPUtil;

public class CategorysDaoImpl implements CategorysDao {
	
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());

	public void add(Categorys categorys) {
		try {
			qr.update("INSERT INTO categorys(NAME,description) VALUES(?,?)", categorys.getName(),categorys.getDescription());
		} catch (SQLException e) {
			System.err.println("CategorysDaoImpl.add出错了");
			throw new RuntimeException(e);
		}
	}

	public List<Categorys> selectAll() {
		try {
			return qr.query("SELECT * FROM categorys",new BeanListHandler<Categorys>(Categorys.class));
		} catch (SQLException e) {
			System.err.println("CategorysDaoImpl.selectAll出错了");
			throw new RuntimeException(e);	
		}
	}

	
	public void delById(int categoryId) {
		try {
			qr.update("DELETE FROM categorys WHERE id = ?",categoryId);
		} catch (SQLException e) {
			System.err.println("CategorysDaoImpl.delById出错了");
			e.printStackTrace();
		}
	}

	public Categorys selectById(int categoryId) {
		try {
			return qr.query("SELECT * FROM categorys WHERE id = ?",new BeanHandler<Categorys>(Categorys.class),categoryId);
		} catch (SQLException e) {
			System.err.println("CategorysDaoImpl.selectById出错了");
			throw new RuntimeException(e);	
		}
	}

}
