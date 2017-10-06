package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/* This file define common function which inject data to required element */
public class CommonWrappers {

	WebDriver eDriver;
	
	/* This method get the url */
	public void getUrl(String path, WebDriver eDriver) {
		this.eDriver = eDriver;
		eDriver.get(path.toString());
	}
	
	
	
	/* This method perform action click on the element */
	public void clickLink(By path, WebDriver eDriver){
		this.eDriver = eDriver;
		eDriver.findElement(path).click();
	}
	
	/* This method enter data into the fields */
	public void enterData(By path, WebDriver eDriver, String data){
		this.eDriver = eDriver;
		eDriver.findElement(path).sendKeys(data);
	}
	
	/* Method to select option from the select dropdown */
	public void selectOptionData(By path, WebDriver eDriver, String data) {
		WebElement lData = eDriver.findElement(path);
		Select sData = new Select(lData);
		sData.selectByVisibleText(data);
	}
	
	/* Method to perform explict wait */
	public void waitUntilElementisLocated(By path, WebDriver eDriver, int timeToWaitinSec) {
		WebElement elementToFind = eDriver.findElement(path);
		WebDriverWait wait = new WebDriverWait(eDriver,timeToWaitinSec);
		wait.until(ExpectedConditions.visibilityOf(elementToFind));
	}
	
}

