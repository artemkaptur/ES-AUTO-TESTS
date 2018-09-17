Feature: Start mobile app

  # As a user
  # I want to install app on device and launch it
  Scenario: Opening ES application
    Given I install Standard app on mobile device
    And I launch Standard app
    Then I see all news subsections on app screen

  # As a user
  # I want to navigate between main menu sections
  Scenario Outline: I can navigate between main menu sections
    When I open section "<section>"
    Then I am in this section "<section>"

    Examples:
      | section          |
      | EDITIONS         |
      | ES MAGAZINE      |
      | HOMES & PROPERTY |

  # As a user
  # I want to open settings of mobile app
  Scenario: I can open app settings after launching it
    When I click control button
    And I click settings button
    And I click on General settings
    Then I see settings activity
