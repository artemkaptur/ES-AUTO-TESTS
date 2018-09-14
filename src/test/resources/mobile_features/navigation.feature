Feature: Navigation Feature
  Check navigation features in ES Application

  Background: I open ES Application
    Given I launch Standard app
    When I close intro slideshow

  # As a user I want to download any section ("Edition", "Es magazine", "Homes&property") for every day till 14/02/2018
  # So when I open ES Application
  # Then I see button "Download"
  @pending
  Scenario Outline: I can see button "Download" at any section
    When I open section "<section>"
    And choose date "<date>"
    Then button "Download" should be visible
    Examples:
      | section          | date       |
      | EDITIONS         | 16/02/2018 |
      | ES MAGAZINE      | 23/02/2018 |
      | HOMES & PROPERTY | 21/02/2018 |

  # As a user I want to download any section ("Edition", "Es magazine", "Homes&property") for every day till 14/02/2018
  # So when I open ES Application
  # Then I see button "Download"
  @pending
  Scenario Outline: I can download magazine at any section
    When I open section "<section>"
    And choose date "<date>"
    And click button "Download"
    Then I see label "Downloading"
    And after downloading under edition in section "<section>" button "Download" changed to "Read"
    Examples:
      | section          | date       |
      | EDITIONS         | 16/02/2018 |
      | ES MAGAZINE      | 23/02/2018 |
      | HOMES & PROPERTY | 21/02/2018 |

  # As a user
  # I can be able to perform left and right swipes to turn the magazines' pages
  @pending
  Scenario Outline: I can turn pages by swiping left and right
    When I open section "<section>"
    And click button "Read" under downloaded edition
    Then I can read the edition and turn pages by swiping left and right
    Examples:
      | section          |
      | EDITIONS         |
      | ES MAGAZINE      |
      | HOMES & PROPERTY |

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
    Then I can swipe right and left to see all availabale articles

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
