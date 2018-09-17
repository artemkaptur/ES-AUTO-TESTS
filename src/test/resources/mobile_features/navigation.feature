Feature: Navigation Feature
  Check navigation features in ES Application

  Background: I open ES Application
    Given I launch Standard app

  # As a user 
  # I want to download magazine 
  # Then I click on any section and see button 'Download'
  Scenario Outline: I can see button 'Download' at any section
    When I open section "<section>"
    Then button "Download" should be visible
    Examples:
      | section          |
      | EDITIONS         |
      | ES MAGAZINE      |
      | HOMES & PROPERTY |

  # As a user
  # I want to download magazine from any section of application
  # Then I click on any section, click button 'Download' and see label 'Downloading'
  # And I click button 'Cancel' then a label 'Downloading' not visible
  Scenario Outline: I can download magazine at any section
    When I open section "<section>"
    And click button "Download"
    Then I see label "Downloading"
    And I click button "CANCEL"
    Then I not see label "Downloading"
    And I click button 'home' 
    Examples:
      | section          |
      | EDITIONS         |
      | ES MAGAZINE      |
      | HOMES & PROPERTY |

  # As a user
  # I want to read downloaded magazine
  # Then I download magazine i see list of all pages and button 'read'
  Scenario: Button "Read" appears when the magazine is downloaded
    When I open section "EDITION"
    When click button "Download"
    Then I see label "Downloading"
    When button "CANCEL" disappears i click button 'home'
    Then I can see list of all pages
    And I click button 'home'
    Then I see button "Read"

  # As a user
  # I want to see list of all pages and pick any
  @pending
  Scenario: I can see list of all pages and pick any
    When I open section "<section>"
    And click button "Read" under downloaded edition
    And click menu button at the upper left corner
    Then I can see list of all pages
    And can open any page

  # As a user
  # I want to open available puzzles
  @pending
  Scenario: I can open available puzzles
    When I open section "Latest news"
    And scroll to bottom of the section
    Then I see "PUZZLES" subsection
    And I can choose any puzzle
      | Sudoku Elementary | Codeword | Sudoku Advanced | Sudoku Intermediate | Cryptic Crossword | Daily Crossword | Quick Crossword |

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
      | LATEST NEWS      |

  # As a user
  # I want to hide and show news sections in "Latest news"
  @pending
  Scenario: I want to show & hide subsections in "Latest news"
    When I open section "Latest news"
    Then I can hide any subsection
      | Football |
    And can show subsection again
      | Football |

  # As a user
  # I want to scroll articles in the section "Latest news" by swiping left and right
  @pending
  Scenario: I want to scroll articles in section "Latest news" by swiping left and right
    When I open section "Latest news"
    And choose subsection
      | Football |
    Then I can swipe right and left to see all available articles

  # As a user
  # I want to open every article
  @pending
  Scenario: I can open any article
    When I open section "Latest news"
    Then I can open every article

  # As a user
  # I can move to main menu from each subsection
  @pending
  Scenario Outline: I can move to main "Latest news" menu from each subsection
    Given I open section "Latest news"
    When I open article in subsection "<subsection>"
    And click top left menu button
    Then I move to main "Latest news" menu
    Examples:
      | section          |
      | EDITIONS         |
      | ES MAGAZINE      |
      | HOMES & PROPERTY |

  # As a user
  # I want to go to section "Latest news" by clicking "Live" button
  @pending
    @lol
  Scenario: I can go to section "Latest news" by clicking "Live" button
    Given open Editions section
    And download edition
    When I click Live button
    Then I go to Latest news section