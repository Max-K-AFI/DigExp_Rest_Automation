@smoke_sfcc
Feature: Verify Popup on Mobile reflects multiple items added

  Scenario: User adds one item and asserts total in popup
    Given User opens expected 'URL'
    And   User search's "Chime 8 Inch Innerspring Queen Mattress" in search bar
    Then  User chooses "8 Inch Chime Innerspring Queen Mattress in a Box, White, large" in plp
    Then  User change qty from 1 to 2 in PDP tablet and desktop skip
    And   User clicks on Add Item to Cart tablet and desktop skip
    Then  User asserts items in popup is "Chime 8 Inch Innerspring Queen Mattress" qty or item