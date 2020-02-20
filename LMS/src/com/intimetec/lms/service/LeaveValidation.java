package com.intimetec.lms.service;

import com.intimetec.lms.dao.LeavesAvlDao;

public class LeaveValidation {
	public boolean noOfDaysValidation(String username, String reason, int noOfDays){
		int getLeaveAvl = new LeavesAvlDao().getLeavesAvl(username, reason);
		if(reason.equals("duty"))
			return true;
		else if(getLeaveAvl >= noOfDays)
			return true;
		return false;
		
	}
}
