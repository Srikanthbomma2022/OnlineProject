package com.obs.tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
//import org.testng.Assert;
import org.testng.annotations.Test;

import com.obs.base.BaseTest;
import com.obs.pages.AdminHomePage;
import com.obs.pages.AdminLoginPage;

import common.obs.utilities.ReadProperties;

public class LoginTest extends BaseTest {
    
	Logger log = (Logger) LogManager.getLogger(LoginTest.class);
	
    @Test
    public void verifyLogin() throws IOException {
    	test =extent.createTest(" Verify admin user login");
        String url, userName, password;
       
        // Reading properties file for credentials
        
        url = ReadProperties.readPropEx("AdminURL");
        userName = ReadProperties.readPropEx("AdminUN");
        password = ReadProperties.readPropEx("AdminPwd");
        
        AdminLoginPage login = new AdminLoginPage(driver,test);
        login.launchApp(url);       
        // Logging the login attempt    
        login.login(userName, password);
        
        // Verifying successful login
        AdminHomePage adminHomePage = new AdminHomePage(driver, test);
      //  log.info("Verifying the home page text after login");
        adminHomePage.verifyHomePageText();

        
    }
}
