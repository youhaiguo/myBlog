package com.mo.po;

import java.util.Calendar;
import java.util.Date;

public class Message {
	private int messageId;
	private String userName;
	private String contend;
	private Date pubDate;
	
	//新增年月日，用于方便显示在前端
	private Calendar cal = Calendar.getInstance();
	private int year;
	private int month;
	private int day;
	
	

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


	
	

	public Message() {
	}
	public Message(String contend) {
		this.contend = contend;
	}
	public Message(String userName, String contend) {
		this.userName = userName;
		this.contend = contend;
	}

	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getContend() {
		return contend;
	}
	public void setContend(String contend) {
		this.contend = contend;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	
	
	
}
