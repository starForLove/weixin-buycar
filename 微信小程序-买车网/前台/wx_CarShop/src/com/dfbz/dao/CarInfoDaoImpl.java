package com.dfbz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.dfbz.bean.CarInfo;
import com.dfbz.jdbc.JDBCUtil;

public class CarInfoDaoImpl implements CarInfoDao {


	@Override
	public List<CarInfo> showCarInfo1(String car_name,String year,String condition) {
		
		List<CarInfo> carInfoList=null;
		//ʹ��JDBC�޸Ļ�ȡ�����û���Ϣ�ķ�ʽ
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			carInfoList = new ArrayList<CarInfo>();
			conn = JDBCUtil.getInstance().getConnection();
			
			String sql = "select a.id,a.car_name,a.price, a.year,a.condition,a.car_model,b.image_url,c.air_admission,c.output,c.horsepower,c.gear_box_name,c.front_type,c.drive_system from car_info a,image b,configuration c where a.image_id=b.id and a.configuration_id=c.id and a.car_name=?and a.year=?and a.condition=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,car_name);
			stmt.setString(2,year);
			stmt.setString(3,condition);
			
			rs = stmt.executeQuery();
//			ѭ��������
			while(rs.next()){
				CarInfo c = new CarInfo();
				c.setId(rs.getInt("id"));
				c.setCar_name(rs.getString("car_name"));
				c.setCar_model(rs.getString("car_model"));
				c.setPrice(rs.getDouble("price"));	
				c.setCondition(rs.getString("condition"));
				c.setYear(rs.getString("year"));
				c.setDrive_system(rs.getString("drive_system"));
				c.setGear_box_name(rs.getString("gear_box_name"));
				c.setFront_type(rs.getString("front_type"));
				c.setAir_admission(rs.getString("air_admission"));
				c.setHorsepower(rs.getInt("horsepower"));
				c.setOutput(rs.getInt("output"));
				carInfoList.add(c);
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.getInstance().free(conn,stmt,rs);
		}
		
		return carInfoList;
	}

	@Override
	public List<CarInfo> showCarInfo2(String car_name) {
		
		List<CarInfo> carInfoList=null;
		//ʹ��JDBC�޸Ļ�ȡ�����û���Ϣ�ķ�ʽ
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			carInfoList = new ArrayList<CarInfo>();
			conn = JDBCUtil.getInstance().getConnection();
			String sql ="select a.id,a.car_name,a.price, a.year,a.condition,a.car_model,b.image_url,c.air_admission,c.output,c.horsepower from car_info a,image b,configuration c where a.image_id=b.id and a.configuration_id=c.id and a.car_name=?";	
			//String sql ="select car_name,year,condition from car_info where car_name=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,car_name);
			rs = stmt.executeQuery(); 
//			ѭ��������
			while(rs.next()){
				CarInfo c = new CarInfo();

				c.setId(rs.getInt("id"));
				c.setCar_name(rs.getString("car_name"));
				//c.setBrand_name(rs.getString("brand_name"));
				c.setCar_model(rs.getString("car_model"));
				c.setPrice(rs.getDouble("price"));	
				c.setCondition(rs.getString("condition"));
				c.setYear(rs.getString("year"));
				c.setImage_url(rs.getString("image_url"));
				c.setAir_admission(rs.getString("air_admission"));
				c.setHorsepower(rs.getInt("horsepower"));
				c.setOutput(rs.getInt("output"));
				carInfoList.add(c);
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.getInstance().free(conn,stmt,rs);
		}
		
		return carInfoList;
	}


}
