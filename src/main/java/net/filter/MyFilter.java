package net.filter;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter {

    
	public void destroy() {
		System.out.println("MyFilter.destroy()");
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 // 获取客户机的 IP 地址   
	      String ipAddress = request.getRemoteAddr();
	      DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	      // 记录 IP 地址和当前时间戳
	      System.out.println("IP "+ ipAddress + ", Time "
	                                       + df.format(new Date()));

	      // 把请求传回过滤链
	      chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("MyFilter.init()");
	}

}
