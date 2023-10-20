Feature: Login
  As a user
  In order to access my account
  I want to be able to log in

  Scenario: Login with valid credentials
    Given I am on the login page
    When I enter valid credentials
    And click the login button
    Then I should be logged in

  Scenario: Login with Invalid username
    Given I am on the login page
    When I enter an invalid username
    And click the login button
    Then I should see an error message

  Scenario: Login with Invalid password
    Given I am on the login page
    When I enter an invalid password
    And click the login button
    Then I should see an error message

  Scenario: Login with Empty credentials
    Given I am on the login page
    When Leave user name and password field empty
    And click the login button
    Then I should see an error message