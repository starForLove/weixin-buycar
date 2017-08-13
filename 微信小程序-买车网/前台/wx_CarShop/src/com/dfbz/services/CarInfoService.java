package com.dfbz.services;
import java.util.List;

import com.dfbz.bean.*;

public interface CarInfoService {

	
	public List<CarInfo>showCarInfo2(String car_name);
	List<CarInfo> showCarInfo1(String car_name, String year,String condition);
}
