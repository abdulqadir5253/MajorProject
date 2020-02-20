package com.intimetec.lms.authenticate;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.intimetec.lms.dao.FetchEmployeeInfoDao;

public class UserAuthentication {
	
	public boolean userValidation(String username, String password){
		
		
			ResultSet results = new FetchEmployeeInfoDao().getEmployeeInfo(username);
			
			try {
				if( !results.first()){
					System.out.println("Incorrect Username!");
					return false;
				}
				else{
					
					String actualPassword =  results.getString("password");
					if(actualPassword.equals(password)){
						System.out.println("Desgination: "+results.getString("designation"));
						return true;				
					}
					else
						System.out.println("Incorrect Password");
						return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
		return false;
	}
}
