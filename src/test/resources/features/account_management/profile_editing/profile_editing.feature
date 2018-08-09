Feature: Evening Standard profile editing positive tests

  Background:
    Given I open the main page
    And I open login form
    And I submit login form with correct credentials
    And I open profile page

  # As a user
  # I want to configure Football newsletters
  # So that i can do it when i click on Football subscription button
  @pending
  Scenario: Configuring newsletters
    When Newsletters subsection button is visible
    And I click on the Newsletters subsection button
    And I click on all subscription buttons
    Then I see that all subscription buttons have changed color to green

  # As a user
  # I want to see profile editing form
  # So that i can see editing form after clicking on "Edit profile" button
  @pending
  Scenario: Opening Edit profile form
    When Edit profile subsection button is visible
    And I click on Edit profile subsection button
    Then editing form is visible

  # As a user
  # I want to see the comments i made
  # So that i see them on Comments page
  @pending
  Scenario: Opening Comments page
    When Comments subsection button is visible
    And I click on the Comments subsection button
    Then comments form is visible

  # As a user
  # I want change my password
  # So that i can see password changing form
  @pending
  Scenario: Opening Password changing form
    When Change password subsection button is visible
    And I click on the Change password subsection button
    Then password changing form is visible

  # As a user
  # I want to see how required fields are marked
  # So that see an asterisk mark near first name field
  @pending
  Scenario: Locating asterisk mark
    When I click on Edit profile subsection button
    Then I locate an asterisk mark near first name field

  # As a user
  # I want to delete my first name on profile page
  # So that i clear First name input and save the changes
  @pending
  Scenario: Deleting profile first name
    When I click on Edit profile subsection button
    And I clear first name field
    And I click on Submit button
    Then message about successful saving after profile editing is not visible

  # As a user
  # I want to delete my last name on profile page
  # So that i clear Last name input and save the changes
  @pending
  Scenario: Deleting profile last name
    When I click on Edit profile subsection button
    And I clear last name field
    And I click on Submit button
    Then message about successful saving after profile editing is not visible

  # As a user
  # I want to remove my gender on profile page
  # So that i select empty option in Select menu and save the changes
  @pending
  Scenario: Deleting profile gender
    When I click on Edit profile subsection button
    And I select empty option on gender dropdown
    And I click on Submit button
    Then message about successful saving after profile editing is not visible

  # As a user
  # I want to change my first name on profile page
  # So that i select empty option in Select menu and save the changes
  @pending
  Scenario: Editing profile first name
    When I click on Edit profile subsection button
    And I clear first name field
    And I enter a valid name into first name field
    And I click on Submit button
    Then message about successful saving after profile editing is visible

  # As a user
  # I want to change country on profile page
  # So that i select China in Select menu and save the changes
  @pending
  Scenario: Editing profile country
    When I click on Edit profile subsection button
    And I select China as country
    And I click on Submit button
    Then message about successful saving after profile editing is visible

  # As a user
  # I want to check if i can use figures in my first name
  # So that i clear first name field and enter figures
  @Pending
  Scenario: Enter not valid first name
    When I click on Edit profile subsection button
    And I clear first name field
    And I enter a not valid name into first name field
    And I click on Submit button
    Then message about successful saving after profile editing is not visible
    And warning message about not valid first name is visible

  # As a user
  # I want to check if i can use strange symbols in my last name
  # So that i clear last name field and enter these symbols
  @pending
  Scenario: Enter not valid last name
    When I click on Edit profile subsection button
    And I clear last name field
    And I enter a not valid name into last name field
    And I click on Submit button
    Then message about successful saving after profile editing is not visible
    And warning message about not valid first name is visible

  # As a user
  # I don't want to use my old password when i am changing it
  # So that i can't see successful changing password message after submitting form with old password
  @pending
  Scenario: Changing password
    When I click on the Change password subsection button
    And I submit password changing form with old password
    Then message about successful saving after password changing is not visible

  # As a user
  # I want to see successful password changing message after changing it
  # So that I see this message after submitting password changing form
  @pending
  Scenario: Changing password message appears
    When I click on the Change password subsection button
    And I submit password changing form with new password
    Then message about successful saving after password changing is visible

  # As a user
  # I want to change my email and can't login with old email
  # So that I see warning message after login with old email
  @pending
  Scenario: Can't login with old email after changing it
    When I click on Edit profile subsection button
    And I clear email field
    And I enter valid email into email field
    And I click on submit button
    And I logout
    And I open login form
    And I fill login form with old credentials
    Then I see warning login message
