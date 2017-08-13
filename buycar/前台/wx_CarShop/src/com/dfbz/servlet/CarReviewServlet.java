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

import com.dfbz.bean.CarReview;
import com.dfbz.services.CarReviewService;
import com.dfbz.services.CarReviewServiceImpl;

public class CarReviewServlet extends HttpServlet {

	CarReviewService CarReviewService = new CarReviewServiceImpl();
	public CarReviewServlet() {
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
			showCarReviewList(request,response);
			break;
		case 1:
			loadMoreList(request,response);
			break;
		default:
			break;
		}
	}
	private void loadMoreList(HttpServletRequest request,
			HttpServletResponse response) {
		String sid = null;
		String id = null;
		String table =null;
		try {
			sid = new String(request.getParameter("sid").getBytes("ISO8859-1"),"UTF-8");
			id = new String(request.getParameter("id").getBytes("ISO8859-1"),"UTF-8");
			table = new String(request.getParameter("table").getBytes("ISO8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int vid = Integer.parseInt(sid);
		int rid = Integer.parseInt(id);
		List<CarReview> carReviewList = CarReviewService.LoadMore(rid,vid,table);
		String resultString="{\"ret\":0}";
		if(carReviewList!=null){
			String json = JSONArray.fromObject(carReviewList).toString(); 
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


	private void showCarReviewList(HttpServletRequest request,
			HttpServletResponse response) {
		String sid = null;
		String table = null;
		try {
			sid = new String(request.getParameter("id").getBytes("ISO8859-1"),"UTF-8");
			table = new String(request.getParameter("table").getBytes("ISO8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int id = Integer.parseInt(sid);
		List<CarReview> carReviewList = CarReviewService.showCarReviewList(id,table);
		String resultString="{\"ret\":0}";
		if(carReviewList!=null){
			String json = JSONArray.fromObject(carReviewList).toString(); 
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
