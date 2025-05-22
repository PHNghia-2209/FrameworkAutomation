Feature: Show Detail User By Name

  Scenario: Show User By User Name
    Given I have the user API endpoint
    When I send GET request show info according to name "sumo"
    Then I should receive a 200 status code
    And the response should contain full info
