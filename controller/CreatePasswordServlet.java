package com.bts.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bts.bo.BugTrackingBO;
import com.bts.bo.BugTrackingBOImpl;

@WebServlet("/createpassword")
public class CreatePasswordServlet extends HttpServlet {
	@Override 
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException{
		String password = req.getParameter("password");
		BugTrackingBO bbo = new BugTrackingBOImpl();
		String status = bbo.createPassword(password);
		//return status to front end
	}
}
