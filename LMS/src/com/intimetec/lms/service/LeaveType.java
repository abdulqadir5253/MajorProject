package com.intimetec.lms.service;

public class LeaveType {
	public String[] getReason(String reason) {
		
		String leaves[] = new String[2];
		
		// 0 index: LeaveAvl 
		// 1 index: LeaveTaken
		
		if (reason.equals("casual")) {
			leaves[0] = "casualLeaveAvl";
			leaves[1] = "casualLeaveTaken";
					
		}

		else if (reason.equals("parental")) {
			leaves[0] = "parentalLeaveAvl";
			leaves[1] = "parentalLeaveTaken";

		} else if (reason.equals("earned")) {
			leaves[0] = "earnedLeaveAvl";
			leaves[1] = "earnedLeaveTaken";

		}

		else if (reason.equals("withouyPay")) {
			leaves[0] = "leaveWitoutPayAvl";
			leaves[1] = "leaveWitoutPayTaken";

		} else if (reason.equals("maternity")) {
			leaves[0] = "maternityLeaveAvl";
			leaves[1] = "maternityLeaveTaken";

		} else if (reason.equals("sick")) {
			leaves[0] = "sickLeaveAvl";
			leaves[1] = "sickLeaveTaken";

		}
		else if(reason.equals("duty")){
			leaves[0] = "sickLeaveAvl";
			leaves[1] = "dutyLeaveTaken";
		}

		return leaves;
	}
}
