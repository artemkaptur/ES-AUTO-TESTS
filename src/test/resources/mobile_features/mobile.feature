Feature: Start mobile app

  # As a user
  # I want to install app on device and launch it
  Scenario: Opening ES application
    Given I install Standard app on mobile device
    And I launch Standard app
    Then I see all news subsections on app screen
