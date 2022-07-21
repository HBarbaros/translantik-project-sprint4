Feature: Login as different user types

  @TRN-1651
  Scenario: login as a driver
    Given the user logged in as "driver"
    When the user navigates to "Fleet" "Vehicles"
