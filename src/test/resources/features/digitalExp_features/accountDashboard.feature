@regression
Feature: Account Dashboard Items verifications

  Scenario: TC-900425 [Account Dashboard] Dashboard Design
    Given User navigates to 'https://mfe-customer.dev.ashleyretail.com/dashboard/'
    And User verifies 'hi,' customer name and 'account dashboard' displays
    And User verifies below options displayed as list and as card in columns
      | account dashboard |
      | my orders         |
      | wishlist          |
      | saved addresses   |
      | email preferences |

#    ====== Waiting for functionality to be available ========
#  Scenario: TC-900430 [Saved Addresses] No Saved Addresses Design
#    Given User navigates to 'https://mfe-customer.dev.ashleyretail.com/dashboard'
#    When User clicks on 'saved addresses' link
#    And User verifies page title includes 'addresses'
#    And User verifies 'home / account dashboard / saved addresses' displayed as breadcrumb
#    And User verifies 'hi,' customer name and 'account dashboard' displays

  Scenario: TC-900435 [Saved Addresses] Add New Address
    Given  User navigates to 'https://mfe-customer.dev.ashleyretail.com/dashboard/addresses'
    And User clicks on 'add a new address' button
    Then User fills up address info with below credentials
      | address-label | Home             |
      | first-name    | Ashley           |
      | last-name     | Tester           |
      | address-1     | 100 Ashley Drive |
      | address-2     | 120              |
      | city          | Tampa            |
      | zip-code      | 33510            |
    And User chooses state as 'FL' from dropdown
    Then User verifies presence of 'submit' button and clicks on it
    Then User validates if new address has been created with 'Ashley Tester' label name

  Scenario: TC-900439 [Saved Addresses] Cancel New Address
    Given  User navigates to 'https://mfe-customer.dev.ashleyretail.com/dashboard/addresses'
    And User clicks on 'add a new address' button
    Then User fills up address info with below credentials
      | address-label | Automation       |
      | first-name    | TestName         |
      | last-name     | TestLastName     |
      | address-1     | 100 Ashley Drive |
      | address-2     | 120              |
      | city          | Tampa            |
      | zip-code      | 33510            |
    And User chooses state as 'FL' from dropdown
    And User verifies presence of 'cancel' button and clicks on it
    Then User verifies cancelled address entry does not show up with label 'Automation'


