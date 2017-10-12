Feature: User Profile
Description: Testing user profile including Edit Profile,Help,About us and Logout

Background:
* Open the browser
* User navigates to 'http://qc.ionhands-sa.com/'
* User clicks at Login link
* User enters correct username and password
* User clicks Login button

@Help
Scenario:
* User clicks on Help link
* Help link opens as well
* Close the browser

@About_Us
Scenario:
* User clicks on About us link
* About us link opens as well
* Close the browser

@Edit_Profile
Scenario:
* User clicks on Edit Profile link
* Edit Profile link opens as well
* User changes name and Contact No
* User clicks Submit
* Changes done successfully
* Close the browser

@Logout
Scenario:
* User clicks on Logout link
* User logs out successfully
* Close the browser


