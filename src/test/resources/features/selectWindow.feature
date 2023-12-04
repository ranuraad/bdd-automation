Feature: List Select Window Task

  @selectWindowTask
  Scenario: Select window commands
    Given Loading the window and check the actions related to window
    When I click on a button new window
    Then Check the window functions