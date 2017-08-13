package com.dfbz.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class topLine {
	private int topId;
    private String topCont;
    private String topTitle;
    private int topBrowes;
    private String topTime;
    private String picture;
	
    public int getTopId() {
		return topId;
	}
	public void setTopId(int topId) {
		this.topId = topId;
	}
	public String getTopCont() {
		return topCont;
	}
	public void setTopCont(String topCont) {
		this.topCont = topCont;
	}
	public String getTopTitle() {
		return topTitle;
	}
	public void setTopTitle(String topTitle) {
		this.topTitle = topTitle;
	}
	public int getTopBrowes() {
		return topBrowes;
	}
	public void setTopBrowes(int topBrowes) {
		this.topBrowes = topBrowes;
	}
	public String getTopTime() {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:m:s");    
        Date date1 = null;
		try {
			date1 = format.parse(this.topTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		this.topTime = getFriendlytime(date1); 		
        return topTime;
	}
	public void setTopTime(String topTime) {
		this.topTime = topTime;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public static String getFriendlytime(Date d){  
        long delta = (new Date().getTime()-d.getTime())/1000;  
        if(delta<=0)return d.toLocaleString();  
        if(delta/(60*60*24*365) > 0) return delta/(60*60*24*365) +"年前";  
        if(delta/(60*60*24*30) > 0) return delta/(60*60*24*30) +"个月前";  
        if(delta/(60*60*24*7) > 0)return delta/(60*60*24*7) +"周前";  
        if(delta/(60*60*24) > 0) return delta/(60*60*24) +"天前";  
        if(delta/(60*60) > 0)return delta/(60*60) +"小时前";  
        if(delta/(60) > 0)return delta/(60) +"分钟前";  
        return "刚刚";  
    }  
    
}
