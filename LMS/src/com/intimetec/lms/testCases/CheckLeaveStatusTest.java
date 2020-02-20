package com.intimetec.lms.testCases;

import static org.junit.Assert.*;

import org.junit.Test;

import com.intimetec.lms.dao.CheckLeaveStatusDao;

public class CheckLeaveStatusTest {

	@Test
	public void test() {
		CheckLeaveStatusDao testingStatus = new CheckLeaveStatusDao();
		// 1 value is returned if status is checked without any exception
		// 0 value when checking status is not checked correctly.
		assertEquals(1, testingStatus.getLeaveStatus(1010));
		System.out.println("Checking status Correctly");
	}

}
