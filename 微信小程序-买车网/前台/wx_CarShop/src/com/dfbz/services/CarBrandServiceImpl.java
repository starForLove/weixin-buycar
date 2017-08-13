package com.dfbz.services;

import java.util.List;

import com.dfbz.bean.CarBrand;
import com.dfbz.dao.CarBrandDao;
import com.dfbz.dao.CarBrandDaoImpl;

public class CarBrandServiceImpl implements CarBrandService {
CarBrandDao show= new CarBrandDaoImpl();
	
	@Override
	public List<CarBrand> showCarBrand() {
		List<CarBrand> resultList = show.showCarBrand();
		if(resultList == null || resultList.size()<=0){
			return null;
		}
		return resultList;
	}


}
