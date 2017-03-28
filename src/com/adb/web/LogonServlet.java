package com.adb.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.adb.business.AuthenticationService;


/**
 * Servlet implementation class LogonServlet
 */
//@WebServlet(description = "LogonServlet To Validate User", urlPatterns = { "/logon.do" })
public class LogonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public LogonServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String logonId  = request.getParameter("logonName");
		String passwd = request.getParameter("password");
		
		System.out.println("Logon : "  + logonId + "   Password: " + passwd);
		
		AuthenticationService authService = new AuthenticationService();
		int userId = authService.isValid(logonId, passwd);
		
		if(userId > 0){
			
			//Create a NEW Session and you can use it.
			HttpSession session = request.getSession(true);
			session.setAttribute("logonId", logonId);
			session.setAttribute("userId", userId);
			
			request.getRequestDispatcher("/welcome.do").forward(request, response);
			
		}else{
			System.out.println("LogonId:" + logonId + " and password: xxxxxx"  +" is NOT valid");
			request.setAttribute("message", "Logon Id / Password is not valid. Please retry.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
		
	}

}
