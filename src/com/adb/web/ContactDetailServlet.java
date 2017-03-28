package com.adb.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adb.business.ContactService;
import com.adb.model.Contact;

/**
 * Servlet implementation class ContactDetailServlet
 */
@WebServlet("/contactdetail.do")
public class ContactDetailServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contactId = request.getParameter("id");
		System.out.println("Received contactId:"+contactId);
		
		ContactService contactService = new ContactService();
		Contact contact = contactService.getContact(Integer.parseInt(contactId));
		request.setAttribute("contact", contact);
		request.getRequestDispatcher("/contactdetail.jsp").forward(request, response);
	}

}
