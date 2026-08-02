@Smoke
Feature: Product Attribute Management

Background:
    Given User launch the chromebrowser
    When User open the URL "http://localhost:5000/admin"
    And User enetrs email as "admin@yourstore.com" and password as "admin"
    And Click on Login

Scenario: Verify Product Attribute Page

    When User click on Catalog menu
    And User click on Attributes menu
    And User click on Product Attributes menu
    Then User should view Product Attributes page
    And close browser

Scenario: Add Product Attribute

    When User click on Catalog menu
    And User click on Attributes menu
    And User click on Product Attributes menu
    And User click Add New Product Attribute
    And User enters Product Attribute details
    And Click on Save Product Attribute
    Then Product Attribute should be added successfully
    And close browser

Scenario: Search Product Attribute

    When User click on Catalog menu
    And User click on Attributes menu
    And User click on Product Attributes menu
    And User search Product Attribute
    Then Product Attribute should be displayed
    And close browser

Scenario: Edit Product Attribute

    When User click on Catalog menu
    And User click on Attributes menu
    And User click on Product Attributes menu
    And User search Product Attribute
    And User edit Product Attribute
    Then Product Attribute should be updated successfully
    And close browser

Scenario: Delete Product Attribute

    When User click on Catalog menu
    And User click on Attributes menu
    And User click on Product Attributes menu
    And User search Product Attribute
    And User select Product Attribute
    And User click Delete Selected
    And User confirm Product Attribute deletion
    Then Product Attribute should be deleted successfully
    And close browser