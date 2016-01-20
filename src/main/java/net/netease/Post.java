package net.netease;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Post extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		 // 设置响应内容类型
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

	      PrintWriter out = response.getWriter();
		  String title = "Using GET Method to Read Form Data";
	      String docType =
	      "<!doctype html public \"-//w3c//dtd html 4.0 " +
	      "transitional//en\">\n";
	      out.println(docType +
	                "<html>\n" +
	                "<head><title>" + title + "</title></head>\n" +
	                "<body bgcolor=\"#f0f0f0\">\n" +
	                "<h1 align=\"center\">" + title + "</h1>\n" +
	                "<ul>\n" +
	                "  <li><b>名字</b>："
	                + new String(request.getParameter("first_name").getBytes("iso-8859-1"),"UTF-8") + "\n" +
	                "  <li><b>姓氏</b>："
	                + new String(request.getParameter("last_name").getBytes("iso-8859-1"), "UTF-8") + "\n" +
	                "</ul>\n" +
	                "</body></html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
