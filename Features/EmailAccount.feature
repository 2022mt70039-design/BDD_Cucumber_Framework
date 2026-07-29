@Smoke @EmailAccount
Feature: Email Account

Background:
    Given User launch the chromebrowser
    When User open the URL "http://localhost:5000/admin"
    And User enetrs email as "admin@yourstore.com" and password as "admin"
    And Click on Login

@Smoke
Scenario: Verify Email Accounts page opens successfully
    When User click on Configuration menu
    And User click on Email Accounts menu
    Then User should view Email Accounts page
    And close browser

@Smoke @Regression
Scenario: Add Email Account
    When User click on Configuration menu
    And User click on Email Accounts menu
    And User click Add New Email Account
    Then User should view Add Email Account page
    When User enters Email Account details
    And Click on Save Email Account
    Then Email Account should be added successfully
    And close browser