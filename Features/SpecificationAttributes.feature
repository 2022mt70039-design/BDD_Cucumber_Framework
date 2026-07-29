@Smoke
@Navigation
@SpecificationAttribute

Feature: Specification Attribute Management

Background:
    Given User launch the chromebrowser
    When User open the URL "http://localhost:5000/admin"
    And User enetrs email as "admin@yourstore.com" and password as "admin"
    And Click on Login

Scenario: Verify Specification Attribute Page

    When User click on Catalog menu
    And User click on Attributes menu
    And User click on Specification Attributes menu
    Then User should view Specification Attributes page
    And close browser