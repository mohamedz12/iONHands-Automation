Feature: Testing Cities
Description: This feature aiming to testing creating , editing ,searching, deactivating and reactivating of cities

Background:
* Open the browser
* User navigates to 'http://qc.ionhands-sa.com/'
* User clicks at Login link
* User enters correct username and password
* User clicks Login button
* user clicks on Cities link from side pane
* Cities link opens as well

@Add_City
Scenario: Adding a new city
* User clicks Add New City button
* User adds a city
* User clicks Submit button
* City will be added successfully
* Close the browser

@Edit-City
Scenario: Editing City
* User clicks Edit for a city
* User edits a city
* User clicks Submit button
* City will be edited successfully
* Close the browser

@Deactivate_City
Scenario: User deactivates a city
* User clicks Deactivate for a city
* User clicks Confirm for the confirmation shown
* City will be deactivated as well
* Close the browser

@Reactivate_City
Scenario: User reactivates a city
* User clicks Reactivate for a city
* User clicks Confirm for the confirmation shown
* City will be reactivated as well
* Close the browser

@Searching_City
Scenario: Searching at cities
* User searches for a city at Search box
* The system returns search results as well for city
* Close the browser
