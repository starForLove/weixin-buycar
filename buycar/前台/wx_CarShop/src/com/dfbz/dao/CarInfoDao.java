package com.dfbz.dao;
import java.util.List;

import com.dfbz.bean.CarInfo;

public interface CarInfoDao {
	

public List<CarInfo>showCarInfo2(String name);
 public List<CarInfo> showCarInfo1(String car_name, String year, String condition);
}
