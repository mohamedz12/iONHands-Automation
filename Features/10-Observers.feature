Feature: Observers
Description: This feature aims to adding,editing,searching,deactivating and reactivating of observers by hospital admin

Background: 
* Open the browser
* User navigates to 'http://qc.ionhands-sa.com/'
* User clicks at Login link
* User enters correct username and password for hospital admin
* User clicks Login button 
* Hospital admin will be logged in as well            
* User clicks Observers link
* Observers page will be opened as well

@Add_observer
Scenario: Add an observer
* user clicks 'Add observer'
* User adds observer
* User clicks Submit button
* observer will be added as well
* Close the browser 

@Edit_observer
Scenario: Edit an observer
* User clicks Edit for an observer
* User edits an observer 
* User clicks Submit button
* Observer will be edited successfully
* Close the browser

@Deactivate_observer
Scenario: Deactivate an observer
* User clicks Deactivate for an observer
* User clicks Confirm for the confirmation shown
* Observer will be deactivated as well
* Close the browser

@Reactivate_observer
Scenario: Reactivate an observer
* User clicks Reactivate for an observer
* User clicks Confirm for the confirmation shown
* Observer will be reactivated as well
* Close the browser

@Search_observer
Scenario: Search for an observer
* User searches for an observer at Search box
* The system returns search results as well for observer
* Close the browser