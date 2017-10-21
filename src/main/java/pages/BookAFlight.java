package pages;

import java.util.Random;

import org.openqa.selenium.By;

import utils.CommonWrappers;
import utils.ConfigManifest;

/*
 * This class is design to test the Book a flight page 
 */
public class BookAFlight {

	static By passFirstName = By.xpath("//input[@name='passFirst0']");
	static By passLastName = By.xpath("//input[@name='passLast0']");
	static By passMealType = By.xpath("//select[@name='pass.0.meal']");
	static By creditCard = By.xpath("//select[@name='creditCard']");
	static By creditnumber = By.xpath("//input[@name='creditnumber']");
	static By cardExpMonth = By.xpath("//select[@name='cc_exp_dt_mn']");
	static By cardExpYear = By.xpath("//select[@name='cc_exp_dt_yr']");
	static By cardHolderFName = By.xpath("//input[@name='cc_frst_name']");
	static By cardHolderMName = By.xpath("//input[@name='cc_mid_name']");
	static By cardHolderLName = By.xpath("//input[@name='cc_last_name']");
	static By billAddress = By.xpath("//input[@name='billAddress1']");
	static By billCity = By.xpath("//input[@name='billCity']");
	static By billState = By.xpath("//input[@name='billState']");
	static By billZip = By.xpath("//input[@name='billZip']");
	static By billCountry = By.xpath("//select[@name='billCountry']");
	static By delAddress = By.xpath("//input[@name='delAddress1']");
	static By delCity = By.xpath("//input[@name='delCity']");
	static By delState = By.xpath("//input[@name='delState']");
	static By delZip = By.xpath("//input[@name='delZip']");
	static By delCountry = By.xpath("//select[@name='delCountry']");
	static By buyFlight = By.xpath("//input[@name='buyFlights']");
	//Flight Confirmation: Mercury Tours
	
	/* //This class contains actions that need to be performed on the page element */
	static CommonWrappers action = new CommonWrappers();
	
	public static void inputPassFirstName() {
		String passFirstNameValue = "kepler";
		action.enterData(passFirstName, ConfigManifest.driver, passFirstNameValue);
	}
	
	public static void inputPassLastName() {
		String passFirstNameValue = "kepler";
		action.enterData(passLastName, ConfigManifest.driver, passFirstNameValue);
	}
	
	public static void selectPassMealType() {
		String passMealTypeValue =  "Hindu";
		action.selectOptionAction(passMealType, ConfigManifest.driver, passMealTypeValue);
	}
	
	public static void selectCreditCard() {
		String creditCardValue =  "MasterCard";
		action.selectOptionAction(creditCard, ConfigManifest.driver, creditCardValue);
	}
	
	public static void inputCardNo() {
		int ran = new Random().nextInt(1000);
		String creditnumberValue = "345566556532" + Integer.toString(ran);
		action.enterData(creditnumber, ConfigManifest.driver, creditnumberValue);
	}
	
	
	public static void selectExpMonth() {
		String cardExpMonthValue =  "06";
		action.selectOptionAction(cardExpMonth, ConfigManifest.driver, cardExpMonthValue);
	}
	
	public static void selectExpYear() {
		String cardExpYearValue =  "2010";
		action.selectOptionAction(cardExpYear, ConfigManifest.driver, cardExpYearValue);
	}
	
	public static void inputCardHolderFName() {
		String cardHolderFNameValue = "Ajit";
		action.enterData(cardHolderFName, ConfigManifest.driver, cardHolderFNameValue);
	}
	
	public static void inputCardHolderMName() {
		String cardHolderMNameValue = "M.";
		action.enterData(cardHolderMName, ConfigManifest.driver, cardHolderMNameValue);
	}
	
	public static void inputCardHolderLName() {
		String cardHolderLNameValue = "Kepler";
		action.enterData(cardHolderLName, ConfigManifest.driver, cardHolderLNameValue);
	}
	
	public static void inputBillAddress() {
		String billAddressValue = "1325 Borregas Ave.";
		action.enterData(billAddress, ConfigManifest.driver, billAddressValue);
	}
	
	public static void inputBillCity() {
		String billCityValue = "Sunnyvale";
		action.enterData(billCity, ConfigManifest.driver, billCityValue);
	}
	
	public static void inputBillState() {
		String billStateValue = "CA";
		action.enterData(billState, ConfigManifest.driver, billStateValue);
	}
	
	public static void inputBillZip() {
		String billZipValue = "94089";
		action.enterData(billZip, ConfigManifest.driver, billZipValue);
	}
	
	public static void selectCountry() {
		String billCountryValue =  "UNITED STATES";
		action.selectOptionAction(billCountry, ConfigManifest.driver, billCountryValue);
	}
	
	public static void inputDelAddress() {
		String delAddressValue = "1325 Borregas Ave.";
		action.enterData(delAddress, ConfigManifest.driver, delAddressValue);
	}
	
	public static void inputDelCity() {
		String delCityValue = "Sunnyvale";
		action.enterData(delCity, ConfigManifest.driver, delCityValue);
	}
	
	public static void inputDelState() {
		String delStateValue = "CA";
		action.enterData(delState, ConfigManifest.driver, delStateValue);
	}
	
	public static void inputDelZip() {
		String delZipValue = "94089";
		action.enterData(delZip, ConfigManifest.driver, delZipValue);
	}
	
	public static void selectDelCountry() {
		String delCountryValue =  "UNITED STATES";
		action.selectOptionAction(delCountry, ConfigManifest.driver, delCountryValue);
	}
	
	public static void bookFlightTest() {
		inputPassFirstName();
		inputPassLastName();
		selectPassMealType();
		
		selectCreditCard();
		inputCardNo();
		selectExpMonth();
		selectExpYear();
		
		inputCardHolderFName();
		inputCardHolderMName();
		inputCardHolderLName();
		
		inputBillAddress();
		inputBillCity();
		inputBillState();
		inputBillZip();
		selectCountry();
		
		inputDelAddress();
		inputDelCity();
		inputDelState();
		inputDelZip();
		selectDelCountry();
	}
}
