package com.adb.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adb.business.ContactService;

/**
 * Servlet implementation class DeleteContactServlet
 */
@WebServlet("/deletecontact.do")
public class DeleteContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contactId = request.getParameter("id");
		ContactService service = new ContactService();
		service.deleteContact(Integer.parseInt(contactId));
		request.getRequestDispatcher("/welcome.do").forward(request, response);
	}

}
