Feature: place an order

  @checkout
  Scenario: using default payment option
    Given I'm a guest customer
    And I'm on the Store page
    When I add a product to the cart
    And I view the cart
    And I proceed to checkout
    And I'm on the Checkout page
    When the user fills billing details
      | firstname | lastname | country            | address_line1     | city  | state | zipId | email            | phone     |
      | demo      | user     | United states (US) | 6300 Spring Creek | plano | Texas | 90210 | mutesi@gmail.com | 078934521 |
    And I place an order
    Then the order should be placed successfully
