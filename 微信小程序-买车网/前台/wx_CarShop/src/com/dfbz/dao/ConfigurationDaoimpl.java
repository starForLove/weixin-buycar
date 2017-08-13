package com.dfbz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dfbz.bean.ConfigurationBean;
import com.dfbz.jdbc.JDBCUtil;


public class ConfigurationDaoimpl implements ConfigurationDao{

	
		
		
		public List<ConfigurationBean> showConfiguration(int id) {
			
			
			List<ConfigurationBean> configList=null;
			
			
			Connection conn=null;
			
			PreparedStatement  ps = null;
			ResultSet rs = null;
			try {
				configList = new ArrayList<ConfigurationBean>();
				conn = JDBCUtil.getInstance().getConnection();
				String sql = "select* from configuration where id=?";
                ps =conn.prepareStatement(sql);
				ps.setInt(1, id);
				rs = ps.executeQuery();
			
				while(rs.next()){
					ConfigurationBean Configuration = new ConfigurationBean();
					Configuration.setId(rs.getInt("id"));
					//Configuration.setBrandname(rs.getString("brand_name"));
					//Configuration.setCarname(rs.getString("car_name"));
					Configuration.setFactoryprice(rs.getDouble("factory_price"));
					Configuration.setLeastprice(rs.getDouble("least_price"));
					Configuration.setCompanyname(rs.getString("companyname"));
					Configuration.setLevel(rs.getString("level"));
					Configuration.setDate(rs.getString("date"));
					Configuration.setEngine(rs.getString("engine"));
					Configuration.setAccelerate(rs.getDouble("accelerate"));
					Configuration.setAidmoney(rs.getDouble("aidmoney"));
					Configuration.setBackgauge(rs.getInt("back_gauge"));
					Configuration.setCapacity(rs.getInt("capacity"));
					Configuration.setCylindernum(rs.getInt("cylinder_num"));
					Configuration.setDoornum(rs.getInt("door_num"));
					Configuration.setFrontgauge(rs.getInt("front_gauge"));
					Configuration.setFuel(rs.getString("fuel"));
					Configuration.setFueltank(rs.getInt("fuel_tank"));
					Configuration.setGearbox(rs.getString("gear_box"));
					Configuration.setHeight(rs.getInt("height"));
					Configuration.setHorsepower(rs.getInt("horsepower"));
					Configuration.setLength(rs.getInt("length"));
					Configuration.setMass(rs.getInt("mass"));
					Configuration.setOilcost(rs.getInt("oil_cost"));
					Configuration.setOilwear(rs.getDouble("oil_wear"));
					Configuration.setOutput(rs.getInt("output"));
					Configuration.setSeatnum(rs.getInt("seat_num"));
					Configuration.setSpeed(rs.getInt("speed"));
					Configuration.setStructure(rs.getString("structure"));
					Configuration.setWheelbase(rs.getInt("wheelbase"));
					Configuration.setWidth(rs.getInt("width"));
					Configuration.setBackbrake(rs.getString("back_brake"));
					Configuration.setBacktyre(rs.getString("back_tyre"));
					Configuration.setDrivesystem(rs.getString("drive_system"));
					Configuration.setEnvstandards(rs.getString("env_standards"));
					Configuration.setFrontbrake(rs.getString("front_brake"));
					Configuration.setFuelmodel(rs.getString("fuel_model"));
					Configuration.setGearboxname(rs.getString("gear_box_name"));
					Configuration.setGearboxstyle(rs.getString("gear_box_style"));
					Configuration.setGearnum(rs.getInt("Gear_num"));
					Configuration.setParkingbrake(rs.getString("parking_brake"));
					Configuration.setPowertype(rs.getString("power_type"));
					Configuration.setSparetire(rs.getString("spare_tire"));
					
					
					
					configList.add(Configuration);
					
				}
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.getInstance().free(conn,ps,rs);
			}
			
			return configList;
		}
		


}
