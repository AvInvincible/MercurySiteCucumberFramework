Feature: Booking Flight roundTrip
Author: Ajit Vijayee Yadav

@smoke
Scenario: Book flight round Trip 
Given Navigate to mercury site website
And SignIn into the mercury portal
When On landing on the Flight finder page search the flight and input the values
And Click continue button
And Select the flight depart, return flight and continue
And Provide user details and secure purchase
Then Verify that invoice is generated