@logout
Feature: Logout functionality

  Background:
    Given user is on Translatik login page


  @TRN-1532 @AC02b
  Scenario Outline: US01-TC03 can't login with old URL after logout
    When user enters "<username>" and "<password>"
    And user copies page URL, logs out, enters copied URL
    Then user remains at the login page

    Examples: Valid credentials are listed below

      | username        | password    |
      | user10          | UserUser123 |
      | storemanager51  | UserUser123 |
      | salesmanager101 | UserUser123 |