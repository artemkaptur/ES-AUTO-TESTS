Feature: Header Subsections Tests
  Check Header subsections' links at main page (https://www.standard.co.uk/)

  Background: User open page https://www.standard.co.uk/ (main page)
    Given I open the main page

  # As a user
  # I want to see all available sections and subsections
  # So when I move mouse at section's name then I see the list of subsections
  Scenario: Verify that drop-down list on News section is displayed when user moves mouse on it and has correct link
    Then main menu item number "1" "News" contains list of sub-menus and they have valid href
      | London    | news/london    |
      | Crime     | news/crime     |
      | Politics  | news/politics  |
      | Transport | news/transport |
      | UK        | news/uk        |
      | World     | news/world     |
      | Business  | business       |
      | Education | news/education |
      | Health    | news/health    |

  Scenario: Verify that drop-down list on Comment section is displayed when user moves mouse on it and has correct link
    Then main menu item number "2" "Comment" contains list of sub-menus and they have valid href
      | Editorials         | author/evening-standard-comment-1                                                   |
      | The Londoner       | news/londoners-diary                                                                |
      | Cartoon            | news/london/the-evening-standard-political-cartoon-by-christian-adams-a3530851.html |
      | London Calling     | comment/comment/london-calling-cartoon-by-kipper-williams-a3849801.html             |
      | The Reader         | comment/letters                                                                     |
      | Matthew d'Ancona   | author/matthew-dancona-0                                                            |
      | Charlotte Edwardes | author/charlotte-edwardes                                                           |
      | Ayesha Hazarika    | author/ayesha-hazarika                                                              |
      | Rohan Silva        | author/rohan-silva                                                                  |
      | Anne McElvoy       | author/anne-mcelvoy-0                                                               |
      | Laura Weir         | author/laura-weir                                                                   |
      | Sam Leith          | author/sam-leith                                                                    |

  Scenario: Verify that drop-down list on Football section is displayed when user moves mouse on it and has correct link
    Then main menu item number "3" "Football" contains list of sub-menus and they have valid href
      | Arsenal           | sport/football/arsenal          |
      | Chelsea           | sport/football/chelsea          |
      | Crystal Palace    | sport/football/crystalpalace    |
      | Fulham            | sport/football/fulham           |
      | Liverpool         | sport/football/liverpool        |
      | Manchester City   | sport/football/manchestercity   |
      | Manchester United | sport/football/manchesterunited |
      | Tottenham         | sport/football/tottenham        |
      | West Ham          | sport/football/westham          |
      | Barcelona         | sport/football/barcelona        |
      | Real Madrid       | sport/football/realmadrid       |
      | Transfer news     | sport/football/transfer-news    |
      | Other sport       | sport                           |

  Scenario: Verify that drop-down list on GoLondon section is displayed when user moves mouse on it and has correct link
    Then main menu item number "4" "GO London" contains list of sub-menus and they have valid href
      | Tickets      | go/london/theatre/tickets |
      | Restaurants  | go/london/restaurants     |
      | Pubs & Bars  | go/london/bars            |
      | Arts         | go/london/arts            |
      | Theatre      | go/london/theatre         |
      | Film         | go/london/film            |
      | Music        | go/london/music           |
      | Things to do | go/london/attractions     |

  Scenario: Verify that drop-down list on Lifestyle section is displayed when user move mouse on it and has correct link
    Then main menu item number "5" "Lifestyle" contains list of sub-menus and they have valid href
      | Fashion          | fashion                |
      | Tech             | tech                   |
      | ES Best          | shopping/esbest        |
      | Food & Drink     | lifestyle/foodanddrink |
      | Beauty           | beauty                 |
      | Health & Fitness | lifestyle/health       |
      | Travel           | lifestyle/travel       |
      | Design           | lifestyle/design       |
      | Books            | lifestyle/books        |
      | ES Magazine      | lifestyle/esmagazine   |

  Scenario: Verify that drop-down list on Showbiz sections is displayed when user moves mouse on it and has correct link
    Then main menu item number "6" "Showbiz" contains list of sub-menus and they have valid href
      | Staying In | stayingin        |
      | TV reviews | topic/tv-reviews |
      | Music news | stayingin/music  |

  Scenario: Verify that drop-down list on Homes&Property section is displayed when user moves mouse on it and has correct link
    Then main menu item number "7" "Homes & Property" contains list of sub-menus and they have valid href
      | Property News | http://www.homesandproperty.co.uk/property-news |
      | Area Guides   | http://www.homesandproperty.co.uk/area-guides   |
      | Home & Garden | http://www.homesandproperty.co.uk/home-garden   |
      | Luxury        | http://www.homesandproperty.co.uk/luxury        |

  Scenario: Verify that drop-down list on FutureLondon section is displayed when user moves mouse on it and has correct link
    Then main menu item number "9" "Future London" contains list of sub-menus and they have valid href
      | Clean Air | futurelondon/cleanair |
      | Health    | futurelondon/health   |

  Scenario: Verify that ESMagazine section is displayed and has correct link
    Then ESMagazine section should have valid href "lifestyle/esmagazine"
