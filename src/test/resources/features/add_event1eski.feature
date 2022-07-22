
Feature: Add Event

 Background:
		#@TRN-1650
    #Given user login successfully as store manager with valid credentials.
   Given the user logged in as "store manager"


  @ac11
Scenario: US005-AC1-Ilker-Verify that Store Manager can access "General Information" page by clicking on any vehicle/row
When the user navigates to "Fleet" "Vehicles"
Then title contains "Car"
Then user should be able to click any vehicle

  @ac22
  Scenario: AC2
    When the user navigates to "Fleet" "Vehicles"
    And user clicks on any vehicle
    Then user clicks on Add Event button

    @ac33
    Scenario: AC3
      When the user navigates to "Fleet" "Vehicles"
      And user clicks on any vehicle
      Then user clicks on Add Event button
      Then the Add Event page should pop up

      @ac44
      Scenario: AC4
        When the user navigates to "Fleet" "Vehicles"
        And user clicks on any vehicle
        And user clicks on Add Event button
        Then  Compulsory fields should be as below
        | Title                  |
        #| Owner                  |
       # | Organizer display name |
        #| Organizer email        |
        #| Start                  |
       # | End                    |