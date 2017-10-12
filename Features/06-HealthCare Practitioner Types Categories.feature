Feature: Testing HPTs categories
Description: This feature for testing HPT categories creation , editing , searching, deactivating and reactivating

Background:
* Open the browser
* User navigates to 'http://qc.ionhands-sa.com/'
* User clicks at Login link
* User enters correct username and password
* User clicks Login button
* User clicks HPT categories
* HPT categories page opens as well

@Add_HPTcategory
Scenario: Create an HPT type category
* User clicks Add HPT category button
* User adds an HPT category
* User clicks Submit button
* HPT category will be added successfully
* Close the browser

@Edit-HPTcategory
Scenario: Editing HPT category
* User clicks Edit for an HPT category
* User edits HPT category
* User clicks Submit button
* HPT category will be edited successfully
* Close the browser

@Deactivate_HPTcategory
Scenario: User deactivates HPT category
* User clicks Deactivate for an HPT category
* User clicks Confirm for the confirmation shown
* HPT category will be deactivated as well
* Close the browser

@Reactivate_HPTcategory
Scenario: User reactivates HPT category
* User clicks Reactivate for an HPT category
* User clicks Confirm for the confirmation shown
* HPT category will be reactivated as well
* Close the browser

@Searching_HPTcategory
Scenario: Searching at HPT categories
* User searches for an HPT category at Search box
* The system returns search results as well for HPT category
* Close the browser