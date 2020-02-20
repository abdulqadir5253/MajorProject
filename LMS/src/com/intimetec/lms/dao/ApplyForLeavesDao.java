package com.intimetec.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.intimetec.lms.dbConnection.ConnectDatabase;
import com.intimetec.lms.pojo.UserInput;


public class ApplyForLeavesDao {
			
	public void insertLeave (UserInput userInput, String username){
		
		Connection connection = new ConnectDatabase().getConnection();
		try {					
			PreparedStatement insertLeavePrpdStmnt = connection.prepareStatement("insert into leaveApplication (username, status, leaveType, fromDate, toDate) values(?, 0, ?, ?, ?)");
			insertLeavePrpdStmnt.setString(1, username);
			insertLeavePrpdStmnt.setString(2, userInput.getTypeOfLeave());
			insertLeavePrpdStmnt.setDate(3, userInput.getFromDate());
			insertLeavePrpdStmnt.setDate(4, userInput.getToDate());			
			insertLeavePrpdStmnt.executeUpdate();
			
			System.out.println("Application Sent!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
