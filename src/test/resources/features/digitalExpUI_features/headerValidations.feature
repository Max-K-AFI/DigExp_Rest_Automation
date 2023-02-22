@regression
Feature: Header items verification

  Background:
    Given User navigates to "https://mfe-product.dev.ashleyretail.com/product-details/2010138"
#    Given User navigates to "homePageUrl"      ---> until home page fixed using above URL

  @desktopOnly
  Scenario: TC-838831 [Header] Header Styling top left links verification
    #OPEN RD IN PLACE FOR FAILURE AT BELOW STEP
    When User verifies store-locator located on top of header and right side of header grid
    When User verifies Top Level Categories for visual navigation in below order
      | Furniture    |
      | Mattress     |
      | Baby & Kids  |
      | Outdoor      |
      | Home & Decor |
      | Shop by      |
      | Deals        |

  @desktopOnly
  Scenario Outline: TC-838831 [Header] Header Styling top right links verification
    Then User verifies "<text>" is located at same grid line and on right side of "<compared text>"
    Examples:
      | text                     | compared text            |
      | Help                     | Deals                    |
      | Interior Design Services | Help                     |
      | Prequalify for Financing | Interior Design Services |

  Scenario: TC-861268 [Header] Verify store location dropdown functionality
    When If platform is mobile or tablet user clicks on hamburger menu
    #OPEN RD IN PLACE FOR FAILURE AT BELOW STEP
    And User clicks Store Locator link within header
    Then User verifies 'search bar', 'update button', 'closest to' and 'no-store-found' fields availability in popup