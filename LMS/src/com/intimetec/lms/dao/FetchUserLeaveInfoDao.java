package com.intimetec.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.intimetec.lms.dbConnection.ConnectDatabase;

public class FetchUserLeaveInfoDao {
	public ResultSet getLeavesinfo(String username){
		
		Connection connection = new ConnectDatabase().getConnection();
		ResultSet executeQuery;
		try {
			PreparedStatement getLeavesInfo = connection.prepareStatement("Select * from leaves where username = ? order by leavesAvl ASC");
			getLeavesInfo.setString(1, username);
			executeQuery = getLeavesInfo.executeQuery();			
			
			return executeQuery;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
