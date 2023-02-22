package com.digitalExperience.step_definitions.digitalExp_steps;

import com.digitalExperience.pages.digitalExpUI_pages.HomePage;
import com.digitalExperience.utilities.Driver;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BrokenLinksStepDefs {

    HomePage homePage = new HomePage();

    @Then("User verifies each link on page")
    public void verifyEachLinkOnPage() {
        List<WebElement> allLinks = Driver.getDriver().findElements(By.tagName("a"));
        System.out.println("Number of links: " + allLinks.size());
        for (WebElement temp : allLinks) {
            String validUrl = temp.getAttribute("href");
            homePage.verifyBrokenLinks(validUrl);
        }
    }
}
