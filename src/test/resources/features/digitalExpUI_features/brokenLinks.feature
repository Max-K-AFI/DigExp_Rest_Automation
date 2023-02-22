#@regression
Feature: Broken links capture
  Check all available "links" and verify if all functional

  @smoke
  Scenario:  Verify if all URLs in page are valid
    Given User navigates to 'https://storefront:afweb2017@lab.ashleyfurniture.com/'
    And User scrolls down to footer - Non Apollo
    When User clicks on 'United States' link in footer next to USA flag - Non Apollo
    Then User verifies each link on page


