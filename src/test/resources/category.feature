Feature: Category dropdown filtering
  In order to shop online easily
  As an Askmodich online shop customer
  I want to filter products by selecting a category from the dropdown

  Background:
    Given the user is on the Askmodich store page

  @category
  Scenario Outline: View products by selecting a category from the dropdown
    When the user selects "<category>" from the category dropdown
    Then only products belonging to the "<category>" category should be displayed

    Examples:
      | category            |
      | Men's Jeans         |

