Feature: Header Logo Tests
  Check if logos (main logo and Homes&Property logo) are shown at every site's page

  # As a user
  # I want to see the main logo while I surfing this site and go to main page by clicking this logo
  Scenario Outline: Verify that main logo in the header lead to the main page from all sections and subsections
    Given I open url "<section>"
    When  I click main logo
    Then  main page should be open

    Examples:
      | section              |
      | news                 |
      | comment              |
      | sport/football       |
      | showbiz              |
      | lifestyle/esmagazine |
      | futurelondon         |

  # As a user
  # I want to see the main logo while I surfing this site and go to main page by clicking this logo
  Scenario: Verify that main logo at GoLondon page leads to the main page
    Given I open url "go/london"
    When  I click main logo at GOLondon section
    Then  main page should be open

  # As a user
  # I want to see the main logo while I surfing Homes&Property section and go to main page by clicking this logo
  Scenario Outline: Verify that main logo in the header lead to the main page from H&P sections
    Given I open url "<section>"
    When  I click main logo at H&P section
    Then  main page should be open

    Examples:
      | section                                                                  |
      | https://www.homesandproperty.co.uk                                       |
      | https://www.homesandproperty.co.uk/property-news                         |
      | https://www.homesandproperty.co.uk/area-guides/london-and-uk-area-guides |
      | https://www.homesandproperty.co.uk/home-garden                           |
      | https://www.homesandproperty.co.uk/luxury                                |

  # As a user
  # I want to see the Homes&Property logo while I surfing this section and go to main H&P page by clicking on it
  Scenario Outline: Verify that the Homes&Property logo at all section's pages leads to main Homes&Property
    Given I open url "<url>"
    When  I click homes&property logo
    Then  page with url "https://www.homesandproperty.co.uk/" should be open
    Examples:
      | url                                                                      |
      | https://www.homesandproperty.co.uk/property-news                         |
      | https://www.homesandproperty.co.uk/mortgages                             |
      | https://www.homesandproperty.co.uk/area-guides/london-and-uk-area-guides |
      | https://www.homesandproperty.co.uk/luxury                                |
      | https://www.homesandproperty.co.uk/home-garden                           |
