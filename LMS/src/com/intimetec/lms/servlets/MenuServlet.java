package com.intimetec.lms.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("markAttendance") != null){
			request.getRequestDispatcher("markAttendanceJSP.jsp").forward(request, response);
		}
		else if(request.getParameter("manageLeave") != null){
			HttpSession session = request.getSession();
			String designation = session.getAttribute("designation").toString();
			if(designation.equals("executive"))
				request.getRequestDispatcher("executiveLeaveMenuJSP.jsp").forward(request, response);
			else if(designation.equals("lead"))
				request.getRequestDispatcher("leadLeaveMenuJSP.jsp").forward(request, response);
			else if(designation.equals("manager"))
				request.getRequestDispatcher("managerLeaveMenuJSP.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
