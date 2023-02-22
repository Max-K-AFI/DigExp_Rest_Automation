#@regression
Feature: Login verification

  @smoke
  Scenario: Login functionality verification
    Given User navigates to "https://www.ashleyfurniture.com/"
    And User clicks on login link on different viewports
    When User logs in with "username" and "password"
    Then User should see user dashboard







