package com.dfbz.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dfbz.bean.CarVideo;
import com.dfbz.bean.CarViewImage;
import com.dfbz.jdbc.JDBCUtil;

public class CarViewPictureDaoImpl implements CarViewPictureDao{

	@Override
	public List<CarViewImage> getImageUrl(String flag,String car_model) {
		List<CarViewImage> carImageList=null;
		//ʹ��JDBC�޸Ļ�ȡ�����û���Ϣ�ķ�ʽ
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null;
		try {
			carImageList = new ArrayList<CarViewImage>();
			conn = JDBCUtil.getInstance().getConnection();
			stmt = conn.createStatement();
			String sql = "select * from viewpicture where flag=\""+flag+"\" and car_model=\""+car_model+"\"";
			rs = stmt.executeQuery(sql);

			while(rs.next()){
				CarViewImage c = new CarViewImage();
				c.setId(rs.getInt("id"));
				c.setFlag(rs.getString("flag"));
				c.setImage_url(rs.getString("image_url"));
				c.setCar_model(rs.getString("car_model"));
				
				carImageList.add(c);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.getInstance().free(conn,stmt,rs);
		}

		return carImageList;
	}

}
