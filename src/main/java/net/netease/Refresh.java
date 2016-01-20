package net.netease;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Refresh extends HttpServlet {
	private static final long serialVersionUID = 3720312748756586649L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置刷新自动加载时间为 5 秒
	      response.setIntHeader("Refresh", 5);
	 
	      // 设置响应内容类型
	      response.setCharacterEncoding("UTF-8");
	      response.setContentType("text/html;charset=UTF-8");
	 
	      // Get current time
	      Calendar calendar = new GregorianCalendar();
	      String am_pm;
	      int hour = calendar.get(Calendar.HOUR);
	      int minute = calendar.get(Calendar.MINUTE);
	      int second = calendar.get(Calendar.SECOND);
	      if(calendar.get(Calendar.AM_PM) == 0)
	        am_pm = "AM";
	      else
	        am_pm = "PM";
	 
	      String CT = hour+":"+ minute +":"+ second +" "+ am_pm;
	    
	      PrintWriter out = response.getWriter();
	      String title = "自动刷新 Header 设置";
	      String docType =
	      "<!doctype html public \"-//w3c//dtd html 4.0 " +
	      "transitional//en\">\n";
	      out.println(docType +
	        "<html>\n" +
	        "<head><title>" + title + "</title></head>\n"+
	        "<body bgcolor=\"#f0f0f0\">\n" +
	        "<h1 align=\"center\">" + title + "</h1>\n" +
	        "<p>当前时间是：" + CT + "</p>\n");
	}
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}

}
