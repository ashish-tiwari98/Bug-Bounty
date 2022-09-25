public package com.bts.controller;

import java.io.IOException;

class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException{

        String email = req.getParameter("umail");
        String role = req.getParameter("urole");

        User u = new User();
        u.setEmail(email);
        u.setRole(role);

        BugTrackingBo btbo = new BugTrackingBoImpl();
        bool status = btbo.showRegStatus();

        if(bool){
            //return to login servlet
        }
        else{
            //raise msg
        }
    }
}