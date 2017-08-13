package com.dfbz.services;

import java.util.List;

import com.dfbz.bean.CarViewImage;
import com.dfbz.dao.CarViewPictureDao;
import com.dfbz.dao.CarViewPictureDaoImpl;

public class CarViewPictureServiceImpl implements CarViewPictureService{
	CarViewPictureDao show = new CarViewPictureDaoImpl();
	@Override
	public List<CarViewImage> getImageUrl(String flag,String car_model) {
		List<CarViewImage> resultList = show.getImageUrl(flag,car_model);
		if(resultList == null || resultList.size()<=0){
			return null;
		}
		return resultList;
	}

}
