Feature: Evening Standard profile editing positive tests

  Background:
    Given I open the main page
    And I check if i logged in as user "GMAIL_MAIL_USER_NEW_PASSWORD"
    And I open profile page

  # As a user
  # I want to configure all newsletters
  # So that i can do it when i click on all subscription buttons
  Scenario: Configuring newsletters
    When Newsletters subsection button is visible on profile page
    And I click on the Newsletters subsection button on profile page
    And I click on all subscription buttons on Newsletters form
    And I click newsletters submit button
    And message about successful saving after newsletters configuring is visible
    Then I see that all subscription buttons on Newsletters form have changed color to green
    And I click on all subscription buttons on Newsletters form
    And I click newsletters submit button
    And message about successful saving after newsletters configuring is visible
    Then I see that all subscription buttons on Newsletters form have changed color to red

  # As a user
  # I want to see profile editing form
  # So that i can see editing form after clicking on "Edit profile" button
  Scenario: Opening Edit profile form
    When Edit profile subsection button is visible on profile page
    And I click on Edit profile subsection button on profile page
    Then editing form is visible on profile page

  # As a user
  # I want to see the comments i made
  # So that i see them on Comments page
  Scenario: Opening Comments page
    When Comments subsection button is visible on profile page
    And I click on the Comments subsection button on profile page
    Then comments form is visible on profile page

  # As a user
  # I want change my password
  # So that i can see password changing form
  Scenario: Opening Password changing form
    When Change password subsection button is visible on profile page
    And I click on the Change password subsection button on profile page
    Then password changing form is visible on profile page

  # As a user
  # I want to see how required fields are marked
  # So that see an asterisk mark near first name field
  Scenario: Locating asterisk mark
    When I click on Edit profile subsection button on profile page
    Then I locate an asterisk mark near first name field input on edit form

  # As a user
  # I want to see warning message if my first name input is empty
  # So that i clear first name input and save the changes
  Scenario: Deleting profile first name
    When I click on Edit profile subsection button on profile page
    And I clear first name field input on edit form
    And I click on Submit button on edit form
    Then warning message about not valid first name is visible on edit form

  # As a user
  # I want to see warning message if my last name input is empty
  # So that i clear last name input and save the changes
  Scenario: Deleting profile last name
    When I click on Edit profile subsection button on profile page
    And I clear last name field input on edit form
    And I click on Submit button on edit form
    Then warning message about not valid last name is visible on edit form

  # As a user
  # I want see warning message if my gender option hasn't been chosen
  # So that i select empty option in Select menu and save the changes
  Scenario: Deleting profile gender
    When I click on Edit profile subsection button on profile page
    And I select empty option on gender dropdown on edit form
    And I click on Submit button on edit form
    Then warning message about empty gender option is visible on edit form

  # As a user
  # I want to change my first name on profile page
  # So that i enter new correct name and save the changes
  Scenario: Editing profile first name
    When I click on Edit profile subsection button on profile page
    And I clear first name field input on edit form
    And I enter a valid name into first name field input on edit form
    And I click on Submit button on edit form
    And message about successful saving after profile editing is visible on edit form
    Then I see that i have changed first name successfully

  # As a user
  # I want to change country on profile page
  # So that i select other country in Select menu and save the changes
  Scenario: Editing profile country
    When I click on Edit profile subsection button on profile page
    And I select new country from country Select dropdown on edit form
    And I click on Submit button on edit form
    And message about successful saving after profile editing is visible on edit form
    Then I see that i have changed country successfully

  # As a user
  # I want to see warning message if i use figures in my first name
  # So that i clear first name field and enter figures
  Scenario: Entering not valid first name
    When I click on Edit profile subsection button on profile page
    And I clear first name field input on edit form
    And I enter a not valid first name into first name field input on edit form
    And I click on Submit button on edit form
    Then warning message about not valid first name is visible on edit form

  # As a user
  # I want to see warning message if i use strange symbols in my last name
  # So that i clear last name field and enter these symbols
  Scenario: Entering not valid last name
    When I click on Edit profile subsection button on profile page
    And I clear last name field input on edit form
    And I enter a not valid name into last name field input on edit form
    And I click on Submit button on edit form
    Then warning message about not valid last name is visible on edit form

  # As a user
  # I want to see warning message if i repeat new password with mistakes
  # So that i see warning message after submitting password changing form
  Scenario: Changing password with mistakes
    When I click on the Change password subsection button on profile page
    And I change "GMAIL_MAIL_USER" password to "GMAIL_MAIL_USER_NEW_PASSWORD" password with mistakes
    Then warning message about not valid password repeating is visible

  # As a user
  # I want to see successful password changing message after changing it
  # So that I see this message after submitting password changing form
  Scenario: Changing password without mistakes
    When I click on the Change password subsection button on profile page
    And I change "GMAIL_MAIL_USER" password to "GMAIL_MAIL_USER_NEW_PASSWORD" password
    And message about successful password changing is visible on password changing form
    And click logout button
    And logout button doesn't exist
    And I open login form
    And I login as a user "GMAIL_MAIL_USER_NEW_PASSWORD"
    Then logout button exists

  # As a user
  # I want to change my email and can't login with old email
  # So that I see warning message after login with old email
  Scenario: Can't login with old email after changing it
    When I click on Edit profile subsection button on profile page
    And I submit edit form with "GMAIL_MAIL_USER_NEW_EMAIL" email
    And message about successful saving after profile editing is visible on edit form
    And click logout button
    And logout button doesn't exist
    And I open login form
    And I login as a user "GMAIL_MAIL_USER"
    Then "Invalid login or password." warning message should be shown

  # As a user
  # I want to see what comments i have left
  # So that i leave a comment in custom news comments section then i open profile page, go to Comments section and find it
  Scenario: Seeing the comment user has left
    When I leave a comment in custom news comments form
    And I open profile page
    And I click on the Comments subsection button on profile page
    Then I verify my comment exists in the Comments subsection button on profile page