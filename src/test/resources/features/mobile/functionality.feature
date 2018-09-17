Feature: Functionality Feature
  Check functionality in ES application

  Background: I open ES Application
    Given I launch Standard app

  @pending
# As a user
# I want to turn device around and get correct display
  Scenario: Turn device around
    When turn device around
    Then application displayed correctly

  @pending
# As a user
# I want to increase images by stretching 2 fingers
  Scenario: Increasing images by stretching 2 fingers
    When I stretching two fingers on image
    Then image increases

  @pending
# As a user
# I want to download something
# So after downloading it appears at "Download" section
  Scenario: Check files tracking at "Download" section
    Given I open subsection "<subsection>"
    When I download edition by date "<date>"
    Then edition appears in "DOWNLOADED" section with label "<label>"
      | section          | date       | label          |
      | HOMES & PROPERTY | 22/08/2018 | H&P 22/08/2018 |
