package com.digitalExperience.step_definitions.digitalExp_steps;

import com.digitalExperience.pages.digitalExpUI_pages.HomePage;
import com.digitalExperience.utilities.BrowserUtils;
import io.cucumber.java.en.Then;

public class StagesStabilityStepDefs {

    HomePage homePage = new HomePage();

    @Then("User scrolls to header")
    public void scrollToHeader() {
        BrowserUtils.scrollToElement(homePage.header);
        BrowserUtils.waitForPageToLoad(3);
    }
}
