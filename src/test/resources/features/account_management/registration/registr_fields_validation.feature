Feature: Evening standard registration fields validation
#As a user
#I want to receive warning messages
#So that i can easily rewrite wrong values

  Background:
    Given I open the main page
    Given I click register button

  @pending
  Scenario: I receive warning message when passwords don't match
    When  I fill registration form with "test@gmail.com", "John", "Smith"
    And   fill registration form password fields with:
      | password     | confirm password |
      | test1111test | test2222test     |
    Then  "Password does not match" warning message should be shown

  @pending
  Scenario: I enter zip code when Zimbabwe is picked
    When  I fill registration form with "test@gmail.com", "John", "Smith"
    And   select "Zimbabwe" country
    Then  zip code field doesn't exist

  @pending
  Scenario: I can select only 1920 and higher year of birth
    When  I fill registration form with "test@gmail.com", "John", "Smith"
    And   click on select year of birth field
    Then  drop-down contains only 1920 and higher years

  @pending
  Scenario: I can select only two genders
    When  I fill registration form with "test@gmail.com", "John", "Smith"
    And   click on select gender field
    Then  drop-down contains only male and female genders

  @pending
  Scenario: I can select only countries at select country drop-down
    When  I fill registration form with "test@gmail.com", "John", "Smith"
    And   click on select country field
    Then  drop-down contains only countries

  @pending
  Scenario: I can choose option receive additional offers and information by email
    When  I fill registration form with "test@gmail.com", "John", "Smith"
    Then  'I would like to receive additional offers' checkbox is clickable

  @pending
  Scenario: I can't enter invalid password
    When  I fill registration form with "test@gmail.com", "John", "Smith"
    And   fill registration form password fields with:
      | password | confirm password |
      | 11       | 11               |
    Then  "Password does not meet complexity requirements" warning message should be shown

  @pending
  Scenario Outline: I can't enter invalid email
    When  I fill email field with <email>
    Then  "Please enter a valid email", "Email cannot be used" warning message should be shown

    Examples:
      | email                   |
      | test                    |
      | test@gmail              |
      | te@st@gmail.com         |
      | te()st@gmail.com        |
      | test@example.com        |
      | test@gm!#$%^&*()ail.com |
      | test@gmail.co!#$%^&*()m |

  @pending
  Scenario Outline: I can't enter invalid first and last name
    When  I fill firstname invalid <first name>
    Then  under firstname field "Please enter a valid first name" warning message should be shown
    When  I fill lastname invalid <last name>
    Then  under lastname field "Please enter a valid last name" warning message should be shown

    Examples:
      | first name                                | last name                                 |
      | 1234                                      | 5678                                      |
      | !@#$%^&()<>?.,*+-/=                       | <>?.,*+-/=!@#$%^&()                       |
      | Петя                                      | Пупкин                                    |
      | ppppppppppppppppppppppppppppppppppppppppp | hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh |
