@ui
Feature: Login Feature

  Scenario: Verify user can login with valid credentials
    Given user open website
    Then verify user is on login page
    And user login with username "tomsmith" and password "SuperSecretPassword!"
    And verify login is successful

  Scenario Outline: Verify user cannot login with invalid credentials
    Given user open website
    Then verify user is on login page
    And user login with username "<username>" and password "<password>"
    And verify invalid login error messsge "<errorMsg>" is displayed

    Examples: 
      | username | password             | errorMsg                  |
      | tomsmith | supersecretpassword! | Your password is invalid!|
      | tomsmith |                      | Your password is invalid! |
      | tomsmith | SuperSecretPassword  | Your password is invalid! |
      |          | SuperSecretPassword! | Your username is invalid! |
      | toms     | SuperSecretPassword! | Your username is invalid! |
      |          |                      | Your username is invalid! |
