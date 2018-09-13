Feature: Evening Standard 'GO London' section - Header

  Background:
    Given I open the main page
    And I click logo 'GO London'

  #As a user
  #I want to open GO London page
  #So I can open main page and click logo on main page and see that 'GO London' page is opened
  Scenario: I open "GO London" main page after clicking "GO London" logo
    Then 'GO London' page is opened

  #As a user
  #I want to see that logo "GO" and "London" change their color when I move mouse between then
  #So I can open 'GO London' page and move mouse between 'GO' and 'London'
  Scenario: "GO" and "London" change their color when I move mouse between then
    When I move mouse between 'GO' and 'London'
    Then 'GO' and 'London' change their color

  #As a user
  #I want to see that toggle menu button is working and showing all available sections and subsections of site
  #So I can open 'GO London' page and click 'toggle menu' button
  Scenario: Toggle menu button is working and showing all available sections and subsections of site
    When I click 'toggle menu' button
    Then all available sections and subsections of site is shown

  #As a user
  #I want to see that all navigation buttons on "GO London" main page are clickable and lead to corresponding sections
  #So I can open 'GO London' page and click 'navigation button' button
  Scenario Outline: All navigation buttons on "GO London" main page are clickable and lead to corresponding sections
    When I click "<navigation_button>" button
    Then "<label>" label on new page is displayed

    Examples:
      | navigation_button | label                   |
      | Tickets           | latest tickets          |
      | Restaurants       | restaurants             |
      | Pubs & Bars       | pubs & bars             |
      | Arts              | latest                  |
      | Theatre           | theatre                 |
      | Film              | film                    |
      | Music             | music                   |
      | Things to do      | events and things to do |

  #As a user
  #I want to see that all links in pop-ups are active and lead to corresponding topics
  #So I can open 'GO London' page and 'click navigation link' subsection in 'navigation button' section
  Scenario Outline: All links in pop-ups are active and lead to corresponding topics
    When I click "<navigation_link>" subsection in "<navigation_button>" section
    Then "<label>" label on new page is displayed

    Examples:
      | navigation_button | navigation_link | label          |
      | Tickets           | Top Shows       | latest tickets |
      | Restaurants       | Pizza           | pizza          |
      | Pubs & Bars       | Whisky          | whisky         |
      | Arts              | Dance           | dance          |
      | Theatre           | Comedy          | comedy         |
      | Film              | Animation       | animation      |
      | Music             | R&B             | r&b            |
      | Things to do      | For kids        | kids           |

  #As a user
  #I want to see that 'user menu' and 'search' button place on same line
  #So I can open 'GO London' page
  Scenario: User menu and search button place on same line
    Then 'user menu' and 'search' button place on same line
