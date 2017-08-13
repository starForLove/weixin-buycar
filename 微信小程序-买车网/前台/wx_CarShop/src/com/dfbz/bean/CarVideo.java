package com.dfbz.bean;

import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Date;  

public class CarVideo {
	private int id;
	private String image_name;
	private String image_url;
	private String video_name;
	private String video_url;
	private String author;
	private String date;
	private String icon_url;
	private String title;
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDate() {
		
		
		
		
		
	/*timeago*/
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:m:s");    
        Date date1 = null;
		try {
			date1 = format.parse(this.date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		this.date = getFriendlytime(date1); 		
        return date;
		
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getIcon_url() {
		return icon_url;
	}
	public void setIcon_url(String icon_url) {
		this.icon_url = icon_url;
	}
	public String getImage_name() {
		return image_name;
	}
	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getVideo_name() {
		return video_name;
	}
	public void setVideo_name(String video_name) {
		this.video_name = video_name;
	}
	public String getVideo_url() {
		return video_url;
	}
	public void setVideo_url(String video_url) {
		this.video_url = video_url;
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
