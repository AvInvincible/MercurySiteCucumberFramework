package utils;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.logger.LoggerHelper;

/* This file define common function which inject data to required element */
public class CommonWrappers {

	WebDriver eDriver;
	private Logger log = LoggerHelper.getLogger(CommonWrappers.class);
	
	/* This method get the url */
	public void getUrl(String path, WebDriver eDriver) {
		log.info("Access the url");
		this.eDriver = eDriver;
		eDriver.get(path.toString());
	}
	
	
	
	/* This method perform action click on the element */
	public void clickAction(By path, WebDriver eDriver){
		this.eDriver = eDriver;
		log.info("Performing click on the link");
		eDriver.findElement(path).click();
	}
	
	/* This method enter data into the fields */
	public void enterData(By path, WebDriver eDriver, String data){
		this.eDriver = eDriver;
		log.info("Entering data in input field");
		WebElement eTest = eDriver.findElement(path);
		eTest.clear();
		eTest.sendKeys(data);
	}
	
	/* Method to select option from the select dropdown */
	public void selectOptionAction(By path, WebDriver eDriver, String data) {
		this.eDriver = eDriver;
		WebElement lData = eDriver.findElement(path);
		log.info("Performing select action");
		Select sData = new Select(lData);
		sData.selectByVisibleText(data);
	}
	
	// Method to get selected value
	public String getSelectedValue(By path, WebDriver eDriver) {
		this.eDriver = eDriver;
		String str = new Select(eDriver.findElement(path)).getFirstSelectedOption().getText();
		return str;
	}
	
	// Method to get all the dropdown 
		public List<String> getAllDropDown(By path, WebDriver eDriver) {
			this.eDriver = eDriver;
			Select sec = new Select(eDriver.findElement(path));
			List<WebElement> elementList = sec.getOptions();
			List<String> valueList = new LinkedList<String>();
			
			for(WebElement w : elementList) {
				log.info(w.getText());
				valueList.add(w.getText());
			}
			return valueList;
		}
	
	/* Method to perform explict wait */
	public void waitUntilElementisLocated(By path, WebDriver eDriver, int timeToWaitinSec) {
		this.eDriver = eDriver;
		WebElement elementToFind = eDriver.findElement(path);
		log.info("Wating for the element");
		WebDriverWait wait = new WebDriverWait(eDriver,timeToWaitinSec);
		wait.until(ExpectedConditions.visibilityOf(elementToFind));
	}
	
}

