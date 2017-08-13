package com.dfbz.services;

import java.util.List;

import com.dfbz.bean.Car;
import com.dfbz.dao.CarKindDao;
import com.dfbz.dao.CarKindDaoImpl;

public class CarKindServicesImpl implements CarKindServices {

	CarKindDao show=new CarKindDaoImpl();
	@Override
	public List<Car> showCarKind() {
		List<Car> resultList = show.showCarKind();
		if(resultList == null || resultList.size()<=0){
			return null;
		}
		return resultList;
	  

	}@Override
	public List<Car> showCarQuantity() {
		List<Car> resultList = show.showCarQuantity();
		if(resultList == null || resultList.size()<=0){
			return null;
		}
		return resultList;
	  

	}


}
