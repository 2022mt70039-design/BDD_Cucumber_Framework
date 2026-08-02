@Smoke @Discount
Feature: Discount Management

Background:
Given User launch the chromebrowser
When User open the URL "http://localhost:5000/admin"
And User enetrs email as "admin@yourstore.com" and password as "admin"
And Click on Login

@Smoke
Scenario: Verify Discounts page opens successfully

When User click on Promotions menu
And User click on Discounts menu
Then User should view Discounts page
And close browser

@Smoke @Regression
Scenario: Add Discount

When User click on Promotions menu
And User click on Discounts menu
And User click Add New Discount
Then User should view Add Discount page
When User enters Discount details
And Click on Save Discount
Then Discount should be added successfully
And close browser

@Smoke @Regression
Scenario: Edit Discount

When User click on Promotions menu
And User click on Discounts menu
And User select Discount
Then User should view Edit Discount page
When User edit Discount details
And Click on Update Discount
Then Discount should be updated successfully
And close browser


@Smoke @Regression
Scenario: Delete Discount

When User click on Promotions menu
And User click on Discounts menu
And User select Discount
And User delete Discount
And User confirm Discount deletion
Then Discount should be deleted successfully
And close browser