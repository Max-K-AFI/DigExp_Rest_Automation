@smoke_sfcc
Feature: Verification of PLP

  Background:
    Given User opens expected 'URL'

#  Verify PLP filters changes results of products in PLP
  Scenario: User chooses product filters and verifies filter changes
    Then   User hovers over on "FURNITURE" and clicks on "Sofas"
    Then   User clicks on item filters in PLP and asserts change with filters
      | lifestyle           |
      | facetProductWidthIn |

  Scenario: User verifies PLP page components through search
    And   User search's "Sofas" in search bar
    Then  User checks for "Learn More" button is present
    Then  User asserts "prequal" in learn how popup with "Prequalify Now"
    Then  User asserts "apply" in learn how popup with "Apply Now"
    Then  User clicks second page of inventory and asserts that "page-2" is "2"
    Then  User clicks next button icon and lands user on page "3"
    Then  User clicks on last page of inventory and asserts page

  Scenario: User verifies PLP page components through navigation drawer
    When  User hovers over on "FURNITURE" and clicks on "Sofas"
    Then  User checks for "Learn More" button is present
    Then  User asserts "prequal" in learn how popup with "Prequalify Now"
    Then  User asserts "apply" in learn how popup with "Apply Now"
    Then  User clicks second page of inventory and asserts that "page-2" is "2"
    Then  User clicks next button icon and lands user on page "3"
    Then  User clicks on last page of inventory and asserts page
