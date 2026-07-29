@Smoke @Measure
Feature: Measure

  Background:
    Given User launch the chromebrowser
    When User open the URL "http://localhost:5000/admin"
    And User enetrs email as "admin@yourstore.com" and password as "admin"
    And Click on Login

  @Smoke
  Scenario: Verify Measure page opens successfully
    When User click on Configuration menu
    And User click on Measures menu
    Then User should view Measures page
    And close browser


 # Scenario: Add Measure
 #   When User click on Configuration menu
 #   And User click on Measures menu
 #   When User enters Measure details
 #   And Click on Save Measure
 #   Then Measure should be added successfully
 #   And close browser