package pages;

import org.openqa.selenium.By;
import helper.logger.CurrentDateHelper;
import utils.CommonWrappers;
import utils.ConfigManifest;

/*
 * This class is design to test the flight finder page 
 */
public class FlightFinder {
	
	static By roundTrip = By.xpath("//input[@value='roundtrip']");
	static By panCount = By.xpath("//select[@name='passCount']");
	static By fromPort = By.xpath("//select[@name='fromPort']");
	static By fromMonth = By.xpath("//select[@name='fromMonth']");
	static By fromDay = By.xpath("//select[@name='fromDay']");
	static By toPort = By.xpath("//select[@name='toPort']");
	static By toMonth = By.xpath("//select[@name='toMonth']");
	static By toDay = By.xpath("//select[@name='toDay']");
	static By serviceClass = By.xpath("//input[@value='First']");
	static By airline = By.xpath("//select[@name='airline']");
	static By findFlights = By.xpath("//input[@name='findFlights']");
	
	
	/* //This class contains actions that need to be performed on the page element */
	static CommonWrappers action = new CommonWrappers();
	static CurrentDateHelper dateK = new CurrentDateHelper();
	
	public static void selectTripType() {
		action.clickAction(roundTrip, ConfigManifest.driver);
	}
	
	public static void selectPassengerCount() {
		String passCountValue =  "1";
		action.selectOptionAction(panCount, ConfigManifest.driver, passCountValue);
	}
	
	public static void selectFromPort() {
		String fromPortValue =  "London";
		action.selectOptionAction(fromPort, ConfigManifest.driver, fromPortValue);
	}
	
	public static void selectfromMonth() {
		String fromMonthValue =  dateK.getMonth();
		action.selectOptionAction(fromMonth, ConfigManifest.driver, fromMonthValue);
	}

	public static void selectfromDay() {
		String fromDayValue =  Integer.toString(dateK.getDay());
		action.selectOptionAction(fromDay, ConfigManifest.driver, fromDayValue);
	}
	
	public static void selectToPort() {
		String toPortValue =  "Portland";
		action.selectOptionAction(toPort, ConfigManifest.driver, toPortValue);
	}
	
	public static void selectToMonth() {
		String toMonthValue =  dateK.getMonth();
		action.selectOptionAction(toMonth, ConfigManifest.driver, toMonthValue);
	}

	public static void selectToDay() {
		String toDayValue =  Integer.toString(dateK.getDay()+2);
		action.selectOptionAction(toDay, ConfigManifest.driver, toDayValue);
	}
	
	public static void selectserviceClass() {
		action.clickAction(serviceClass, ConfigManifest.driver);
	}
	
	public static void selectAirline() {
		String airlineValue =  "Blue Skies Airlines";
		action.selectOptionAction(airline, ConfigManifest.driver, airlineValue);
	}

	public static void selectFindFlights() {
		action.clickAction(findFlights, ConfigManifest.driver);
	}
	
	public static void findFlightTest() {
		selectTripType();
		selectPassengerCount();
		
		selectFromPort();
		selectfromMonth();
		selectfromDay();
		
		selectToPort();
		selectToMonth();
		selectToDay();
		
		selectserviceClass();
		selectAirline();
		//selectFindFlights();
	}

}

