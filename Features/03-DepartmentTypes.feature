Feature: Testing Department Types
Description : This feature for testing creating , editing and deactivating of department types

Background: 
* Open the browser
* User navigates to 'http://qc.ionhands-sa.com/'
* User clicks at Login link
* User enters correct username and password
* User clicks Login button
* User clicks Department Types
* Department Types page opens as well

@Add_DepartmentType
Scenario: Adding Department Types
* User clicks Add Department Type button
* User adds a department type
* User clicks Submit button
* Department Type will be added successfully
* Close the browser

@Edit-DepartmentType
Scenario: Editing Department Type
* User clicks Edit for a department type
* User edits department type
* User clicks Submit button
* Department Type will be edited successfully
* Close the browser

@Deactivate_DepartmentType
Scenario: User deactivates department type
* User clicks Deactivate for a department type
* User clicks Confirm for the confirmation shown
* Department Type will be deactivated as well
* Close the browser

@Reactivate_DepartmentType
Scenario: User reactivates department type
* User clicks Reactivate for a department type
* User clicks Confirm for the confirmation shown
* Department Type will be reactivated as well
* Close the browser

@Searching_DepartmentTypes
Scenario: Searching at DepartmentTypes
* User searches for a departmenttype at Search box
* The system returns search results as well for departmenttype
* Close the browser