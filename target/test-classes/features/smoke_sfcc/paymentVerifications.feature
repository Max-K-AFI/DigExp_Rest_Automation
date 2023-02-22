@regression @payments
Feature: Payment verifications of all types

  Background:
    Given User opens expected 'URL'

  @visa
  Scenario: Visa card payment verification
  Verify user can place an order with Visa card as payment type
    Given User finds closest store by '33606'
    Then User hovers over on "furniture" and clicks on "Tables"
    Then User clicks Quick View on top of the First Product
    Then User clicks on Add Item to Cart
    Then User navigates to cart page
    Then User clicks on Confirm button to confirm the zip code
    #Then User removes Protection Plan
    Then User clicks on Secure Check out button
    Then User manually enters customer info in all fields on Secure Checkout Delivery Page
      | QA              |
      | Tester          |
      | 100 Main St    |
      | Tampa           |
      | Florida         |
      | 33606           |
      | 6123513551      |
      | Tester@test.com |
    Then User clicks on Continue button after filling in address info on check-out page
    Then User clicks on Use Address as Entered button on PopUp window
    Then User clicks on continue to billing and payment button
    Then User is on Billing and Payment Page
    Then User clicks on Credit Card Payment option
    Then User enters Credit card Info on Billing page
      | QA Tester        |
      | 4000000000000002 |
      | December         |
      | 2025             |
      | 382              |
    Then User clicks on Continue Button on Billing Page
    Then User clicks on Place Order button
    Then User verifies successful order submission

  @master
  Scenario: Master Credit card payment verification
  Verify user can place an order with Master Credit card as payment type
    Given User finds closest store by '33606'
    Then User hovers over on "furniture" and clicks on "Tables"
    Then User clicks Quick View on top of the First Product
    Then User clicks on Add Item to Cart
    Then User navigates to cart page
    Then User clicks on Confirm button to confirm the zip code
    Then User clicks on Secure Check out button
    Then User manually enters customer info in all fields on Secure Checkout Delivery Page
      | QA               |
      | Tester           |
      | 100 Main Street, |
      | Apt 234          |
      | Tampa            |
      | Florida          |
      | 33606            |
      | 6123513551       |
      | Tester@test.com  |
    Then User clicks on Continue button after filling in address info on check-out page
    Then User clicks on Use Address as Entered button on PopUp window
    Then User clicks on continue to billing and payment button
    Then User is on Billing and Payment Page
    Then User clicks on Credit Card Payment option
    Then User enters Credit card Info on Billing page
      | QA Tester        |
      | 5121212121212124 |
      | December         |
      | 2025             |
      | 382              |
    Then User clicks on Continue Button on Billing Page
    Then User clicks on Place Order button
    Then User verifies successful order submission

  @discover
  Scenario: Discover Credit card payment verification
  Verify user can place an order with Discover Credit card as payment type
    Given User finds closest store by '33606'
    Then User hovers over on "furniture" and clicks on "Tables"
    Then User clicks Quick View on top of the First Product
    Then User clicks on Add Item to Cart
    Then User navigates to cart page
    Then User clicks on Confirm button to confirm the zip code
    Then User clicks on Secure Check out button
    Then User manually enters customer info in all fields on Secure Checkout Delivery Page
      | QA               |
      | Tester           |
      | 100 Main Street, |
      | Apt 234          |
      | Tampa            |
      | Florida          |
      | 33606            |
      | 6123513551       |
      | Tester@test.com  |
    Then User clicks on Continue button after filling in address info on check-out page
    Then User clicks on Use Address as Entered button on PopUp window
    Then User clicks on continue to billing and payment button
    Then User is on Billing and Payment Page
    Then User clicks on Credit Card Payment option
    Then User enters Credit card Info on Billing page
      | QA Tester        |
      | 6011000000000004 |
      | December         |
      | 2025             |
      | 382              |
    Then User clicks on Continue Button on Billing Page
    Then User clicks on Place Order button
    Then User verifies successful order submission

  @american
  Scenario: American Express Credit card payment verification
  Verification if  user can place an order with American Express Credit card as payment type
    Given User finds closest store by '33606'
    Then User hovers over on "furniture" and clicks on "Tables"
    Then User clicks Quick View on top of the First Product
    Then User clicks on Add Item to Cart
    Then User navigates to cart page
    Then User clicks on Confirm button to confirm the zip code
    Then User clicks on Secure Check out button
    Then User manually enters customer info in all fields on Secure Checkout Delivery Page
      | QA               |
      | Tester           |
      | 100 Main Street, |
      | Apt 234          |
      | Tampa            |
      | Florida          |
      | 33606            |
      | 6123513551       |
      | Tester@test.com  |
    Then User clicks on Continue button after filling in address info on check-out page
    Then User clicks on Use Address as Entered button on PopUp window
    Then User clicks on continue to billing and payment button
    Then User is on Billing and Payment Page
    Then User clicks on Credit Card Payment option
    Then User enters Credit card Info on Billing page
      | QA Tester       |
      | 370000000000002 |
      | December        |
      | 2025            |
      | 382             |
    Then User clicks on Continue Button on Billing Page
    Then User clicks on Place Order button
    Then User verifies successful order submission

  @synchrony
  Scenario: Synchrony [Six month promo offer] payment verification
  Verification if user can place an order with Ashley Advantage Synchrony Six Months promotional offer as payment type
    Given User finds closest store by '45420'
    Then User hovers over on "furniture" and clicks on "Sofas"
    Then User clicks Quick View on top of the First Product
    Then User clicks on Add Item to Cart
    Then User navigates to cart page
    Then User clicks on Confirm button to confirm the zip code
    Then User clicks on Secure Check out button
    Then User manually enters customer info in all fields on Secure Checkout Delivery Page
      | QA               |
      | Tester           |
      | 950 FORRER BLVD, |
      | 100              |
      | Dayton           |
      | Ohio             |
      | 45420            |
      | 6123513551       |
      | Tester@test.com  |
    Then User clicks on Continue button after filling in address info on check-out page
    Then User clicks on continue to billing and payment button
    Then User is on Billing and Payment Page
    Then User clicks on Ashley Advantage Payment option
    Then User enters AA Synchrony account number '6019193609801005' on Billing page
    Then User clicks on View Financing Offers Button on Billing Page
    Then User selects '6 Months Promotional Financing' financing term and click on continue button on Billing page
    Then User clicks on Accept button on Billing page
    Then User clicks on Place Order button
    Then User verifies successful order submission

  @acima
  Scenario: ACIMA Leasing payment type verification
  Verify user can place an order with Visa card as payment type
    Given User finds closest store by '33606'
    Then User hovers over on "furniture" and clicks on "Sofas"
    Then User clicks Quick View on top of the First Product
    Then User clicks on Add Item to Cart
    Then User navigates to cart page
    Then User clicks on Confirm button to confirm the zip code
    #Then User removes Protection Plan
    Then User clicks on Secure Check out button
    Then User manually enters customer info in all fields on Secure Checkout Delivery Page
      | QA              |
      | Tester          |
      | 100 Main Str    |
      | Apt 234         |
      | Tampa           |
      | Florida         |
      | 33606           |
      | 6123513551      |
      | Tester@test.com |
    Then User clicks on Continue button after filling in address info on check-out page
    Then User clicks on Use Address as Entered button on PopUp window
    Then User clicks on continue to billing and payment button
    Then User is on Billing and Payment Page
    Then User clicks on Acima Leasing Logo as Payment option
    Then User clicks on Place Order button
    Then User enters last four digits of SSN as "8987" in Acima popup and clicks Submit
    Then User clicks Continue on Verification Page
    Then User enters full SSN as "123458987" and Confirms entry one more time
    Then User clicks Submit, confirms information and clicks Submit again
    Then User clicks on CheckBox to agree to Disclosure and clicks on Sign Agreement
    Then User types "Approved High" as user name and clicks on Accept and Sign
    Then User clicks on CheckBox to enable AutoPay and enters Card info
      | CardNumber       | Month | Year | Cvv |
      | 4029820001111111 | June  | 2024 | 779 |
    Then User clicks on Make Payment
    Then User verifies successful order submission


  @paypal
  Scenario: Visa card payment verification
  Verify user can place an order with Visa card as payment type
    Given User finds closest store by '33606'
    Then User hovers over on "furniture" and clicks on "Tables"
    Then User clicks Quick View on top of the First Product
    Then User clicks on Add Item to Cart
    Then User navigates to cart page
    Then User clicks on Confirm button to confirm the zip code
    #Then User removes Protection Plan
    Then User clicks on Secure Check out button
    Then User manually enters customer info in all fields on Secure Checkout Delivery Page
      | QA              |
      | Tester          |
      | 100 Main St    |
      | Apt 234         |
      | Tampa           |
      | Florida         |
      | 33606           |
      | 6123513551      |
      | Tester@test.com |
    Then User clicks on Continue button after filling in address info on check-out page
    Then User clicks on Use Address as Entered button on PopUp window
    Then User clicks on continue to billing and payment button
    Then User is on Billing and Payment Page
    Then User verifies Paypal Payment option and clicks on it
    Then User logs into paypal account and review order
    Then User clicks on Place Order button
    Then User verifies successful order submission