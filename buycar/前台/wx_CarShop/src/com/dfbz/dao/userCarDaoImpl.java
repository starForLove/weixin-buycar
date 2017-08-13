package com.dfbz.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dfbz.bean.topLine;
import com.dfbz.bean.userCar;
import com.dfbz.jdbc.JDBCUtil;
import com.mysql.jdbc.Statement;

public class userCarDaoImpl implements userCarDao {
     
	public List<userCar> checkcCar(int id,String address){
		Connection conn=null;
		Statement stmt = null;
		ResultSet rs =null;
		List<userCar> list= null;
		try {
			
			conn = JDBCUtil.getInstance().getConnection();
			stmt = (Statement) conn.createStatement();
			String sql = "select name,location,price from company com left join car_company  car_com  on com.id = car_com.comid where car_com.carid="+id+" and com.provence ='"+address+"'";
					
			rs = stmt.executeQuery(sql);
			list = new ArrayList<userCar>();
//			循环处理结果集
			while(rs.next()){
				userCar car = new userCar();
				car.setName(rs.getString("name"));
				car.setLocation(rs.getString("location"));
				car.setPrice(rs.getDouble("price"));
				list.add(car);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.getInstance().free(conn,stmt,rs);
		}
		return list;
	
	}
	public static void main(String[] args) {
		   userCarDao dao =new userCarDaoImpl();
		   
		   List<userCar> list = dao.checkcCar(1,"北京" );
		   userCar car = list.get(0);
		   System.out.println(car.getLocation());
	}
}
