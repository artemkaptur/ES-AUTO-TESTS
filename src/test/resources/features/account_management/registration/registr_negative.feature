Feature: Evening standard registration negative tests
#As a product owner
#I want to be sure that nobody can register with already used email
#So that there wouldn't be any conflicts in user's data base

#recurrent actions go below - in "Background section"
  Background:
    Given I open the main page
    Given I click register button

  @pending
  Scenario: user can't register with already used email
    When  I fill registration form with "test@gmail.com", "John", "Smith"
    And   fill registration form mandatory fields with:
      | country | birthyear | gender | nickname | password |
      | Belarus | 1999      | male   | Johnny   | test7890 |
    Then  I verify that complete registration page is opened
