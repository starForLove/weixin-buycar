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

import com.dfbz.bean.CarBrand;
import com.dfbz.dao.CarBrandDaoImpl;
import com.dfbz.services.CarBrandService;
import com.dfbz.services.CarBrandServiceImpl;

public class CarBrandServlet extends HttpServlet {

	CarBrandService carBrandService=new CarBrandServiceImpl();

	public CarBrandServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
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
			showCarBrand(request,response);
			break;
		case 1:
			askPrice(request,response);
			break;
		default:
			break;
		}
	}

	private void askPrice(HttpServletRequest request,
			HttpServletResponse response) {

		
	}

	private void showCarBrand(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException, IOException {
		List<CarBrand> carBrandList = carBrandService.showCarBrand();
		String resultString="{\"ret\":0}";
		if(carBrandList!=null){
			String json = JSONArray.fromObject(carBrandList).toString(); 
			resultString="{\"ret\":1,\"data\":"+json+"}";
		}
		if(!resultString.isEmpty())
		{	//����HTTP���ص�״ֵ̬
			response.setStatus(200);
			//Content-Type���������÷�������������������͵���������ʲô�ļ����͡���Content-Type ��ֵ����Ϊtext/html��text/plainʱ,ǰ�߻���������ѽ��յ���ʵ��������HTML��ʽ����,���߻������������ͨ�ı�����.
			response.setHeader("Content-type","text/html;charset=UTF-8");
			//response.setHeader("Cache-Control", "no-cache");
			response.getOutputStream().write(resultString.getBytes("utf-8"));
		}
	}

	public void init() throws ServletException {
	
	}

}
