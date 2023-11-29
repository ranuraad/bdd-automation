Feature: Talk to Bot API

  @openANewCDAPI
  Scenario: Open a new CD via API
    Given I have access to open a new CD API
    When I send the API request
    Then I should receive the response

  @failure
  Scenario: Demo an API failure
    Given I have access to API failure
    When I send invalid API request
    Then I should receive the failure response