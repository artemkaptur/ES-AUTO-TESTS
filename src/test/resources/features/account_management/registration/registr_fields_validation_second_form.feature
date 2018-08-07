Feature: Evening standard registration fields validation second form
#As a user
#I want to receive warning messages
#So that i can easily rewrite wrong values

  Background:
    Given I open the main page
    Given I click register button
    Then  I fill registration form with "YANDEX_MAIL_USER" email, "John", "Smith"

  Scenario: I receive warning message when passwords don't match
    When  fill registration form password fields with "test111", "test222"
    Then  "Password does not match" warning message should be shown under confirm password field

  Scenario: I can't enter zip code when Zimbabwe is picked
    When  select "Zimbabwe" country
    Then  zip code field isn't displayed

  Scenario: I can select only 1920 and higher year of birth
    When  click on select year of birth field
    Then  drop-down contains only years between 1920 and 2000

  Scenario: I can select only two genders
    When  click on select gender field
    Then  drop-down contains only "Male" and "Female" genders
    
  Scenario: I can select only countries at select country drop-down
    When  click on select country field
    Then  drop-down contains only countries

  Scenario: I can choose option receive additional offers and information by email
    Then  'I would like to receive additional offers' checkbox is clickable

  Scenario: I can't enter invalid password
    When  fill registration form password field with "11"
    Then  "Password does not meet complexity requirements" warning message should be shown under password field
