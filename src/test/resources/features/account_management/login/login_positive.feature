Feature: Evening standard login positive tests

  Background:
    Given I open the main page
    Then  logout button doesn't exist
    Then  I open login form

#As a user
#I want to login with correct credentials
#So that i can use all available functionality of application
  Scenario: I can login with correct credentials
    When  I login as a user "YANDEX_MAIL_USER"
    Then  click logout button

#As a user
#I want to be able recover my password
#So that i can restore access to my account
  Scenario: I can recover my password
    When  I click forgotten password
    And   enter email of user "YANDEX_MAIL_USER"
    And   go to the mail box "YANDEX_MAIL_USER" and open reset password link
    And   enter new password "test5678"
    Then  "Your password has been successfully reset." successful password change message should be shown
    And   I open login form
    And   I submit login form as a user "YANDEX_MAIL_USER"
    Then  "Invalid login or password." warning message should be shown
    And   I click forgotten password
    And   enter email of user "YANDEX_MAIL_USER"
    And   go to the mail box "YANDEX_MAIL_USER" and open reset password link
    And   enter new password "test1234"
    Then  "Your password has been successfully reset." successful password change message should be shown
