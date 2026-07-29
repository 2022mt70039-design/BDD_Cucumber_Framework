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