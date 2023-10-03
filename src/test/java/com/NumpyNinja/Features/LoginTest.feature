Feature: LT-65123 Leaftaps Login story

@Smoke @Regression
Scenario: TC001 - Verify the login with valid credentials
Given Open the chrome browser - maximize and set the timeout
When Load the application url "http://leaftaps.com/opentaps"
Then Enter username as "Demosalesmanager"
And Enter password as "crmsfa"
When Login button is clicked
Then verify the user logged-in successfully
And get all the tab name
And dataTable
		 |Lead ID,First name,Last name,Company Name,City,State/Province,Phone Number,E-Mail Address|
		 





