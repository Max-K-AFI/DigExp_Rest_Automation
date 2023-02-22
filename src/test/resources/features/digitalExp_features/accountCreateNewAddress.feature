@smoke_sfcc
Feature: Verification of address in account tab

  Background:
    Given User opens expected 'URL'

  Scenario: User adds new address to existing account in account tab
    And   User clicks on login link on different viewports
    When  User logs in with "username" and "password"
    And   User clicks on "addressbook" in account
    And   User creates new address in account tab
    And   User inputs generated new address data into fields
    And   User enters personal information into create new address tab
    And   User deletes saved address

  Scenario: User logins into account and verifies address, email, phone number for registered user
    And   User clicks on login link on different viewports
    When  User logs in with "username" and "password"
    Then  User asserts user name on account page reflects "Jaime Guitron"
    Then  User asserts email-address on account page reflects "jguitron@ashleyfurniture.com"
    Then  User asserts phone number on account page reflects "887-766-5547"


