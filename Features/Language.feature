@Smoke @Language
Feature: Language

  Background:
    Given User launch the chromebrowser
    When User open the URL "http://localhost:5000/admin"
    And User enetrs email as "admin@yourstore.com" and password as "admin"
    And Click on Login

  @Smoke
  Scenario: Verify Language page opens successfully
    When User click on Configuration menu
    And User click on Languages menu
    Then User should view Languages page
    And close browser

  @Smoke @Regression
  Scenario: Add Language
    When User click on Configuration menu
    And User click on Languages menu
    And Click on Add New Language button
    Then User should view Add Language page
    When User enters Language details
    And Click on Save Language
    Then Language should be added successfully
    And close browser