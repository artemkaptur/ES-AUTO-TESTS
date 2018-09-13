Feature: Evening standard registration fields validation first form
#As a user
#I want to receive warning messages
#So that i can easily rewrite wrong values

  Background:
    Given I open the main page
    Given I click register button

  Scenario Outline: I can't enter invalid email
    When  I fill email field with <email>
    Then  "Please enter a valid email", "Email address is invalid" or "Email cannot be used" warning message should be shown

    Examples:
      | email                   |
      | test                    |
      | test@gmail              |
      | te@st@gmail.com         |
      | te()st@gmail.com        |
      | test@example.com        |
      | test@gm!#$%^&*()ail.com |
      | test@gmail.co!#$%^&*()m |

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
