Feature: Open EveningStandard page

  @Start
  Scenario: Verify that user can open EveningStandard main page
    Given I navigate to the page with URL 'https://standard.co.uk'
    Then an element by xpath "//a[@class='logo']" exists
