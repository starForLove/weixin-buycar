package com.dfbz.dao;

import java.util.List;

import com.dfbz.bean.CarReview;

public interface CarReviewDao {
	public List<CarReview> showCarReview(int sid,String table);
	public List<CarReview> LoadMore(int id,int sid,String table);
}
