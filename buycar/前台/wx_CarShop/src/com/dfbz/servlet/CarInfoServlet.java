package com.dfbz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.dfbz.bean.Car;
import com.dfbz.bean.CarInfo;
import com.dfbz.services.CarInfoService;
import com.dfbz.services.CarInfoServiceImpl;
import com.dfbz.services.CarKindServices;
import com.dfbz.services.CarKindServicesImpl;

public class CarInfoServlet extends HttpServlet {

	CarInfoService carInfoService=new CarInfoServiceImpl();
	public CarInfoServlet() {
		super();
	}


	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	String method = request.getParameter("method");
		
		switch (Integer.parseInt(method)) {
		case 0:
			showCarInfo1(request,response);
		
			break;
		case 1:showCarInfo2(request,response);
			
			break;
		default:
			break;
		}
	}

	
	private void showCarInfo2(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException, IOException {
		String car_name;
		String year;
		car_name = new String(request.getParameter("car_name").getBytes("ISO8859-1"),"UTF-8");
		//year=new String (request.getParameter("year").getBytes("ISO8859-1"),"UTF-8");
		List<CarInfo> carList = carInfoService.showCarInfo2(car_name);
		
		String resultString="{\"ret\":0}";
		if(carList!=null){
			String json = JSONArray.fromObject(carList).toString(); 
			resultString="{\"ret\":1,\"data\":"+json+"}";
		}
		if(!resultString.isEmpty())
		{	//设置HTTP返回的状态值
			response.setStatus(200);
			//Content-Type的作用是让服务器告诉浏览器它发送的数据属于什么文件类型。当Content-Type 的值设置为text/html和text/plain时,前者会让浏览器把接收到的实体内容以HTML格式解析,后者会让浏览器以普通文本解析.
			response.setHeader("Content-type","text/html;charset=UTF-8");
			//response.setHeader("Cache-Control", "no-cache");
			response.getOutputStream().write(resultString.getBytes("utf-8"));
		}
		
	}

	private void showCarInfo1(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException, IOException {
		String car_name;
		String year;
		String condition;
		car_name = new String(request.getParameter("car_name").getBytes("ISO8859-1"),"UTF-8");
		year=new String (request.getParameter("year").getBytes("ISO8859-1"),"UTF-8");
		condition=new String (request.getParameter("condition").getBytes("ISO8859-1"),"UTF-8");
		List<CarInfo> carList = carInfoService.showCarInfo1(car_name,year,condition);
		
		String resultString="{\"ret\":0}";
		if(carList!=null){
			String json = JSONArray.fromObject(carList).toString(); 
			resultString="{\"ret\":1,\"data\":"+json+"}";
		}
		if(!resultString.isEmpty())
		{	//设置HTTP返回的状态值
			response.setStatus(200);
			//Content-Type的作用是让服务器告诉浏览器它发送的数据属于什么文件类型。当Content-Type 的值设置为text/html和text/plain时,前者会让浏览器把接收到的实体内容以HTML格式解析,后者会让浏览器以普通文本解析.
			response.setHeader("Content-type","text/html;charset=UTF-8");
			//response.setHeader("Cache-Control", "no-cache");
			response.getOutputStream().write(resultString.getBytes("utf-8"));
		}
		
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
