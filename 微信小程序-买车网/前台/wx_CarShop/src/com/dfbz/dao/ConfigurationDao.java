package com.dfbz.dao;

import java.util.List;

import com.dfbz.bean.ConfigurationBean;



public interface ConfigurationDao {
	public List<ConfigurationBean> showConfiguration(int id);
}
