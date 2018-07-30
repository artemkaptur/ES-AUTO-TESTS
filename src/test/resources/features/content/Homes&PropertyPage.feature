Feature: Evening standard navigation content on Homes&Property Page

  Background: 
    Given I open the main page
    Given I open the Homes&PropertyPage

#As a user
#I want to change criteria search
#So that i can click tab 'For Sale' or 'To Rent'
  Scenario: Changing tabs search properties in 'Homes&Property' section
     Then tab 'For Sale' is active
     When I click on tab 'To Rent'
     Then tab 'To Rent' is active
     When I click on tab 'For Sale'
     Then tab 'For Sale' is active

#As a user
#I want to see all items of dropdown 'Type'
#So that i can click on dropdown 'Type' and see all items
  Scenario: Checking all items in property dropdown
     When I click on dropdown 'Type' in 'Homes&Property' section
     Then The items in dropdown 'Type' are "Flats, Houses, Bungalows, Land, Commercial Property, Other"

#As a user
#I want to see all items of dropdown 'Beds'
#So that i can click on dropdown 'Beds' and see all items
  Scenario: Checking all items in number of bed dropdown
     When I click on dropdown 'Beds' in 'Homes&Property' section
     Then The items in dropdown 'Beds' are "No Min, 1 Bed, 2 Bed, 3 Bed, 4 Bed, 5 Bed"
     
#As a user
#I want to search property with relevant search criteria
#So that i can change all search criteria and see all search result
  Scenario Outline: Configure search properties in 'Homes&Property' section
     When I enter "<location>" and choose "<type>", "<number_of_beds>" in 'Homes&Property' section
      And I click 'search properties' button in 'Homes&Property' section
     Then the information about property search found corresponds to the selected "<location>", "<type>" and "<number_of_beds>"
  
    Examples: 
      | location   | type     | number_of_beds | 
      | London     | Flats    | 1 Bed          | 
      | Manchester | Houses   | 5 Bed          |

#As a user
#I want to check min and max price of tab "For Sale"
#So that i can see their below the drop-down lists
  Scenario: Checking min and max price for sale in 'Homes&Property' section 
	Then I see min price "200,000" and max price "1m" in 'For Sale'

#As a user
#I want to check min and max price of tab "To Rent"
#So that i can click on tab 'To Rent' and see their below the drop-down lists	 
  Scenario: Checking min and max price to rent in 'Homes&Property' section 
	When I click on tab 'To Rent' 
	Then I see min price "900 PCM" and max price "3,500 PCM" in tab 'To Rent'

#As a user
#I want to change price using slide bar
#So that i can click on slide bar and see that a min price was changing
  Scenario: Checking slide bar of price in 'Homes&Property' section 
	When I click on slide bar of price
	Then I see another minimum price than "200,000", and the slide bar moves to the center of the price scale
