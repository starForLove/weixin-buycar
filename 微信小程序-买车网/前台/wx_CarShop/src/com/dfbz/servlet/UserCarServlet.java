package com.dfbz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.dfbz.bean.userCar;
import com.dfbz.services.UserCarService;
import com.dfbz.services.UserCarServiceImpl;

public class UserCarServlet extends HttpServlet {
    
	/**
	 * Constructor of the object.
	 */
	public UserCarServlet() {
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
				getMessage(request,response);
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
		public void getMessage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    UserCarService service = new UserCarServiceImpl();
			int carId;
			String address;
			
			carId = Integer.parseInt(request.getParameter("carId"));
			address = new String(request.getParameter("address").getBytes("ISO8859-1"),"UTF-8");
			System.out.println("carid:"+carId +";" +"address:"+address);
			List<userCar> list = service.findCar(carId, address);
			System.out.println(list);
			String sl = JSONArray.fromObject(list).toString();
						
			String res ="{\"ret\":1,\"objlist\":"+sl+"}";
			//String res ="{\"ret\":1,\"str\":\"asdffgd\"}";
			//String res ="{\"ret\":1,\"str\":\"asdffgd\",\"list\":[1,\"asd\",{\"aaa\":232}]}";
			System.out.println(res);
			//返回状态码
			response.setStatus(200);
			//设定返回的数据格式
			response.setHeader("Content-type", "text/html;charset=UTF-8");
			//把返回值以流的形式返回给页面
			response.getOutputStream().write(res.getBytes("UTF-8"));
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
