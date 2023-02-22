# Max-K.
# Below Feature have been tested in all 3 viewports, result = PASS!

@smoke_sfcc
Feature: Available payment types in cart page verification
  As a user, I should be able to choose desired payment method; CC, AA, PL, Caddipay, Acima or PP

  Scenario: User sets store as Florida store, search for an item, add item to cart and navigate to Cart Page
    Given User opens expected 'URL'
    Then User finds closest store by '33544'
    Then User searches for SKU 'A2000223'
    Then User clicks on Add Item to Cart
    Then User navigates to cart page
    Then User clicks on Confirm button to confirm the zip code
    Then User clicks on Secure Check out button
    Then User fills in customer and shipping info using auto address selection
      | QA                     |
      | Tester                 |
      | 26222 Golden Maple Rd, |
      | Wesley Chapel          |
    Then User clicks on Continue as Guest button
    Then User clicks on continue to billing and payment button
    Given User is on 'Checkout' Page
    Then User verifies Credit card Payment options are available
    Then User verifies Ashley Advantage Payment option and clicks on it
    And User verifies Ashley Advantage logos and fields are displayed
    Then Caddipay Payment option is available and clicks on it
    Then User verifies that Caddipay page is launched then close the window
    Then User verifies Progressive leasing Payment and clicks on ot
    And User verifies Progressive leasing Payment logos and fields
    Then User verifies Paypal Payment option and clicks on it
    And User verifies that Paypal login page is launched
    Then Acima Payment option is available


