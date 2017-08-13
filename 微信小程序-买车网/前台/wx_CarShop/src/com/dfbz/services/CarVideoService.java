package com.dfbz.services;

import java.util.List;

import com.dfbz.bean.CarVideo;

public interface CarVideoService {
	public List<CarVideo> showCarVideoList();
	public List<CarVideo> getCarVideos(int id);
	public List<CarVideo> loadMore(int id);
}
