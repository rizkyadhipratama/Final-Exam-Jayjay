Feature: Sign Up
  @web
  Scenario: New User Sign Up
    Given User in Home Index page
    Then User click sign up
    Then User fill username with "special_user2"
    Then User fill password with "user"
    Then User click submit

