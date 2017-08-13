package com.dfbz.dao;

import java.util.List;

import com.dfbz.bean.CarInfo;
import com.dfbz.bean.CarVideo;
import com.dfbz.bean.CarViewImage;
import com.dfbz.bean.ConfigurationBean;
import com.dfbz.bean.userCar;

public class test {
	public static void main(String[] args) {
		userCarDao cdi =new userCarDaoImpl();
		List<userCar> ls = cdi.checkcCar(1, "北京");
		System.out.println(ls);
	}
}
