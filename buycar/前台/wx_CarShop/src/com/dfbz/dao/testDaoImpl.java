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
		String s = "�µ�A4L";
		t.show(s);
		
		
	}
	public List<CarInfo> show(String car_name) {
		List<CarInfo> al = new ArrayList<CarInfo>();
		Connection conn = null;//Connection���������ݿ�����ӣ���ӵ�д���SQL���ķ���������ɻ�����SQL����
		PreparedStatement pstm = null;
		ResultSet rs = null;//������Statement��PreparedStatement��executeQuery������SELECT�Ľ�������൱����������ȡ���ݿ���ÿ�е�ֵ��
		try {
			conn = JDBCUtil.getInstance().getConnection();//��ȡ���ݿ����Ӷ���
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
			JDBCUtil.getInstance().free(conn,pstm,null);//������Ҫ����Դ�ͷ�
		}
		
		
		return al;
		
	}
}
