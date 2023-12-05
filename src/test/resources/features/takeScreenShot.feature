Feature: Take Screen Shot

  @takeScreenShot
  Scenario: Take screen shot
    Given I opened the login page
    When I take screen shot
    Then Close web driver