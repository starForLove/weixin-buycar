package com.dfbz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dfbz.bean.CarBrand;
import com.dfbz.bean.CarVideo;
import com.dfbz.jdbc.JDBCUtil;

public class CarVideoDaoImpl implements CarVideoDao {

	@Override
	public List<CarVideo> showCarVideoList() {
		int res=0;
		List<CarVideo> carVideoList=null;
		//ʹ��JDBC�޸Ļ�ȡ�����û���Ϣ�ķ�ʽ
		Connection conn = null;
		PreparedStatement  stmt = null;
		ResultSet rs = null;
		try {
			carVideoList = new ArrayList<CarVideo>();
			conn = JDBCUtil.getInstance().getConnection();
			
			String sql = "select * from image_video";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);

			while(rs.next()){
				CarVideo c = new CarVideo();
				c.setId(rs.getInt("id"));
				c.setImage_url(rs.getString("image_url"));
				c.setImage_name(rs.getString("image_name"));
				c.setVideo_name(rs.getString("video_name"));
				c.setVideo_url(rs.getString("video_url"));
				c.setAuthor(rs.getString("author"));
				c.setDate(rs.getString("date"));
				c.setIcon_url(rs.getString("icon_url"));
				c.setTitle(rs.getString("title"));
				carVideoList.add(c);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.getInstance().free(conn,stmt,rs);
		}
		
		return carVideoList;
	
	}


	@Override
	public List<CarVideo> getVideoInfo(int id) {
		int res=0;
		List<CarVideo> carVideoList=null;
		//ʹ��JDBC�޸Ļ�ȡ�����û���Ϣ�ķ�ʽ
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement  stmt = null;
		ResultSet rs = null;
		try {
			carVideoList = new ArrayList<CarVideo>();
			conn = JDBCUtil.getInstance().getConnection();
			
			String sql = "select * from image_video where id="+id;
			stmt = conn.prepareStatement(sql);
			
			
			rs = stmt.executeQuery(sql);

			while(rs.next()){
				CarVideo c = new CarVideo();
				c.setId(rs.getInt("id"));
				c.setImage_url(rs.getString("image_url"));
				c.setImage_name(rs.getString("image_name"));
				c.setVideo_name(rs.getString("video_name"));
				c.setVideo_url(rs.getString("video_url"));
				c.setAuthor(rs.getString("author"));
				c.setDate(rs.getString("date"));
				c.setIcon_url(rs.getString("icon_url"));
				c.setTitle(rs.getString("title"));
				carVideoList.add(c);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.getInstance().free(conn,stmt,rs);
		}
		
		return carVideoList;
	}

}
