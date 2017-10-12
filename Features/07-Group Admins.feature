Feature: Testing Group Admins
Description: This feature aims to creating,editing,searching ,deactivating and reactivating of group admins

Background: 
* Open the browser
* User navigates to 'http://qc.ionhands-sa.com/'
* User clicks at Login link
* User enters correct username and password
* User clicks Login button
* user clicks on Group Admins link from side pane
* Group Admins link opens as well

@Add_GA
Scenario: Adding Group Admin
* User clicks Add New Admin button
* User adds a new admin
* User clicks Submit button
* GA will be added successfully
* Close the browser

@Edit_GA
Scenario: Edit Group Admin
* User clicks Edit for a group admin
* User edits a group admin
* User clicks Submit button
* Group Admin will be edited successfully
* Close the browser

@Deactivate_GA
Scenario: Deactivate Group Admin
* User clicks Deactivate for a group admin
* User clicks Confirm for the confirmation shown
* Group Admin will be deactivated as well
* Close the browser

@Reactivate_GA
Scenario: Reactivate Group Admin
* User clicks Reactivate for a group admin
* User clicks Confirm for the confirmation shown
* Group Admin will be reactivated as well
* Close the browser

@Search_GA
Scenario: Searching Group Admin
* User searches for a group admin at Search box
* The system returns search results as well for group admin
* Close the browser
