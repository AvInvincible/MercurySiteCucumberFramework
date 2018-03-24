Feature: User registration on MercuryTour site
Author: Ajit Vijayee Yadav

@smoke @regression
Scenario: User registration on MercuryTour site
Given Navigate to mercury site website
And Navigate to mercury site website registration page
When User enters the registration details
And Click register button
Then User is successfully registered to MercurySite