package com.mo.dao.impl;

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mo.dao.ArticleDao;
import com.mo.po.Article;
import com.mo.util.DBCPUtil;


public class ArticleDaoImpl implements ArticleDao {
	
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());

	public Article selectById(int id) {
		try {
			Article article = qr.query("SELECT * FROM article WHERE articleId = ?", new BeanHandler<Article>(Article.class),id);
			return article;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Article> findByIndex(int start, int size) {
		List<Article> list;
		try {
			list = qr.query("SELECT * FROM article ORDER BY articleid DESC LIMIT ?,?", new BeanListHandler<Article>(Article.class),start,size);
			return list;
		} catch (SQLException e) {
			System.err.println("ArticleDaoImpl.findByIndex出错了");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public int findTotalCount() {
		try {
			return ((Long)qr.query("SELECT COUNT(articleId) FROM article", new ScalarHandler(1))).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void add(Article article) {
		try {
			qr.update("INSERT INTO article(title,pubDate,content,categoryId) VALUES(?,?,?,?)",article.getTitle(),article.getPubDate(),article.getContent(),article.getCategoryId());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void delById(int articleId) {
		try {
			qr.update("DELETE FROM article WHERE articleId = ?",articleId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Article> selectByCategoryId(Integer categoryId) {
		try {
			return qr.query("SELECT * FROM article WHERE categoryId = ?", new BeanListHandler<Article>(Article.class),categoryId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public int findTotalCountByCategory(int categoryId) {
		try {
			return ((Long)qr.query("SELECT COUNT(*) FROM article WHERE categoryId = ?", new ScalarHandler(1),categoryId)).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Article> selectByIndexInCategory(int categoryId,int startIndex, int pageSize) {
		try {
			return qr.query("SELECT * FROM article WHERE categoryId = ? ORDER BY pubDate DESC LIMIT ?,?", new BeanListHandler<Article>(Article.class),categoryId,startIndex,pageSize);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public Article selectNext(int articleId) {
		try {
			return qr.query("SELECT * FROM article WHERE articleId > ? ORDER BY articleId  LIMIT 1", new BeanHandler<Article>(Article.class),articleId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public Article selectPre(int articleId) {
		try {
			return qr.query("SELECT * FROM article WHERE articleId < ? ORDER BY articleId DESC LIMIT 1", new BeanHandler<Article>(Article.class),articleId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}