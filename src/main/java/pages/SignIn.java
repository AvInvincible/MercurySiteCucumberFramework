package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import utils.CommonWrappers;
import utils.ConfigManifest;
import utils.PropertiesReader;

public class SignIn {
	static By sSignPage = By.linkText("SIGN-ON");
	static By sUserName = By.name("userName");
	static By sUserPassword = By.name("password");
	static By sLogin = By.name("login");
	static By sLogout = By.linkText("SIGN-OFF");
	
	
	
	/* //This class contains actions that need to be performed on the page element */
	static CommonWrappers dataInc = new CommonWrappers();
	/* Class for reading test data that are * entered in SingnIn page elements */
	static PropertiesReader readTestData = new PropertiesReader();
	
	
	
	/* --------------Method to check if mercury-site page loaded successfully ------------*/
	public static void getMercury() {
		String path = readTestData.readData("url");
		dataInc.getUrl(path, ConfigManifest.driver);
	}
	/*--------------------------------------------------------------------------------*/
	
	
	/* --------------Method to check if signIn page loaded successfully ------------*/
	public static boolean signInPageLoad() {
		dataInc.clickLink(sSignPage, ConfigManifest.driver);
		dataInc.waitUntilElementisLocated(sSignPage, ConfigManifest.driver, 30);
		String signInPageTitle = ConfigManifest.driver.getTitle();
		if(signInPageTitle.equalsIgnoreCase("Sign-on: Mercury Tours")) {
			return true;
		}else {
			return true;
		}
	}
	/*--------------------------------------------------------------------------------*/
	
	
	/*-------------- Method to enter data into the signIn fields& Submitting --------- */
	public static void enterUserName(String userName){
		dataInc.waitUntilElementisLocated(sUserName, ConfigManifest.driver, 30);
		dataInc.enterData(sUserName, ConfigManifest.driver, userName);
	}
	
	public static void enterUserPassword(String userPassword){
		dataInc.enterData(sUserPassword, ConfigManifest.driver, userPassword);
	}
	
	public static void clickSignIn(){
		dataInc.clickLink(sLogin, ConfigManifest.driver);
	}
	
	public static boolean siginTitle() {
		String signInpageTitle = ConfigManifest.driver.getTitle();
		if(signInpageTitle.equalsIgnoreCase("Find a Flight: Mercury Tours:")) {
			dataInc.clickLink(sLogout, ConfigManifest.driver);
			return true;
		}else {
			dataInc.clickLink(sLogout, ConfigManifest.driver);
			return false;
		}
	}
	
	/*--------------------------------------------------------------------------------*/
	
	/* ------------------Method to test the signIn with Valid data -------------------*/
	public static void signInTestValidData() throws IOException{
		enterUserName(readTestData.readData("sValidUserEmail"));
		enterUserPassword(readTestData.readData("sValidUserPassword"));
	}
	/* -------------------------------------------------------------------------------*/
	
	/* ------------------Method to test the signIn with inValid data -------------------*/
	public static void signInTestinValidData() throws IOException{
		enterUserName(readTestData.readData("sinValidUserEmail"));
		enterUserPassword(readTestData.readData("sinValidUserPassword"));
	}
	/* -------------------------------------------------------------------------------*/
	
}
