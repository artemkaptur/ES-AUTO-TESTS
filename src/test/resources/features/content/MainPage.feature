Feature: Evening standard navigation content on Main Page

  Background: 
    Given I open the main page
    
#As a user
#I want to open any navigation section link
#So that i can click on section link
  Scenario Outline: Move To Category News
     When I click on "<section_link>" on Main Page
     Then I navigate to "<name_of_section>" section
  
    Examples: 
  
      | section_link | name_of_section | 
      | football     | Football 	   | 
      | showbiz      | Showbiz 		   |

#As a user
#I want to see the video on news
#So that i can click on news with video content 
  Scenario: Move To News With Video File
     When I click on news_with_playbutton on Main Page
     Then news should be with video

#As a user
#I want to see the news
#So that i can click on news and see correct content   
  Scenario: Open News
     When I click on news on Main Page
     Then news should be show on new Page

#As a user
#I want to read news content
#So that i can click on news and read correct content 
  Scenario: News Have a News Content 
     When I click on news on Main Page
     Then news should have a news content
