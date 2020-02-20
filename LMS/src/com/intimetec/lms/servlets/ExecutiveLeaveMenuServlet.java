package com.intimetec.lms.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.intimetec.lms.dao.AllLeaveOfExecutiveDao;
import com.intimetec.lms.pojo.UserLeaveApplication;

@WebServlet("/ExecutiveLeaveMenu")
public class ExecutiveLeaveMenuServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String username = session.getAttribute("username").toString();

		if (request.getParameter("applyForLeave") != null) {
			request.getRequestDispatcher("applyForLeavesJSP.jsp").forward(request, response);
		}

		else if (request.getParameter("checkLeaveStatus") != null) {
			List<UserLeaveApplication> allLeaveData = new AllLeaveOfExecutiveDao().getAllLeaveData(username);
			request.setAttribute("allLeaveData", allLeaveData);
			request.getRequestDispatcher("checkLeaveStatusJSP.jsp").forward(request, response);
		}
	}
}
