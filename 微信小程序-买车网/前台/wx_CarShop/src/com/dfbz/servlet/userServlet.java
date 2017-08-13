package com.dfbz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dfbz.dao.askDao;
import com.dfbz.dao.askDaoImpl;
import com.dfbz.dao.userDao;
import com.dfbz.dao.userDaoImpl;

public class userServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public userServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method= request.getParameter("method");
        System.out.println("method="+method);
        switch (Integer.parseInt(method)) {
		case 0:
			findUser(request,response);
			break;
		case 1:
			//getHotID(request,response);
			break;
		case 3:
			//showHotLine(request,response);
		case 4:
			//loadMoreList(request,response);
		default:
			break;
		}
        
		
	}
    
	public void findUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  String userName=null;
		  String userPhone=null;
		  String shops =null;
		  int  carId =0;
		  int userId = 0;
		  String ret="{\"ret\":0}"; 
		  
		  carId = Integer.parseInt(request.getParameter("carid"));
		  userName=new String(request.getParameter("userName").getBytes("ISO8859-1"),"UTF-8");
		  userPhone=request.getParameter("userPhone"); 
		  shops = new String(request.getParameter("shops").getBytes("ISO8859-1"),"UTF-8");
		  String[] shopsList = shops.split(",");
		  
		  
		  System.out.println("carId:"+carId);
		  System.out.println("userName:"+userName);
		  System.out.println("userPhone:"+userPhone);
		  System.out.println("shops"+shopsList[0]);
		  
		  //调取方法
		  userDao dao = new userDaoImpl();
		  boolean flag = false;
		  int userID=0;
		 
		  flag = dao.checkUser(userName);
		  System.out.println("flaggggg"+flag);
		  if(flag){
			  //获取user的ID
			  userID = dao.checkUserID(userName);
			  askDao ask = new askDaoImpl();
			  for(int i = 0; i< shopsList.length;i++){
				  ask.insertAsk(userID, carId, shopsList[i]);
			  }
			  
			  
		  }
		  else{
			  System.out.println("flagqqqq:" + flag);
			  userID=dao.insertUser(userName,userPhone);
			  askDao ask = new askDaoImpl();
			  for(int i = 0; i< shopsList.length;i++){
				  ask.insertAsk(userID, carId, shopsList[i]);
			  }
			  //获取 userID
		  }
		  if(userId!=0){
			  
			  //调插入方法
			  ret="{\"ret\":}"; 
		  }
		  
		  
		  System.out.println(flag);

			try {
				response.setStatus(200);
				response.setHeader("Content-type","text/html;charset=UTF-8");
				response.getOutputStream().write(ret.getBytes("utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
	}
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
