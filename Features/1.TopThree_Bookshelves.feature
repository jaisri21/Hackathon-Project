Feature: Getting top three bookshelves

  Scenario: Getting top three bookshelves sorting using all filters
    Given the homepage of the website for searching bookshelves
    When the user enters "bookshelves" in the sesrch box
    Then the user navigates to the result page
    When the user click the category button to choose Bookshelves as a category
    And the user clicks the price button to fix the price range as below 15000
    And click the exclude out of stock option
    And sort by price high to low
    Then print the top three bookshelve's name and price
