package com.obs.base;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;  // Use ExtentSparkReporter instead of ExtentHtmlReporter
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {

    public WebDriver driver;
    public ExtentSparkReporter sparkReporter; // Declare ExtentSparkReporter instead of ExtentHtmlReporter
    public ExtentReports extent;
    public ExtentTest test;

    @BeforeSuite
    public void initializeReport() {
    	//Log.info("launching browser");
        // Initialize the ExtentSparkReporter with the file path
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/ExtentReport.html");
        
        // Initialize the ExtentReports instance
        extent = new ExtentReports();  
        extent.attachReporter(sparkReporter);  // Attach the ExtentSparkReporter
        
        // Set system info for the report
        extent.setSystemInfo("Host Name", "Venkata Krishna");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Venkat");

        // Configuring the Spark report's document title, name, and theme
        sparkReporter.config().setDocumentTitle("Extent Report ");
        sparkReporter.config().setReportName("OBS Report "); 
        sparkReporter.config().setTheme(Theme.STANDARD);
    }   

	    @AfterSuite
	    public void cleanup() {
	       // Write the results to the report
	    	extent.flush();
	    }  
    
    	@BeforeMethod
    	@Parameters(value={"Browser"})
    	public void  launch(String browser){
    		//test =extent.createTest("Test case is Started");
    	if(browser.toLowerCase().contains("chrome")) {
    		WebDriverManager.chromedriver().setup();
    		driver=new ChromeDriver();
    	}else if(browser.toLowerCase().contains("firefox")) {
    		WebDriverManager.firefoxdriver().setup();
    		driver=new FirefoxDriver();
    	}else if(browser.toLowerCase().contains("edge")) {
    		WebDriverManager.edgedriver().setup();
    		driver=new EdgeDriver();
    	}
    	}	
    	@AfterMethod
    	public void afterTest(ITestResult result) throws IOException 
    	{
    		driver.quit();
    	}
    	
}	
    	
