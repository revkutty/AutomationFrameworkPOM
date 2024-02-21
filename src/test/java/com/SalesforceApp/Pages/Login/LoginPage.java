package com.SalesforceApp.Pages.Login;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SalesforceApp.Pages.Base.BasePage;

public class LoginPage extends BasePage{
	@FindBy(id="username") WebElement userNameElement;
	@FindBy(xpath="//input[@id='password']") WebElement passwordElement;
	@FindBy(xpath="//input[@id='Login']") WebElement loginButtonElement;
	@FindBy(css="div#error.loginError") WebElement error;
	@FindBy(xpath="//input[@id='rememberUn']") WebElement remember;
	@FindBy(xpath="//*[@id='idcard-identity']") WebElement Rememberedusername;
	@FindBy(xpath="//input[@id='rememberUn']") WebElement rememberme;
	@FindBy(xpath="//a[@id='forgot_password_link']") WebElement forgetpassword;
	@FindBy(xpath="//input[@id='un']") WebElement forgetpassusername;
	@FindBy(xpath="//input[@id='continue']") WebElement passcontinue;
	@FindBy(xpath="//div/p[@class='senttext mb12'][1]") WebElement emailtext;
	@FindBy(css="div#error") WebElement invaliduserpass;

	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterUserName(String data) {
		//userNameElement.sendKeys(data);
		waitForVisibility(userNameElement, 30,"userNameElement");
		enterText(userNameElement, data, "Username textbox");
		//extentReport.logTestInfo("username data is entered in username field");
	}
	public void enterPassword(String data) {
		enterText(passwordElement, data, "password field");
	}
	
	public WebDriver clickLoginButton() {
		clickElement(loginButtonElement,"login button");
		return driver;
		
	}
	
	public void clickRemeberMeElement() {
		 clickElement(remember, "Remember Me");
		
	}
	
	public void clickForgotPasswordElement() {
		 clickElement(forgetpassword, "Forget password");
		
	}
	
	public void clickContinueElement() {
		 clickElement(passcontinue, "Forget password Continue");
		
	}
	
	
	
	public void enterForgotUserName(String data) {
		//userNameElement.sendKeys(data);
		waitForVisibility(forgetpassusername, 30,"forgetpassusername");
		enterText(forgetpassusername, data, "Forgot Password Username textbox");
		//extentReport.logTestInfo("username data is entered in username field");
	}
	
		
	public String getErrorFromElement() {
		waitForVisibility(error, 20,"userNameElement");
		return getTextFromElement(error, "error message");
	}
	
	
	public String getTextFromemailElement() {
		waitForVisibility(emailtext, 20,"userNameElement");
		return getTextFromElement(emailtext, "Check Your Email error message");
	}
	
	public String getErrormsgFromElement() {
		waitForVisibility(invaliduserpass, 20,"invaliduserpass");
		return getTextFromElement(invaliduserpass, "error message for invalid username & password");
	}
	
	
	
	
	public String getTitleOfThePage() {
		waitUntilPageLoads();
		return getPageTitle();
	}
	public Alert switchToErrorAlert() {
		return SwitchToAlert();
	}

	public void acceptErrorAlert(Alert a) {
		// TODO Auto-generated method stub
		a.accept();
	}

	public String getRememberedUsername() {
		isDisplayed();
		return getTextFromElement(Rememberedusername, "Rememberedusername");
	
	}
	
	public void isSelected() {
		isSelected(rememberme, "Remember Me");
		
	}
	
	public boolean isDisplayed() {
		return isDisplayed(Rememberedusername, "Rememberedusername");
		
		
	}
	

	
}
