Feature: Opening Login Page
Description: This feature will test google

Background:
* Open the browser
* User navigates to 'http://qc.ionhands-sa.com/'
* User clicks at Login link

@open_login
Scenario: Opening Login Page
* The system will open Login page successfully
* Close the browser

#@Forgot_Password
#Scenario: Testing Forgot Password link
#* Click 'Forgot Password' link
#* Forgot password page opens as well
#* Enter valid Email address
#* Click Submit
#* Email will be sent as well
#* Close the browser

@login_failed
Scenario: User logged in insuccessfully
* User enters incorrect username and password
* User clicks Login button
* The system will give a validation incorrect credentials
* Close the browser

@login_successful
Scenario: User logged in successfully
* User enters correct username and password
* User clicks Login button
* The system will login the user to his dashboard as well
* Close the browser



