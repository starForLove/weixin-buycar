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
import com.dfbz.bean.TopLinePage;
import com.dfbz.services.TopLinePageService;
import com.dfbz.services.TopLinePageServiceImpl;
import com.dfbz.services.TopLinePageService;

public class TopLinePageServlet extends HttpServlet {

	TopLinePageService topLinePageService = new TopLinePageServiceImpl();
	public TopLinePageServlet() {
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
			showPage(request,response);
			break;
		default:
			break;
		}
	}
	private void showPage(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String sid = null;
		try {
			sid = new String(request.getParameter("id").getBytes("ISO8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int id = Integer.parseInt(sid);
		TopLinePage toplinepage = topLinePageService.getPage(id);
		String resultString="{\"ret\":0}";
		if(toplinepage!=null){
			String json = JSONArray.fromObject(toplinepage).toString(); 
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
