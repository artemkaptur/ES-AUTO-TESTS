Feature: Start mobile app

  Scenario: Opening ES application
    Given I launch Standard app
    When I close intro slideshow
    Then I see all news subsections on app screen
