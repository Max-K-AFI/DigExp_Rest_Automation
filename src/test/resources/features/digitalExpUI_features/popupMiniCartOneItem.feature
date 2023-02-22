@smoke_sfcc
Feature: Verify Popup on Mobile reflects one item added

  Scenario: User adds one item and asserts total in popup
    Given User opens expected 'URL'
    And   User search's "Honey-Can-Do 4 Piece Jar Storage Set" in search bar
    Then  User chooses "Honey-Can-Do 4-Piece Glass Jar Storage Set with Bamboo Lids, , large" in plp
    And   User clicks on Add Item to Cart mobile skip
    Then  User asserts items in popup is "Honey-Can-Do 4 Piece Jar Storage Set" qty or item
