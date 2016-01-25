package net.netease;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//	清除Cookies
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		for(int i=0; cookies!=null && i <cookies.length; i++){
			cookies[i].setMaxAge(0);
			response.addCookie(cookies[i]);
		}
		ServletOutputStream out = response.getOutputStream();
		request.getSession(false).invalidate();
		out.write("清除成功！".getBytes());
		request.getRequestDispatcher("\\SessionTrack").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
