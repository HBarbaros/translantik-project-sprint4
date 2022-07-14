@TRN-1515 @login
Feature: Login functionality

  Background:
    Given user is on Translatik login page


  @TRN-1524 @AC01
  Scenario Outline: US01-TC01 login with valid credentials
    When user enters "<username>" and "<password>"
    Then user lands on the "<expected_page_heading>" page
    And user validates page URL
    And user validates page title
    And user validates breadcrumb element is visible and equals "<expected_page_heading>"

    Examples: Valid credentials are listed below

      | username        | password    | expected_page_heading |
      | user10          | UserUser123 | Quick Launchpad       |
      | storemanager51  | UserUser123 | Dashboard             |
      | salesmanager101 | UserUser123 | dashboard             |

  @TRN-1531 @AC02a
  Scenario Outline: US01-TC02 can't login with invalid credentials
    When user enters "<username>" and "<password>"
    Then user remains at the login page
    Examples: Invalid credentials are listed below

      | username        | password    |
      | user10          | invalid     |
      | user            | UserUser123 |
      | user21          |             |
      |                 | Userser123  |
      | storemanager51  | invalid     |
      | storemanager51  | userUser123 |
      | storemanager71  |             |
      | store manager71 | UserUser123 |
      | salesmanager101 | useruser123 |
      | invalid         | UserUser123 |
      | salesmanager121 | UserUser321 |
      | salesmanager121 | User?ser123 |
      |                 |             |

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

  @TRN-1533 @AC03a
  Scenario Outline: US01-TC04 user remains logged in after passing a new tab while the previous was open
    When user enters "<username>" and "<password>"
    And copies the URL, opens a new TAB, closes the previous TAB and then pastes the URL
    Then user remains logged in on the dashboard page "<expected_page_title>"

    Examples: Valid credentials are listed below

      | username        | password    | expected_page_title |
      | user10          | UserUser123 | Dashboard           |
      | storemanager51  | UserUser123 | Dashboard           |
      | salesmanager101 | UserUser123 | Dashboard           |


  @TRN-1534 @AC03b
  Scenario Outline: US01-TC05 user can't remain logged in after quitting browser without logout
    When user enters "<username>" and "<password>"
    And user copies URL, closes browser, opens new browser and pastes the URL
    Then user can't remain logged in on the "<expected_page_title>"

    Examples: Valid credentials are listed below

      | username        | password    | expected_page_title |
      | user10          | UserUser123 | Dashboard           |
      | storemanager51  | UserUser123 | Dashboard           |
      | salesmanager101 | UserUser123 | Dashboard           |


  @TRN-1537 @AC04
  Scenario Outline: US01-TC06 leading and trailing spaces entered into the Username field should be trimmed
    When user enters "<username>" and "<password>" with spaces
    Then user should log in the "<expected_page_title>"

    Examples: Valid credentials are listed below

      | username        | password    | expected_page_title |
      | user10          | UserUser123 | Dashboard           |
      | storemanager51  | UserUser123 | Dashboard           |
      | salesmanager101 | UserUser123 | Dashboard           |


  @TRN-1538 @AC05
  Scenario: US01-TC07 user can see proper placeholders in username and password boxes
    Then user can see placeholder in username and password input boxes

  @TRN-1539 @AC06
  Scenario Outline: US01-TC08 user receives warning messages for invalid credentials and empty fields
    When user enters "<username>" and "<password>"
    Then "<message>" should be displayed for invalid entry or any empty field

    Examples:
      | username       | password    | message                        |
      | user10         | invalid     | Invalid user name or password. |
      | invalid        | UserUser123 | Invalid user name or password. |
      | storemanager51 |             | Please fill in this field.     |
      |                | UserUser123 | Please fill in this field.     |
      |                |             | Please fill in this field.     |

  @TRN-1564 @AC07
  Scenario: US01-TC09 user can't see the password entered to the password input box
    Then user enters password in the input box
    And password text is toggled to hide its visibility

  @TRN-1566 @AC08
  Scenario Outline: US01-TC10 user can't see the password in the source page
    When user enters "<username>" and "<password>"
    Then "<password>" shouldn't be displayed in the page source

    Examples: Valid credentials are listed below

      | username | password    |
      | user10   | UserUser123 |

  @TRN-1567 @AC09
  Scenario: US01-TC11 user can't copy the text entered into the password field
    When user enters valid password to the password input box
    And copies the entered password from the password box then the two text shouldn't match

  @TRN-1568 @AC10
  Scenario: US01-TC12 users can change their passwords with username
    When user clicks forgot password link lands on the forgot_password_page
    And user enters username "user10" to the box and clicks the request button
    Then user sees the success message


  @TRN-1569 @AC11
  Scenario: US01-TC13 user can see remember me link on the login page and validate it is clickable
    And user validates the remember me checkbox is clickable

  @TRN-1570 @AC12a
  Scenario Outline: US01-TC14 user can login by using keyboard keys by using ENTER key
    When user clicks username input box and enters a valid "<username>" and hits enter key
    And cursor skips to password input box and user enters a valid "<password>" and hit enter key
    Then user should log in the "<expected_page_title>"

    Examples:
      | username | password    | expected_page_title |
      | user10   | UserUser123 | Dashboard           |

  @TRN-1571 @AC12b
  Scenario Outline: US01-TC15 user can login by using keyboard keys by using TAB key
    When user clicks username input box and enters a valid "<username>" and hits tab key
    And cursor skips to password input box and user enters a valid "<password>" and hit tab key
    Then user should log in the "<expected_page_title>"

    Examples:
      | username | password    | expected_page_title |
      | user10   | UserUser123 | Dashboard           |


  @TRN-1572 @AC13
  Scenario: US01-TC16 validates background color  of login button's hex code: "#0c84a3"
    Then user validates background color of login button's hex code: "#0c84a3"
