Feature: place an order

  @checkout
  Scenario: using default payment option
    Given I'm a guest customer
    And I'm on the Store page
    When I add a product to the cart
    And I proceed to checkout
    When the user fills billing details
      | firstname | lastname | address_line1 | city  | state | zip   | email     | phone     |
      | demo      | user     | 6300 Spring   | plano | Texas | 90210 | abc@x.com | 078934521 |

    And I place an order
    Then the order should be placed successfully
