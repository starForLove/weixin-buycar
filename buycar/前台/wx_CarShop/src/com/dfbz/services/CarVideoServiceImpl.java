package com.dfbz.services;

import java.util.List;


import com.dfbz.bean.CarVideo;
import com.dfbz.dao.CarVideoDao;
import com.dfbz.dao.CarVideoDaoImpl;

public class CarVideoServiceImpl implements CarVideoService {
	CarVideoDao show = new CarVideoDaoImpl();
	@Override
	public List<CarVideo> showCarVideoList() {
		List<CarVideo> resultList = show.showCarVideoList();
		if(resultList == null || resultList.size()<=0){
			return null;
		}
		return resultList;
	}
	@Override
	public List<CarVideo> getCarVideos(int id) {
		List<CarVideo> resultList = show.getVideoInfo(id);
		if(resultList == null || resultList.size()<=0){
			return null;
		}
		return resultList;
	}
	@Override
	public List<CarVideo> loadMore(int id) {
		List<CarVideo> resultList = show.loadMore(id);
		if(resultList == null || resultList.size()<=0){
			return null;
		}
		return resultList;
	}

}
