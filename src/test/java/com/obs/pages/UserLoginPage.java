package com.obs.pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;

import com.obs.base.BaseTest;

public class UserLoginPage extends BaseTest {
		Logger log = (Logger) LogManager.getLogger(UserLoginPage.class);
		WebDriver driver;
		ExtentTest test;
		

		@FindBy(xpath="//input[@name='email']")
		WebElement emailField;
		
		@FindBy(xpath="//input[@name='password']")
		WebElement passwordField;
		
		@FindBy(xpath="//button[normalize-space()='Login']")
		WebElement loginbtn;
		
		public UserLoginPage(WebDriver driver, ExtentTest test) {
			this.driver=driver;
			this.test=test;
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			PageFactory.initElements(driver, this);
		}
		
		public void UserLogin(String email,String password) {
			
			emailField.sendKeys(email);
			passwordField.sendKeys(password);
			loginbtn.click(); 
			
			
		}
		
		
}
