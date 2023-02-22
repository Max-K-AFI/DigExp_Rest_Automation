@smoke_sfcc
Feature: Verification of Save for Later button

  Background:
    Given User opens expected 'URL'

  Scenario: User adds Honey-Can-Do 4 Piece Jar Storage Set to cart and clicks save for later
    Given  User search's "Honey-Can-Do 4 Piece Jar Storage Set" in search bar
    Then  User chooses "Honey-Can-Do 4-Piece Glass Jar Storage Set with Bamboo Lids, , large" in plp
    And   User clicks on Add Item to Cart
    And   User clicks on cart icon
    And   User clicks on Confirm button to confirm the zip code
    Then  User clicks save for later button
    And   User Logs in
    Then  User asserts "Honey-Can-Do 4 Piece Jar Storage Set" saved items with "honey"


  Scenario: Verification of Save for Later button in mini cart
    And   User search's "Honey-Can-Do 4 Piece Jar Storage Set" in search bar
    Then  User chooses "Honey-Can-Do 4-Piece Glass Jar Storage Set with Bamboo Lids, , large" in plp
    And   User clicks on Add Item to Cart
    And   User clicks on save for later mini cart
    And   User logs in with "username" and "password" mobile skip
    Then  User clicks on cart icon
    Then  User asserts "Honey-Can-Do 4 Piece Jar Storage Set" saved items in cart with "honey" mobile skip
