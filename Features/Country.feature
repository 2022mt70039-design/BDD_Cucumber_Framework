@Smoke @Country
Feature: Country

  Background:
    Given User launch the chromebrowser
    When User open the URL "http://localhost:5000/admin"
    And User enetrs email as "admin@yourstore.com" and password as "admin"
    And Click on Login

  @Smoke
  Scenario: Verify Countries page opens successfully
    When User click on Configuration menu
    And User click on Countries menu
    Then User should view Countries page
    And close browser

  @Smoke @Regression
  Scenario: Add Country
    When User click on Configuration menu
    And User click on Countries menu
    And Click on Add New Country button
    Then User should view Add Country page
    When User enters Country details
    And Click on Save Country
    Then Country should be added successfully
    And close browser