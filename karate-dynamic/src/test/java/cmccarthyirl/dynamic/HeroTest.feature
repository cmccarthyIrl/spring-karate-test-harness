@ignore
Feature: Hero Tests

  Background:
    Given url baseUrl
    And header Accept = 'application/json'
    And header Content-Type = 'application/json; charset=utf-8'

  Scenario: Verify the user can create a Hero
    Given path '/hero'
    And request {"id": '#(id)',"name": '#(name)',"age": '#(age)',"weapon": '#(weapon)',"specialPower": '#(specialPower)'}
    When method POST
    Then status 200
