package com.dfbz.services;


import java.util.List;

import com.dfbz.bean.topLine;
import com.dfbz.dao.topLineDao;
import com.dfbz.dao.topLineDaoImpl;

public class CarAticleServiceImpl implements CarAticleService {
    topLineDao top = new topLineDaoImpl();
	@Override
	public List<topLine> showAticle() {
		List<topLine> list = top.getTopLines();
		if(list == null || list.size()<=0){
			return null;
		}
		return list;
	}
	    
		
	

}
