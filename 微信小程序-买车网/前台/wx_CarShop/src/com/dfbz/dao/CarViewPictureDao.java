package com.dfbz.dao;

import java.util.List;

import com.dfbz.bean.CarViewImage;

public interface CarViewPictureDao {
	public List<CarViewImage> getImageUrl(String flag,String car_model);
}
