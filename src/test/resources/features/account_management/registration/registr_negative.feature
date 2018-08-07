Feature: Evening standard registration negative tests
#As a product owner
#I want to be sure that nobody can register with already used email
#So that there wouldn't be any conflicts in user's data base

  Background:
    Given I open the main page
    Given I click register button

  Scenario: user can't register with already used email
    When  I fill registration form with "YANDEX_MAIL_USER" email, "John", "Smith"
    And   fill registration form mandatory fields with:
      | country   | Belarus  |
      | birthyear | 1999     |
      | gender    | Male     |
      | password  | test7890 |
    Then  I verify that complete registration page is opened
