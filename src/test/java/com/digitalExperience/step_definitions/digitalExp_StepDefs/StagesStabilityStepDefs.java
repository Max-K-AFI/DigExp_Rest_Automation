package com.digitalExperience.step_definitions.digitalExp_StepDefs;

import com.digitalExperience.pages.digitalExp_pages.HomePage;
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
