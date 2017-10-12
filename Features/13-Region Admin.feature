Feature: Region Admin
Description: This feature aims to testing adding,editing,deactivating,reactivating and assigning to hospitals
             of region admin from group admin session

Background:
* Open the browser
* User navigates to 'http://qc.ionhands-sa.com/'
* User clicks at Login link
* User enters correct username and password for group admin
* User clicks Login button 
* Group admin will be logged in as well            
* User clicks Region Admin link
* Region page will be opened as well

@add_region_admin
Scenario: Adding Region Admin
* User clicks Add New Region Admin
* User adds region admin fields
* User clicks Submit button
* Region Admin will be added as well
* Close the browser

@edit_region_admin
Scenario: Editing Region Admin
* User clicks Edit for Region Admin
* User edits a region admin
* User clicks Submit button
* Region Admin will be edited as well
* Close the browser

@deactivate_region_admin
Scenario: Deactivating Region Admin
* User clicks Deactivate for region admin
* User clicks Confirm for the confirmation shown
* Region Admin will be deactivated as well
* Close the browser

@reactivate_region_admin
Scenario: Reactivating Region Admin
* User clicks Reactivate for a region admin
* User clicks Confirm for the confirmation shown
* Region Admin will be reactivated as well
* Close the browser

@assign_hospitals
Scenario: Assigning hospitals to region admin
* User clicks Assign Hospitals button for hospitals
* User clicks Confirm for the confirmation shown
* Hospital will be assigned as well to region admin
* Close the browser