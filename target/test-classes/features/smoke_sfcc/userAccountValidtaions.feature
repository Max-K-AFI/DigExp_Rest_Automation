@smoke_sfcc
Feature: User account verifications

  Background:
    Given User opens expected 'URL'

  Scenario: Login verification with an existing user credentials
    And User clicks on login link on different views
    When User logs in with "username" and "password" smoke
    Then User should be able to see user dashboard
    Then Assert user is logged in via name displays in header

#  New user signup/create new account
  Scenario: Validation of creation new user account.
    When  User clicks on login button
    Then  User then clicks on Login link
    And   User clicks Create account link
    Then  User enters personal information
    Then User confirms age
    And  User clicks on Submit button if the Environment is non-production

#  User Verifies Address Functionality for Registered User
  Scenario: User edits address in account page and creates new address
    And   User clicks on login link on different viewports
    When  User logs in with "username" and "password"
    And   User clicks on "addressbook" in account
    Then  User clicks on "edit" button in saved address
    And   User edits First Name and Last Name in edit address to "paige", "lafon"
    And   User asserts field change in address tab
    And   User makes edited address to "make-default"
    And   User asserts created address is now primary address







