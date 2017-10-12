Feature: Settings
Description: This feature aims to testing the change of monthly target and the time between sessions

Background:
* Open the browser
* User navigates to 'http://qc.ionhands-sa.com/'
* User clicks at Login link
* User enters correct username and password for hospital admin
* User clicks Login button 
* Hospital admin will be logged in as well            
* User clicks Settings link
* Settings page will be opened as well

@month_target
Scenario: Changing Monthly Target
* User clicks Edit for monthly target
* User sets a value
* User clicks Submit button
* Value willbe saved as well
* Close the browser

@Time_between_sessions
Scenario: Changing Time between sessions
* User adds another value at Time between sessions
* user selects minutes option
* User clicks Save
* Selected options will be saved as well
* Close the browser