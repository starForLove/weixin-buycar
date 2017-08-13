package com.dfbz.services;


import com.dfbz.bean.TopLinePage;
import com.dfbz.dao.TopLinePageDao;
import com.dfbz.dao.TopLinePageDaoImpl;

public class TopLinePageServiceImpl implements TopLinePageService{
	TopLinePageDao show = new TopLinePageDaoImpl();
	@Override
	public TopLinePage getPage(int id) {
		TopLinePage result = show.getPage(id);
		if(result == null){
			return null;
		}
		return result;
	}

}
