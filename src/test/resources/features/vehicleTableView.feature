@TRN-1641 @smoke
Feature: All vehicle information should be seen.
  As a user, I should be able to see all vehicle information in a table under Fleet-Vehicle page

  Background: login as a store manager
    Given the user logged in as "store manager"
    When the user navigates to "Fleet" "Vehicles"

  @TRN-1672
  Scenario: All vehicle information under 'Fleet-Vehicles' module should be seen.
    Then All vehicles information table should be seen under Fleet-Vehicle page

  @TRN-1673
  Scenario: User can see the total page number
    Then User should see total page number

  @TRN-1674
  Scenario: User can go to next page clicking ">" button and
  can go to previous page clicking "<" button .
    Then User should go to the next page clicking forward button
    Then User should go to the previous page clicking back button

  @TRN-1675
    Scenario: User can see total recordings of vehicles
    Then user should see total recordings of vehicles

  @TRN-1676
  Scenario: User can download table data in XLS format from
  "Export Grid" (a confirmation message is enough to validate)
    When User clicks on export grid link
    And User clicks on XLS link
    Then User can download table data

  @TRN-1677
  Scenario: User can download table data in CSV format from
  "Export Grid" (a confirmation message is enough to validate)
    When User clicks on export grid link
    And User clicks on CSV link
    Then User can download table data








