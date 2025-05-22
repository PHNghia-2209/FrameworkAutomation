Feature: Login API

  Scenario: Login with valid credentials
    Given I have the login API endpoint
    When I send POST request with valid credentials
    Then I should receive a 201 status code
    And the response should contain a token
