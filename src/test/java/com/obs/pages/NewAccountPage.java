package com.obs.pages;

import java.time.Duration;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;



public class NewAccountPage {
	Logger log = (Logger) LogManager.getLogger(NewAccountPage.class);
	WebDriver driver;
	ExtentTest test;
	
		//@FindBy(xpath="(//p[normalize-space()='Account Management']")
		//WebElement NewAccountmanagment;
		
		@FindBy(xpath="//p[normalize-space()='New Account']")
		WebElement NewAccount;
		
		@FindBy(xpath="//input[@name='account_number']")
		WebElement accountNumber;
		
		@FindBy(xpath="//input[@name='firstname']")
		WebElement FirstName;
		
		@FindBy(xpath="//input[@placeholder='(optional)']")
		WebElement middleName;
		
		@FindBy(xpath="//input[@name='lastname']")
		WebElement lastName;
		
		@FindBy(xpath="//input[@name='email']")
		WebElement email;
		
		@FindBy(xpath="//input[@name='generated_password']")
		WebElement password;
		
		@FindBy(xpath="//input[@name='pin']")
		WebElement pin;
		
		@FindBy(xpath="//input[@name='balance']")
		WebElement balance;
		
		@FindBy(xpath="//button[@class='btn btn-primary mr-2']")
		WebElement save;

		@FindBy(xpath="//a[normalize-space()='Cancel']")
		WebElement cancel;
		
		
		public NewAccountPage(WebDriver driver, ExtentTest test) {
		this.driver=driver;
		this.test=test;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
			
		}
	
		//new account page
		@SuppressWarnings("unlikely-arg-type")
		public void NewUserCreation(HashMap<String,String> data) {
			//NewAccountmanagment.click();
			NewAccount.click();
			accountNumber.sendKeys(data.get(accountNumber));
			accountNumber.sendKeys(data.get(FirstName));
			middleName.sendKeys(data.get(middleName));
			lastName.sendKeys(data.get(lastName));
			email.sendKeys(data.get(email));
			password.sendKeys(data.get(password));
			pin.sendKeys(data.get(pin));
			balance.sendKeys(data.get(balance));
			save.click();
			
			
		}
		//	cancel.sendKeys(null);
		
		//new account page
		
		// HashMap<String,String> testData=new HashMap<String,String>();
		/* 	testData.put("accountNumber" , " ");
	        testData.put("FirstName", "");
	        testData.put("middleName", "");
	        testData.put("lastName", "");
	        testData.put("email", "");
	        testData.put("password", "");
	        testData.put("pin", "");
	        testData.put("balance", ""); */
	
}
