package com.intimetec.lms.testCases;

import static org.junit.Assert.*;
import org.junit.Test;

import com.intimetec.lms.authenticate.UserAuthentication;

public class ValidateTest {

	@Test
	public void test() {
		UserAuthentication validLogin = new UserAuthentication();
		assertTrue(validLogin.userValidation("abdul.qadir", "1616"));		
	}	
	
	

}
