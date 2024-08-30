Feature: Re-Use Existing Feature Files

  Background:
    Given url baseUrl
    And header Accept = 'application/json'
    And header Content-Type = 'application/json; charset=utf-8'

    * def waitXAmount =
      """
      function(x) {
        karate.log('sleeping for ' + x + ' milliseconds');
        java.lang.Thread.sleep(x);
      }
      """

  Scenario Outline: Verify a Feature file can re-use existing Feature files
    # Create hero
    * def createHero = call read('HeroTest.feature') { id: 7, name: 'Thor', age: 100, weapon: 'Hammer', specialPower: 'Immortal' }

    # Create a battle
    * def battle = call read('BattleTest.feature') { firstHeroToFight: 7, secondHeroToFight: <secondHeroToFight> }
    * def battleResponse = battle.response

    # Get the result
    * def result = call read('ResultTest.feature') { resultId: '#(battleResponse.resultId)' }
    * call waitXAmount 300
    * def resultResponse = result.response
    And print resultResponse
    Then match resultResponse.result == '<result>'

    Examples:
      | result | secondHeroToFight |
      | WIN    | 2                 |
      | LOSS   | 4                 |
      | DRAW   | 3                 |
