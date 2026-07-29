Feature: Manufacturer Management

Background:
    Given User launch the chromebrowser
    When User open the URL "http://localhost:5000/admin"
    And User enetrs email as "admin@yourstore.com" and password as "admin"
    And Click on Login

Scenario: Add Manufacturer
    When User click on Catalog menu
    And User click on Manufacturers menu
    And Click on Add New Manufacturer button
    Then User should view Add Manufacturer page
    When User enters Manufacturer Details
    And Click on Save Manufacturer
    Then Manufacturer should be added successfully
    And close browser

Scenario: Search Manufacturer
    When User click on Catalog menu
    And User click on Manufacturers menu
    And Search Existing Manufacturer
    Then Manufacturer should appear in search result
    And close browser

Scenario: Edit Manufacturer
    When User click on Catalog menu
    And User click on Manufacturers menu
    And Search Existing Manufacturer
    And Edit Manufacturer Details
    And Save Manufacturer Changes
    Then Manufacturer should be updated successfully
    And close browser

Scenario: Delete Manufacturer
    When User click on Catalog menu
    And User click on Manufacturers menu
    And Search Existing Manufacturer
    And Delete Manufacturer
    Then Manufacturer should be deleted successfully
    And close browser