Feature: Testing Region Admins
Description: This feature aims to login with region admin,hospitals of region admin

Background:
* Open the browser
* User navigates to 'http://qc.ionhands-sa.com/'
* User clicks at Login link
* User enters correct username and password for region admin
* User clicks Login button 
* Region admin will be logged in as well            

@search_hospital
Scenario: Searching at Hospital
* User clicks Hospitals link from side menu
* Hospitals page will be opened successfully
* User searches for a hospital of region admin at Search box
* The system returns search results as well for region admin
* Close the browser