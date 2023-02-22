# Nirosh.
# Below Feature have been tested in all 3 viewports, result = PASS!

@smoke_sfcc
Feature: Verification protection plan availability for Florida, Alaska, Hawaii

  Scenario:  As a user, I should be able to see protection plan details and cost on cart page
    Given User opens expected 'URL'
    Then User finds closest store by "33606"
    Then  User searches for SKU "7500538"
    Then User verifies that FPP available on PDP
    And  User clicks on Add Item to Cart
    Then  User searches for SKU "P455-822"
    Then User verifies that OUTDoorPP available on PDP
    And  User clicks on Add Item to Cart
    Then  User searches for SKU "M9X732"
    And  User clicks on Add Item to Cart
    Then  User searches for SKU "M9X732"
    And User Select King bed size
    Then User verifies that KingAdjustable available on PDP
    Then  User clicks on Add Item to Cart
    Then User navigates to cart page
    Then User clicks on Confirm button to confirm the zip code
    When User verifies that "protection plan" is added to cart
    Then User changes the delivery "99503" by clicking on zipcode link from Cart Page
    Then User verifies that Protection Plan is not available
    Then User changes the delivery "96818" by clicking on zipcode link from Cart Page
    Then User verifies that Protection Plan is not available
    Then User changes the delivery "33606" by clicking on zipcode link from Cart Page
    Then User verifies that protection plan is available on cart
    Then User verifies that protection plan is unselected
