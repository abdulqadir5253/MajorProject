package com.intimetec.lms.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.intimetec.lms.dao.PendingLeavesDataDao;
import com.intimetec.lms.pojo.UserLeaveApplication;


@WebServlet("/ManagerMenu")
public class ManagerMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		System.out.println("Inside ManagerMenuServlet");
		System.out.println("ans: "+request.getParameter("manageExecutiveLeave"));
		
		if(request.getParameter("manageExecutiveLeave") != null){
			System.out.println("ManagerMenuServlet Inside If");
			List<UserLeaveApplication> allPendingApplication  = new PendingLeavesDataDao().getLeavesData(username);
			request.setAttribute("allPendingApplication", allPendingApplication);
			request.getRequestDispatcher("displayPendingLeavesJSP.jsp").forward(request, response);
		}
		
		else if(request.getParameter("creditDebitLeave") != null){
			System.out.println("ManagerMenuServlet Inside If else");
		}
	}


}
