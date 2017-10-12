Feature: Healthcare Practitioner Types
Description: This feature aims to testing creating, editing, searching, deactivating and reactivating
             of HPTs by hospital admin

Background: 
* Open the browser
* User navigates to 'http://qc.ionhands-sa.com/'
* User clicks at Login link
* User enters correct username and password for hospital admin
* User clicks Login button 
* Hospital admin will be logged in as well            
* User clicks HPTs link
* HPTs page will be opened as well

@Add_HPT
Scenario: Add HPT
* user clicks 'Add HPT'
* user selects an HPT category
* User adds an HPT
* User clicks Submit button
* HPT will be added as well
* Close the browser 

@Edit_HPT
Scenario: Editing HPTs
* User clicks Edit for an HPT
* User edits an HPT 
* User clicks Submit button
* HPT will be edited successfully
* Close the browser

@Deactivate_HPT
Scenario: Deactivate HPTs
* User clicks Deactivate for an HPT
* User clicks Confirm for the confirmation shown
* HPT will be deactivated as well
* Close the browser

@Reactivate_HPT
Scenario: Reactivate HPTs
* User clicks Reactivate for an HPT
* User clicks Confirm for the confirmation shown
* HPT will be reactivated as well
* Close the browser

@Search_HPT
Scenario: Search HPTs
* User searches for an HPT at Search box
* The system returns search results as well for HPT
* Close the browser