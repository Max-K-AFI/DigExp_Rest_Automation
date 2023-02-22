@regression @smoke
Feature: Footer sub-category links verification
  Verify if all clickable "sub-category links" in footer functioning as expected

  Background:
    Given User navigates to "homePageUrl"
    When User scrolls down to footer

  Scenario Outline: [Footer] Verifying '<subCategory>'
    And  If platform is mobile user clicks on below category
      | Get To Know Us   |
      | Customer Care    |
      | Get Inspired     |
      | Terms & Policies |

    #OPEN RD IN PLACE FOR SOME FAILURE!!!
    Then User verifies "<subCategory>" opens "<expectedPage>" page
    Examples:
      | subCategory                       | expectedPage             |
      | About Ashley Homestore            | about-us                 |
      | Our History                       | company/history          |
      | About Ashley Furniture Industries | company-overview         |
      | Careers                           | ashleycareers            |
      | News                              | news                     |
      | Social Responsibility             | social-responsibility    |
      | Store Locations                   | stores                   |
      | Trade Program                     | trade                    |
      | Help Center                       | ask-ashley               |
      | Contact Us                        | ask-ashley               |
      | Apply for Financing               | financing                |
      | Prequalify for Financing          | financing                |
      | Lease to Own Option               | financing/acima          |
      | Returns                           | demandware.store         |
      | Accessibility                     | accessibility            |
      | Consumer Notifications            | consumer-notifications   |
      | FAQ                               | demandware.store         |
      | Price Match                       | price-match              |
      | Child Safety                      | anchorit                 |
      | Warranty Information              | warranty-information     |
      | Product Care & Cleaning           | care-and-cleaning        |
      | Furniture Protection Plan         | furniture-protection     |
      | Blog                              | blog                     |
      | Home Ideas                        | shop-by                  |
      | Digital Catalog                   | digital-catalog          |
      | 3D Room Design                    | roombuilder              |
      | Hope to Dream                     | ahopetodream             |
      | Refer a Friend                    | referafriend             |
      | Offers & Details*                 | coupons-deals-and-offers |
      | Terms & Conditions                | terms-and-conditions     |
      | Terms of Use                      | terms-of-use             |
      | Privacy Policy                    | privacy-policy           |
      | Interest-Based Ads                | interest-based-ads       |
      | Do not sell my Personal Info      | preferences              |


    #OPEN RD IN PLACE FOR FAILURE!!!
  Scenario: TC-826999 [Footer] 'Country Selector' link verification
    When User clicks on country selector link
      | United States |
    Then User verifies page title includes "choose-country-region"

    
  Scenario: TC-830402 [Footer] Sign Up link verification
    When User verifies Email entry box exists
    Then User verifies "Sign Up" button is shown




