Feature: Mercury Site Links Tests
  Author: Ajit

  @LinkTest
  Scenario: Test all the links on home page
    Given I access the home page
    Then I get all the link on accessed page and verify the links

    #Examples: 
      #| page   |
      #| "Home" |
