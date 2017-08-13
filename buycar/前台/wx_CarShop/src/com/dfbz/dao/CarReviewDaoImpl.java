package com.dfbz.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dfbz.bean.CarReview;
import com.dfbz.bean.CarReview;
import com.dfbz.jdbc.JDBCUtil;

public class CarReviewDaoImpl implements CarReviewDao{

	@Override
	public List<CarReview> showCarReview(int sid,String table) {
		List<CarReview> carReviewList=null;
		//ʹ��JDBC�޸Ļ�ȡ�����û���Ϣ�ķ�ʽ
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null;
		try {
			carReviewList = new ArrayList<CarReview>();
			conn = JDBCUtil.getInstance().getConnection();
			stmt = conn.createStatement();
			String sql = "select * from "+table+" WHERE videoid = "+sid+ " ORDER BY id DESC LIMIT 0,3";
			rs = stmt.executeQuery(sql);

			while(rs.next()){
				CarReview c = new CarReview();
				c.setId(rs.getInt("id"));
				c.setPosition(rs.getString("position"));
				c.setReview(rs.getString("review"));
				c.setReviewdate(rs.getString("reviewdate"));
				c.setIcon_url(rs.getString("icon_url"));
				c.setUsername(rs.getString("username"));
				c.setVideoid(rs.getInt("videoid"));
				carReviewList.add(c);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.getInstance().free(conn,stmt,rs);
		}
		
		return carReviewList;
	}

	@Override
	public List<CarReview> LoadMore(int id,int sid,String table) {
		List<CarReview> carReviewList=null;
		//ʹ��JDBC�޸Ļ�ȡ�����û���Ϣ�ķ�ʽ
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null;
		try {
			carReviewList = new ArrayList<CarReview>();
			conn = JDBCUtil.getInstance().getConnection();
			stmt = conn.createStatement();
			String sql = "select * from "+table+" WHERE videoid = "+sid+ " ORDER BY id DESC LIMIT "+id+",3";
			rs = stmt.executeQuery(sql);

			while(rs.next()){
				CarReview c = new CarReview();
				c.setId(rs.getInt("id"));
				c.setPosition(rs.getString("position"));
				c.setReview(rs.getString("review"));
				c.setReviewdate(rs.getString("reviewdate"));
				c.setIcon_url(rs.getString("icon_url"));
				c.setUsername(rs.getString("username"));
				c.setVideoid(rs.getInt("videoid"));
				carReviewList.add(c);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.getInstance().free(conn,stmt,rs);
		}
		
		return carReviewList;
	}

}
