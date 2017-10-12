Feature: Testing Regions
Description: This feature aiming to testing creating , editing ,searching, deactivating and reactivating of regions

Background:
* Open the browser
* User navigates to 'http://qc.ionhands-sa.com/'
* User clicks at Login link
* User enters correct username and password
* User clicks Login button
* user clicks on Regions link from side pane
* Regions link opens as well

@Add_Region
Scenario: Adding a new region
* User clicks Add New Region button
* User adds a region
* User clicks Submit button
* Region will be added successfully
* Close the browser

@Edit-Region
Scenario: Editing Region
* User clicks Edit for a region
* User edits a region
* User clicks Submit button
* Region will be edited successfully
* Close the browser

@Deactivate_Region
Scenario: User deactivates a region
* User clicks Deactivate for a region
* User clicks Confirm for the confirmation shown
* Region will be deactivated as well
* Close the browser

@Reactivate_Region
Scenario: User reactivates a region
* User clicks Reactivate for a region
* User clicks Confirm for the confirmation shown
* Region will be reactivated as well
* Close the browser

@Searching_Region
Scenario: Searching at regions
* User searches for a region at Search box
* The system returns search results as well for region
* Close the browser
