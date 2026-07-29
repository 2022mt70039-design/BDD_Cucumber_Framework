Feature: Tax Category

Background:
Given User launch the chromebrowser
When User open the URL "http://localhost:5000/admin"
And User enetrs email as "admin@yourstore.com" and password as "admin"
And Click on Login

@Smoke @TaxCategory
Scenario: Verify Tax Categories page opens successfully

When User click on Configuration menu
And User click on Tax Categories menu
Then User should view Tax Categories page
And close browser


@Smoke @TaxCategory @Regression
Scenario: Add Tax Category

When User click on Configuration menu
And User click on Tax Categories menu
And User enters Tax Category details
Then Tax Category should be added successfully
And close browser