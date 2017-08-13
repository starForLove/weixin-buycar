package com.dfbz.services;

import java.util.List;

import com.dfbz.bean.CarVideo;
import com.dfbz.bean.CarViewImage;
import com.dfbz.bean.TopLinePage;
import com.dfbz.dao.CarVideoDao;
import com.dfbz.dao.CarVideoDaoImpl;
import com.dfbz.dao.CarViewPictureDao;
import com.dfbz.dao.CarViewPictureDaoImpl;
import com.dfbz.dao.TopLinePageDao;
import com.dfbz.dao.TopLinePageDaoImpl;

public class test {
	public static void main(String[] args) {
//		CarViewPictureDao cdi = new CarViewPictureDaoImpl();
//		List<CarViewImage> list = cdi.getImageUrl("center", "audi_A4L");
//		for(int i=0;i<3;i++){
//		System.out.println(list.get(i).getImage_url());
//		System.out.println(list.get(i).getId());
//		}
		
		TopLinePageDao te =new TopLinePageDaoImpl();
		TopLinePage li = te.getPage(2);
		System.out.println(li.getPage());
	}
}
