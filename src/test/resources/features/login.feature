@login
Feature: Default

  @TRN-1524
  Scenario Outline: US01-TC01 login with valid credentials
    Given user is on Translatik login page
    When user enters "<username>" and "<password>"
    Then user lands on the "<expected_page_heading>" page
    And user validates page URL
    And user validates page title
    And user validates breadcrumb element is visible and equals "<expected_page_heading>"

    Examples: Valid credentials are listed below

      | username        | password    | expected_page_heading |
      | user10          | UserUser123 | Quick Launchpad       |
      | user20          | UserUser123 | Quick Launchpad       |
      | user21          | UserUser123 | Quick Launchpad       |
      | user32          | UserUser123 | Quick Launchpad       |
      | storemanager51  | UserUser123 | Dashboard             |
      | storemanager52  | UserUser123 | Dashboard             |
      | storemanager71  | UserUser123 | Dashboard             |
      | storemanager82  | UserUser123 | dashboard             |
      | salesmanager101 | UserUser123 | dashboard             |
      | salesmanager102 | UserUser123 | dashboard             |
      | salesmanager121 | UserUser123 | dashboard             |
      | salesmanager132 | UserUser123 | dashboard             |

  @TRN-1531
  Scenario Outline: US01-TC02 can't login with invalid credentials
    Given user is on Translatik login page
    When user enters "<username>" and "<password>"
 #   Then user sees Invalid user name or password message
    Then user remains at the login page
    Examples: Invalid credentials are listed below

      | username        | password    |
      | user10          | invalid     |
      | invalid         | UserUser123 |
      | user21          |             |
      |                 | UserUser123 |
      | storemanager51  | invalid     |
      | invalid         | UserUser123 |
      | storemanager71  |             |
      |                 | UserUser123 |
      | salesmanager101 | invalid     |
      | invalid         | UserUser123 |
      | salesmanager121 |             |
      |                 | UserUser123 |
      |                 |             |

  @TRN-1532
  Scenario Outline: US01-TC03 can't login with old URL after logout
    Given user is on Translatik login page
    When user enters "<username>" and "<password>"
    And user copies page URL, logs out, enters copied URL
    Then user remains at the login page

    Examples: Valid credentials are listed below

      | username        | password    |
      | user10          | UserUser123 |
      | storemanager51  | UserUser123 |
      | salesmanager101 | UserUser123 |

  @TRN-1533
  Scenario Outline: US01-TC04 user remains logged in after passing a new tab while the previous was open
    Given user is on Translatik login page
    When user enters "<username>" and "<password>"
    Then user lands on the "<expected_page_heading>" page

    Examples: Valid credentials are listed below

      | username        | password    |
      | user10          | UserUser123 |
      | storemanager51  | UserUser123 |
      | salesmanager101 | UserUser123 |


  @TRN-1534 @problem
  Scenario Outline: US01-TC05 user can't remain logged in after quitting browser without logout and passing a new browser
    Given user is on Translatik login page
    When user enters "<username>" and "<password>"user can't remain at the "<expected_page>"

    Examples: Valid credentials are listed below

      | username        | password    |expected_page |
      | user10          | UserUser123 |Quick Launchpad       |
      | storemanager51  | UserUser123 |Dashboard             |
      | salesmanager101 | UserUser123 |dashboard             |


  @TRN-1537
  Scenario Outline: US01-TC06 leading and trailing spaces entered into the Username field should be trimmed
    Given user is on Translatik login page
    When user enters "<username>" and "<password>" with spaces
    Then user lands on the "<expected_page_heading>" page

    Examples: Valid credentials are listed below

      | username        | password    | expected_page_heading |
      | user10          | UserUser123 | Quick Launchpad       |
      | storemanager51  | UserUser123 | Dashboard             |
      | salesmanager101 | UserUser123 | dashboard             |


  @TRN-1538
  Scenario: US01-TC07 user can see proper placeholders in username and password boxes
    When user is on Translatik login page
    Then user can see placeholder in username and password input boxes

  @TRN-15xx
  Scenario Outline: US01-TC08 user receives warning messages for invalid credentials and empty fields
    Given user is on Translatik login page
    When user enters "<username>" and "<password>"
    Then "<warning_message>" should be displayed for invalid entry or any empty field

    Examples:
      | username       | password    | warning_message              |
      | user10         | invalid     | Invalid username or password |
      | invalid        | UserUser123 | Invalid username or password |
      | storemanager51 |             | Please fill out this field   |
      |                | UserUser123 | Please fill out this field   |
      |                |             | Please fill out this field   |


