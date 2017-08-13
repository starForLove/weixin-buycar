package com.dfbz.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.PUBLIC_MEMBER;

import net.sf.json.JSONArray;

import com.dfbz.bean.topLine;
import com.dfbz.dao.topLineDaoImpl;
import com.dfbz.services.CarAticleService;

public class CarArticleServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CarArticleServlet() {
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
			getHotLine(request,response);
			break;
		case 1:
			getHotID(request,response);
			break;
		case 3:
			//showHotLine(request,response);
		case 4:
			loadMoreList(request,response);
		default:
			break;
		}
		
	}
	public void getHotLine(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		topLineDaoImpl impl =new topLineDaoImpl();
	    List<topLine> list = new ArrayList<topLine>();
	    list = impl.getTopLines();
	    String jsonString = JSONArray.fromObject(list).toString();
        System.out.println(jsonString);
        
        String res ="{\"ret\":1,\"obj\":"+jsonString+"}";
        System.out.println(res);
		//返回状态码
		response.setStatus(200);
		//设定返回的数据格式
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		//把返回值以流的形式返回给页面
		response.getOutputStream().write(res.getBytes("UTF-8"));
	}
	public void getHotID(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<topLine> list = new ArrayList<topLine>();
		topLineDaoImpl impl =new topLineDaoImpl();
	    String id= request.getParameter("id");
	    System.out.println("id="+id);
	    impl.checkId(Integer.parseInt(id));
	    list = impl.getTopLines();
	    String jsonString = JSONArray.fromObject(list).toString();
        System.out.println(jsonString);
        
        String res ="{\"ret\":1,\"obj\":"+jsonString+"}";
        System.out.println(res);
		//返回状态码
		response.setStatus(200);
		//设定返回的数据格式
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		//把返回值以流的形式返回给页面
		response.getOutputStream().write(res.getBytes("UTF-8"));
	    
	    
	}
//	public void showHotLine(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		topLineDaoImpl impl =new topLineDaoImpl();
//	    List<topLine> list = new ArrayList<topLine>();
//	    list = impl.showTopLines();
//		String resultString="{\"ret\":0}";
//		
//	    String json = JSONArray.fromObject(list).toString(); 
//		resultString="{\"ret\":1,\"data\":"+json+"}";
//		System.out.println("json"+resultString);
//		response.setStatus(200);
//			response.setHeader("Content-type","text/html;charset=UTF-8");
//			try {
//				response.getOutputStream().write(resultString.getBytes("utf-8"));
//			} catch (UnsupportedEncodingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		
//	}
	private void loadMoreList(HttpServletRequest request,
			HttpServletResponse response) {
		String sid = null;
		try {
			sid = new String(request.getParameter("id").getBytes("ISO8859-1"),"UTF-8");
			System.out.println("sid:"+sid);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int id = Integer.parseInt(sid);
		topLineDaoImpl impl =new topLineDaoImpl();
	    List<topLine> list = new ArrayList<topLine>();
	    list=impl.loadMore(id);
		String resultString="{\"ret\":0}";
		
			String json = JSONArray.fromObject(list).toString(); 
			resultString="{\"ret\":1,\"data\":"+json+"}";
		
		
			
			try {
				response.setStatus(200);
				response.setHeader("Content-type","text/html;charset=UTF-8");
				response.getOutputStream().write(resultString.getBytes("utf-8"));
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
