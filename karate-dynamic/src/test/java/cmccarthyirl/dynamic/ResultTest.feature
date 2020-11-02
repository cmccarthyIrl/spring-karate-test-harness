Feature: Results Endpoint test

  Background:
    Given url baseUrl
    And header Accept = 'application/json'
    And header Content-Type = 'application/json; charset=utf-8'
    * def waitXAmount =
    """
    function(x) {
        karate.log('sleeping');
         java.lang.Thread.sleep(x);
    }
    """

  Scenario: Verify the user can retrieve all the results
    Given path '/results'
    And request { "resultId" : #(resultId) }
    When method POST
    Then status 200
    * call waitXAmount 100
