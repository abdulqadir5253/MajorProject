package com.intimetec.lms.dbConnection;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class ReadConfigurations {
	public Properties getConfigurations() {

		Properties propertyFile = new Properties();
		try {
			propertyFile.load(
					new FileInputStream("C:\\Users\\abdul.qadir\\workspace\\LMS\\configuration.properties"));
			return propertyFile;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		return null;
	}
}
