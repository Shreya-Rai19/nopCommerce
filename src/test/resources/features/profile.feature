Feature: Profile Update Flow
@profile
Scenario: Update user profile successfully
  Given User launches the browser
  And User navigates to login page
  When User enters email and password
  And User clicks login button
  Then User should be logged in

  When User navigates to My Account
  And User updates profile details
  And User saves the changes
  Then Profile should be updated successfully