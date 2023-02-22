package com.digitalExperience.step_definitions.digitalExp_steps;

import com.digitalExperience.pages.digitalExpUI_pages.HomeSmokePage;
import com.digitalExperience.utilities.ConfigurationReader;
import com.digitalExperience.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class HeaderSmokeStepDefs {

    WebDriver driver = Driver.getDriver();
    HomeSmokePage homeSmokePage = new HomeSmokePage();
    BaseSmokeStepDefs baseSmokeStepDefs = new BaseSmokeStepDefs();
    String platform = ConfigurationReader.getProperty("platform");

    @Then("Assert user is logged in via name displays in header")
    public void assertUserIsLoggedInViaNameDisplaysInHeader() {
        if (platform.equals("desktop")) {
            String account = homeSmokePage.userNameDisplayed.getText();
            System.out.println(account);
            String expectedName = "Hi, Jaime";
            Assert.assertEquals(expectedName, account);
        } else {
            System.out.println("Does not apply to tablet and Mobile");
        }
    }

    @Then("Assert total number of items in mini cart is {int}")
    public void assertTotalNumberOfItemsInMiniCartIs(int expectedCartQty) {
        baseSmokeStepDefs.CartPageSize(expectedCartQty);
    }
}
