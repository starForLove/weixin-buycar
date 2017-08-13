package com.dfbz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dfbz.bean.CarVideo;
import com.dfbz.bean.TopLinePage;
import com.dfbz.jdbc.JDBCUtil;

public class TopLinePageDaoImpl implements TopLinePageDao{

	@Override
	public TopLinePage getPage(int id) {
		TopLinePage topLinePage=null;
		//ʹ��JDBC�޸Ļ�ȡ�����û���Ϣ�ķ�ʽ
		Connection conn = null;
		PreparedStatement ps = null;
		Statement  stmt = null;
		ResultSet rs = null;
		try {
		
			conn = JDBCUtil.getInstance().getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT id,topCont,topTitle,page,topTime,topHead FROM article,article_page WHERE article.topId=article_page.id AND topId="+id;
			
			
			
			rs = stmt.executeQuery(sql);

			while(rs.next()){
				TopLinePage c = new TopLinePage();
				c.setId(rs.getInt("id"));
				c.setPage(rs.getString("page"));
				c.setAuthor(rs.getString("topTitle"));
				c.setAuthoricon(rs.getString("topHead"));
				c.setToptime(rs.getString("topTime"));
				c.setToptitle(rs.getString("topCont"));
				topLinePage = c;
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.getInstance().free(conn,stmt,rs);
		}
		
		return topLinePage;
	}

}
