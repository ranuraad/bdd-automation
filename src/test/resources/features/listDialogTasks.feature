Feature: List Dialog Tasks

  @openDialogTasks
  Scenario: Open Dialog Tasks
    Given I logged into Kore & navigated to coversational skills
    When I click on Dialog Tasks
    Then All the Dialog Tasks should be listed