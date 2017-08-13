package com.dfbz.services;

import java.util.List;

import com.dfbz.bean.CarReview;
import com.dfbz.bean.CarVideo;
import com.dfbz.dao.CarReviewDao;
import com.dfbz.dao.CarReviewDaoImpl;

public class CarReviewServiceImpl implements CarReviewService{
	CarReviewDao show = new CarReviewDaoImpl();
	@Override
	public List<CarReview> showCarReviewList(int id,String table) {
		List<CarReview> resultList = show.showCarReview(id,table);
		if(resultList == null || resultList.size()<=0){
			return null;
		}
		return resultList;
	}
	@Override
	public List<CarReview> LoadMore(int id,int sid,String table) {
		List<CarReview> resultList = show.LoadMore(id,sid,table);
		if(resultList == null || resultList.size()<=0){
			return null;
		}
		return resultList;
	}
	

}
