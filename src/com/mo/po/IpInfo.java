package com.mo.po;

import java.util.Date;

public class IpInfo {
	
	private int id;
	private String ip;
	private String addressLocation;
	private Date firstTime;
	private Date lastTime;
	private int visitTimes;
	private String greet;
	
	public String getGreet() {
		return greet;
	}
	public void setGreet(String greet) {
		this.greet = greet;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getAddressLocation() {
		return addressLocation;
	}
	public void setAddressLocation(String addressLocation) {
		this.addressLocation = addressLocation;
	}
	public Date getFirstTime() {
		return firstTime;
	}
	public void setFirstTime(Date firstTime) {
		this.firstTime = firstTime;
	}
	public Date getLastTime() {
		return lastTime;
	}
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	public int getVisitTimes() {
		return visitTimes;
	}
	public void setVisitTimes(int visitTimes) {
		this.visitTimes = visitTimes;
	} 
	
	
	
}
