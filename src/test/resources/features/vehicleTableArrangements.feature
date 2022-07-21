Feature: US-004 Vehicle Table Arrangements

  @TRN-1651
  Background:
    Given the user logged in as "storemanager85"
    When the user navigates to "Fleet" "Vehicles"

  @TRN-1654
  Scenario:
    Then user validates default view per page value is 25


