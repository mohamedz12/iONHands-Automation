Feature: Hospitals from Group Admin
Description: This feature aims to adding,editing,searching,deactivating and reactivating hospitals by group admin	

Background:
* Open the browser
* User navigates to 'http://qc.ionhands-sa.com/'
* User clicks at Login link
* User enters correct username and password for group admin
* User clicks Login button 
* Group admin will be logged in as well            
* User clicks Hospitals link
* Hospitals page will be opened as well

@Add_hospital
Scenario: Adding hospital
* User clicks Add Hospital
* User adds hospital fields
* User clicks Submit button
* Hospital will be added as well
* Close the browser

@Edit_hospital
Scenario: Editing hospital
* User clicks Edit for hospital
* User edits a hospital
* User clicks Submit button
* Hospital will be edited as well
* Close the browser

@Deactivate_hospital
Scenario: Deactivating hospital
* User clicks Deactivate for hospital
* User clicks Confirm for the confirmation shown
* Hospital will be deactivated as well
* Close the browser

@Reactivate_hospital
Scenario: Reactivating hospital
* User clicks Reactivate for hospital
* User clicks Confirm for the confirmation shown
* Hospital will be reactivated as well
* Close the browser

@Hospital_by_group
Scenario: Assign a hospital from super admin by group
* User clicks on Logout link
* User clicks at Login link 
* User enters correct username and password
* User clicks Login button
* user clicks on Hospitals link from side pane
* User clicks on Edit icon
* User edits the hospital group
* User clicks Submit button
* User clicks on Logout link
* User clicks at Login link 
* User enters correct username and password for group admin
* User clicks Login button
* User clicks Hospitals link
* Hospital will be shown successfully
* Close the browser