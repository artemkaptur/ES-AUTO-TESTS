Feature: Header Subsections Tests
  Check Header subsections' links at main page (https://www.standard.co.uk/)

  Background: User open page https://www.standard.co.uk/ (main page)
    Given I open the main page

  # As a user
  # I want to see all available sections and subsections
  # So when I move mouse at section's name then I see the list of subsections
  @pending
  Scenario Outline: Verify that drop-down list on News section is displayed when user moves mouse on it and has correct link
    Then main menu item "News" contains sub-menu "<subsection>"
    And sub-menu "<subsection>" should have valid href "<href>"

    Examples:
      | subsection | href            |
      | London     | /news/london    |
      | Crime      | /news/crime     |
      | Politics   | /news/politics  |
      | Transport  | /news/transport |
      | UK         | /news/uk        |
      | World      | /news/world     |
      | Business   | /business       |
      | Education  | /news/education |
      | Health     | /news/health    |

  @pending
  Scenario Outline: Verify that drop-down list on Comment section is displayed when user moves mouse on it and has correct link
    Then main menu item "Comment" contains sub-menu "<subsection>"
    And sub-menu "<subsection>" should have valid href "<href>"

    Examples:
      | subsection         | href                                                                                 |
      | Editorials         | /author/evening-standard-comment-1                                                   |
      | The Londoner       | /news/londoners-diary                                                                |
      | Cartoon            | /news/london/the-evening-standard-political-cartoon-by-christian-adams-a3530851.html |
      | London Calling     | /comment/comment/london-calling-cartoon-by-kipper-williams-a3849801.html             |
      | The Reader         | /comment/letters                                                                     |
      | Matthew d'Ancona   | /author/matthew-dancona-0                                                            |
      | Charlotte Edwardes | /author/charlotte-edwardes                                                           |
      | Ayesha Hazarika    | /author/ayesha-hazarika                                                              |
      | Rohan Silva        | /author/rohan-silva                                                                  |
      | Anne McElvoy       | /author/anne-mcelvoy-0                                                               |
      | Laura Weir         | /author/laura-weir                                                                   |
      | Sam Leith          | /author/sam-leith                                                                    |

  @pending
  Scenario Outline: Verify that drop-down list on Football section is displayed when user moves mouse on it and has correct link
    Then main menu item "Football" contains sub-menu "<subsection>"
    And sub-menu "<subsection>" should have valid href "<href>"

    Examples:
      | subsection     | href                          |
      | Arsenal        | /sport/football/arsenal       |
      | Chelsea        | /sport/football/chelsea       |
      | Crystal Palace | /sport/football/crystalpalace |
      | Tottenham      | /sport/football/tottenham     |
      | West Ham       | /sport/football/westham       |
      | Transfer news  | /sport/football/transfer-news |
      | Other sport    | /sport                        |

  @pending

  Scenario Outline: Verify that drop-down list on GoLondon section is displayed when user moves mouse on it and has correct link
    Then main menu item "GO London" contains sub-menu "<subsection>"
    And sub-menu "<subsection>" should have valid href "<href>"

    Examples:
      | subsection   | href                       |
      | Tickets      | /go/london/theatre/tickets |
      | Restaurants  | /go/london/restaurants     |
      | Pubs & Bars  | /go/london/bars            |
      | Arts         | /go/london/arts            |
      | Theatre      | /go/london/theatre         |
      | Film         | /go/london/film            |
      | Music        | /go/london/music           |
      | Things to do | /go/london/attractions     |

  @pending
  Scenario Outline: Verify that drop-down list on Lifestyle section is displayed when user move mouse on it and has correct link
    Then main menu item "Lifestyle" contains sub-menu "<subsection>"
    And sub-menu "<subsection>" should have valid href "<href>"

    Examples:
      | subsection       | href                    |
      | Fashion          | /fashion                |
      | Tech             | /tech                   |
      | ES Best          | /shopping/esbest        |
      | Food & Drink     | /lifestyle/foodanddrink |
      | Beauty           | /beauty                 |
      | Health & Fitness | /lifestyle/health       |
      | Travel           | /lifestyle/travel       |
      | Design           | /lifestyle/design       |
      | Books            | /lifestyle/books        |
      | ES Magazine      | /lifestyle/esmagazine   |

  @pending
  Scenario Outline: Verify that drop-down list on Showbiz sections is displayed when user moves mouse on it and has correct link
    Then main menu item "Showbiz" contains sub-menu "<subsection>"
    And sub-menu "<subsection>" should have valid href "<href>"

    Examples:
      | subsection | href              |
      | Staying In | /stayingin        |
      | TV reviews | /topic/tv-reviews |
      | Music news | /stayingin/music  |

  @pending
  Scenario Outline: Verify that drop-down list on Homes&Property section is displayed when user moves mouse on it and has correct link
    Then main menu item "Homes & Property" contains sub-menu "<subsection>"
    And sub-menu "<subsection>" should have valid href "<href>"

    Examples:
      | subsection    | href                                            |
      | Property News | http://www.homesandproperty.co.uk/property-news |
      | Area Guides   | http://www.homesandproperty.co.uk/area-guides   |
      | Home & Garden | http://www.homesandproperty.co.uk/home-garden   |
      | Luxury        | http://www.homesandproperty.co.uk/luxury        |

  @pending
  Scenario Outline: Verify that drop-down list on FutureLondon section is displayed when user moves mouse on it and has correct link
    Then main menu item "Future London" contains sub-menu "<subsection>"
    And sub-menu "<subsection>" should have valid href "<href>"

    Examples:
      | subsection | href                   |
      | Clean Air  | /futurelondon/cleanair |
      | Health     | /futurelondon/health   |

  @pending
  Scenario: Verify that ESMagazine section is displayed and has correct link
    When I click ESMagazine section
    Then page with "/lifestyle/esmagazine" should be open
