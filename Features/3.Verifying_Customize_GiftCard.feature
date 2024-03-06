Feature: Customize the gift card

  Scenario Outline: Entering amount in the amount text box
    Given the homepage of the website
    When the user clicks the gift cards
    And choose an Occasion as Birthday/Anniversary
    And customize the gift card by entering the amount as "<Amount>"
    Then verify that the next button is enabled are not

    Examples: 
      | Amount  |
      |     100 |
      | 5000000 |
      |    1000 |
