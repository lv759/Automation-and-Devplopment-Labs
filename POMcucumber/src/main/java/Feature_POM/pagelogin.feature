Feature: verfiy Login functionality 
Scenario Outline: To check login with valid username and password 
	Given browser has opened
	When user enters <username> and <password> 
	And clicks on login button 
	Then user is navigated to homepage 
 Examples:
 |username|password|
 |vishal|12345|
 |atul|12345|