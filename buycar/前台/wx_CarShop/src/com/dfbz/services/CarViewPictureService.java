package com.dfbz.services;

import java.util.List;

import com.dfbz.bean.CarViewImage;

public interface CarViewPictureService {
	public List<CarViewImage> getImageUrl(String flag,String car_model);
}
