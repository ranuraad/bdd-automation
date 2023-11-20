Feature: Talk to Bot

  @init
  Scenario: Open a new CD
    Given I logged into Kore & talking with WealthAdvisoryBot
    When I select Open a new CD
    Then Please fill the CD form reply should be given