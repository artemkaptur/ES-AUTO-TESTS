Feature: Functionality in reading mode feature
  Check functionality after downloading an edition

  Background: I open ES application and download edition
    Given I launch Standard app
    And I open subsection "HOMES & PROPERTY"
    And I download edition by date "22/08/2018"

  @pending
  # As a user
  # I want to use "Thumbnails" mode
  Scenario: Check "Thumbnails" mode
    Given I open section "DOWNLOADED"
    And click button "Read" under edition with label "H&P 22/08/2018"
    When I click settings button
    And choose Thumbnails mode
    Then I see sketches of pages
    When I click settings button
    And choose Thumbnails mode
    Then I see full page again

  @pending
  # As a user
  # I want to see all pages at Thumbnails mode
  # So when I make right and left swipes pages flipped through
  Scenario: Check right & left swipes at Thumbnails mode
    Given I open section "DOWNLOADED"
    And click button "Read" under edition with label "H&P 22/08/2018"
    When I click settings button
    And choose item "Thumbnails"
    And make right swipe
    Then page counter increase
    When I make left swipe
    Then page counter decrease

  @pending
  # As a user
  # I want to make bookmarks of favourite pages and find them at "Bookmark" section
  Scenario Outline: I make bookmark and then find it at "Bookmark" section
    Given I open section "DOWNLOADED"
    And click button "Read" under edition with label "<label>"
    And I click settings button
    And click item "Bookmark"
    And choose option "Add to bookmark"
    And click settings button
    And click item "Bookmark"
    And choose option "Go to bookmarks"
    Then I see page with label "<label>" and "<page>" at bookmarks
    Examples:
      | label          | page   |
      | H&P 22/08/2018 | Page 1 |

  @pending
  # As a user
  # I want to use searching feature
  Scenario: Check user search
    Given I open section "DOWNLOADED"
    And click button "Read" under edition with label "<label>"
    And I click settings button
    And click item "Search"
    When I enter search word
      | London |
    And click search button on the keyboard
    Then I see search results with wanted word

  @pending
  # As a user
  # I want to share favourite pages
  Scenario: Check share function
    Given I open section "DOWNLOADED"
    And click button "Read" under edition with label "H&P 22/08/2018"
    When I click settings button
    And choose item "Share"
    And choose "Email" way
    And I go to page "ADD NEW ACCOUNT"
    And enter credentials
    And enter email I want to share the page
    And click send button
    Then message with shared page should appear in entered mailbox
