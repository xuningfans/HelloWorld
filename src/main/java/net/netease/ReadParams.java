package net.netease;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadParams
 */
@WebServlet("/ReadParams")
public class ReadParams extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置响应内容类型
	      response.setCharacterEncoding("UTF-8");
	      response.setContentType("text/html;charset=UTF-8");

	      PrintWriter out = response.getWriter();
		  String title = "读取所有的表单数据";
	      String docType =
	      "<!doctype html public \"-//w3c//dtd html 4.0 " +
	      "transitional//en\">\n";
	      out.println(docType +
	        "<html>\n" +
	        "<head><title>" + title + "</title></head>\n" +
	        "<body bgcolor=\"#f0f0f0\">\n" +
	        "<h1 align=\"center\">" + title + "</h1>\n" +
	        "<table width=\"100%\" border=\"1\" align=\"center\">\n" +
	        "<tr bgcolor=\"#949494\">\n" +
	        "<th>参数名称</th><th>参数值</th>\n"+
	        "</tr>\n");

	      Enumeration<String> paramNames = request.getParameterNames();
	      
	      while(paramNames.hasMoreElements()) {
	         String paramName = (String)paramNames.nextElement();
	         out.print("<tr><td>" + paramName + "</td>\n<td>");
	         String[] paramValues =
	                request.getParameterValues(paramName);
	         // 读取单个值的数据
	         if (paramValues.length == 1) {
	           String paramValue = /*new String(*/paramValues[0]/*.getBytes("iso-8859-1"),"UTF-8")*/;
	           if (paramValue.length() == 0)
	             out.println("<i>No Value</i>");
	           else
	             out.println(paramValue);
	         } else {
	             // 读取多个值的数据
	             out.println("<ul>");
	             for(int i=0; i < paramValues.length; i++) {
	                out.println("<li>" + paramValues[i]);
	             }
	             out.println("</ul>");
	         }
	      }
	      out.println("</tr>\n</table>\n</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
