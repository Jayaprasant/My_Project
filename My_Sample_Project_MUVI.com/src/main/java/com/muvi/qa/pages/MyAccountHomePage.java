package com.muvi.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.muvi.qa.base.TestBase;

public class MyAccountHomePage extends TestBase {

	@FindBy(xpath = "//*[@id=\"overlay-content\"]/div[1]/div[2]/div[1]/a")
	WebElement NextManageMetaData;

	@FindBy(xpath = "//*[@id=\"overlay-content\"]/div[2]/div[2]/div[1]/a[1]")
	WebElement NextContentLibrary;
	
	@FindBy(xpath = "//*[@id=\"overlay-content\"]/div[3]/div[2]/div[1]/a[1]")
	WebElement NextManageTemplate;
	

	@FindBy(xpath = "//*[@id=\"overlay-content\"]/div[4]/div[1]/div[1]/a[1]")
	WebElement OKGotIt;

	@FindBy(xpath = "//html/body/div[5]/div[1]/div/div[1]/ul/li[2]/a")
	WebElement ManageContent;
	
	@FindBy(xpath = "//html/body/div[5]/div[1]/div/div[1]/ul/li[2]/ul/li[1]/a")
	WebElement ContentLibrary; 
	
	@FindBy(xpath = "//*[@id=\"body_alert\"]/div[5]/div[3]/div[3]/div/a[1]/button")
	WebElement AddContent;
	
	@FindBy(xpath = "//*[@id=\"parent_content_type\"]")
	WebElement ContentForms;
	
	@FindBy(xpath = "//*[@id=\"mname\"]")
	WebElement ContentName;
	
	@FindBy(xpath = "//*[@id=\"release_date\"]")
	WebElement ReleaseDate;
	
	@FindBy(xpath = "//*[@id=\"story\"]")
	WebElement Story;

	@FindBy(xpath = "//*[@id=\"content_category_value\"]")
	WebElement ContentCatagory;
	
	@FindBy(xpath = "//*[@id=\"trailer_btn\"]")
	WebElement UploadPreview;
	
	@FindBy(xpath = "//*[@id=\"Upload_preview\"]/div/div/input[2]")
	WebElement UploadPreview1;
	
	@FindBy(xpath = "//*[@id=\"addvideo_popup\"]/div/div/div[3]/button")
	WebElement Close;
	
	@FindBy(xpath = "//*[@id=\"add_change-top-banner-text\"]")
	WebElement UploadBannr;
	
	@FindBy(xpath = "//*[@id=\"home1\"]/div/div/input[7]")
	WebElement UploadBannr1;
	
	@FindBy(xpath = "//*[@id=\"topbanner_submit_btn\"]")
	WebElement Save;
	
	
	
	@FindBy(xpath = "//*[@id=\"cast-and-crew-block\"]/div/div/div[2]/div/a")
	WebElement AddNewCast;
	
	
	@FindBy(xpath = "//*[@id=\"castname\"]")
	WebElement CastName;
	

	@FindBy(xpath = "//*[@id=\"ajaxshowtype\"]/button")
	WebElement CastType;
	
	@FindBy(xpath = "//*[@id=\"typeliidone\"]/label/span")
	WebElement Actor;
	
	
	@FindBy(xpath = "//*[@id=\"castncrewform\"]/div[3]/div[1]/div/div")
	WebElement UploadImage;
	
	
	@FindBy(xpath = "//*[@id=\"Upload-Video_\"]/div/div/input[1]")
	WebElement UploadImage1;
	
	
	@FindBy(xpath = "//*[@id=\"next\"]")
	WebElement Next;
	
	@FindBy(xpath = "//*[@id=\"add_btn\"]")
	WebElement AddButton;
	
	@FindBy(xpath = "//*[@id=\"save-btn\"]")
	WebElement SaveAndContinue;
	

	@FindBy(xpath = "//*[@id=\"body_alert\"]/div[5]/div[3]/div[4]/div/div/div[1]/span/i")
	WebElement FilterColumn;
	
	@FindBy(xpath = "//*[@id=\"search_content\"][@name= 'searchForm[search_text]']")
	WebElement SearchContent;
	
	@FindBy(xpath = "//*[@id=\"movie_list_tbl\"]/tbody/tr/td[1]/a/div[2]")
	WebElement ContentLibraryName;
	
	
	
	
	
	
	// Initializing the Page Objects:
	public MyAccountHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public void ManageWelcomePopUps() {
		NextManageMetaData.click();
		NextContentLibrary.click();
		NextManageTemplate.click();
		OKGotIt.click();
	}

	
	public void GoToContentLibrary(){
		Actions action = new Actions(driver);
		action.moveToElement(ManageContent).build().perform();
		ContentLibrary.click();
		
	}
	
	
	public void AddContentLibrary() throws AWTException, InterruptedException {
		
		AddContent.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Select select = new Select(ContentForms);
		select.selectByVisibleText("VOD Single Part");
		ContentName.sendKeys("My_Favorite_Content");
		DateFormat dateformat = new SimpleDateFormat("mm/dd/yyyy");
		Date date = new Date();
		ReleaseDate.sendKeys(dateformat.format(date));
		Story.sendKeys("Whatever you want to do you can do");
		
		Select Sel1 = new Select(ContentCatagory);
		Sel1.selectByVisibleText("Movie");
		
		
		UploadBannr.click();
		Thread.sleep(3000);
		UploadBannr1.click();
		
		Thread.sleep(5000);
		Robot RB = new Robot();
		StringSelection str = new StringSelection("C:\\Users\\HP\\eclipse-workspace\\My_Sample_Project_MUVI.com\\src\\main\\java\\com\\muvi\\qa\\testdata\\ImageFiles\\Birds.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		
		RB.keyPress(KeyEvent.VK_CONTROL);
		RB.keyPress(KeyEvent.VK_V);
		
		RB.keyRelease(KeyEvent.VK_CONTROL);
		RB.keyRelease(KeyEvent.VK_V);
		
		RB.keyPress(KeyEvent.VK_ENTER);
		RB.keyRelease(KeyEvent.VK_ENTER);
		
		//UploadBannr1.sendKeys("C:\\Users\\HP\\eclipse-workspace\\My_Sample_Project_MUVI.com\\src\\main\\java\\com\\muvi\\qa\\testdata\\ImageFiles\\Birds.jpg");
		Thread.sleep(2000);
		Save.click();
		Thread.sleep(5000);
		
		
		AddNewCast.click();
		CastName.sendKeys("Saharukh khan");
		
		CastType.click();
		Thread.sleep(2000);
		Actor.click();
		
		UploadImage.click();
		Thread.sleep(3000);
		UploadImage1.click();
		Thread.sleep(3000);
		Robot RB1 = new Robot();
		StringSelection str1 = new StringSelection("C:\\Users\\HP\\eclipse-workspace\\My_Sample_Project_MUVI.com\\src\\main\\java\\com\\muvi\\qa\\testdata\\ImageFiles\\View.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str1, null);
		
		RB1.keyPress(KeyEvent.VK_CONTROL);
		RB1.keyPress(KeyEvent.VK_V);
		
		RB1.keyRelease(KeyEvent.VK_CONTROL);
		RB1.keyRelease(KeyEvent.VK_V);
		
		RB1.keyPress(KeyEvent.VK_ENTER);
		RB1.keyRelease(KeyEvent.VK_ENTER);
		
		//UploadImage1.sendKeys("C:\\Users\\HP\\eclipse-workspace\\My_Sample_Project_MUVI.com\\src\\main\\java\\com\\muvi\\qa\\testdata\\ImageFiles\\View.jpg");
		Next.click();
		Thread.sleep(5000);
		
		AddButton.click();
		
		
		SaveAndContinue.click();
		
		Thread.sleep(5000);
		
		
		
	}
	
	
	public boolean VerifyMyContentLibrary() throws InterruptedException {
		boolean flg = false;
		GoToContentLibrary();
		FilterColumn.click();
		SearchContent.sendKeys("My_Favorite_Content");
		SearchContent.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		if(ContentLibraryName.equals("My_Favorite_Content")) {
			flg = true;
			
		}
		
		
		return flg;
		
	}
	
	
	
	

}
