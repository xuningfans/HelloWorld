package net.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter {
    @Override
    public void destroy() {
        // do nothing
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException,
            ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //response.setContentType("text/html;charset=UTF-8");
        filterChain.doFilter(request, response);
        
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    	
    }
}
