package stepdefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BookAFlight;
import pages.FlightFinder;
import pages.SelectFlight;
import pages.SignIn;

/*
 * This class is defined to test the booking flight  
 */
public class BookFlightDef {
	
	@Given("^SignIn into the mercury portal$")
	public void SignIn_into_the_mercury_portal() throws Throwable {
	    SignIn.signInTest();
	}

	@When("^On landing on the Flight finder page search the flight and input the values$")
	public void On_landing_on_the_Flight_finder_page_search_the_flight_and_input_the_values() throws Throwable {
	    FlightFinder.findFlightTest();
	}

	@When("^Click continue button$")
	public void Click_continue_button() throws Throwable {
	    FlightFinder.selectFindFlights();
	}

	@When("^Select the flight depart, return flight and continue$")
	public void Select_the_flight_depart_return_flight_and_continue() throws Throwable {
	    SelectFlight.selectFlightTest();
	}

	@When("^Provide user details and secure purchase$")
	public void Provide_user_details_and_secure_purchase() throws Throwable {
	    BookAFlight.bookFlightTest();
	}

	@Then("^Verify that invoice is generated$")
	public void Verify_that_invoice_is_generated() throws Throwable {
	    
	}
}
