package com.SalesforceApp.Pages.Base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
// getTitle, switchToAlert acceptAlert DismissAlert getTextFromAlert
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;

import com.google.common.io.Files;
import com.SalesforceApp.Utilities.ExtentReportsUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.SalesforceApp.Utilities.SalesforceAppListnerUtility.class)
public class BasePage {
	public WebDriver driver = null;
	protected Wait<WebDriver> wait = null;
	protected Logger baseTestlog = LogManager.getLogger();
	protected ExtentReportsUtility extentReport = ExtentReportsUtility.getInstance();

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterText(WebElement ele, String data, String objectName) {
		if (ele.isDisplayed()) {
			ele.clear();
			ele.sendKeys(data);
			baseTestlog.info("data is entered in " + objectName + " textbox");
			extentReport.logTestInfo("data is entered in " + objectName + " textbox");

		} else {
			baseTestlog.info(objectName + " element is not displayed");
		}
	}

	public void clickElement(WebElement ele, String objectName) {
		if (ele.isEnabled()) {
			ele.click();
			baseTestlog.info(objectName + "button is clicked");
			extentReport.logTestInfo(objectName + "button is clicked");

		} else {
			baseTestlog.info(objectName + " element is not enabled");

		}
	}

	public String getTextFromElement(WebElement ele, String objectName) {
		String data = ele.getText();
		baseTestlog.info("text is extracted from " + objectName);
		baseTestlog.info("Extracted Text " + data);
		extentReport.logTestInfo("text is extracted from " + objectName);
		return data;
	}

	public void maximiseBrowser() {
		driver.manage().window().maximize();
		baseTestlog.info("browser window has maximized");
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void refreshPage() {
		driver.navigate().refresh();
		baseTestlog.info("page is refreshed");

	}

	public void CompareText(String exptext, String acttext, String objectName) {
		// TODO Auto-generated method stub
		if (exptext.equals(acttext)) {
			System.out.println(objectName + " Successful and Testcase passed....");
		} else {
			System.out.println(objectName + " Unsuccessful and Testcase failed....");
		}
	}

	public void clearElement(WebElement ele, String ObjectName) {
		if (ele.isDisplayed()) {
			ele.clear();
			baseTestlog.info(ObjectName + " is cleared");
		} else {
			baseTestlog.info(ObjectName + " element is not displayed");
		}
	}

	public WebDriver getDriverInstance() {
		return this.driver;
	}

	public void waitForVisibility(WebElement ele, int i, String objectName) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, i);
		wait.until(ExpectedConditions.visibilityOf(ele));
		baseTestlog.info(objectName + "is visible");
	}
	
	public void waitUntilPageLoads() {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	public Alert SwitchToAlert() {
		// TODO Auto-generated method stub
		Alert alert = driver.switchTo().alert();
		return alert;
	}

	public String extractTextFromAlert(Alert a) {
		// TODO Auto-generated method stub
		return null;
	}

	public Actions Actions() {
		Actions action = new Actions(driver);
		return action;

	}

	public void isSelected(WebElement ele, String objectName) {
		if (ele.isSelected()) {
			baseTestlog.info(objectName + "is selected");
		}
	}
	
	public boolean isDisplayed(WebElement ele, String objectName) {
		if (ele.isDisplayed()) {
			baseTestlog.info(objectName + "is Displayed");
		}
		return false;
	}

}
