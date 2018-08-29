Feature: Evening Standard "GO London" section - Footer

  Background:
    Given I open the 'GO London' page

  #As a user
  #I want to use "Navigation" section
  #So I can open 'Go London' page and click footer link
  Scenario Outline: Check "Navigation" section
    When I click footer "<link>"
    Then privacy "<page>" is opened
    Examples:
      | link           | page           |
      | Privacy policy | Privacy Notice |
      | Jobs           | Find a job     |
