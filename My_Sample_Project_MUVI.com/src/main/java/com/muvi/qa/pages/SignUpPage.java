package com.muvi.qa.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.muvi.qa.base.TestBase;

public class SignUpPage extends TestBase{
	
	
	MyAccountHomePage MyAccountHomePage;
	
	@FindBy(xpath = "//*[@id=\"navbar\"]/ul/div[2]/a/button")
	@CacheLookup
	WebElement FreeTrial;
	
	@FindBy(xpath = "//*[@id=\"name\"]")
	@CacheLookup
	WebElement Name;
	
	@FindBy(xpath = "//*[@id=\"companyname\"]")
	@CacheLookup
	WebElement CompanyName;
	
	@FindBy(xpath = "//*[@id=\"userinfo\"]/div[3]/input")
	@CacheLookup
	WebElement Phone;
	
	
	@FindBy(xpath = "//*[@id=\"email\"]")
	@CacheLookup
	WebElement EMail;
	

	@FindBy(xpath = "//*[@id=\"inputPassword\"]")
	@CacheLookup
	WebElement Password;
	
	@FindBy(xpath = "//*[@id=\"subdomain\"]")
	@CacheLookup
	WebElement DomainName;
	
	@FindBy(xpath = "//html/body/div[3]/main/section[1]/div/div/div[2]/div/form/div[7]/div/input")
	@CacheLookup
	WebElement IAgreeCheckBox;
	
	@FindBy(xpath = "//html/body/div[3]/main/section[1]/div/div/div[2]/div/form/button")
	@CacheLookup
	WebElement NextBubbton1;
	
	@FindBy(xpath = "//html/body/div[3]/main/section[1]/div/div/div[3]/div[1]/form/div[7]/button")
	@CacheLookup
	WebElement NextBubbton2;
	
	
	
	
	@FindBy(xpath = "//*[@id=\"updateTemplate\"]/div[4]/div[2]/div/div[1]/div")
	@CacheLookup
	WebElement SelectPlatform;
	
	@FindBy(xpath = "//*[@id=\"updateTemplate\"]/div[6]/div[2]/div/img")
	@CacheLookup
	WebElement SelectSubscription;
	
		
	
	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean VerifyFreeTrialButtonExist() {
		return FreeTrial.isDisplayed();
	}
	
	public void ClickOnTheFreeTrialButton() {
		FreeTrial.click();
	}
	
	public MyAccountHomePage SignUpMuvi(String Name, String CompanyName, String Phone, String Email, String Password, String DomainName) {
		
		Random rand = new Random();
		int rand_int1 = rand.nextInt(1000);
		Name = Name.substring(0,4) + rand_int1;
		this.Name.sendKeys(Name);
		this.CompanyName.clear();
		this.CompanyName.sendKeys(CompanyName);
		this.Phone.sendKeys(Phone);
		int rand_int2 = rand.nextInt(1000);
		Email = Email.substring(0,4) + rand_int2 + Email.substring(4,Email.length());
		this.EMail.sendKeys(Email);
		this.Password.sendKeys(Password);
		int rand_int3 = rand.nextInt(1000);
		DomainName = DomainName.substring(0,4) + rand_int3 + DomainName.substring(4,DomainName.length());
		this.DomainName.click();
		this.DomainName.clear();
		this.DomainName.sendKeys(DomainName);
		
		JavascriptExecutor Executor = (JavascriptExecutor)driver;  
		Executor.executeScript("arguments[0].click();", IAgreeCheckBox);
		Executor.executeScript("arguments[0].click();", NextBubbton1);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(SelectPlatform));
		
		String  attr = SelectPlatform.getAttribute("class");
		
		if(attr.contains("_selected")) {
			SelectPlatform.click();
			SelectPlatform.click();
		}
		
		driver.navigate().refresh();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/div[3]/main/section[1]/div/div/div[3]/div[1]/form/div[7]/button")));
		
		Executor.executeScript("arguments[0].click();", NextBubbton2);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new MyAccountHomePage();
	}

}
