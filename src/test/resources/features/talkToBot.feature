Feature: Talk to Bot

  @openANewCD
  Scenario: Open a new CD
    Given I logged into Kore & talking with WealthAdvisoryBot
    When I select Open a new CD
    Then Please fill the CD form reply should be given

  @failure
  Scenario: Demo a failure
    Given I logged into Kore & talking with invalid BOT
    When I cannot proceed
    Then Test case should be failed