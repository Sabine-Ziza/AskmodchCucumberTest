Feature: Login functionality on Askmodch website
  As a customer
  I want to log in through the Account page
  So that I can access my account

  Scenario Outline: Login with multiple credentials
    Given the user is on the Askmodch homepage
    When the user enters <username> and <password> in the login form
    And the user clicks on the Login button
    Then the user should see the "<expectedResult>"

    Examples:
      | username | password | expectedResult    |
      | "mutesi" | "mutesi" | dashboard         |
      | "sabine" | "sabine" | error message     |
      | "test"   | "12345"  | error message     |
