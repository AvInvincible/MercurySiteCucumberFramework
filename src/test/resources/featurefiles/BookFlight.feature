Feature: Login into the Mercury site
Author: Ajit Vijayee Yadav

# @smoke
Scenario: Login into the mercury site with valid credentials
Given Navigate to mercury site website
And Click on signin link to navigate to signIn page
When Input userName and userPassword
And Click submit button
Then User is successfully get logged into MercurySite