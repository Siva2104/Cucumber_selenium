#Feature: Feature to Login of AKB 3.0
#
#Scenario Outline: Check login is Working
#Given login page
#When user enter "standard_user" and "secret_sauce"
#And click on the login button
#Then Logged to the application and navigated to Homepage
#
#Examples:
#| login         | password     |
#| standard_user | secret_sauce |
#
#
Feature: Feature to Login of AKB 3.0

  Scenario Outline: Check login is Working
    Given login page
    When user enter "<login>"and"<password>"
    And click on the login button
    Then Logged to the application and navigated to Homepage

    Examples: 
      | login         | password     |
      | standard_user | secret_sauce |
      
