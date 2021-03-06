package net.netease;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		OutputStream out=response.getOutputStream();
		//out.write(data.getBytes());

		  String title = "使用 GET 方法读取表单数据";
	      String docType =
	      "<!doctype html public \"-//w3c//dtd html 4.0 " +
	      "transitional//en\">\n";
	      out.write((docType +
	                "<html>\n" +
	                "<head><title>" + title + "</title>"+
	                "</head>\n" +
	                "<body bgcolor=\"#f0f0f0\">\n" +
	                "<h1 align=\"center\">" + title + "</h1>\n" +
	                "<ul>\n" +
	                "  <li><b>名字</b>："
	                + request.getParameter("first_name") + "\n" +
	                "  <li><b>姓氏</b>："
	                + new String(request.getParameter("last_name").getBytes("iso-8859-1"),"UTF-8") 
	                + "\n" +
	                "</ul>\n" +
	                "</body></html>").getBytes());
	      
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("destroy");
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init");
		super.init();
	}

}
