package com.dfbz.dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dfbz.bean.CarInfo;
import com.dfbz.jdbc.JDBCUtil;

public class testDaoImpl {
	public static void main(String[] args) {
		testDaoImpl t = new testDaoImpl();
		String s = "奥迪A4L";
		t.show(s);
		
		
	}
	public List<CarInfo> show(String car_name) {
		List<CarInfo> al = new ArrayList<CarInfo>();
		Connection conn = null;//Connection代表与数据库的链接，并拥有创建SQL语句的方法，以完成基本的SQL操作
		PreparedStatement pstm = null;
		ResultSet rs = null;//包含了Statement和PreparedStatement的executeQuery方法中SELECT的结果集。相当于用它来读取数据库里每列的值。
		try {
			conn = JDBCUtil.getInstance().getConnection();//获取数据库连接对象
			String sql = "select a.car_name, a.year,a.condition,b.image_url from car_info a LEFT JOIN image b on a.image_id=b.id where a.car_name=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, car_name);
			rs = pstm.executeQuery();
			while(rs.next()){
				CarInfo c = new CarInfo();
				c.setCar_name(rs.getString("car_name"));
				c.setCondition(rs.getString("condition"));
				c.setYear(rs.getString("year"));
				c.setImage_url(rs.getString("image_url"));
				al.add(c);
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.getInstance().free(conn,pstm,null);//用完了要把资源释放
		}
		
		
		return al;
		
	}
}
