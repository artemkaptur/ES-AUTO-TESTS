Feature: Evening Standard 'GO London' section - Header

  Background:
    Given I open the 'GO London' page
    When I click 'Search properties' button
    Then 'Go London search properties' page is opened

  #As a user
  #I want to find some information in search properties in 'Go London' section
  #So I can open 'Go London search properties' page and enter search properties and click 'INSPARE ME' button
  Scenario Outline: I able to configure search properties in 'Go London' section
    When I enter "<I`m looking for>" section
    And enter "<in>" in 'in' section
    And enter "<that serve/are/have/show>" in 'that "<number>"' section
    And enter "<that are>" in 'that are' section
    And enter "<and>" in 'and' section
    And click 'INSPARE ME' button
    Then positive result search in search properties page is shown

    Examples:
      | I`m looking for | in            | that serve/are/have/show | that are   | and                 | number |
      | bars            | all of London | live music               | top rated  | reasonable          | 5      |
      | gigs            | West End      | rock                     | top rated  | any budget          | 9      |

  #As a user
  #I want to find no result massage in search properties in 'Go London' section
  #So I can open 'Go London search properties' page and enter search properties and click 'INSPARE ME' button
  Scenario: I able to configure search properties in 'Go London' section
    When I enter "films" section
    And enter "Soho" in 'in' section
    And enter "sci-fi" in 'that "7"' section
    And enter "any rating" in 'that are' section
    And enter "will blow my budget" in 'and' section
    And click 'INSPARE ME' button
    Then negative result search in search properties page is shown
