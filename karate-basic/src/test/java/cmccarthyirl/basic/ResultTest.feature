Feature: Results Endpoint test

  Background:
    Given url baseUrl
    And header Accept = 'application/json'
    And header Content-Type = 'application/json; charset=utf-8'

  Scenario: Verify the user can retrieve all the results
    Given path '/results'
    When method GET
    Then status 200

#  Scenario: Verify the user can delete all the results
#    Given path '/results'
#    When method DELETE
#    Then status 200
#    And match response == []
