Feature: List Get attribute Tasks

  @getAttributeTask
  Scenario: get attribute Tasks
    Given I opened the login page
    When get attribute
    Then Assert the page attribute