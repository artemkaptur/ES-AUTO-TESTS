Feature: Evening standard registration negative tests
#As a product owner
#I want to be sure that nobody can register with already used email
#So that there wouldn't be any conflicts in user's data base

  Background:
    Given I open the main page
    Given I click register button

  Scenario: user can't register with already used email
    When  I fill registration form with "YANDEX_MAIL_USER" email, "John", "Smith"
    Then  "Email cannot be used. Try another" message should be shown under email field at registration form
