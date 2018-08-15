Feature: Footer Logo Test
  Check Footer logo

  # As a user
  # I want to see the main site's logo at each site page
  # and go to the main page by clicking on it
  @pending
  Scenario Outline: Verify that main logo in footer is displayed from all sections and leads to main page
    Given I open "<url>"
    When  I click main footer logo
    Then  main page should be open

    Examples:
      | url                                                                                  |
      | /news                                                                                |
      | /comment                                                                             |
      | /sport/football                                                                      |
      | /go/london                                                                           |
      | /showbiz                                                                             |
      | /lifestyle/esmagazine                                                                |
      | /futurelondon                                                                        |

  @pending
  Scenario Outline: Verify that main logo in footer at H&P pages is displayed from all subsections and leads to main page
    Given I open "<url>"
    When  I click main footer logo
    Then  main page should be open

    Examples:
      | url                                                                                  |
      | https://www.homesandproperty.co.uk                                                   |
      | https://www.homesandproperty.co.uk/property-news                                     |
      | https://www.homesandproperty.co.uk/area-guides/london-and-uk-area-guides             |
      | https://www.homesandproperty.co.uk/home-garden                                       |
      | https://www.homesandproperty.co.uk/luxury                                            |
