package com.OrangeHRM;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCases {
	@BeforeClass
	public static void startLog() throws Throwable {
		LogFile.openLogFile("D:\\Vikram Selenium\\7.LogFile\\AllTestResult.txt");
	}
	
	@AfterClass
	public static void StopLog() throws Throwable {
		LogFile.closeLogfile();
	}
	
	@Test
	public void user_Login() throws Throwable {
		ProjectLibrary.open_Browser();
		ProjectLibrary.access_Application();
		ProjectLibrary.user_Login();
		ProjectLibrary.user_Logout();
		ProjectLibrary.close_Browser();
		LogFile.writeIntoLogFile("+++++++++++++++++++++++++++++");
	}

	@Test
	public void add_Employee() throws Throwable {
		ProjectLibrary.open_Browser();
		ProjectLibrary.access_Application();
		ProjectLibrary.user_Login();
		ProjectLibrary.add_Employee();
		ProjectLibrary.user_Logout();
		ProjectLibrary.close_Browser();
		LogFile.writeIntoLogFile("+++++++++++++++++++++++++++++");
		
	}

	//@Ignore
	@Test
	public void delete_Employee() throws Throwable {
		ProjectLibrary.open_Browser();
		ProjectLibrary.access_Application();
		ProjectLibrary.user_Login();
		ProjectLibrary.delete_Employee();
		ProjectLibrary.user_Logout();
		ProjectLibrary.close_Browser();
		LogFile.writeIntoLogFile("+++++++++++++++++++++++++++++");

	}

	
	
}
