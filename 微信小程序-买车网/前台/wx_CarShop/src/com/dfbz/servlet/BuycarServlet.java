package com.dfbz.servlet;

import java.io.IOException;

import java.io.UnsupportedEncodingException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dfbz.services.ConfigurationService;
import com.dfbz.services.ConfigurationServiceimpl;

import net.sf.json.JSONArray;



import com.dfbz.bean.CarBrand;
import com.dfbz.bean.ConfigurationBean;





public class BuycarServlet extends HttpServlet {

	





	public BuycarServlet() {
		super();
	}

	
	public void destroy() {
		super.destroy(); 
			}
    public void init() throws ServletException {
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        doPost(request, response);
       		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    String method=new String(request.getParameter("method").getBytes("ISO8859-1"),"utf-8") ;
		    
		    System.out.println(method);

		int m=Integer.parseInt(method);
		switch (m) {

		case 3:
			showCarConfig(request,response);
			break;
		
		default:
			break;
		}
		
		
	
	}


	
	
		private void showCarConfig(HttpServletRequest request,HttpServletResponse response){
			ConfigurationService Config=new ConfigurationServiceimpl();
			String resultString="{\"ret\":0}";
			List<ConfigurationBean> carConfigList = null;
			try {
				 String id1 = new String(request.getParameter("id").getBytes("ISO8859-1"),"utf-8");
				 int id=Integer.parseInt(id1);
				 carConfigList = Config.showcarConfiguration(id);
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		   
			
			if(carConfigList!=null){
				String json = JSONArray.fromObject(carConfigList).toString(); 
				resultString="{\"ret\":1,\"data\":"+json+"}";
				System.out.print(resultString);
			}
			if(!resultString.isEmpty())
			{	//设置HTTP返回的状态值
				response.setStatus(200);
				//Content-Type的作用是让服务器告诉浏览器它发送的数据属于什么文件类型。当Content-Type 的值设置为text/html和text/plain时,前者会让浏览器把接收到的实体内容以HTML格式解析,后者会让浏览器以普通文本解析.
				response.setHeader("Content-type","text/html;charset=UTF-8");
				//response.setHeader("Cache-Control", "no-cache");
				try {
					response.getOutputStream().write(resultString.getBytes("utf-8"));
				} catch (Exception e) {
					
					e.printStackTrace();
				} 
			}
		}


			
		
	
	
		
	 
		
	}

	


