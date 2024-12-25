package com.obs.pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.obs.base.BaseTest;


public class AdminLoginPage extends BaseTest {
	
	Logger log = (Logger) LogManager.getLogger(AdminLoginPage.class);
	WebDriver driver;
	ExtentTest test;
	
	
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement UserName;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement Password;
	
	@FindBy(xpath="//button[normalize-space()='Sign In']")
	WebElement SignIn;
	
	@FindBy(xpath="//a[normalize-space()='User Login']")
	WebElement goToWebSite;

	public AdminLoginPage(WebDriver driver, ExtentTest test) {
		this.driver=driver;
		this.test=test;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	public void login(String UN,String pwd) {
		test.log(Status.PASS, "Verify admin user login");
		UserName.sendKeys(UN);
		Password.sendKeys(pwd);
		SignIn.click();
	
	}
	
	public void gotoUserLogin() {
		test.log(Status.PASS, "Verify gotouserSite Link");
		log.info("verifying open adin user link");
		goToWebSite.click();		
	}
	
	public void launchApp(String URL) {
		test.log(Status.PASS, "Verify admin user login");
		log.info("verifying open adin user login");
		driver.get(URL);
	}
}