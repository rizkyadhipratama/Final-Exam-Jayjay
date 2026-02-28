Feature: Checkout Process
  As a user
  I want to select a specific product and complete the checkout process
  So that I can purchase the product

  @web
  Scenario: User selects Samsung Galaxy S6 and completes checkout
    Given User is on login page
    When user input username text box with "special_user2"
    And user input password pada text box with "user"
    And user click submit
    Then user will redirect to homepage
    
    When User select specific product
    Then User click add to cart
    And User in cart page
    And User click place order
    And User fill order with name "John Doe" country "USA" city "New York" credit card "1234567890123456" month "12" year "2025"
    And User click purchase
