package com.obs.tests;

import java.io.IOException;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.annotations.Test;

import com.obs.base.BaseTest;
import com.obs.pages.AdminHomePage;
import com.obs.pages.AdminLoginPage;
import com.obs.pages.NewAccountPage;
import com.obs.pages.UserLoginPage;

import common.obs.utilities.RandomNumber;
import common.obs.utilities.ReadProperties;

public class VerifyUserLogin extends BaseTest {

    long accountNumber = RandomNumber.getRandomNumber();
    String emailId = "onlinetestinghelp" + accountNumber + "@gmail.com";
    String password = "123456";  // This is the global password
    Logger log = (Logger) LogManager.getLogger(VerifyUserLogin.class);

    @Test
    public void verifyLogin() throws IOException {
        test = extent.createTest("Verify admin user login");

        String url, userName, adminPassword;  // Renamed local password variable to adminPassword
        
        // Reading properties file for credentials
        url = ReadProperties.readPropEx("AdminURL");
        userName = ReadProperties.readPropEx("AdminUN");
        adminPassword = ReadProperties.readPropEx("AdminPwd");  // Use renamed variable
        
        AdminLoginPage login = new AdminLoginPage(driver, test);
        login.launchApp(url);
        login.login(userName, adminPassword);  // Pass renamed variable

        // Verifying successful login
        AdminHomePage adminHomePage = new AdminHomePage(driver, test);
        adminHomePage.verifyHomePageText();

        // Click on Account Management
        adminHomePage.clickOnAccMgmt();
        
        // Create a new account
        HashMap<String, String> testData = new HashMap<>();
        testData.put("accountNumber", String.valueOf(accountNumber));
        testData.put("FirstName", "Venkat");
        testData.put("middleName", "Krishna");
        testData.put("lastName", "VK");
        testData.put("email", emailId);
        testData.put("password", password);  // Using the global password here
        testData.put("pin", "1234");
        testData.put("balance", "100000");

        NewAccountPage newAccount = new NewAccountPage(driver, test);
        newAccount.NewUserCreation(testData);

        // Logout from Admin Home Page
        adminHomePage.logout();
        
        // User login
        login.gotoUserLogin();      
        UserLoginPage userPage = new UserLoginPage(driver, test);
        userPage.UserLogin(userName, password);  // Using the global password again
    }
}
