Feature: Default

  @TRN-1524
  Scenario Outline: US01-TC01 login with valid credentials
    Given user is on Translatik login page
    When user enters "<username>" and "<password>"
    Then user lands on the "<expected_page_heading>" page
    And user validates breadcrumb element is visible and equals "<expected_page_heading>"
    And user validates page URL
    And user validates page title


    Examples: Valid credentials are listed below

      | username        | password    | expected_page_heading |
      | user10          | UserUser123 | Quick Launchpad       |
#      | user20          | UserUser123 | Quick Launchpad       |
#      | user21          | UserUser123 | Quick Launchpad       |
#      | user32          | UserUser123 | Quick Launchpad       |
      | storemanager51  | UserUser123 | Dashboard             |
#      | storemanager52  | UserUser123 | Dashboard             |
#      | storemanager71  | UserUser123 | Dashboard             |
#      | storemanager82  | UserUser123 | dashboard             |
      | salesmanager101 | UserUser123 | dashboard             |
#      | salesmanager102 | UserUser123 | dashboard             |
#      | salesmanager121 | UserUser123 | dashboard             |
#      | salesmanager132 | UserUser123 | dashboard             |