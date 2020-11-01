Feature: E2E Tests

  Background:
    Given url baseUrl
    And header Accept = 'application/json'
    And header Content-Type = 'application/json; charset=utf-8'

  Scenario Outline: Verify we can create a new Hero, complete a battle and retrieve the results
    #create hero
    Given path '/hero'
    And request {"id": 7,"name": "SDET","age": 100,"weapon": "Programming","specialPower": "Can see the Matrix"}
    When method POST
    Then status 200
    #create a battle
    Given path '/battle'
    And request { "firstHeroToFight" : 7, "secondHeroToFight" : <secondHeroToFight> }
    When method POST
    Then status 200
    And def result = response
    #get the result
    Given path '/results'
    And request { "resultId" : #(result.resultId) }
    When method POST
    Then status 200
    And match response.result == "<result>"

    Examples:
      | secondHeroToFight | result |
      | 2                 | WIN    |
      | 4                 | LOSS   |
      | 3                 | DRAW   |




