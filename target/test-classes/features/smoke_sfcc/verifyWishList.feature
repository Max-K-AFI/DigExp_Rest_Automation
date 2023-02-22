@smoke_sfcc
Feature: Verification of WishList Items

  Background:
    Given User opens expected 'URL'

  Scenario: User adds item to cart from wish list
    And   User search's "Darcy Sofa" in search bar
    And   User chooses "Darcy Sofa, Cobblestone, large" in plp
    And   User clicks on Heart Icon in pdp
    When  User logs in with "username" and "password"
    Then  User verifies that "Darcy Sofa, Cobblestone, large" in Wish List is clickable with url text "darcy"
    And   User clicks on "wishlist" in account tab
    And   User verify view details button for "Darcy Sofa" in Wish list
    And   User clicks on "wishlist" in account tab
    Then  User clicks on remove button in Wish List for "Darcy Sofa"
    Then  User Asserts "Darcy Sofa, Cobblestone, large" is not in wishlist


#  Verification of WishList Add to Cart from cart page
  Scenario: User adds item to cart from wish list
    And   User clicks on login link on different viewports
    When  User logs in with "username" and "password"
    And   User clicks on "wishlist" in account tab
    Then  User clicks "Honey-Can-Do 4-Piece Glass Jar Storage Set with Bamboo Lids" add to cart from Wish List
    Then  User clicks on cart icon
    Then  User clicks on Confirm button to confirm the zip code
    Then  User asserts "Honey-Can-Do 4 Piece Jar Storage Set" saved items in cart


