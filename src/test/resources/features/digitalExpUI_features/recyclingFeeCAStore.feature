@smoke_sfcc @cucumberError
Feature: Verify State Recycling fee is displayed in Shipping and billing pages when user select a CA store and not displayed for non - CA stores

  Background:
    Given User opens expected 'URL'

  Scenario: Verify recycle fee is available when CA store is selected.
    Then User finds closest store by '90015'
    Then  User searches for SKU 'M69511'
    Then  User clicks on Add Item to Cart
    Then User navigates to cart page
    Then User clicks on Confirm button to confirm the zip code
    Then User clicks on Secure Check out button
    Then User fills in customer and shipping info using auto address selection
      | FName            |
      | LName            |
      | 1810 S Broadway, |
      | Los Angeles      |
    Then User clicks on Continue as Guest button
    Then User Verifies Recycle Fee is displayed on SecureCheckOut Shipping Page only for CA store
    Then User clicks on continue to billing and payment button
    Then User Verifies Recycle Fee is displayed on SecureCheckOut Billing Page only for CA store


  Scenario: Verify recycle fee is NOT available when north carolina store (non- CA store) is selected.
    Then User finds closest store by '28115'
    Then  User searches for SKU 'M69511'
    Then  User clicks on Add Item to Cart
    Then User navigates to cart page
    Then User clicks on Confirm button to confirm the zip code
    Then User clicks on Secure Check out button
    Then User fills in customer and shipping info using auto address selection
      | FName          |
      | LName          |
      | 125 Alborn Dr, |
      | Mooresville    |
    Then User clicks on Continue as Guest button
    Then User Verifies Recycle Fee is displayed on SecureCheckOut Shipping Page only for CA store
    Then User clicks on continue to billing and payment button
    Then User Verifies Recycle Fee is displayed on SecureCheckOut Billing Page only for CA store

