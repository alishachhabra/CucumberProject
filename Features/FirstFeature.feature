Feature: Chekout Feature
  Checkout flow for puchasing pillow
   
   Scenario Outline: checkout flow for purchasing Pillow using Credit Card as payment method with valid card details
    Given user is able to launch application url
    When user clicks on Buy now button
	And user should be navigated to Shopping Cart
 	And user enters customer details
 	Then user should be navigated to order summary popup
 	And user clicks on continue button on order summary popup
 	Then user should be navigated to payment page
 	Then user selects payment method as "Credit Card"
 	And user navigated to payment type page
 	And user enter card details from file "<fileName>"
 	Then user clicks on paynow button
 	And user navigated to payment processing page
 	And user enters otp after verifying total amount
 	Then verify payment completed

Examples:
|fileName|
|CardDetails.json|

Scenario Outline: checkout flow for purchasing Pillow using Credit Card as payment method with invalid card details
    Given user is able to launch application url
    When user clicks on Buy now button
	And user should be navigated to Shopping Cart
 	And user enters customer details
 	Then user should be navigated to order summary popup
 	And user clicks on continue button on order summary popup
 	Then user should be navigated to payment page
 	Then user selects payment method as "Credit Card"
 	And user navigated to payment type page
 	And user enter card details from file "<fileName>"
 	Then user clicks on paynow button


Examples:
|fileName|
|InvalidCardDetails.json|

   
    