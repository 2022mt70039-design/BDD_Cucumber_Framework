Feature: Customers

	Scenario: Add a New Customer
		Given User launch the chromebrowser
		When User open the URL "http://localhost:5000/admin"
		And  User enetrs email as "admin@yourstore.com" and password as "admin"
		And Click on Login
		When User click on customer menu
		And Click on customer Item 
		And Click on add new button 
		Then User can view add new customer page 
		When user enter customer Info 
		And Click on save button 
		Then user can view confirmation message "The new customer has been added successfully."
		And close browser
		
		
	Scenario: Search customer by Email ID
		Given User launch the chromebrowser
		When User open the URL "http://localhost:5000/admin"
		And  User enetrs email as "admin@yourstore.com" and password as "admin"
		And Click on Login
		When User click on customer menu
		And Click on customer Item 
		And Enter customer Email 
		When  Click on search button 
		Then User should found in search tabel
		And close browser	
		
		
	Scenario: Search customer by Name

		Given User launch the chromebrowser
		When User open the URL "http://localhost:5000/admin"
		And User enetrs email as "admin@yourStore.com" and password as "admin"
		And Click on Login
		When User click on customer menu
		And Click on customer Item
		And Enter customer FirstName
		And Enter customer LastName
		When Click on search button
		Then User should found in search table by Name
		And close browser

		