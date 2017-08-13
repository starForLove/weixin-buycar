package com.dfbz.dao;

import java.util.List;

import com.dfbz.bean.CarInfo;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarInfoDao test=new CarInfoDaoImpl();
		List<CarInfo> w= test.showCarInfo();
	    CarInfo list=w.get(0);
	    System.out.print(list);

	}

}
