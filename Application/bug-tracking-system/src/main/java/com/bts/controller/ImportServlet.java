package com.bts.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bts.bo.BugTrackingBO;
import com.bts.bo.BugTrackingBOImpl;
import com.bts.model.User;

@WebServlet("/import")
public class ImportServlet extends HttpServlet {
	@Override 
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException{
		String name = req.getParameter("name");
		String role = req.getParameter("type");
		String email = req.getParameter("email");
		
		User user = new User();
		user.setName(name);
		user.setRole(role);
		user.setEmail(email);
		
		BugTrackingBO bbo = new BugTrackingBOImpl();
		bbo.importUsers(user);
	}
}
