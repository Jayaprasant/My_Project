package com.muvi.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.muvi.qa.base.TestBase;
import com.muvi.qa.pages.MyAccountHomePage;
import com.muvi.qa.util.TestUtil;

public class MyAccountHomePageTest extends TestBase {
	
	MyAccountHomePage MyAccountHomePage;
	TestUtil testUtil;
	

	public MyAccountHomePageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		MyAccountHomePage = new MyAccountHomePage();
		
	}
	
	
	@Test(priority=1)
	public void ManageWelcomePopUps(){
		MyAccountHomePage.ManageWelcomePopUps();
	}
	
	@Test(priority=2)
	public void GoToContentLibrary(){
		MyAccountHomePage.GoToContentLibrary();
	}
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
