package com.intimetec.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.intimetec.lms.dbConnection.ConnectDatabase;

public class FetchEmployeeInfoDao {
	public ResultSet getEmployeeInfo(String username){
		Connection connection = new ConnectDatabase().getConnection();
		ResultSet employeeInfoResultSet = null;
		try {			
			PreparedStatement employeeInfoPrpdStmnt = connection.prepareStatement(""
					+ "select username, password, designation from employee where username=?");
			employeeInfoPrpdStmnt.setString(1, username);
			
			employeeInfoResultSet = employeeInfoPrpdStmnt.executeQuery();
		}
		catch(Exception e){
			
		}
		
		return employeeInfoResultSet;
	}
}
