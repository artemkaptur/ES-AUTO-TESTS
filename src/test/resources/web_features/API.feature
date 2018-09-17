Feature: Evening standard API testing mobile application 

Background: 
	Given I install base url "https://app.standard.co.uk/" 

Scenario: Checking status code
	When I send a GET request to base url and see status code "200" 

Scenario: Checking header Content-Type 
	When I send a GET request to "endpoint.xml" and see "Content-Type" is "application/xml"

Scenario: Checking correct request to news links
	When I send a GET request to "endpoint.xml" and parse a links to news
	Then I send a GET requests to news and i see status code "200" and Content-Type is "application/xml"