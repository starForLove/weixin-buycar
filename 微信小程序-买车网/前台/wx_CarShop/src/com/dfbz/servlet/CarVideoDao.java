package com.dfbz.dao;

import java.util.List;

import com.dfbz.bean.CarVideo;

public interface CarVideoDao {
	public List<CarVideo> showCarVideoList();
	public List<CarVideo> getVideoInfo(int id);
}
