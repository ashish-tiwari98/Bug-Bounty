public package com.bts.controller;

import java.io.IOException;
import java.io.PrintWriter;

class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException{

        String email = req.getParameter("umail");
        String role = req.getParameter("urole");

        User u = new User();
        u.setEmail(email);
        u.setRole(role);

        PrintWriter out = res.getWriter();

        BugTrackingBo btbo = new BugTrackingBoImpl();
        bool status = btbo.showRegStatus();

        if(bool){

            out.println("<br>User Resgistered Sucessfully");
            RequestDispatcher rd1 = req.getRequestDispatcher("login.html");
            rd1.include(req, res);
        }
        else{
            out.println("<br>User not found");
			RequestDispatcher rd2=request.getRequestDispatcher("register.html");
			rd2.include(req, res);
        }

        out.close();
    }
}