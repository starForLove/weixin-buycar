package com.dfbz.services;

import java.util.List;
import com.dfbz.bean.CarInfo;
import com.dfbz.dao.CarInfoDao;
import com.dfbz.dao.CarInfoDaoImpl;

public class CarInfoServiceImpl implements CarInfoService {

	CarInfoDao show=new CarInfoDaoImpl();
	@Override
	public List<CarInfo> showCarInfo1(String car_name,String year,String condition) {
		List<CarInfo> resultList = show.showCarInfo1(car_name, year,condition);
		if(resultList == null || resultList.size()<=0){
			return null;
		}
		return resultList;
	}
	@Override
	public List<CarInfo> showCarInfo2(String car_name) {
		List<CarInfo> resultList = show.showCarInfo2(car_name);
		if(resultList == null || resultList.size()<=0){
			return null;
		}
		return resultList;
	}
}