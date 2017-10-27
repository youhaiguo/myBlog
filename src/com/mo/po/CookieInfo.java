package com.mo.po;

public class CookieInfo {

	private String lastVisitTime;//上一次的访问时间
	private String ipAddress;//上一次访问的ip地址
	private String greet;//问候语
	
	public CookieInfo() {
	}
	
	public CookieInfo(String lastVisitTime, String ipAddress, String greet) {
		super();
		this.lastVisitTime = lastVisitTime;
		this.ipAddress = ipAddress;
		this.greet = greet;
	}
	public String getGreet() {
		return greet;
	}
	public void setGreet(String greet) {
		this.greet = greet;
	}
	public String getLastVisitTime() {
		return lastVisitTime;
	}
	public void setLastVisitTime(String lastVisitTime) {
		this.lastVisitTime = lastVisitTime;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

}
