package com.dfbz.services;

import java.util.List;


import com.dfbz.bean.ConfigurationBean;
import com.dfbz.dao.ConfigurationDao;
import com.dfbz.dao.ConfigurationDaoimpl;


public class ConfigurationServiceimpl implements ConfigurationService {

	public List<ConfigurationBean> showcarConfiguration(int id) {
		ConfigurationDao configuration= new ConfigurationDaoimpl();
			
			List<ConfigurationBean> resultList = configuration.showConfiguration(id);
				if(resultList == null || resultList.size()<=0){
					return null;
				}
				return resultList;
			}
	

}
