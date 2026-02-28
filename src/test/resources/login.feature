Feature: Login
  @web @valid-login
  Scenario: Login with valid username and password
    Given user is on login page
    When user input username text box with "special_user2"
    And user input password pada text box with "user"
    Then user click submit
    Then user will redirect to homepage
    Then user logout

  @web @invalid-login
  Scenario: Login with invalid username and password
    Given user is on login page
    When user input username text box with "special_user2"
    And user input password pada text box with "secret_invalid"
    Then user click submit
    Then user will stay on login page
