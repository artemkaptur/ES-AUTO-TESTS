Feature: Evening standard registration positive tests
#As a user
#I want to be able register
#So that i can get all functionality of application

  Background:
    Given I open the main page
    Given I click register button
    
  Scenario: I can register
    When  I fill registration form with random email, "John", "Smith"
    And   fill registration form mandatory fields with:
      | country   | Belarus  |
      | birthyear | 1999     |
      | gender    | Male     |
      | password  | test7890 |
    Then  successful registration message should be shown
    And  click logout button
    And  I open login form
    And  I login as a user registrationPositiveTestUser
    Then  click logout button

  Scenario: I can register with facebook
    When  I click facebook icon
    Then  new window with facebook login page should be opened

  Scenario: I can register with twitter
    When  I click twitter icon
    Then  new window with twitter login page should be opened

  Scenario: I can register with g+ account
    When  I click google icon
    Then  new window with google login page should be opened
