package com.dfbz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dfbz.bean.CarBrand;
import com.dfbz.jdbc.JDBCUtil;

public class CarBrandDaoImpl implements CarBrandDao {

	@Override

	public List<CarBrand> showCarBrand() {
		
		List<CarBrand> carbrandList=null;
		//ʹ��JDBC�޸Ļ�ȡ�����û���Ϣ�ķ�ʽ
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			carbrandList = new ArrayList<CarBrand>();
			conn = JDBCUtil.getInstance().getConnection();
			
			String sql = "select * from brand";//��ѯbrand���������û���Ϣ��SQL���
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
//			ѭ����������
			while(rs.next()){
				CarBrand c = new CarBrand();
				c.setId(rs.getInt("id"));
				c.setBrand_name(rs.getString("brand_name"));
				c.setAplha_code(rs.getString("aplha_code"));
				c.setQuantity(rs.getInt("quantity"));
				c.setLogo(rs.getString("logo"));
				carbrandList.add(c);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.getInstance().free(conn,stmt,rs);
		}
		
		return carbrandList;
	}

	
}
