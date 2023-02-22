@smoke_sfcc
Feature: Progressive Payment verifications

  Background:
    Given User opens expected 'URL'
@PAYMENT
#  Verify Pop up message is displayed if Progressive payment is selected with a Protection plan
  Scenario: User sets store as Florida store
    Then User finds closest store by "33606"
    Then  User searches for SKU "APK-12020-3R"
    Then User verifies that FPP available on PDP
    Then  User clicks on Add Item to Cart
    Then User navigates to cart page
    Then User clicks on Confirm button to confirm the zip code
    Then User clicks on Secure Check out button
    Then User fills in customer and shipping info using auto address selection
      | QA                         |
      | Tester                     |
      | 401 W (West) KENNEDY BLVD, |
      | Tampa                      |
    Then User clicks on Continue as Guest button
    Then User clicks on continue to billing and payment button
    Then User clicks on Progressive leasing Payment option
    Then User verifies that Progressive Popup for ProtectionPlan is displayed
    Then User click on Continue with Progressive Leasing button in Progressive popup msg
    Then User navigate back to cart page
    Then User clicks on Confirm button to confirm the zip code
    Then User Removes item from cart

#  Verify that Pop up combined popup message is displayed if Progressive payment is selected with a Handy Item + FPP
  Scenario: User sets store as Florida store
    Then User finds closest store by "33606"
    Then  User searches for SKU "D631-01"
    Then User verifies that FPP available on PDP
    Then  User clicks on Add Item to Cart
    Then User navigates to cart page
    Then User clicks on Confirm button to confirm the zip code
    Then User check Handy Item check box
    Then User clicks on Secure Check out button
    Then User fills in customer and shipping info using auto address selection
      | QA                  |
      | Tester              |
      | 401 W KENNEDY BLVD, |
      | Tampa               |
    Then User clicks on Continue as Guest button
    Then User clicks on continue to billing and payment button
    Then User clicks on Progressive leasing Payment option
    Then User verifies that Progressive Popup for FPP and Handy Item is displayed
    Then User click on Continue with Progressive Leasing button in Progressive FPP and Handy popup msg
    Then User navigate back to cart page
    Then User clicks on Confirm button to confirm the zip code
    Then User Removes item from cart
@PAYMENT
#  Verify Pop up message is displayed if Progressive payment is selected with a Handy Item
  Scenario: User sets store as Florida store
    Then User finds closest store by "33606"
    Then  User searches for SKU "D631-01"
    Then User verifies that FPP available on PDP
    Then  User clicks on Add Item to Cart
    Then User navigates to cart page
    Then User clicks on Confirm button to confirm the zip code
    Then User uncheck Protection Plan check box
    Then User check Handy Item check box
    Then User clicks on Secure Check out button
    Then User fills in customer and shipping info using auto address selection
      | QA                  |
      | Tester              |
      | 401 W KENNEDY BLVD, |
      | Tampa               |
    Then User clicks on Continue as Guest button
    Then User clicks on continue to billing and payment button
    Then User clicks on Progressive leasing Payment option
    Then User verifies that Progressive Popup for Handy Item is displayed
    Then User click on Continue with Progressive Leasing button in Progressive Handy popup msg
    Then User navigate back to cart page
    Then User clicks on Confirm button to confirm the zip code
    Then User Removes item from cart





