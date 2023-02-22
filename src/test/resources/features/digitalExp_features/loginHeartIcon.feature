# Nirosh.
# Below Feature have been tested in all 3 viewports, result = PASS!

@smoke_sfcc
Feature: Verification of login functionality via heart icon on pdp

  Scenario: User adds item to wish list via heart icon
    Given User opens expected 'URL'
    And   User search's "Honey-Can-Do 4 Piece Jar Storage Set" in search bar
    And   User clicks on Heart Icon in plp
    And   User Logs in
    Then  Assert user is logged in via name displays in header
