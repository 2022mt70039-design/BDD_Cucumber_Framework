@Smoke @MessageTemplate
Feature: Message Template Management

Background:
Given User launch the chromebrowser
When User open the URL "http://localhost:5000/admin"
And User enetrs email as "admin@yourstore.com" and password as "admin"
And Click on Login

@Smoke
Scenario: Verify Message Templates page opens successfully

When User click on Content Management menu
And User click on Message Templates menu
Then User should view Message Templates page
And close browser


@Regression @Smoke
Scenario: Search Existing Message Template

When User click on Content Management menu
And User click on Message Templates menu
And User searches Message Template "Customer.PasswordRecovery"
Then Message Template should be displayed
And close browser


@Regression
Scenario: Edit Existing Message Template

When User click on Content Management menu
And User click on Message Templates menu
And User searches Message Template "Customer.PasswordRecovery"
And User click Edit Message Template
Then User should view Edit Message Template page
When User updates Message Template Subject
And Click Save Message Template
Then Message Template should be updated successfully
And close browser