@Smoke @Warehouse
Feature: Warehouse

  Background:
    Given User launch the chromebrowser
    When User open the URL "http://localhost:5000/admin"
    And User enetrs email as "admin@yourstore.com" and password as "admin"
    And Click on Login

  @Smoke
  Scenario: Verify Warehouse page opens successfully

    When User click on Configuration menu
    And User click on Shipping menu
    And User click on Warehouses menu
    Then User should view Warehouses page
    And close browser


  @Smoke @Regression
  Scenario: Add Warehouse

    When User click on Configuration menu
    And User click on Shipping menu
    And User click on Warehouses menu
    And User click Add New Warehouse
    Then User should view Add Warehouse page
    When User enters Warehouse details
    And Click on Save Warehouse
    Then Warehouse should be added successfully
    And close browser