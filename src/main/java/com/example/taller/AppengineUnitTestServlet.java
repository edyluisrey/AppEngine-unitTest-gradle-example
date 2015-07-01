package com.example.taller;

import java.io.IOException;
import javax.servlet.http.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class AppengineUnitTestServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
			UserService userService = UserServiceFactory.getUserService();
	        User user = userService.getCurrentUser();        
	        if (user != null) {
	        	String email= user.getEmail();
	        	resp.getWriter().print(email);
	        }
	        else {
	            resp.sendRedirect(userService.createLoginURL(req.getRequestURI()));
	        }
	}
}
