	Feature: Product Management

Background:
    Given User launch the chromebrowser
    When User open the URL "http://localhost:5000/admin"
    And User enetrs email as "admin@yourstore.com" and password as "admin"
    And Click on Login

Scenario: Add New Product

    When User click on Catalog menu
    And User click on Products menu
    And Click on Add New Product button
    Then User should view Add Product page
    When User enters Product Details
    And Click on Save Product
    Then Product should be added successfully
    And close browser

Scenario: Search Product by Name

    When User click on Catalog menu
    And User click on Products menu
    And Search Existing Product
    Then Product should appear in search result
    And close browser

Scenario: Edit Product

    When User click on Catalog menu
    And User click on Products menu
    And Search Existing Product
    And Edit Product Details
    And Save Product Changes
    Then Product should be updated successfully
    And close browser

Scenario: Delete Product

    When User click on Catalog menu
    And User click on Products menu
    And Search Existing Product
    And Delete Product
    Then Product should be deleted successfully
    And close browser