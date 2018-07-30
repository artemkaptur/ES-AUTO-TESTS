Feature: Evening standard navigation content on Homes&Property Page

  Background: 
    Given I open the main page
    Given I open the Homes&PropertyPage
  
  @pending
  Scenario: Changing tabs search properties in 'Homes&Property' section
     Then tab 'For Sale' is active
     When I click on tab 'To Rent'
     Then tab 'To Rent' is active
     When I click on tab 'For Sale'
     Then tab 'For Sale' is active
     
  @pending
  Scenario: Checking all items in property dropdown
     When I click on dropdown 'Type'
     Then The items I see are 'Flats, Houses, Bungalows, Land, Commercial Property, Other'
     
  @pending
  Scenario: Checking all items in number of bed dropdown
     When I click on dropdown 'Beds'
     Then The items I see are 'No Min, 1 Bed, 2 Bed, 3 Bed, 4 Bed, 5 Bed'
  
  @pending
  Scenario Outline: Configure search properties in 'Homes&Property' section
     When I enter <location> and choose <type>, <number_of_beds>
      And I click 'search properties' button
     Then the information found corresponds to the selected parameters
  
    Examples: 
  
      | location   | type     | number_of_beds | 
      | London     | Flats    | 1 Bed          | 
      | Manchester | Houses   | 5 Bed          |
      
  @pending
  Scenario: Checking min and max price for sale in 'Homes&Property' section 
	Then I see min price '200,000' and max price '1m'
	
  @pending
  Scenario: Checking min and max price to rent in 'Homes&Property' section 
	When I click on tab 'To Rent' 
	Then I see min price '900 PCM' and max price '3,500 PCM'
	
  @pending
  Scenario: Checking slide bar of price in 'Homes&Property' section 
	When I drag a slide bar of price
	Then I see that a price changing
	
	