package com.intimetec.lms.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.intimetec.lms.dao.ActionOnLeaveDao;

@WebServlet("/DisplayPendingLeave")
public class DisplayPendingLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int leavesId = Integer.parseInt(request.getParameter("leaveId"));
		

		if (request.getParameter("approve") != null) {
			new ActionOnLeaveDao().approveApplication(leavesId);			
			request.getRequestDispatcher("managerLeaveMenuJSP.jsp").forward(request, response);
			
		}

		else if (request.getParameter("cancel") != null) {
			new ActionOnLeaveDao().cancelApplication(leavesId);
			request.getRequestDispatcher("managerLeaveMenuJSP.jsp").forward(request, response);
		}
	}

}
