package com.intimetec.lms.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.intimetec.lms.dao.CheckLeaveStatusDao;


@WebServlet("/CheckLeaveStatusServlet")

public class CheckLeaveStatusServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int leaveId = Integer.parseInt(request.getParameter("leaveId")); 
		
		int getStatus = new CheckLeaveStatusDao().getLeaveStatus(leaveId);
		String status = null;
		if(getStatus == -1)
			status = "Application Cancelled";
		else if(getStatus == 1)
			status = "Application Approved";
		else if(getStatus == -0)
			status = "Pending For Approval";
			
		
		System.out.println(status);
		
		request.setAttribute("status", status);
		request.getRequestDispatcher("checkLeaveStatusJSP.jsp").forward(request, response);
	}

}
