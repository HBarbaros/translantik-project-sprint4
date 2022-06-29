Feature: Mercedes page
  As a user I should accept the cookies agree button

  @mercedes
  Scenario: User clicks the cookies agree button
    Given User is on mercedes.uk homepage
    When User clicks the agree to all button
    Then pop-up frame goes off