Feature: Getting all the sub-options

  Scenario: Getting all the sub-options from the living menu option
    Given the homepage of the website containing all options
    When the user clicks the living option menu
    Then the user should see all the sub-options of the menu
    And the user should print all the value
