Feature: Login Test

Scenario: Valid Login
  Given user is on login page
  When user enters username and password
  Then user should see dashboard
  
  Scenario: Invalid Login
  Given user is on login page
  When user enters invalid username and password
  Then error message should be displayed