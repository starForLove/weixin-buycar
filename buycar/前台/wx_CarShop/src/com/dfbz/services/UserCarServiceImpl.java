package com.dfbz.services;

import java.util.List;

import com.dfbz.bean.userCar;
import com.dfbz.dao.userCarDao;
import com.dfbz.dao.userCarDaoImpl;
import com.sun.xml.internal.bind.v2.model.core.ID;

public class UserCarServiceImpl implements UserCarService{
	userCarDao dao =new userCarDaoImpl();
	@Override
	public List<userCar> findCar(int id , String address) {
		// TODO Auto-generated method stub
		List<userCar> list=dao.checkcCar(id, address);
		if(list == null || list.size()<=0){
			return null;
		}
		return list;
	
	}
   
}
