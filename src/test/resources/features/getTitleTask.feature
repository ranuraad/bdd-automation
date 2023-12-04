Feature: List Title Tasks

  @getTitle
  Scenario: Get page title
    Given I opened the login page
    When Get web page title
    Then Assert the page title