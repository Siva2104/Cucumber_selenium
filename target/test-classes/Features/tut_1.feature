Feature: Feature to Login of AKB 3.0

  Scenario: Check login is Working
    Given user is on login page
    When user enter login and  password
    And click login button
    Then Login to the application and navigated to Homepage