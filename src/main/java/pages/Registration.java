package pages;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonWrappers;
import utils.ConfigManifest;
import utils.PropertiesReader;

public class Registration {
	
	//static WebDriver driver;
	
	//Logger
	static Logger log = Logger.getLogger(Registration.class.getName());//register class
	//clicking the register link
	static By registerUser = By.linkText("REGISTER");
	
	//Register page fields details
	static By eFirstName = By.name("firstName");
	static By eLastName = By.name("lastName");
	static By ePhone = By.name("phone");
	static By eEmail = By.id("userName");
	static By eAddress1 = By.name("address1");
	static By eAddress2 = By.name("address2");
	static By eCity = By.name("city");
	static By eState = By.name("state");
	static By ePostalCode = By.name("postalCode");
	static By eCountry = By.name("country");
	static By eUserName = By.id("email");
	static By ePassword = By.name("password");
	static By eConfirmPassword = By.name("confirmPassword");
	static By eSubmit = By.name("register");
	static By eregSuccessMessage = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font"); //to be updated with new element path
	
	
	/* //This class contains actions that need to be performed on the page element */
	static CommonWrappers dataInc = new CommonWrappers();
	/* Class for reading test data that are * entered in SingnIn page elements */
	static PropertiesReader readTestData = new PropertiesReader();


//	/*
//	 * Initializing driver in constructor	 
//	 * */
//	public Registration(WebDriver driver) {
//		this.driver = driver;
//	}
	
	
	/*----------- Loading the Registeration page------------------ */
	public static boolean loadRegPage() {
		log.info("Clicking on register link");
		dataInc.clickAction(registerUser, ConfigManifest.driver);
	/* Checking if registration page has loaded successfully */
		String regTitle = ConfigManifest.driver.getTitle();
		if(regTitle.equalsIgnoreCase("Register: Mercury Tours")) {
			return true;
		}else {
			System.out.println(regTitle);
			return false;
		}
	}
	/*-------------------------------------------------------------*/
	
	/*----------Methods to perform actions like entering data, clicks selects -----------*/
	
	public static void enterFirstName(String iFirstName){
		dataInc.waitUntilElementisLocated(eFirstName, ConfigManifest.driver, 30);
		log.info("Entering user first name");
		dataInc.enterData(eFirstName, ConfigManifest.driver, iFirstName);
	}
	
	public static void enterLastName(String iLastName){
		log.info("Entering user last name");
		dataInc.enterData(eLastName, ConfigManifest.driver, iLastName);
	}
	
	public static void enterPhoneNo(String iPhoneNo){
		log.info("Entering user phone number");
		dataInc.enterData(ePhone, ConfigManifest.driver, iPhoneNo);
	}
	
	public static void enterEmail(String iEmail){
		log.info("Entering user existing user email address");
		dataInc.enterData(eEmail, ConfigManifest.driver, iEmail);
	}
	
	
	public static void enterAddress1(String iAddress1){
		log.info("Entering user address");
		dataInc.enterData(eAddress1, ConfigManifest.driver,iAddress1);
	}
	
	public static void enterAddress2(String iAddress2){
		log.info("Entering user address2");
		dataInc.enterData(eAddress2, ConfigManifest.driver,iAddress2);
	}
	
	public static void enterCityName(String iCity){
		log.info("Entering user city name");
		dataInc.enterData(eCity, ConfigManifest.driver, iCity);
	}
	
	public static void enterStateName(String iState){
		log.info("Entering user state name");
		dataInc.enterData(eState, ConfigManifest.driver, iState);
	}
	
	public static void enterPostalCode(String iPostalCode){
		log.info("Entering user postal code");
		dataInc.enterData(ePostalCode, ConfigManifest.driver, iPostalCode);
	}
	
	public static void enterCountryName(String iCountry){
		log.info("Entering user country name");
		dataInc.selectOptionAction(eCountry, ConfigManifest.driver, iCountry);
	}
	
	public static void enterUserName(String iUserName){
		log.info("Entering username");
		dataInc.enterData(eUserName, ConfigManifest.driver, iUserName);
	}
	
	public static void enterUserPassword(String iUserPassword){
		log.info("Entering user password! Don't ask me i won't tell you(Ask Ajit)");
		dataInc.enterData(ePassword, ConfigManifest.driver, iUserPassword);
	}
	
	public static void enterUserConPassword(String iUserConPassword){
		log.info("Confirming user password");
		dataInc.enterData(eConfirmPassword, ConfigManifest.driver, iUserConPassword);
	}
	
	public static void clickRegister(){
		log.info("That's all user is register");
		dataInc.clickAction(eSubmit, ConfigManifest.driver);
	}
	
	public static boolean regStatus() {
		dataInc.waitUntilElementisLocated(eregSuccessMessage, ConfigManifest.driver, 30);
		WebElement succesReg = ConfigManifest.driver.findElement(eregSuccessMessage);
		System.out.println("User has registered successfully, registration message" + succesReg.getText());
		if(succesReg.getText().equalsIgnoreCase("Thank you for registering. You may now sign-in using the user name and password you've just entered.")) {
			return true;
		}
		else {
			return false; 
		}
		
	}
	
	
	/*-----------------------------------------------------------------------------------*/
	// To be used readTestData.readData("rFirstName")
	
	/*-----------Registration test methods calls ------------------------------ */
	public static void registerTest()throws IOException {
		enterFirstName(readTestData.readData("rFirstName"));
		enterLastName(readTestData.readData("rLastName"));
		enterPhoneNo(readTestData.readData("rPhoneNo"));
		enterEmail(readTestData.readData("rEmail"));
		enterAddress1(readTestData.readData("rAddress1"));
		enterAddress2(readTestData.readData("rAddress2"));
		enterCityName(readTestData.readData("rCityName"));
		enterStateName(readTestData.readData("rStateName"));
		enterPostalCode(readTestData.readData("rPostalCode"));
		enterCountryName(readTestData.readData("rCountry"));
		enterUserName(readTestData.readData("rUserName"));
		enterUserPassword(readTestData.readData("rPassword"));
		enterUserConPassword(readTestData.readData("rConfirmPassword"));
	}

}
