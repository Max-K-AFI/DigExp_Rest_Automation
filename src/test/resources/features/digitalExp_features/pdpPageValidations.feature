@smoke_sfcc
Feature: Verify PDP page items

  Background:
    Given User opens expected 'URL'

  Scenario: User Changes between different bed size verifying switching occurs
    And   User search's "Chime 12 Inch Hybrid Twin Mattress in a Box, White, large" in search bar
    And   User chooses "Chime 12 Inch Hybrid Twin Mattress in a Box, White, large" in plp
    And   User asserts "twin" bed size displayed on PDP
    Then  User changes bed size in PDP to ones not currently displayed mattress and asserts change
      | full            |
      | queen           |
      | king            |
      | california king |


#  Verification of Color Switching on PDP
  Scenario: User Changes between different colors schemes verifying switching occurs
    And   User search's "Darcy Loveseat" in search bar
    And   User chooses "Darcy Loveseat, Cobblestone, large" in plp
    And   User asserts "Cobblestone" color displayed on PDP
    Then  User changes color scheme in PDP to ones not currently displayed by colors different colors and asserts change
      | Salsa       |
      | Mocha       |
      | Cafe        |
      | Cobblestone |
      | Blue        |
      | Black       |
      | Steel       |

# Max-K
# Desktop only verification - test pass!
# Verification of quick view in PDP
  Scenario: Navigate to the PDP page and click on quick view and verify tab
    When User hovers over on "FURNITURE" and clicks on "Sofas"
    Then User hovers over on first found item's hero image
    And User verifies visibility of Quick view text and clicks on it
    Then User clicks on right arrow switching between products on QuickView
    Then User navigates to "Soletren Sofa" using next arrow in QuickView
    Then User changes color scheme in quick view and asserts change
      | Ash   |
      | Stone |
    Then User clicks on learn more and closes
    And User changes qty from 1 to 2 in PLP quick view
    And User clicks on Add Item to Cart in quick view
    Then User clicks X to exit quick view and asserts items in mini cart is "2" qty