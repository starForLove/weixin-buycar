package com.dfbz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.Line;

import com.dfbz.bean.CarBrand;
import com.dfbz.bean.topLine;
import com.dfbz.jdbc.JDBCUtil;
import com.mysql.jdbc.Statement;
import com.sun.mail.imap.protocol.Item;

public class topLineDaoImpl implements topLineDao{

	@Override
	public List<topLine> getTopLines() {
		List<topLine> list= null;
		Connection conn=null;
		Statement stmt = null;
		ResultSet rs =null;
		try {
			list = new ArrayList<topLine>();
			conn = JDBCUtil.getInstance().getConnection();
			stmt = (Statement) conn.createStatement();
			String sql = "select * from article ORDER BY topId DESC LIMIT 0,5";//查询brand表中所有用户信息的SQL语句
			rs = stmt.executeQuery(sql);
//			循环处理结果集
			while(rs.next()){
				topLine top = new topLine();
				top.setTopId(rs.getInt("topId"));
				top.setTopCont(rs.getString("topCont"));
				top.setTopTitle(rs.getString("topTitle"));
				top.setTopBrowes(rs.getInt("topBrowes"));
				top.setTopTime(rs.getString("topTime"));
				top.setPicture(rs.getString("topPicture"));
				list.add(top);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.getInstance().free(conn,stmt,rs);
		}
		return list;
	
	}
	public List<topLine> loadMore(int id) {
		List<topLine> list=null;
		
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null;
		try {
			list = new ArrayList<topLine>();
			conn = JDBCUtil.getInstance().getConnection();
			stmt = (Statement) conn.createStatement();
			String sql = "select * from article ORDER BY topId DESC LIMIT "+id+",5";
			rs = stmt.executeQuery(sql);

			while(rs.next()){
				topLine top = new topLine();
				top.setTopId(rs.getInt("topId"));
				top.setTopCont(rs.getString("topCont"));
				top.setTopTitle(rs.getString("topTitle"));
				top.setTopBrowes(rs.getInt("topBrowes"));
				top.setTopTime(rs.getString("topTime"));
				top.setPicture(rs.getString("topPicture"));
				list.add(top);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.getInstance().free(conn,stmt,rs);
		}
		
		return list;
	}

	
	
	public void checkId(int id){
		Connection conn=null;
		Statement stmt1 = null;
		ResultSet rs =null;
		int	rs1 =0;
				
		try {
			//update article t set t.topBrowes=(select a.topBrowes+1  from ( select  topBrowes from 
			//article where topId="+id+") a) where t.topId"+id;//查询brand表中所有用户信息的SQL语句
			conn = JDBCUtil.getInstance().getConnection();
			stmt1 = (Statement) conn.createStatement();
			String sql = "update article t set t.topBrowes=(select a.topBrowes+1  from ( select  topBrowes from article where topId="+id+") a) where t.topId="+id;
		    rs1 = stmt1.executeUpdate(sql);
			
			
			//循环处理结果集
			//while(rs.next()){
//				topLine line = new topLine();
//				line.setTopId(rs.getInt("topId"));
//				line.setTopCont(rs.getString("topCont"));
//				line.setTopTitle(rs.getString("topTitle"));
//				line.setTopBrowes(rs.getInt("topBrowes")+1 );
//				line.setTopTime(rs.getString("topTime"));
//				line.setPicture(rs.getString("topPicture"));
//			    return line;
//			} 
			
			
				
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.getInstance().free(conn,stmt1,rs);
			
		}
		
		
	}
//	public void insert(int id){
//		Connection conn = JDBCUtil.getConnection();
//		PreparedStatement stmt = null;
//		ResultSet rs =null;
//		topLine top = new topLine();
//		
//		String sql="update article t set t.topBrowes=? where t.topId=" +id;
//		try {
//			stmt = conn.prepareStatement(sql);
//			 stmt.setInt(1, top.getTopId());
//			 stmt.setString(2, top.getTopCont());
//			 stmt.setString(3, top.getTopTime());
//			 stmt.setInt(4, top.getTopBrowes());
//			 stmt.setString(5, top.getTopTime());
//			 stmt.setString(6, top.getPicture());
//			 int i=stmt.executeUpdate();
//			 System.out.println(i);
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	public static void main(String[] args) {
		topLineDaoImpl dao = new topLineDaoImpl();
	    topLine top = new topLine();
	    dao.checkId(2);
	    
	    
		
	}
	
}
