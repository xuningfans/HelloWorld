package net.netease;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class showError extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest reuquest, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(407, "Need authentication!!!");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}
	
}
