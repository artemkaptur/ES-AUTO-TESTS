Feature: Evening Standard "GO London" section - Content

  Background:
    Given I open the 'GO London' page

  #As a user
  #I want to open article links
  #So I can open 'Go London' page and click link
  Scenario: I able to open article links
    When I open article by click button
    Then page with article is opened

  #As a user
  #I want to share article in Facebook
  #So I can open article and click 'facebook' label
  Scenario: I able to put Facebook like and share link on his Facebook page
    When I open article by click button
    And I click facebook label in article page
    Then new window with facebook login page should be opened

  #As a user
  #I want to know that background have black color
  #So I can open 'GO London' page
  Scenario: background has black color
    Then background is black
