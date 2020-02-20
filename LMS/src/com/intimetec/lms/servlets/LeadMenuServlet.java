package com.intimetec.lms.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LeadMenu")
public class LeadMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("applyForLeave") != null) {
			request.getRequestDispatcher("applyForLeavesJSP.jsp").forward(request, response);
		} else if (request.getParameter("checkLeaveStatus") != null) {
			request.getRequestDispatcher("checkLeaveStatusJSP.jsp").forward(request, response);
		} else if (request.getParameter("manageExecutiveLeaves") != null) {
			request.getRequestDispatcher("checkLeaveStatusJSP.jsp").forward(request, response);
		} else if (request.getParameter("creditDebitLeave") != null) {
			request.getRequestDispatcher("checkLeaveStatusJSP.jsp").forward(request, response);
		}
	}

}
