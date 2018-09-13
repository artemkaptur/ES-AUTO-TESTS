Feature: Evening standard login negative tests

  Background:
    Given I open the main page
    Then  logout button doesn't exist
    Then  I open login form

#As a user
#I want to receive warning message
#So that i can easily rewrite login or password
  Scenario Outline: I can't login with wrong credentials
    When  I submit login form as a user "<user>"
    Then  "Invalid login or password." warning message should be shown

    Examples:
      | user                                           |
      | REGISTERED_USER_CORRECT_EMAIL_WRONG_PASSWORD   |
      | REGISTERED_USER_WRONG_EMAIL_CORRECT_PASSWORD   |
      | UNREGISTERED_USER_WRONG_EMAIL_WRONG_PASSWORD   |
      | UNREGISTERED_USER_WRONG_EMAIL_EXISTED_PASSWORD |

#As a user
#I want to receive warning message
#So that i can easily rewrite wrong email
  Scenario Outline: I can't login with invalid email
    When  I fill login form with email <email>
    Then  "Please enter an email address" message should be shown

    Examples:
      | email                   |
      | Casper                  |
      | Casp@er@mail.ru         |
      | Casper()er@mail.ru      |
      | Casper@m!#$%^&*()ail.ru |
      | Casper@mail.r!#$%^&*()u |
