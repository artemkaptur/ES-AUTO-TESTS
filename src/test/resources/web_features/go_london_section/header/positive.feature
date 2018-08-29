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
    Then 'GO' and 'London' have another color with hover action

  #As a user
  #I want to see that toggle menu button is working and showing all available sections and subsections of site
  #So I can open 'GO London' page and click 'toggle menu' button
  Scenario: Toggle menu button is working and showing all available sections and subsections of site
    When I click 'toggle menu' button
    Then "full-menu full-menu-normal" item number "1" "News" contains list of sub-menus and they have valid href
      | London        | news/london    |
      | Crime         | news/crime     |
      | Politics      | news/politics  |
      | Transport     | news/transport |
      | UK            | news/uk        |
      | World         | news/world     |
      | Education     | news/education |
      | Health        | news/health    |
      | Future London | futurelondon   |
    And "full-menu full-menu-normal" item number "2" "Comment" contains list of sub-menus and they have valid href
      | Editorials         | author/evening-standard-comment-1                                                   |
      | The Londoner       | news/londoners-diary                                                                |
      | Cartoon            | news/london/the-evening-standard-political-cartoon-by-christian-adams-a3530851.html |
      | London Calling     | comment/comment/london-calling-cartoon-by-kipper-williams-a3849801.html             |
      | The Reader         | comment/letters                                                                     |
      | Matthew d'Ancona   | author/matthew-dancona-0                                                            |
      | Charlotte Edwardes | author/charlotte-edwardes                                                           |
      | Ayesha Hazarika    | author/ayesha-hazarika                                                              |
      | Rohan Silva        | author/rohan-silva                                                                  |
    And "full-menu full-menu-normal" item number "3" "Football" contains list of sub-menus and they have valid href
      | Arsenal           | sport/football/arsenal          |
      | Chelsea           | sport/football/chelsea          |
      | Tottenham Hotspur | sport/football/tottenham        |
      | Crystal Palace    | sport/football/crystalpalace    |
      | Watford           | sport/football/watford          |
      | West Ham          | sport/football/westham          |
      | Transfer News     | sport/football/transfer-news    |
      | Premier League    | sport/football/premier-league   |
      | Champions League  | sport/football/champions-league |
    And "full-menu full-menu-normal" item number "4" "Sport" contains list of sub-menus and they have valid href
      | Tennis      | sport/tennis  |
      | Rugby Union | sport/rugby   |
      | Cricket     | sport/cricket |
    And "full-menu full-menu-normal" item number "5" "Showbiz" contains list of sub-menus and they have valid href
      | Staying In | stayingin        |
      | TV reviews | topic/tv-reviews |
      | Music news | stayingin/music  |
    And "full-menu full-menu-normal" item number "6" "GO London" contains list of sub-menus and they have valid href
      | Restaurants          | go/london/restaurants                                                                        |
      | Bars, Pubs & Clubs   | go/london/bars                                                                               |
      | Arts                 | go/london/arts                                                                               |
      | Theatre              | go/london/theatre                                                                            |
      | Film                 | go/london/film                                                                               |
      | Music                | go/london/music                                                                              |
      | Comedy               | go/london/comedy                                                                             |
      | Events & Attractions | go/london/attractions                                                                        |
      | Great Days Out       | go/london/great-days-out                                                                     |
      | Tickets              | http://www.eveningstandardtickets.co.uk/?utm_source=standard&utm_medium=nav&utm_campaign=nav |
    And "full-menu full-menu-normal" item number "7" "Lifestyle" contains list of sub-menus and they have valid href
      | Fashion          | fashion                                                                                              |
      | Tech             | tech                                                                                                 |
      | Food & Drink     | lifestyle/foodanddrink                                                                               |
      | Beauty           | beauty                                                                                               |
      | Health & Fitness | lifestyle/health                                                                                     |
      | Travel           | lifestyle/travel                                                                                     |
      | Design           | lifestyle/design                                                                                     |
      | Books            | lifestyle/books                                                                                      |
      | ES Magazine      | lifestyle/esmagazine                                                                                 |
      | Puzzles & Games  | http://puzzles.standard.co.uk/?utm_campaign=navbar&utm_medium=nav&utm_source=nav                     |
      | Crosswords       | http://puzzles.standard.co.uk/?utm_campaign=navbar&utm_medium=navcrosswords&utm_source=navcrosswords |
      | Competitions     | esrewards                                                                                            |
      | Motors           | lifestyle/motors                                                                                     |
    And "full-menu full-menu-normal" item number "8" "Shopping" contains list of sub-menus and they have valid href
      | ES Best       | shopping/esbest                     |
      | ES Shop       | http://shop.standard.co.uk/         |
      | Travel Offers | http://traveloffers.standard.co.uk/ |
      | Voucher Codes | vouchercodes                        |
    And "full-menu full-menu-normal" item number "9" "Business & Money" contains list of sub-menus and they have valid href
      | Money Transfers    | business/hifx-international-money-transfers |
      | Business Directory | http://local.standard.co.uk/                 |
      | Health insurance   | lifestyle/health-insurance                  |
    And "full-menu full-menu-normal" item number "10" "Homes & Property" contains list of sub-menus and they have valid href
      | Property news | https://www.homesandproperty.co.uk/property-news |
      | Area guides   | https://www.homesandproperty.co.uk/area-guides   |
      | Home & garden | http://www.homesandproperty.co.uk/home-garden    |
      | Luxury        | http://www.homesandproperty.co.uk/luxury         |


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
