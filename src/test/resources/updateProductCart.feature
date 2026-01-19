Feature: Cart Update and Remove

  Background:
    Given the user is on the cart page
    And the cart contains "Anchor Bracelet"


  @increaseQuantity
  Scenario: Increase product quantity in the cart
    When the user clicks the increase arrow for "Anchor Bracelet" 1 times
    Then the quantity of "Anchor Bracelet" should increase by 1
    And the "Update Cart" button should be visible


  @removeProduct
  Scenario: Remove product from the cart
    When the user clicks the remove button for"Anchor bracelet"
    Then "Anchor bracelet" should be removed from the cart
    And the cart should be empty
