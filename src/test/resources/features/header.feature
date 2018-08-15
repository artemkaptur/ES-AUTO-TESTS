Feature: Header Tests
  Check Header's menu button, search button and profile button at main page (https://www.standard.co.uk/)

  Background: User opened page https://www.standard.co.uk/ (main page)
    Given I open the main page

  # As a user
  # I want to use menu
  # So when I click the menu button I see all available sections and subsections
  @pending
  Scenario: Verify that toggle menu button works and shows all available sections and subsections of the site
    When  I click on Toggle Menu Button
    Then  full menu should be visible

  # As a user
  # I want to be able to search the site
  @pending
  Scenario: Verify that after clicking the search button search field appears
    When I click on Toggle Search Button
    Then search field should be visible

  # As a user
  # I want to be able to search the site
  # So when I enter my inquiry in search field I get related results
  @pending
  Scenario: Verify that search button is displayed and works with Google Search algorithm
    When  I search "London"
    Then  I see results related to "London"
    And under search results should be visible Google logo
    And Google logo in search results should have valid href


  # As a user
  # I want to see list of available profile sections
  # So when I move mouse on the profile button I see list of options
  @pending
  Scenario: Verify that drop-down profile list is displayed when user move mouse on it
    When  I click on Profile Button"
    Then profile toggle menu should be visible
