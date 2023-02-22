#@regression
Feature: Stages stability verification
  Verify if apollo URLS are up and running

  @smoke
  Scenario Outline: verify all apollo stages up and running
    When User navigates to "<URL>"
    When User scrolls down to footer
    Then User scrolls to header
    Examples:
      | URL                                         |
      | https://mfe-content.dev.ashleyretail.com/   |
      | https://mfe-content.stage.ashleyretail.com/ |

