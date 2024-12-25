package com.obs.pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class AdminHomePage {
	Logger log = (Logger) LogManager.getLogger(AdminHomePage.class);
	WebDriver driver;
	ExtentTest test;
	
	@FindBy(xpath="//h1[normalize-space()='Welcome to']")
	WebElement homePageText;
	
	@FindBy(xpath="//p[normalize-space()='Account Management']")
	WebElement accountManagement;
	
	@FindBy(xpath="//p[normalize-space()='Transaction']")
	WebElement transactions;
	
	@FindBy(xpath="//p[normalize-space()='Announcements']")
	WebElement announcement;
	
	@FindBy(xpath="//span[@class='ml-3']")
	WebElement profileIcon;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement logout;
	
	
	public AdminHomePage(WebDriver driver, ExtentTest test) {
		this.driver=driver;
		this.test=test;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		
	}
	
	//verify homepage
	public void verifyHomePageText() {
		if(homePageText.isDisplayed()) {
			Assert.assertTrue(true,"Home page is displayed succesfully");
			test.log(Status.PASS, "home page displayed sucessfully");
			log.info("Home page is displayed sucessfully");
		}else {
			Assert.assertTrue(false,"Home page is NOT displayed");
			test.log(Status.FAIL, "home page not displayed sucessfully");
			log.info("Home page is not displayed");
		}
	}
	//click an account managemnt
	public void clickOnAccMgmt() {
		accountManagement.click();
	}
	//click transactions
	public void transactions() {
		transactions.click();
	}
	//transactions
	public void announcement() {
		announcement.click();
	}
	
	//logout
	public void profileIcon() {
		profileIcon.click();
		logout.click();
	}
}
