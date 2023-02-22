@smoke_sfcc
Feature: Shopping Cart validations

  Background:
    Given User opens expected 'URL'

#  Verification of 3 Items added to cart is reflected in "mini cart logo" as 3 total items
  Scenario: User adds items to cart
    Given User hovers over on "FURNITURE" and clicks on "Sofas"
    And   User clicks on PLP Show "80" per page button
    And   User chooses "Darcy Sofa, Cobblestone, large" in plp
    Then  User clicks on Add Item to Cart
    And   User hovers over on "FURNITURE" and clicks on "Sofas"
    And   User clicks on PLP Show "80" per page button
    And   User chooses "Soletren Sofa, Stone, large" in plp
    Then  User clicks on Add Item to Cart
    Then  Assert total number of items in mini cart is 2

#  Verification of Mini Cart after adding 1 item and items from "shop the collection" to cart
  Scenario: User Adds item to cart and adds items from shop the collection to cart
    And   User search's "Macleary Sofa" in search bar
    Then  User chooses "Macleary Sofa, Moss, large" in plp
    And   User Clicks Add to Cart in Shop the Collection for "8900620"
    Then  User clicks on Add Item to Cart PDP scroll
    Then  User asserts items in mini cart is "2" qty





