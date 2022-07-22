@TRN-1631
Feature: US-004 Vehicle Table Arrangements

  Background:
    Given the user logged in as "store manager"
    When the user navigates to "Fleet" "Vehicles"

  @TRN-1654 @AC1
  Scenario: The value of 'View Per Page' should be '25' by default
    Then user validates default view per page value is 25

  @TRN-1655 @AC2
  Scenario: View Per Page' should include the values: "10", "25", "50", "100"
    Then user validates view per page dropdown has "10", "25", "50", "100" values

  @TRN-1663 @AC3 @wip
  Scenario Outline: User can arrange rows/vehicle numbers to be displayed by clicking on the 'View Per Page'
    When user selects <number> from view per page button
    Then selected <number> of vehicles should be displayed
    Examples:
      | number |
      | 10    |
      | 25    |
      | 50    |
      | 100   |

