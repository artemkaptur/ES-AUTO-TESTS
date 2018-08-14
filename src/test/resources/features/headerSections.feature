Feature: Header Logo Tests
  Check if logos (main logo and Homes&Property logo) are shown at every site's page

  # As a user
  # I want to see the main logo while I surfing this site and go to main page by clicking this logo
  @pending
  Scenario Outline: Verify that main logo in the header lead to the main page from all sections and subsections
    Given I open "<section>"
    When  I click main logo
    Then  main page should be open

    Examples:
      | section                                                                              |
      | /news                                                                                |
      | /comment                                                                             |
      | /sport/football                                                                      |
      | /go/london                                                                           |
      | /showbiz                                                                             |
      | /lifestyle/esmagazine                                                                |
      | /futurelondon                                                                        |
      | /news/london                                                                         |
      | /news/crime                                                                          |
      | /news/politics                                                                       |
      | /news/transport                                                                      |
      | /news/uk                                                                             |
      | /news/world                                                                          |
      | /business                                                                            |
      | /news/education                                                                      |
      | /news/health                                                                         |
      | /author/evening-standard-comment-1                                                   |
      | /news/londoners-diary                                                                |
      | /news/london/the-evening-standard-political-cartoon-by-christian-adams-a3530851.html |
      | /comment/comment/london-calling-cartoon-by-kipper-williams-a3849801.html             |
      | /comment/letters                                                                     |
      | /author/matthew-dancona-0                                                            |
      | /author/charlotte-edwardes                                                           |
      | /author/ayesha-hazarika                                                              |
      | /author/rohan-silva                                                                  |
      | /author/anne-mcelvoy-0                                                               |
      | /author/laura-weir                                                                   |
      | /author/sam-leith                                                                    |
      | /sport/football/arsenal                                                              |
      | /sport/football/chelsea                                                              |
      | /sport/football/crystalpalace                                                        |
      | /sport/football/tottenham                                                            |
      | /sport/football/watford                                                              |
      | /sport/football/westham                                                              |
      | /sport/football/transfer-news                                                        |
      | /sport                                                                               |
      | /go/london/theatre/tickets                                                           |
      | /go/london/restaurants                                                               |
      | /go/london/bars                                                                      |
      | /go/london/arts                                                                      |
      | /go/london/theatre                                                                   |
      | /go/london/film                                                                      |
      | /go/london/music                                                                     |
      | /go/london/attractions                                                               |
      | /fashion                                                                             |
      | /tech                                                                                |
      | /shopping/esbest                                                                     |
      | /lifestyle/foodanddrink                                                              |
      | /beauty                                                                              |
      | /lifestyle/health                                                                    |
      | /lifestyle/travel                                                                    |
      | /lifestyle/design                                                                    |
      | /lifestyle/books                                                                     |
      | /lifestyle/esmagazine                                                                |
      | /stayingin                                                                           |
      | /topic/tv-reviews                                                                    |
      | /stayingin/music                                                                     |

  # As a user
  # I want to see the main logo while I surfing Homes&Property section and go to main page by clicking this logo
  @pending
  Scenario Outline: Verify that main logo in the header lead to the main page from all sections and subsections
    Given I open "<section>"
    When  I click main logo
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
  @pending
  Scenario Outline: Verify that the Homes&Property logo at all section's pages leads to main Homes&Property
    Given I open "<url>"
    When  I click homes&property logo
    Then  page with "https://www.homesandproperty.co.uk" should be open

    Examples:
      | url                                                                      |
      | https://www.homesandproperty.co.uk/property-news                         |
      | https://www.homesandproperty.co.uk/mortgages                             |
      | https://www.homesandproperty.co.uk/area-guides/london-and-uk-area-guides |
      | https://www.homesandproperty.co.uk/luxury                                |
      | https://www.homesandproperty.co.uk/home-garden                           |
