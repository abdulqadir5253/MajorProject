package com.intimetec.lms.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.intimetec.lms.authenticate.UserAuthentication;
import com.intimetec.lms.service.EmployeeDesignation;

@WebServlet("/LoginCheck")
public class LoginCheckServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("userName");
		String password = request.getParameter("passWord");

		HttpSession session = request.getSession();

		request.setAttribute("invalidValidation", "");

		System.out.println("LoginCheckServlet: " + username);

		if (new UserAuthentication().userValidation(username, password)) {
			String designation = new EmployeeDesignation().getDesignation(username);

			session.setAttribute("designation", designation);
			session.setAttribute("username", username);

			String message;

			if (designation.equals("executive")) {
				message = "executive";
				response.getWriter().write(message);
			}

			else if (designation.equals("lead")) {
				message = "lead";				
				response.getWriter().write(message);
			}

			else if (designation.equals("manager")){
				message = "manager";
				response.getWriter().write(message);
			}
		}

		else {
			String text = "error";
			response.getWriter().write(text);
		}
	}

}
