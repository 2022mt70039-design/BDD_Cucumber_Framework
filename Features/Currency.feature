@Smoke @Currency
Feature: Currency

  Background:
    Given User launch the chromebrowser
    When User open the URL "http://localhost:5000/admin"
    And User enetrs email as "admin@yourstore.com" and password as "admin"
    And Click on Login

  @Smoke
  Scenario: Verify Currency page opens successfully
    When User click on Configuration menu
    And User click on Currencies menu
    Then User should view Currencies page
    And close browser

  @Smoke @Regression
  Scenario: Add Currency
    When User click on Configuration menu
    And User click on Currencies menu
    And Click on Add New Currency button
    Then User should view Add Currency page
    When User enters Currency details
    And Click on Save Currency
    Then Currency should be added successfully
    And close browser