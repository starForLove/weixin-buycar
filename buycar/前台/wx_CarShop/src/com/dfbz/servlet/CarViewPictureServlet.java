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
import com.dfbz.bean.CarViewImage;
import com.dfbz.services.CarVideoService;
import com.dfbz.services.CarVideoServiceImpl;
import com.dfbz.services.CarViewPictureService;
import com.dfbz.services.CarViewPictureServiceImpl;

public class CarViewPictureServlet extends HttpServlet {

	CarViewPictureService carViewPictureService = new CarViewPictureServiceImpl();
	public CarViewPictureServlet() {
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
			getImageUrlList(request,response);
			break;
		default:
			break;
		}
	}




	private void getImageUrlList(HttpServletRequest request,
			HttpServletResponse response) {
		String sid = null;
		String car_model = null;
		try {
			sid = new String(request.getParameter("flag").getBytes("ISO8859-1"),"UTF-8");
			car_model = new String(request.getParameter("car_model").getBytes("ISO8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<CarViewImage> carImageList = carViewPictureService.getImageUrl(sid,car_model);
		String resultString="{\"ret\":0}";
		if(carImageList!=null){
			String json = JSONArray.fromObject(carImageList).toString(); 
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
		// Put your code here
	}

}
