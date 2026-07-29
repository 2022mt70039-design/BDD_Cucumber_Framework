@Smoke @GiftCard
Feature: Gift Card Management

Background:
Given User launch the chromebrowser
When User open the URL "http://localhost:5000/admin"
And User enetrs email as "admin@yourstore.com" and password as "admin"
And Click on Login

@Smoke
Scenario: Verify Gift Cards page opens successfully

When User click on Sales menu
And User click on Gift Cards menu
Then User should view Gift Cards page
And close browser

@Smoke @Regression
Scenario: Add Gift Card

When User click on Sales menu
And User click on Gift Cards menu
And User click Add New Gift Card
Then User should view Add Gift Card page
When User enters Gift Card details
And Click on Save Gift Card
Then Gift Card should be added successfully
And close browser