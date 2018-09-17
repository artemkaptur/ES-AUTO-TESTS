Feature: Evening Standard "GO London" section - Content

  #As a user
  #I want to know that all article links contain related subsections tags, and these tags lead to these subsections
  #So I can open article and click these tags
  Scenario Outline: All article links contain related subsections tags, and these tags lead to these subsections
    Given I open "https://www.standard.co.uk/go/london/theatre/emilia-at-shakespeares-globe-first-look-at-production-pictures-a3911901.html"
    When I click "<tag>" tag
    Then page with "<label>" is opened

    Examples:
      | tag | label               |
      | 1   | SHAKESPEARE         |
      | 2   | CHARITY WAKEFIELD   |
      | 3   | THEATRE             |
      | 4   | ARTS                |
      | 5   | SHAKESPEARE'S GLOBE |
