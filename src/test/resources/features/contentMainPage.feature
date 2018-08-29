Feature: Evening standard navigation content on Main Page

  Background: 
    Given I open the main page
  
  Scenario Outline: Move To Category News
     When I click on <section_link> on Main Page
     Then the <section> opened
  
    Examples:
      | section_link | section  | 
      | Football     | Football | 
      | Showbiz      | Showbiz  | 
  
  Scenario: Move To News With Video File
     When I click on news_with_playbutton on Main Page
     Then news should be with video
  
  Scenario: Open fullscreen mode on videoplayer
     When I click on news_with_playbutton on Main Page
      And I click on fullscreen button
     Then I see the video in full screen
  
  @pending
  Scenario: Open News
     When I click on news on Main Page
     Then news should be show on new Page
     
  @pending
  Scenario: Video immobilize and visible on top when user to scrolling the page
     When I click on news_with_playbutton on Main Page
      And I scroll the page
     Then video should be on the top and visible