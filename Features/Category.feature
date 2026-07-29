Feature: Category Management

Background:
    Given User launch the chromebrowser
    When User open the URL "http://localhost:5000/admin"
    And User enetrs email as "admin@yourstore.com" and password as "admin"
    And Click on Login

Scenario: Add New Category

    When User click on Catalog menu
    And User click on Categories menu
    And Click on Add New Category button
    Then User should view Add Category page
    When User enters Category Details
    And Click on Save Category
    Then Category should be added successfully
    And close browser

Scenario: Search Category

    When User click on Catalog menu
    And User click on Categories menu
    And Search Existing Category
    Then Category should appear in search result
    And close browser

Scenario: Edit Category

    When User click on Catalog menu
    And User click on Categories menu
    And Search Existing Category
    And Edit Category Details
    And Save Category Changes
    Then Category should be updated successfully
    And close browser

Scenario: Delete Category

    When User click on Catalog menu
    And User click on Categories menu
    And Search Existing Category
    And Delete Category
    Then Category should be deleted successfully
    And close browser