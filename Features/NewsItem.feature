@Smoke @NewsItem
Feature: News Item Management

Background:
Given User launch the chromebrowser
When User open the URL "http://localhost:5000/admin"
And User enetrs email as "admin@yourstore.com" and password as "admin"
And Click on Login

@Smoke
Scenario: Verify News Items page opens successfully

When User click on Content Management menu
And User click on News Items menu
Then User should view News Items page
And close browser

@Smoke @Regression
Scenario: Add News Item

When User click on Content Management menu
And User click on News Items menu
And User click Add New News Item
Then User should view Add News Item page
When User enters News Item details
And Click on Save News Item
Then News Item should be added successfully
And close browser