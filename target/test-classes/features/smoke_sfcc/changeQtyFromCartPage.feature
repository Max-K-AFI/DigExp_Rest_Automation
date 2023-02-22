# Nirosh.
# Below Feature have been tested in all 3 viewports, result = PASS!

@smoke_sfcc
Feature: Changing quantity from cart page verification

  Scenario: Verify if quantity can be changed in Cart Page when item is Added to the Cart.
    Given User opens expected 'URL'
    And   User search's "Chime 8 Inch Innerspring Twin Mattress" in search bar
    And   User chooses "8 Inch Chime Innerspring Twin Mattress in a Box, White, large" in plp
    And   User clicks on Add Item to Cart
    Then  User clicks on cart icon
    Then User clicks on Confirm button to confirm the zip code
    Then  User changes Qty from "1" to "2" in cart
    Then  Assert cart is reflecting "My Cart (2 items)" QTY change


