package com.intimetec.lms.testCases;

import static org.junit.Assert.*;

import org.junit.Test;

import com.intimetec.lms.dbConnection.ConnectDatabase;

public class ConnectDatabaseTest {

	@Test
	public void test() {
		ConnectDatabase testingConnection = new ConnectDatabase();
				
		assertEquals("com.mysql.cj.jdbc.ConnectionImpl", testingConnection.getConnection().getClass().getName());	
		System.out.println("Connection is good");		
	}

}
