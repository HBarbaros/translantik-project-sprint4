@TRN-1652 @id @smoke
Feature: US-005 Add Event-1

  @TRN-1648 @TRN-1649 @id
  Scenario: US005-AC1-Ilker-Verify that Store Manager can access "General Information" page by clicking on any vehicle/row
    When Store manager click on any vehicle
    And Store manager will see "General Information" page

  @TRN-1653 @TRN-1649 @id
  Scenario: US005-AC2-Verify that Store Manager can click the "Add Event" button
    When Store manager click on any vehicle
    Then Store manager can see addEvent button
    And Store manager can click on addEvent button

  @TRN-1662 @TRN-1649 @id
  Scenario: US005-AC4-Verify that Compulsory fields are shown
    Given Store manager click on any vehicle
    When Store manager can click on addEvent button
    Then Compulsory Fields must be shown
      | Title                  |
      | Owner                  |
      | Organizer display name |
      | Organizer email        |
      | Start                  |
      | End                    |

  @TRN-1664 @TRN-1649 @id
  Scenario: US005-AC3-Verify that the "Add Event" page should pop up, after clicking on the "Add event" button,
    When Store manager click on any vehicle
    When Store manager can click on addEvent button
    Then "Add Event" Page opens

  @TRN-1665 @TRN-1649 @id
  Scenario Outline: US005-AC5-Verify that  if any compulsory field is not filled, "This value should not be blank." message should be displayed after clicking on the save button.
    When Store manager click on any vehicle
    And Store manager can click on addEvent button
    Then Store manager should not save even without filling out compulsory "<Title>" , "<Organizer display name>", "<Organizer email>"
    Examples:
      | Title  | Organizer display name | Organizer email  |
      | Tranka |                        | ale1457@mail.com |
      | Test   | Mike                   |                  |
    #  |        | John                   | dd@mail.com      |
