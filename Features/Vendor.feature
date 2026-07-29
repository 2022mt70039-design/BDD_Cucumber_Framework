@Smoke @Vendor
Feature: Vendor Module

  Background:
    Given User launch the chromebrowser
    When User open the URL "http://localhost:5000/admin"
    And User enetrs email as "admin@yourstore.com" and password as "admin"
    And Click on Login

  @Smoke
  Scenario: Verify Vendor page opens successfully

    When User click on Customers menu
    And User click on Vendors menu
    Then User should view Vendors page
    And close browser

 @Smoke @Vendor @Regression
Scenario: Add Vendor

    When User click on Customers menu
    And User click on Vendors menu
    And Click on Add New Vendor button
    Then User should view Add Vendor page
    When User enters Vendor details
    And Click on Save Vendor
    Then Vendor should be added successfully
    And close browser