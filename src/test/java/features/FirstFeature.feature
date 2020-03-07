Feature: Login Feature
  Verify if user is able to Login in to the site

@Smoke
  Scenario: Login as an authenticated user
    Given user is on homepage
    When user navigates to registration Page
    And user enters "AlishaChhabra" and "Test@1234"
    Then message "Success!" is displayed

@Regression    
   Scenario Outline: Login as an authenticated user with multiple test data
    Given user is on homepage
    When user navigates to registration Page
    And user enters "<username>" and "<password>"
    Then message "<message>" is displayed
    
    Examples:
    | username  | password  | message |
	| test1234 | test@123456 | Success! |
	| test1245 | Test@12 |Failed! please enter strong password|
	
@Datatable	
	Scenario: Login as an authenticated user with data table
    Given user is on homepage
    When user navigates to registration Page
    And user enters following credentials
    | username  | password  |
    | test1234 | test@123456 |
    | alishachhabra | test@1237 |
    And user clicks on submit
    Then message "Success!" is displayed