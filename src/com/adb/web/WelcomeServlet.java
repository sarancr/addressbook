package com.adb.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.adb.business.ContactService;
import com.adb.model.Contact;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/welcome.do")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if(session == null ||  session.getAttribute("logonId") == null){
			request.setAttribute("message", "User session has time out. Please login again.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		int userId = (Integer) session.getAttribute("userId");
		
		//Generate Welcome Page
		ContactService contactService = new ContactService();
		List<Contact> contacts  = contactService.getAllContacts(userId);
		request.setAttribute("contacts", contacts);
		request.getRequestDispatcher("/welcome.jsp").forward(request, response);
	}

}
