@smoke_sfcc
Feature: Zero tax state validation
  As a customer in no sales tax state (Oregon), my order should not have any taxes.

  Scenario: User sets store as Florida store, search for an item, add item to cart and navigate to Cart Page
    Given User opens expected 'URL'
    Then User finds closest store by '33606'
    Then User searches for SKU "9510438"
    Then User clicks on Add Item to Cart
    Then User navigates to cart page
    Then User clicks on Confirm button to confirm the zip code
    Then User validates the tax amount on CartPage
    Then User changes the delivery "97317" by clicking on zipcode link from Cart Page
    Then User validates the tax amount on CartPage
    Then User clicks on Secure Check out button
    Then User fills in customer and shipping info using auto address selection
      | FName                    |
      | LName                    |
      | 3850 Hagers Grove Rd SE Ste 106, |
      | Salem                    |
    Then User validates the tax amount on SecureCheckout CustomerInfo Page
    Then User clicks on Continue as Guest button
    Then User validates the tax amount on SecureCheckout Shipping Page
    Then User clicks on continue to billing and payment button
    Then User validates the tax amount on SecureCheckout Billing Page
