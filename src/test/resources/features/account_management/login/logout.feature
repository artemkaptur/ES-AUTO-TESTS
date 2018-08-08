Feature: Evening standard logout test
#As a user
#I want to be able logout
#So that nobody else can't get my private info

#recurrent actions go below - in "Background section"
  Background:
    Given I open the main page
    Then  logout button doesn't exist
    Then  I open login form

  @pending
  Scenario: I can logout
    When  submit form with credentials "Casper17oioi@mail.ru", "test1234test"
    And   click logout button
    Then  login button is displayed
