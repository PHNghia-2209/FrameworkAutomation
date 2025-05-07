@ui-login
Feature: check Email feature

  Scenario: Check Email Address
    Given I am logged in
    When I check Email Address is "nghiatui2233"
    Then Email is"nghiatui2233"