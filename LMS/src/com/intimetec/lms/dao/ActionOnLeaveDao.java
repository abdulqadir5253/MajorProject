package com.intimetec.lms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import com.intimetec.lms.dbConnection.ConnectDatabase;

public class ActionOnLeaveDao {
	public void approveApplication(int leaveId) {
		Connection connection = new ConnectDatabase().getConnection();
		try {

			PreparedStatement approveQueryPrpdStmnt = connection.prepareStatement(
					"select * from leaveApplication where leaveId=?");
			approveQueryPrpdStmnt.setInt(1, leaveId);
			ResultSet approveQueryResultSet = approveQueryPrpdStmnt.executeQuery();

			approveQueryResultSet.first();

			String username = approveQueryResultSet.getString("username");
			String leaveType = approveQueryResultSet.getString("leaveType");
			Date fromDate = approveQueryResultSet.getDate("fromDate");
			Date toDate = approveQueryResultSet.getDate("toDate");
			
			// --Updating the UserLeaveInfo Table
			int newLeaveAvl = getLeavesAvl(username, leaveType, fromDate, toDate);

			PreparedStatement updateLeavesPreparedStmnt = connection
					.prepareStatement("update userLeaveInfo set "+leaveType+" = ? where username=? ");
			
			updateLeavesPreparedStmnt.setInt(1, newLeaveAvl);
			updateLeavesPreparedStmnt.setString(2, username);
			
			updateLeavesPreparedStmnt.executeUpdate();		
			
			// -- Updating the LeaveApplication Table

			PreparedStatement updateStatusPreparedStmnt = connection.prepareStatement(
					"update leaveApplication set status=1 where leaveId=?");
			updateStatusPreparedStmnt.setInt(1, leaveId);
			
			updateStatusPreparedStmnt.executeUpdate();
			
			System.out.println("Application Approved");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void cancelApplication(int leaveId){
		Connection connection = new ConnectDatabase().getConnection();
		try{
			PreparedStatement cancelQueryPrpdStmnt = connection.prepareStatement(
					"update leaveApplication set status = -1 where leaveId = ?");
			cancelQueryPrpdStmnt.setInt(1, leaveId);
			
			cancelQueryPrpdStmnt.executeUpdate();
		}
		catch(SQLException e){
			
		}
	}
	
	public int getLeavesAvl(String username, String leaveType, Date fromDate, Date toDate) {
		Connection con = new ConnectDatabase().getConnection();
		try {
			PreparedStatement leaveAvlPreparedStmnt = con.prepareStatement("select * from userLeaveInfo where username=?");
			leaveAvlPreparedStmnt.setString(1, username);
			
			ResultSet leaveAvlResultSet = leaveAvlPreparedStmnt.executeQuery();
			
			leaveAvlResultSet.first();
			
			long diffInMillies = Math.abs(toDate.getTime() - fromDate.getTime());
			int noOfDays = (int) TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
						
			int oldLeaveAvl = leaveAvlResultSet.getInt(leaveType);
			
			return oldLeaveAvl-noOfDays;
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
