package com.intimetec.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.intimetec.lms.dbConnection.ConnectDatabase;

import com.intimetec.lms.pojo.UserLeaveApplication;

public class PendingLeavesDataDao {
	public List<UserLeaveApplication> getLeavesData(String username){
		List<UserLeaveApplication> UserLeaveApplications = new ArrayList<UserLeaveApplication>();
		
		Connection connection = new ConnectDatabase().getConnection();
		
		try {
			PreparedStatement pendingLeavesPrpdSmnt = connection.prepareStatement(
					"Select * from leaveApplication where status = 0 and username != ?");			
			pendingLeavesPrpdSmnt.setString(1, username);			
			
			ResultSet pendingLeavesResultSet = pendingLeavesPrpdSmnt.executeQuery();
			while(pendingLeavesResultSet.next()){
				UserLeaveApplication userLeaveApplication = new UserLeaveApplication();
				userLeaveApplication.setFromDate(pendingLeavesResultSet.getDate("fromDate"));
				userLeaveApplication.setToDate(pendingLeavesResultSet.getDate("toDate"));
				userLeaveApplication.setLeaveType(pendingLeavesResultSet.getString("leaveType"));
				userLeaveApplication.setLeaveId(pendingLeavesResultSet.getInt("leaveId"));
				userLeaveApplication.setUsername(pendingLeavesResultSet.getString("username"));
				UserLeaveApplications.add(userLeaveApplication);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return UserLeaveApplications;
	}
}


