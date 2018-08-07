Feature: Evening standard login negative tests

#recurrent actions go below - in "Background section"
  Background:
    Given I open the main page
    Then  logout button doesn't exist
    Then  I open login form

#As a user
#I want to receive warning message
#So that i can easily rewrite login or password
  @pending
  Scenario: I can't login with wrong credentials
    When  submit form with credentials
      | registered_user_correct_email | registered_user_wrong_password | registered_user_wrong_email | registered_user_correct_password |
      | Casper17oioi@mail.ru          | test0000test                   | Caspoooooer17oioi@mail.ru   | test1234test                     |
    And   submit form with credentials
      | unregistered_user_email | unregistered_user_wrong_password | unregistered_user_email | registered_user_correct_password |
      | Jjjjjjjjjjjj@gmail.com  | testpassword7788                 | Jjjjjjjjjjjj@gmail.com  | test1234test                     |
    Then  "Invalid login or password." message should be shown

#As a user
#I want to receive warning message
#So that i can easily rewrite wrong email

  @pending
  Scenario Outline: I can't login with invalid email
    When  enter these <email>
    Then  "Please enter an email address" message should be shown

    Examples:
      | email                   |
      | Casper                  |
      | Casp@er@mail.ru         |
      | Casper()er@mail.ru      |
      | Casper@m!#$%^&*()ail.ru |
      | Casper@mail.r!#$%^&*()u |
