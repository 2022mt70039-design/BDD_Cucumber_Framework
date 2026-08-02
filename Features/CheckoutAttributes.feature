@Smoke
@Navigation
@CheckoutAttribute

Feature: Checkout Attribute Management

Background:
    Given User launch the chromebrowser
    When User open the URL "http://localhost:5000/admin"
    And User enetrs email as "admin@yourstore.com" and password as "admin"
    And Click on Login

Scenario: Verify Checkout Attribute Page
    When User click on Catalog menu
    And User click on Attributes menu
    And User click on Checkout Attributes menu
    Then User should view Checkout Attributes page
    And close browser

Scenario: Add Checkout Attribute
    When User click on Catalog menu
    And User click on Attributes menu
    And User click on Checkout Attributes menu
    And User click Add New Checkout Attribute
    And User enters Checkout Attribute details
    And Click on Save Checkout Attribute
    Then Checkout Attribute should be added successfully
    And close browser

Scenario: Edit Checkout Attribute
    When User click on Catalog menu
    And User click on Attributes menu
    And User click on Checkout Attributes menu
    And User edit Checkout Attribute
    Then Checkout Attribute should be updated successfully
    And close browser

Scenario: Delete Checkout Attribute
    When User click on Catalog menu
    And User click on Attributes menu
    And User click on Checkout Attributes menu
    And User select Checkout Attribute
    And User click Delete Selected Checkout Attribute
    And User confirm Checkout Attribute deletion
    Then Checkout Attribute should be deleted successfully
    And close browser