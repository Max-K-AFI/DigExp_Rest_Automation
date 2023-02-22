@smoke_sfcc
Feature: Verification of search field shows searched item suggestions

  Scenario: User types in sofa in search bar and verifies suggestions return
    Given User opens expected 'URL'
    Then  User types "Table" in search bar
    Then  User asserts in search bar for search suggestions returns top results for "Table"