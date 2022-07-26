@TRN-1661
Feature: Default

  Background:
    Given the user logged in as "store manager"
    Then the user navigates to "Fleet" "Vehicles"


  @TRN-1657
  Scenario Outline: US001-TC01 verify that user can see the "General Information" page by clicking on any row
    When user on All Cars page and user clicks "<rowNum>" .row on the All Cars page
    Then user should lands on General Information page
    Examples:
      | rowNum |
      | 1      |
      | 2      |
      | 3      |


  @TRN-1658
  Scenario: US001-TC02 verify that user can see the "General Information" page clicking on the "Eye (View)" icon at the end of each row
    When user on All Cars page and user clicks any three dot at the end of the row and clicks Eye "View" icon
    Then user should lands on General Information page


  @TRN-1659
  Scenario Outline: US001-TC03 verify that user should see "Edit", "Delete" and "Add Event" buttons
    When user clicks "<rowNum>" .row
    Then user should lands on General Information page
    Then Edit, Delete, and Add Event button should be displayed
    Examples:
      | rowNum |
      | 4      |
      | 5      |
      | 6      |


  @TRN-1660
  Scenario Outline: US001-TC04 verify that "General Information" page and "Fleet-Vehicle" page information same
    Then check and store all information of "<rowNum>" .row
    When user clicks "<rowNum>" .row
    Then verify the all information are all same for both pages
    Examples:
      | rowNum |
      | 7      |
      | 8      |
      | 9      |