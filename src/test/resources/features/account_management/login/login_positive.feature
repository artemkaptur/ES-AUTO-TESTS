Feature: Evening standard login positive tests

#recurrent actions go below - in "Background section"
  Background:
    Given I open the main page
    Then  logout button doesn't exist
    Then  I open login form

#As a user
#I want to login with correct credentials
#So that i can use all available functionality of application

  @pending
  Scenario: I can login with correct credentials
    When  submit form with credentials "Casper17oioi@mail.ru", "test1234test"
    Then  logout button exists

#As a user
#I want to be able recover my password
#So that i can restore access to my account
  @pending
  Scenario: I can recover his password
    When  I click forgotten password
    And   enter email "Casper17oioi@mail.ru"
    And   go to the mail box and open reset password link
    And   enter new password "test5678test"
    Then  successful reset password message should be shown
