package com.SalesforceApp.Automationtests;

//before->
//beforeMethod->onTestStarts->automationscript->onTestSuccess->afetrMethod
//after
import java.util.List;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.SalesforceApp.Base.BaseTest;
import com.SalesforceApp.Pages.Home.HomePage;
import com.SalesforceApp.Pages.Login.LoginPage;
import com.SalesforceApp.Utilities.Constants;
import com.SalesforceApp.Utilities.PropertiesUtility;

public class AutomationScripts extends BaseTest {

	protected Logger AutomationScriptslog = LogManager.getLogger();

	@Test
	public void succesLogin_2() throws InterruptedException {

		/*
		 * String exptext = "Student Registration Form1243"; String expTitle =
		 * "Selenium"; SoftAssert sftAsrt = new SoftAssert();
		 * extentReport.logTestInfo("soft assert object has created for validation");
		 * sftAsrt.assertEquals(getPageTitle(), expTitle,"title not matched");
		 * 
		 * login_firebase();
		 * 
		 * WebElement TextElement = driver.findElement(By.tagName("h1"));
		 * 
		 * waitForVisibility(TextElement,30, "h1 text element");
		 * 
		 * 
		 * String actText = getTextFromElement(TextElement,
		 * "student registration element");
		 * sftAsrt.assertEquals(actText,exptext,"text is not matched with expected");
		 * sftAsrt.assertAll();
		 */

		AutomationScriptslog.info("******Login_to_Salesforce automation script started***********");
		String expected = "Home Page ~ Salesforce - Developer Edition";
		String userName = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		String passWord = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
		extentReport.logTestInfo("username and password extracted from properties file");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(userName);
		loginPage.enterPassword(passWord);
		driver = loginPage.clickLoginButton();

		HomePage homePage = new HomePage(driver);
		String actual = homePage.getTextFromSalesforceHomePage();
		Assert.assertEquals(actual, expected);

	}

	@Test
	public void invalid_login_1() throws InterruptedException {
		String expError = "Please enter your password.";

		String userName = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		extentReport.logTestInfo("username extracted from properties file");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(userName);
		loginPage.enterPassword("");
		driver = loginPage.clickLoginButton();
		String actualError = loginPage.getErrorFromElement();
		Assert.assertEquals(actualError, expError);
		
	}

	@Test
	public void Rememberme_login_3() throws InterruptedException {

		String expHomeTitle = "Home Page ~ Salesforce - Developer Edition";
	//	String expLoginTitle = "Login | Salesforce";
		String userName = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		String passWord = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
		extentReport.logTestInfo("username and password extracted from properties file");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(userName);
		loginPage.enterPassword(passWord);
		loginPage.clickRemeberMeElement();
		driver = loginPage.clickLoginButton();
		String actHomeTitle = loginPage.getTitleOfThePage();
		Assert.assertEquals(actHomeTitle, expHomeTitle);
		HomePage homePage = new HomePage(driver);
		homePage.gotoUserMenu();
		driver = homePage.Logout();

		System.out.println(driver.getCurrentUrl());
	
	/*	LoginPage loginPage1 = new LoginPage(driver);
		String actLoginTitle = loginPage1.getTitleOfThePage();
		Assert.assertEquals(actLoginTitle, expLoginTitle);

		String actRememberedUsername = loginPage.getRememberedUsername();
		String expuserName = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		Assert.assertEquals(actRememberedUsername, expuserName);

		loginPage.isSelected();   */
	}

	@Test
	public void Rememberme_login_4a() throws InterruptedException {

		String expforgotpassemailmsg = "We’ve sent you an email with a link to finish resetting your password.";
		String expforgotpassemailTitle = "Check Your Email | Salesforce";
		String expforgetpasstitle = "Forgot Your Password | Salesforce";
		String expHomeTitle = "Home Page ~ Salesforce - Developer Edition";
		String expLoginTitle = "Login | Salesforce";
		String userName = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		String passWord = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
		extentReport.logTestInfo("username and password extracted from properties file");

		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.clickForgotPasswordElement();
		String actforgetpasstitle = loginPage.getTitleOfThePage();
		Assert.assertEquals(actforgetpasstitle, expforgetpasstitle);
		loginPage.enterForgotUserName(userName);
		loginPage.clickContinueElement();
		String actforgotpassemailTitle = loginPage.getTitleOfThePage();
		Assert.assertEquals(actforgotpassemailTitle, expforgotpassemailTitle);
		String actforgotpassemailmsg = loginPage.getTextFromemailElement();
		Assert.assertEquals(actforgotpassemailmsg, expforgotpassemailmsg);

	}
	
	@Test
	public void Rememberme_login_4b() throws InterruptedException {
		String expinvaliduserpassText = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		String userName = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		String passWord = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
		extentReport.logTestInfo("username and password extracted from properties file");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName("123");
		loginPage.enterPassword("22131");
		driver = loginPage.clickLoginButton();
		String actinvaliduserpassText = loginPage.getErrormsgFromElement();
		Assert.assertEquals(actinvaliduserpassText, expinvaliduserpassText);
				
		
		
	

	}
}
