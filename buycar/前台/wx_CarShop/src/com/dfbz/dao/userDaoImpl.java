package com.dfbz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.mail.Flags.Flag;

import com.dfbz.bean.User;
import com.dfbz.jdbc.JDBCUtil;
import com.mysql.jdbc.Statement;


public class userDaoImpl implements userDao{

	@Override
	public boolean checkUser(String username) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stmt = null;
		ResultSet rs =null;
		boolean flag = false;
     try {
			
			conn = JDBCUtil.getInstance().getConnection();
			stmt = (Statement) conn.createStatement();
			String sql = "select username from user where username='"+username+"'";		
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				flag=true;
			}
			else{
				flag=false;
			}
		
		
		
     } catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.getInstance().free(conn,stmt,rs);
		}
	return flag;
	}
	
	
//	public static void main(String[] args) {
//		userDao dao =new userDaoImpl();
//		boolean flag ;
//		flag = dao.checkUser("发");
//		System.out.println(flag);
//		
//	}
	
	
	@Override
	public int insertUser(String userName, String userPhone) {
		// TODO Auto-generated method stub
		Connection conn=null;
		//Statement stmt = null;
		PreparedStatement stmt = null;
		int rs =0;
		boolean flag = false;
		ResultSet res = null;
		try {
			conn = JDBCUtil.getInstance().getConnection();
			
			//stmt = (Statement) conn.createStatement();
			String sql = "insert  into user(username,phone) value(?,?)";
			stmt =  conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, userName);
			stmt.setString(2, userPhone);
			rs = stmt.executeUpdate();
			System.out.println("rs:"+rs);
			res = stmt.getGeneratedKeys();
			
			 int num = -1;
            if(res.next())
            {
                num = res.getInt(1);
                return num;
            }
	         System.out.println("num:"+num);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   return 0;
		
	}

	
	
//	public static void main(String[] args) {
//		userDao dao =new userDaoImpl();
//		boolean flag ;
//		flag = dao.insertUser("李四", "123456");
//		System.out.println(flag);
//		
//    }  
	
	

	@Override
	public int checkUserID(String username) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		User user = new User();
		int userid=0;
		try {
			conn = JDBCUtil.getInstance().getConnection();
			
			//stmt = (Statement) conn.createStatement();
			String sql = "select id from  user where username =?";
			stmt =  conn.prepareStatement(sql);
			stmt.setString(1, username);
			res  =stmt.executeQuery();
			if(res.next()){
				
				user.setUserId(res.getInt("id"));
			}
			
			userid = user.getUserId();
			
		 } catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.getInstance().free(conn,stmt,res);
			}
		
		
		return userid;
	}
	  
	
//	public static void main(String[] args) {
//	userDao dao =new userDaoImpl();
//    int id=0 ;
//	id = dao.checkUserID("彭佑华");
//	System.out.println(id);
//	
//}


	
	

}