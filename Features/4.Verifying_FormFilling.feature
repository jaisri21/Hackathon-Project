Feature: Verifying the form in the Giftcard section

  Background: Navigating to giftcard page and filling the two section
    Given the homepage of the website having giftcard option
    When the user clicks the gift card option in the homepage
    Then the user should be navigated to the giftcard page
    When the user clicks the Anniversary/Birthday in the occasion
    And enters the amount in the text and click the next button

  Scenario Outline: Filling the form with test data
    Given the form section in the giftcard page
    Then the user should fill the form with the data excel row "<row_index>"
    And the user should get the error or confirmation message

    Examples: 
      | row_index |
      |         1 |
      |         2 |
      |         3 |
      |         4 |
