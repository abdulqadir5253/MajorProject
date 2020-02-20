package com.intimetec.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.intimetec.lms.dbConnection.ConnectDatabase;
import com.intimetec.lms.service.LeaveType;

public class LeavesAvlDao {
	public int getLeavesAvl(String username, String leaveType) {

		Connection connection = new ConnectDatabase().getConnection();			

		try {
			
			System.out.println("In LeavesAvlDao");
			
			PreparedStatement leavesAvlPrpdStmnt = connection
					.prepareStatement("select * from userLeaveInfo where username=?");					
			
//			getLeaveAvl.setString(1, leaveType);
			leavesAvlPrpdStmnt.setString(1, username);			
			
			
			
			ResultSet leavesAvlResultSet = leavesAvlPrpdStmnt.executeQuery();			

			leavesAvlResultSet.first();				
			
			return leavesAvlResultSet.getInt(leaveType); 
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return 0;
	}

}
