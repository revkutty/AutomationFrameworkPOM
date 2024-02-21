package com.SalesforceApp.Pages.Home;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.SalesforceApp.Pages.Base.BasePage;

public class HomePage extends BasePage {
	@FindBy(xpath ="//a[@title='Home Tab']") WebElement SalesforceHomePage;
	@FindBy(xpath="//div[@id='userNav-arrow']") WebElement usermenu;
	@FindBy(xpath="//a[@title='Logout']") WebElement logout;
	
		
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public String getTextFromSalesforceHomePage() {
		waitForVisibility(SalesforceHomePage, 30,"Salesforce HomePage");
		String data= getPageTitle();
		System.out.println("text extracted from Salesforce HomePage="+data);
		return data;
	}
	
	//wait.until(ExpectedConditions.visibilityOf(usermenu));
	
	
	public void gotoUserMenu() {
		waitForVisibility(usermenu, 30,"usermenu");
		Actions action = Actions();
		action.moveToElement(usermenu).click().build().perform();
					
	}
	
	public WebDriver Logout() {
		waitForVisibility(logout, 30,"logout");
		Actions action = Actions();
		action.moveToElement(logout).click().build().perform();
		return driver;
	}
		
	

	

	



	


	
	
}
