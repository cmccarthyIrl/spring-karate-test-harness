@ignore
Feature: Battle Endpoint Tests

  Background:
    Given url baseUrl
    And header Accept = 'application/json'
    And header Content-Type = 'application/json; charset=utf-8'

  Scenario: Verify the user can create a battle
    Given path '/battle'
    And request { "firstHeroToFight" : '#(firstHeroToFight)', "secondHeroToFight" : '#(secondHeroToFight)' }
    When method POST
    Then status 200