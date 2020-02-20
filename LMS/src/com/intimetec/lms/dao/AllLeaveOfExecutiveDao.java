package com.intimetec.lms.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.intimetec.lms.dbConnection.ConnectDatabase;
import com.intimetec.lms.pojo.UserLeaveApplication;

public class AllLeaveOfExecutiveDao {
	public List<UserLeaveApplication> getAllLeaveData(String username){
		List<UserLeaveApplication> allLeaveData = new ArrayList<UserLeaveApplication>();
		
		Connection connection = new ConnectDatabase().getConnection();
		
		try {
			PreparedStatement leaveDataPrpdStmnt = connection.prepareStatement("select * from leaveApplication where username=?");
			leaveDataPrpdStmnt.setString(1, username);
			
			ResultSet leaveDataResultSet = leaveDataPrpdStmnt.executeQuery();
			while(leaveDataResultSet.next()){
				UserLeaveApplication userLeaveApplication = new UserLeaveApplication();
				
				userLeaveApplication.setLeaveType(leaveDataResultSet.getString("leaveType"));
				userLeaveApplication.setFromDate(leaveDataResultSet.getDate("fromDate"));
				userLeaveApplication.setToDate(leaveDataResultSet.getDate("toDate"));
				
				
				
				int status = leaveDataResultSet.getInt("status");
				if(status == 0)
					userLeaveApplication.setStatus("Pending");
				else if(status == -1)
					userLeaveApplication.setStatus("Cancelled");
				else if(status == 1)
					userLeaveApplication.setStatus("Approved");
				allLeaveData.add(userLeaveApplication);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return allLeaveData;
	}
}
