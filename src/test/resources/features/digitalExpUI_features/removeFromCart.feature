@smoke_sfcc
Feature: Remove from cart validations

  Background:
    Given User opens expected 'URL'

  Scenario: Add Whitesburg Dining Table to cart and remove, validating cart reflects removal
    Given User search's "Whitesburg Dining Table" in search bar
    Then User chooses "Whitesburg Dining Table, , large" in plp
    And  User clicks on Add Item to Cart
    And  User clicks on cart icon
    And User clicks on Confirm button to confirm the zip code
    And  User Removes item from cart
    Then User Validates cart is 0 qty


  Scenario: User Adds item to cart and removes from mini cart
    Given  User search's "Ultra Luxury Memory Foam" in search bar
    Then  User chooses "Ultra Luxury Firm Tight Top with Memory Foam Queen Mattress, White, large" in plp
    Then  User clicks on Add Item to Cart
    Then  User Removes item from mini cart
    Then  User asserts items in mini cart is "0" qty

