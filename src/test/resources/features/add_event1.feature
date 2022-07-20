
Feature: Default

  Background:
		#@TRN-1650
    Given user login successfully with "store manager" valid credentials.

@ac1
Scenario: US005-AC1-Ilker-Verify that Store Manager can access "General Information" page by clicking on any vehicle/row
When user navigates to Fleet, Vehicles
Then title should be Vehicles
Then user clicks on any vehicle