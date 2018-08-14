Feature: Footer Tests
  Check Footer features: links to social networks and useful links at footer.

  Background: User open page https://www.standard.co.uk/ (main page)
    Given I open the main page

  # As a user
  # I want to find site's news from social networks
  # So I can easily find social network links and go there by clicking on social network icons
  @pending
  Scenario Outline: Verify that social network buttons work correctly
    Then  footer should have social button "<socialButton>"
    And "<socialButton>" should have valid href "<href>"

    Examples:
      | socialButton | href                                     |
      | facebook     | https://www.facebook.com/eveningstandard |
      | twitter      | https://twitter.com/standardnews         |

  # As a user
  # I want to use helpful links at site's pages
  # So that I can find them in the footer and they work correctly
  @pending
  Scenario Outline: Verify that links in footer work correctly
    When  I click footer link with "<text>"
    Then  page with "<url>" should be open

    Examples:
      | text         | url                                            |
      | All Topics   | /topics-list                                   |
      | All Authors  | /author-list                                   |
      | Archive      | /archive                                       |
      | Terms of use | /service/terms-of-use-6902768.html             |
      | Contact Us   | /service/contact-evening-standard-7185764.html |

  # As a user
  # I want to see helpful links at site's pages
  # So that I can find them in the footer and they lead to necessary page
  @pending
  Scenario Outline: Verify that all links in footer has valid attribute href
    Then  footer link with "<text>" should have valid href "<href>"

    Examples:
      | text                    | href                                      |
      | Advertisers             | http://esimedia.co.uk/                    |
      | Syndication             | http://syndication.standard.co.uk/        |
      | Homes & Property        | https://www.homesandproperty.co.uk/       |
      | Jobs                    | http://independentjobs.independent.co.uk/ |
      | London Live             | http://www.londonlive.co.uk/              |
      | The Independent         | https://www.independent.co.uk/            |
      | This is London Magazine | http://www.thisislondontickets.co.uk/     |
      | indy100                 | https://www.indy100.com/                  |

  # As a user
  # I want to see helpful links at site's pages
  # So that I can find them in the footer and they lead to necessary page
  @pending
  Scenario Outline: Verify that all links in footer has valid attribute href
    Then  footer link with "<text>" should have valid href "<href>"

    Examples:
      | text                         | href                                                                                                                      |
      | Privacy policy               | /service/privacy-policy-6925316.html                                                                                      |
      | Cookie policy                | /service/cookie-policy-7785319.html                                                                                       |
      | Code of Conduct & Complaints | /service/code-of-conduct-complaints-7467885.html                                                                          |
      | Promotion rules              | /service/promotion-rules-6914218.html                                                                                     |
      | Contributors                 | /incoming/external-contributors-terms-conditions-for-freelancers-bloggers-and-contributors-of-user-generated-8717657.html |
      | Install our apps             | /staticpage/applanding                                                                                                    |
      | Voucher Codes                | /vouchercodes                                                                                                             |
