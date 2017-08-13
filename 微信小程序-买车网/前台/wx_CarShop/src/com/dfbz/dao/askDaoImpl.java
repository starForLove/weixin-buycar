package com.dfbz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dfbz.jdbc.JDBCUtil;

public class askDaoImpl implements askDao {

	@Override
	public void insertAsk(int userId, int carId, String shop) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		
		try {
			conn = JDBCUtil.getInstance().getConnection();
			String sql = " insert into ask(userid,carid,shop) values(?,?,?)";
			stmt =  conn.prepareStatement(sql);
			stmt.setInt(1,userId );
			stmt.setInt(2, carId);
			stmt.setString(3, shop);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.getInstance().free(conn,stmt,res);
		}
	}
	
//	public static void main(String[] args) {
//		askDao dao =new askDaoImpl();
//	    int id=0 ;
//		dao.insertAsk(1, 2, "Ìì½ò");
//		System.out.println(id);
//		
//	}
}
