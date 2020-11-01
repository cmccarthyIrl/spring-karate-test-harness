Feature: Battle Endpoint Tests

  Background:
    Given url baseUrl
    And header Accept = 'application/json'
    And header Content-Type = 'application/json; charset=utf-8'

  Scenario Outline: Verify the user can create a battle
    Given path '/battle'
    And request { "firstHeroToFight" : 2, "secondHeroToFight" : <secondHeroToFight> }
    When method POST
    Then status 200

    Examples:
      | secondHeroToFight |
      | 2                 |
      | 4                 |
      | 1                 |