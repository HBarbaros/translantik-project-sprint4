@TRN-1631
Feature: US-004 Vehicle Table Arrangements

  Background:
    Given the user logged in as "store manager"
    When the user navigates to "Fleet" "Vehicles"

  @TRN-1654 @AC1
  Scenario:
    Then user validates default view per page value is 25

  @TRN-1655 @AC2
  Scenario Outline:
    Then user validates view per page dropdown has "<expected values>"

    Examples:
      | expected values |
      | 10              |
      | 25              |
      | 50              |
      | 100             |

