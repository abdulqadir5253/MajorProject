package com.intimetec.lms.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectDatabase {
	
	public Connection getConnection(){
		
		Properties configurations = new ReadConfigurations().getConfigurations();
		
		try {
			Class.forName(configurations.getProperty("driver"));			
			Connection connection=DriverManager.getConnection(  
					configurations.getProperty("url"),
					configurations.getProperty("username"),
					configurations.getProperty("password"));  				
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}  						
		return null;
	}
}
