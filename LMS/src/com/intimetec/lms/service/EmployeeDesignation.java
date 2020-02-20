package com.intimetec.lms.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.intimetec.lms.dao.FetchEmployeeInfoDao;

public class EmployeeDesignation {
	public String getDesignation(String username){
		String designation = null;
		
		ResultSet resultSet = new FetchEmployeeInfoDao().getEmployeeInfo(username);
		
		try {
			resultSet.first();
			designation = resultSet.getString("designation");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return designation;
	}
}
