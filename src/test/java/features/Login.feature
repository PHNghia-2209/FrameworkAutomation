@ui-config
Feature: Login feature


  Scenario: Login Successful
    Given I am on the Website page
    When Input valid email and password and hit Login button
    Then Login successful