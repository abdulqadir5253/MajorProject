package com.intimetec.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.intimetec.lms.dbConnection.ConnectDatabase;

public class CheckLeaveStatusDao {
	public int getLeaveStatus(int leaveId){
		
		// Get Connection
		Connection connection = new ConnectDatabase().getConnection();
		int status = 2;		
		try {
			PreparedStatement statusPrpdStmnt = connection.prepareStatement("select status from leaves where leaveId = ?");
			statusPrpdStmnt.setInt(1, leaveId);
			ResultSet statusResultSet = statusPrpdStmnt.executeQuery();
			if( !statusResultSet.first()){
				System.out.println("No Such Leave ID Exists");
			}
			else{
				status = statusResultSet.getInt("status");
				if(status == -1)
					System.out.println("Application Cancelled");
				else if(status == 0)
					System.out.println("Application Pending For Approval");
				else if(status == 1)
					System.out.println("Application Approved!");
				
			}
			return status;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
}
