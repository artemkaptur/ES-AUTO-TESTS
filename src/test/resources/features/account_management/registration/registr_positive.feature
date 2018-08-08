Feature: Evening standard registration positive tests
#As a user
#I want to be able register
#So that i can get all functionality of application

#recurrent actions go below - in "Background section"
  Background:
    Given I open the main page
    Given I click register button

  @pending
  Scenario: user can register
    When  I fill registration form with "test@gmail.com", "John", "Smith"
    And   fill registration form mandatory fields with:
      | country | birthyear | gender | nickname | password |
      | Belarus | 1999      | male   | Johnny   | test7890 |
    Then  successful registration message should be shown
    And   go to the mail box and check a registration successful message

  @pending
  Scenario: I can register with facebook
    When  I click facebook icon
    Then  new window with facebook login page should be opened

  @pending
  Scenario: I can register with twitter
    When  I click twitter icon
    Then  new window with twitter login page should be opened
