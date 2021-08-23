package com.muvi.qa.testcases;

import java.awt.AWTException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.muvi.qa.base.TestBase;


import com.muvi.qa.pages.MyAccountHomePage;
import com.muvi.qa.pages.SignUpPage;
import com.muvi.qa.util.TestUtil;

public class SignUpPageTest extends TestBase{
	
	MyAccountHomePage MyAccountHomePage;
	TestUtil testUtil;
	SignUpPage SignUpPage;
	
	String sheetName = "SignUp";
	
	public SignUpPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		SignUpPage = new SignUpPage();
		MyAccountHomePage = new MyAccountHomePage();
		//MyAccountHomePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@DataProvider
	public Object[][] getMuviTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	
	@Test(priority=1,dataProvider="getMuviTestData")
	public void SignUpMoviPage(String Name,String CompanyName,String Phone, String Email,String Password, String DomainName) throws AWTException, InterruptedException {
		if (SignUpPage.VerifyFreeTrialButtonExist()) {
			SignUpPage.ClickOnTheFreeTrialButton();
		}
		MyAccountHomePage = SignUpPage.SignUpMuvi(Name, CompanyName, Phone, Email, Password, DomainName);
		MyAccountHomePage.ManageWelcomePopUps();
		MyAccountHomePage.GoToContentLibrary();
		MyAccountHomePage.AddContentLibrary();
	    MyAccountHomePage.VerifyMyContentLibrary();
		
		
	}
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
