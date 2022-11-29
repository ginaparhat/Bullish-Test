@api
Feature: API Automatioon feature file

  Scenario: verify user can able to add new student
    Given user wants to call post request to add student
    And set header "Content-Type" to "application/json"
    When user call post request
    Then verify status code is 200

  Scenario: verify user can able to retrieve the student information
    Given user wants to call get request to retrieve the student
    And set header "Content-Type" to "application/json"
    And set query parameter "id" to "12334"
    When user call get request
    Then verify status code is 200

  Scenario: verify user can able to update the student information
    Given user wants to call put update the student information
    And set header "Content-Type" to "application/json"
    When user call put request
    Then verify status code is 200

  Scenario: verify user can able to delete the student
    Given user wants to call delete request to delete student
    And set header "Content-Type" to "application/json"
    When user call delete request
    Then verify status code is 200
