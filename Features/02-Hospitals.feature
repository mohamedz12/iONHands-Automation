Feature: Testing Hospitals CRUD
Description: This feature aimed to testing the creation , update and deactivate/reactivate of hospitals

Background: 
* Open the browser
* User navigates to 'http://qc.ionhands-sa.com/'
* User clicks at Login link
* User enters correct username and password
* User clicks Login button
* user clicks on Hospitals link from side pane
* Hospitals link opens as well

@Adding_Hospital 
Scenario: Adding a new hospital
* Uset clicks on 'Add Hospital'
* User add Hospital fields
* User clicks Submit for Hospitals
* Hospital will be added successfully
* Close the browser

@Editing_Hospital
Scenario: Editing a hospital
* User clicks on Edit icon
* User edits the hospital
* User clicks Submit for Edit form
* Close the browser

@Deactivating_Hospital
Scenario: Deactivating a hospital
* User clicks Deactivate icon
* User clicks Confirm for the confirmation shown
* Hospital will be deactivated successfully
* Close the browser

@Reactivating_Hospital
Scenario: Reactivating a hospital
* User clicks Reactivate icon
* User clicks Confirm for the confirmation shown
* Hospital will be reactivated successfully
* Close the browser

@Searching_Hospitals
Scenario: Searching at Hospitals
* User searches for a hospital at Search box
* The system returns search results as well for hospitals
* Close the browser





