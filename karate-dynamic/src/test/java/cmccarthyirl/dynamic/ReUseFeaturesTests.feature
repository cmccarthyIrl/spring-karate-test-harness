@parallel=false
Feature: Re-Use Existing Feature files

  Background:
    Given url baseUrl
    And header Accept = 'application/json'
    And header Content-Type = 'application/json; charset=utf-8'


  Scenario Outline: Verify we can re-use existing feature files
          #create hero
    * def createHero = call read('HeroTest.feature') {"id": 7,"name": "Thor","age": 100,"weapon": "Hammer","specialPower": "Immortal"}
      #create a battle
    * def battle = call read('BattleTest.feature') {"firstHeroToFight": 7,"secondHeroToFight": <secondHeroToFight>}
    * def battleResponse = battle.response
      #get the result
    * def result = call read('ResultTest.feature') {"resultId": #(battleResponse.resultId) }
    * def resultResponse = result.response
    And print resultResponse
    Then match resultResponse.result == "<result>"

    Examples:
      | result | secondHeroToFight |
      | WIN    | 2                 |
      | LOSS   | 4                 |
      | DRAW   | 3                 |
