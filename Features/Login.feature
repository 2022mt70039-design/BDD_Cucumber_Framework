Feature: Login

Scenario: Suceesful Login with valid credentials
	Given User launch the chromebrowser
	When User open the URL "http://localhost:5000/admin"
	And  User enetrs email as "admin@yourStore.com" and password as "admin"
	And Click on Login
	When User click on Logout link
	And close browser	



