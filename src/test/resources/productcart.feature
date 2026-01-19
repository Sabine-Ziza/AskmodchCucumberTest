Feature: Product Cart functionality
  As a customer
  I want to add products to the cart from the homepage
  So that I can view and purchase them later

  Scenario: Add product to cart and verify in Cart page
    Given the user is on the homepage
    When the user clicks Add to cart button
    And the user clicks View cart link
    Then product added should be listed in the cart page
