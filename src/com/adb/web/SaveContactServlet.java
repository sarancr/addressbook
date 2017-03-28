package com.adb.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.adb.business.ContactService;
import com.adb.model.Contact;

/**
 * Servlet implementation class SaveContactServlet
 */
@WebServlet("/savecontact.do")
public class SaveContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session == null ||  session.getAttribute("logonId") == null){
			request.setAttribute("message", "User session has time out. Please login again.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		int userId = (Integer) session.getAttribute("userId");
		
		
		Contact contact = new Contact();
		String contactId = request.getParameter("id");
		if(!request.getParameter("id").isEmpty()){ // Id will be empty for add contact case
			contact.setId(Integer.parseInt(contactId));
		}
		contact.setFirstname(request.getParameter("firstname"));
		contact.setLastname(request.getParameter("lastname"));
		contact.setAddress(request.getParameter("address"));
		contact.setEmail(request.getParameter("email"));
		contact.setPhone(request.getParameter("phone"));
		contact.setUserId(userId);
		
		ContactService service = new ContactService();
		if(contactId == null || contactId.isEmpty()){
			service.insert(contact); // Add new contact
		}else{
			service.update(contact); // Update existing contact
		}
		
		
		request.getRequestDispatcher("/welcome.do").forward(request, response);
		
	}

}
