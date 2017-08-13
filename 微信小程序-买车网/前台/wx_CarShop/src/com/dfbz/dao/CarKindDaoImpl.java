package com.dfbz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dfbz.bean.Car;
import com.dfbz.bean.CarBrand;
import com.dfbz.jdbc.JDBCUtil;

public class CarKindDaoImpl implements CarKindDao {

	@Override
	public List<Car> showCarKind() {
		List<Car> carKindList=null;
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			carKindList = new ArrayList<Car>();
			conn = JDBCUtil.getInstance().getConnection();
			
			String sql = "select * from car where id in (select min(id) from car group by car_name)";//查询brand表中所有用户信息的SQL语句
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
//			循环处理结果集
			while(rs.next()){
				Car c = new Car();
				c.setId(rs.getInt("id"));
				c.setBrand_name(rs.getString("brand_name"));
				c.setCar_name(rs.getString("car_name"));
				c.setKind(rs.getString("kind"));
				
				c.setPicture(rs.getString("picture"));
				c.setPrice_range(rs.getString("price_range"));
				c.setSize(rs.getString("size"));
				
			
				carKindList.add(c);
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.getInstance().free(conn,stmt,rs);
		}
		
		return carKindList;
	}
	@Override
	public List<Car> showCarQuantity() {
		List<Car> carQuantity=null;
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			carQuantity = new ArrayList<Car>();
			conn = JDBCUtil.getInstance().getConnection();
			
			String sql = "select kind,brand_name,count(*) count from car group by kind";//查询brand表中所有用户信息的SQL语句
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
//			循环处理结果集
			while(rs.next()){
				Car c = new Car();
				c.setBrand_name(rs.getString("brand_name"));			
				c.setKind(rs.getString("kind"));
				c.setCount(rs.getInt("count"));	
				carQuantity.add(c);
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.getInstance().free(conn,stmt,rs);
		}
		
		return carQuantity;
	}

}
