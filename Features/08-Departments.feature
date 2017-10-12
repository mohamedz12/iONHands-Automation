Feature: Departments
Description: This feature aims to testing creating, editing, searching, deactivating and reactivating
             of departments by hospital admin

Background: 
* Open the browser
* User navigates to 'http://qc.ionhands-sa.com/'
* User clicks at Login link
* User enters correct username and password for hospital admin
* User clicks Login button 
* Hospital admin will be logged in as well            
* User clicks Departments link
* Departments page will be opened as well

@Add_Dep
Scenario: Adding departments
* user clicks 'Add Department'
* user selects a department type
* User adds a department
* User clicks Submit button
* Department will be added as well
* Close the browser

@Edit_Dep
Scenario: Editing departments
* User clicks Edit for a department
* User edits a department 
* User clicks Submit button
* Department will be edited successfully
* Close the browser

@Deactivate_Dep
Scenario: Deactivate departments
* User clicks Deactivate for a department
* User clicks Confirm for the confirmation shown
* Department will be deactivated as well
* Close the browser

@Reactivate_Dep
Scenario: Reactivate departments
* User clicks Reactivate for a department
* User clicks Confirm for the confirmation shown
* Department will be reactivated as well
* Close the browser

@Search_Dep
Scenario: Search departments
* User searches for a department at Search box
* The system returns search results as well for department
* Close the browser
