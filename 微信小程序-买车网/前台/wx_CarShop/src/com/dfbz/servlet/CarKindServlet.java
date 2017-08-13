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
import com.dfbz.bean.CarBrand;
import com.dfbz.dao.CarBrandDaoImpl;
import com.dfbz.services.CarBrandService;
import com.dfbz.services.CarBrandServiceImpl;
import com.dfbz.services.CarKindServices;
import com.dfbz.services.CarKindServicesImpl;

public class CarKindServlet extends HttpServlet {

	CarKindServices carKindService=new CarKindServicesImpl();

	public CarKindServlet() {
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
			showCarKind(request,response);
			//showCarQuantity(request,response);
			
		case 1:
			
			break;
		default:
			break;
		}
	}

	private void showCarKind(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException, IOException {
		List<Car> carList = carKindService.showCarKind();
		System.out.println(carList.size());
		String resultString="{\"ret\":0}";
		if(carList!=null){
			String json = JSONArray.fromObject(carList).toString(); 
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
	
	private void showCarQuantity(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException, IOException {
		List<Car> carList = carKindService.showCarQuantity();
		String resultString="{\"ret\":0}";
		if(carList!=null){
			String json = JSONArray.fromObject(carList).toString(); 
			resultString="{\"ret\":1,\"quantity\":"+json+"}";
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
