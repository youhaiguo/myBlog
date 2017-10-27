package com.mo.dao.impl;

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mo.dao.ArticleDailyDao;
import com.mo.po.ArticleDaily;
import com.mo.util.DBCPUtil;


public class ArticleDailyDaoImpl implements ArticleDailyDao {
	
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());

	public ArticleDaily selectById(int id) {
		try {
			ArticleDaily article = qr.query("SELECT * FROM ArticleDaily WHERE articleId = ?", new BeanHandler<ArticleDaily>(ArticleDaily.class),id);
			return article;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<ArticleDaily> findByIndex(int start, int size) {
		List<ArticleDaily> list;
		try {
			list = qr.query("SELECT * FROM ArticleDaily ORDER BY articleid DESC LIMIT ?,?", new BeanListHandler<ArticleDaily>(ArticleDaily.class),start,size);
			return list;
		} catch (SQLException e) {
			System.err.println("ArticleDailyDaoImpl.findByIndex出错了");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public int findTotalCount() {
		try {
			return ((Long)qr.query("SELECT COUNT(articleId) FROM ArticleDaily", new ScalarHandler(1))).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void add(ArticleDaily article) {
		try {
			qr.update("INSERT INTO ArticleDaily(title,pubDate,content) VALUES(?,?,?)",article.getTitle(),article.getPubDate(),article.getContent());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void delById(int articleId) {
		try {
			qr.update("DELETE FROM ArticleDaily WHERE articleId = ?",articleId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public ArticleDaily selectNext(int articleId) {
		try {
			return qr.query("SELECT * FROM ArticleDaily WHERE articleId > ? ORDER BY articleId  LIMIT 1", new BeanHandler<ArticleDaily>(ArticleDaily.class),articleId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public ArticleDaily selectPre(int articleId) {
		try {
			return qr.query("SELECT * FROM ArticleDaily WHERE articleId < ? ORDER BY articleId DESC LIMIT 1", new BeanHandler<ArticleDaily>(ArticleDaily.class),articleId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


}