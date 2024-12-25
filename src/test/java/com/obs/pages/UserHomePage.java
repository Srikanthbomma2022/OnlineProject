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


	public class UserHomePage {
		Logger log = (Logger) LogManager.getLogger(UserHomePage.class);
			WebDriver driver;
			ExtentTest test;
			
	
			@FindBy(xpath="//h1[normalize-space()='Welcome to']")
			WebElement WelcomeText;
			
	
			public UserHomePage(WebDriver driver, ExtentTest test) {
				this.driver=driver;
				this.test=test;
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				PageFactory.initElements(driver, this);
			}
			
			public void verifyWelcomText() {
				if(WelcomeText.isDisplayed()) {
					Assert.assertTrue(true,"User Home page is displayed succesfully");
					test.log(Status.PASS, "User home page displayed sucessfully");
					log.info("User home page is displayed sucessfully");
				}else {
					Assert.assertTrue(false,"User Home page is NOT displayed");
					log.info("user home page is not displayed");
					test.log(Status.FAIL, "User home page not displayed sucessfully");
					}
				}
				
				
				
	}	

