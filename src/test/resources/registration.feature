Feature: User Registration
  As a new user
  I want to register on the website
  So that I can create an account

  Scenario Outline: Successful registration with valid details
    Given the user is on the registration page
    When the user enters "<username>", "<email>", and "<password>"
    And clicks the Register button
    Then the user should see a success message "<message>"

    Examples:
      | username | email          | password | message                        |
      | keza    | muti@gmail.com | sabine   | Hello keza (not keza? Log out) |

