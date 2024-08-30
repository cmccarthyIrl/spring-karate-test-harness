Feature: Hero Tests

  Background:
    Given url baseUrl
    And header Accept = 'application/json'
    And header Content-Type = 'application/json; charset=utf-8'

  Scenario: Verify the user retrieve all Heroes
    Given path '/hero'
    When method GET
    Then status 200

  Scenario: Verify the user can retrieve a single Hero
    Given path '/hero/1'
    When method GET
    Then status 200
    And match response.name == 'Achilles'

  Scenario: Verify the user can create a Hero
    Given path '/hero'
    And request {"id": 7,"name": "SDET","age": 100,"weapon": "Programming","specialPower": "Can see the Matrix"}
    When method POST
    Then status 200
