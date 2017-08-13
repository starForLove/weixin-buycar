package com.dfbz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class JDBCUtil {
 
	private static JDBCUtil instance = null;
	private final static String URL = "jdbc:mysql://localhost:3306/carshop?useUnicode=true&characterEncoding=utf8";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "fr5123500";
	
	//˽�е���ι�����
	private JDBCUtil(){}
	
	//��̬��
	static {
	
			try {//������ݿ����
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
	}
	 //	��̬�������� �����ڻ�ȡ��ǰ���Ψһʵ��
	public static JDBCUtil getInstance(){
		if(instance==null){
			//�ӳټ��أ��ڵ�һ��ʹ�øõ����ʱ��Ż�ʵ������������Ҫ���ǲ������⣬���Ը�ǰ�����
			//��ʵ�κ�һ���࣬������һ��Class������������Ӧ�������Class�����У�������ʵ�����ʱ����Ҫ�Ļ���Ϣ��
			//A.class  ��ʵ���ص���һ����A��Class������newһ��A����ʱ��Ҫͨ��A.class�����ȡʵ�����ʱ����Ҫ�Ļ���Ϣ��������ס��A.class���޷�
			//���������ʵ�����
			//jvm��java�ļ������class�ļ�������������ʱ�õ��ĸ�class�ļ��Ż�����ĸ�class�ļ������غ�����ڴ浱�еõ�һ��.class����Ȼ����.class����ȥ������������ж���

			synchronized (JDBCUtil.class) {
				if(instance == null){
					instance = new JDBCUtil();
				}
			}
		}
		
		return instance;
	}
	
	
	
//	���ڻ�ȡConnection����ķ���
	public Connection getConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
//	���ڽ�����Դ�ͷŵķ���
	public void free(Connection conn,Statement stmt,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
}
