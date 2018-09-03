Feature: Evening Standard password changing tests

  Background:
    Given I open the main page
    And I check if i logged in as user "GMAIL_MAIL_USER_OLD_PASS"
    And I open profile page

  # As a user
  # I want to see warning message if i repeat new password with mistakes
  # So that i see warning message after submitting password changing form
  Scenario: Changing password with mistakes
    When I click on the Change password subsection button on profile page
    And I change "GMAIL_MAIL_USER_OLD_PASS" password to "GMAIL_MAIL_USER_NEW_PASS" password with mistakes
    Then warning message about not valid password repeating is visible

  # As a user
  # I want to change my password
  # So that I submit password changing form with new password and then try to login with this password
  Scenario: Changing password without mistakes
    When I click on the Change password subsection button on profile page
    And I change "GMAIL_MAIL_USER_OLD_PASS" password to "GMAIL_MAIL_USER_NEW_PASS" password
    Then message about successful password changing is visible on password changing form
    And click logout button
    And logout button doesn't exist
    And I open login form
    And I login as a user "GMAIL_MAIL_USER_NEW_PASS"
    And I open profile page
    And I click on the Change password subsection button on profile page
    And I change "GMAIL_MAIL_USER_NEW_PASS" password to "GMAIL_MAIL_USER_OLD_PASS" password
    Then message about successful password changing is visible on password changing form
    And click logout button
    And logout button doesn't exist
    And I open login form
    Then I login as a user "GMAIL_MAIL_USER_OLD_PASS"