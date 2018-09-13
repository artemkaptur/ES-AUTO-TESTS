Feature: Evening standard logout test
#As a user
#I want to be able logout
#So that nobody else can't get my private info

  Background:
    Given I open the main page
    Then  logout button doesn't exist
    Then  I open login form

  Scenario: I can logout
    When  I login as a user "MAILRU_MAIL_USER"
    And   click logout button
    Then  login button is displayed
