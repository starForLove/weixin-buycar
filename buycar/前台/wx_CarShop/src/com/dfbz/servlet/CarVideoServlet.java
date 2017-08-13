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

import com.dfbz.bean.CarVideo;
import com.dfbz.services.CarVideoService;
import com.dfbz.services.CarVideoServiceImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class CarVideoServlet extends HttpServlet {
//	CarBrandService carBrandService=new CarBrandServiceImpl();
	CarVideoService carVideoService = new CarVideoServiceImpl();
	public CarVideoServlet() {
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
			showCarVideoList(request,response);
			break;
		case 1:
			getVideoInfo(request,response);
			break;

		case 2:
			loadMoreList(request,response);
			break;
		default:
			break;
		}
	}




	private void loadMoreList(HttpServletRequest request,
			HttpServletResponse response) {
		String sid = null;
		try {
			sid = new String(request.getParameter("id").getBytes("ISO8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int id = Integer.parseInt(sid);
		List<CarVideo> carVideoList = carVideoService.loadMore(id);
		String resultString="{\"ret\":0}";
		if(carVideoList!=null){
			String json = JSONArray.fromObject(carVideoList).toString(); 
			resultString="{\"ret\":1,\"data\":"+json+"}";
		}
		if(!resultString.isEmpty())
		{	
			response.setStatus(200);
			response.setHeader("Content-type","text/html;charset=UTF-8");
			try {
				response.getOutputStream().write(resultString.getBytes("utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	private void getVideoInfo(HttpServletRequest request,
			HttpServletResponse response) {
		String sid = null;
		try {
			sid = new String(request.getParameter("id").getBytes("ISO8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int id = Integer.parseInt(sid);
		List<CarVideo> carVideoList = carVideoService.getCarVideos(id);
		String resultString="{\"ret\":0}";
		if(carVideoList!=null){
			String json = JSONArray.fromObject(carVideoList).toString(); 
			resultString="{\"ret\":1,\"data\":"+json+"}";
		}
		if(!resultString.isEmpty())
		{	
			response.setStatus(200);
			response.setHeader("Content-type","text/html;charset=UTF-8");
			try {
				response.getOutputStream().write(resultString.getBytes("utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	private void showCarVideoList(HttpServletRequest request,
			HttpServletResponse response) {
		List<CarVideo> carVideoList = carVideoService.showCarVideoList();
		String resultString="{\"ret\":0}";
		if(carVideoList!=null){
			String json = JSONArray.fromObject(carVideoList).toString(); 
			resultString="{\"ret\":1,\"data\":"+json+"}";
		}
		if(!resultString.isEmpty())
		{	
			response.setStatus(200);
			response.setHeader("Content-type","text/html;charset=UTF-8");
			try {
				response.getOutputStream().write(resultString.getBytes("utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public void init() throws ServletException {
	
	}

}
