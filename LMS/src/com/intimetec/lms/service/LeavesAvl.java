package com.intimetec.lms.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.intimetec.lms.dao.FetchUserLeaveInfoDao;

public class LeavesAvl {
	public String getLeavesAvl(String username) {
		ResultSet resultSet = new FetchUserLeaveInfoDao().getLeavesinfo(username);
		
		try {
			resultSet.first();
			return resultSet.getString("leavesAvl");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
