package com.dfbz.dao;

public interface userDao {
	
    public boolean checkUser(String username);
    public int insertUser(String userName, String userPhone);
    public int checkUserID(String username);
   
}
