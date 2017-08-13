package com.dfbz.services;

import java.util.List;

import com.dfbz.bean.CarReview;

public interface CarReviewService {
	public List<CarReview> showCarReviewList(int id,String table);
	public List<CarReview> LoadMore(int id,int sid,String table);
}
