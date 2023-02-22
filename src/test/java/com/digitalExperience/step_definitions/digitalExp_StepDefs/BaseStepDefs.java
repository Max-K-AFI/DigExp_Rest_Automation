package com.digitalExperience.step_definitions.digitalExp_StepDefs;

import com.digitalExperience.pages.digitalExp_pages.HomePage;
import com.digitalExperience.utilities.ConfigurationReader;
import com.digitalExperience.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class BaseStepDefs {

    WebDriver driver = Driver.getDriver();
    HomePage homePage = new HomePage();
    String url;

    @Given("User navigates to {string}")
    public void UserNavigatesTo(String url) {
        if (url.equals("homePageUrl")) {
            this.url = System.getProperty("homePageUrl", ConfigurationReader.getProperty("homePageUrl"));
            driver.get(this.url);
        } else {
            driver.get(url);
        }
    }

    @When("User clicks on {string} link")
    public void clickOnLink(String element) {
        homePage.clickOn_A_Link(element);
    }
}
