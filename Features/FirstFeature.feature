Feature: Twitter
   
   Scenario Outline: Login to Twitter
    Given user is able to launch application url
    When user clicks on login button
	And user should be navigated to Login Page
 	And user verify login button is disabled
 	And user enters username and password from file "<fileName>"
 	Then user clicks on login button on login page
 	And user should navigate to twitter home page
	And user logout from twitter
Examples:
|fileName|
|CustomerDetails.json|

Scenario Outline: Upload profile picture
    Given user is able to launch application url
    When user clicks on login button
	And user should be navigated to Login Page
 	And user enters username and password from file "<fileName>"
 	Then user clicks on login button on login page
 	And user should navigate to twitter home page
 	And user clicks on profile button
 	And user uploads profile picture
 	

Examples:
|fileName|
|CustomerDetails.json|
   
    
    Scenario Outline: Update Profile
    Given user is able to launch application url
    When user clicks on login button
	And user should be navigated to Login Page
 	And user enters username and password from file "<login>"
 	Then user clicks on login button on login page
 	And user should navigate to twitter home page
 	And user clicks on profile button
 	And user clicks on edit profile button
 	And user enters profile data from file "<profile>"
 	

Examples:
|login|profile|
|CustomerDetails.json|ProfileDetails.json|

 Scenario Outline: Verify updated Profile details
    Given user is able to launch application url
    When user clicks on login button
	And user should be navigated to Login Page
 	And user enters username and password from file "<login>"
 	Then user clicks on login button on login page
 	And user should navigate to twitter home page
 	And user clicks on profile button
 	And user verify profile data from file "<profile>"
 	

Examples:
|login|profile|
|CustomerDetails.json|ProfileDetails.json|

Scenario Outline: Fetch tweets
    Given user is able to launch application url
    When user clicks on login button
	And user should be navigated to Login Page
 	And user enters username and password from file "<login>"
 	Then user clicks on login button on login page
 	And user should navigate to twitter home page
 	And enter search data from file "<profile>"
 	And Fetch tweet details
 	

Examples:
|login|profile|
|CustomerDetails.json|ProfileDetails.json|
   