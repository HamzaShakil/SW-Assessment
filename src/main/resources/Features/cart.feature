Feature: Verify the functionality of the Swag Labs shopping cart

  Scenario: Add item to the cart and verify the item
    Given I am on the Swag Labs homepage
    When I add the Sauce Labs Backpack to the cart
    Then the single item should be added to the cart

  Scenario: Add multiple items to the cart and verify the items
    Given I am on the Swag Labs homepage
    When I add two item into a cart
    Then the multiple item should be added to the cart

  Scenario: Add multiple items to the cart and verify the count
    Given I am on the Swag Labs homepage
    When I add two item into a cart
    Then the cart should display a count of 2 items

  Scenario: Proceed to checkout from the cart
    Given I am on the Swag Labs homepage
    When I add two item into a cart
    Then the multiple item should be added to the cart
    When I proceed to checkout
    Then I should be redirected to the information page
    When I add the information
    And click the continue button
    Then I should be redirected to the checkout overview page
    When I click the finish button
    Then I should be redirected to the complete page
    And the page should display the thank you message

