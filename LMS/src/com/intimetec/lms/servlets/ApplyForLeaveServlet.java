package com.intimetec.lms.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.intimetec.lms.dao.ApplyForLeavesDao;
import com.intimetec.lms.excptn.ExcessLeavesException;
import com.intimetec.lms.pojo.UserInput;
import com.intimetec.lms.service.LeaveValidation;

@WebServlet("/ApplyForLeave")
public class ApplyForLeaveServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String designation = (String)session.getAttribute("desgination");
		
		if(designation.equals("lead"))
			request.getRequestDispatcher("leadLeaveMenuJSP.jsp").forward(request, response);
		else
			request.getRequestDispatcher("executiveLeaveMenuJSP.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String username = session.getAttribute("username").toString();
		
		UserInput userInput = new UserInput();
		
		String leaveType = request.getParameter("typeOfLeave");
		String fromDateStr = request.getParameter("fromDate");
		String toDateStr = request.getParameter("toDate");

		Date fromDate = Date.valueOf(fromDateStr);
		Date toDate = Date.valueOf(toDateStr);
		
		long diffInMillies = Math.abs(toDate.getTime() - fromDate.getTime());
		int noOfDays = (int) TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		
		userInput.setTypeOfLeave(request.getParameter("typeOfLeave"));
		userInput.setFromDate(fromDate);
		userInput.setToDate(toDate);
		userInput.setNoOfDays(noOfDays);
			
		if (fromDate.compareTo(toDate) > 0) {
			request.getRequestDispatcher("applyForLeavesJSP.jsp").forward(request, response);
		}

		else if (new LeaveValidation().noOfDaysValidation(username, leaveType, noOfDays)) {
			System.out.println("ApplyForLeaveServlet: " + noOfDays);
			new ApplyForLeavesDao().insertLeave(userInput, username);
			request.getRequestDispatcher("executiveLeaveMenuJSP.jsp").forward(request, response);
		}
		
		else{
			try {
				throw new ExcessLeavesException("Low Leaves Availability");
			} catch (ExcessLeavesException e) {
				// TODO Auto-generated catch block
				request.getRequestDispatcher("applyForLeavesJSP.jsp").forward(request, response);
				System.out.println(e);
			}
		}
	}

}
