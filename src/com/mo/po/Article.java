package com.mo.po;

import java.util.Calendar;
import java.util.Date;
/**
 * 文章
 * @author 文龙
 * @since 2017.10.14
 *
 */
public class Article {
	private int articleId;
	private String title;
	private int userId;
	private String userName;
	private Date pubDate;
	private String content;
	private int liked;
	private int watched;
	private int categoryId;
	
	//新增年月日，用于方便显示在前端
	private Calendar cal = Calendar.getInstance();
	private int year;
	private int month;
	private int day;
	
	private Article preArticle;
	private Article nextArticle;
	
	
	
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Article getPreArticle() {
		return preArticle;
	}

	public void setPreArticle(Article preArticle) {
		this.preArticle = preArticle;
	}

	public Article getNextArticle() {
		return nextArticle;
	}

	public void setNextArticle(Article nextArticle) {
		this.nextArticle = nextArticle;
	}

	public int getYear() {
		cal.setTime(pubDate);
		return cal.get(cal.YEAR);
	}

	public int getMonth() {
		cal.setTime(pubDate);
		return cal.get(cal.MONTH)+1;
	}

	public int getDay() {
		cal.setTime(pubDate);
		return cal.get(cal.DATE);
	}

	public String toString() {
		return "Article [articleId=" + articleId + ", title=" + title
				+ ", userId=" + userId + ", userName=" + userName
				+ ", pubDate=" + pubDate + ", content=" + content + ", liked="
				+ liked + ", watched=" + watched + "]";
	}
	
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getLiked() {
		return liked;
	}
	public void setLiked(int liked) {
		this.liked = liked;
	}
	public int getWatched() {
		return watched;
	}
	public void setWatched(int watched) {
		this.watched = watched;
	}

	
	
}
