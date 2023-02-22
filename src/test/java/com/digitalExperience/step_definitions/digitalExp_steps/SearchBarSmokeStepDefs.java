package com.digitalExperience.step_definitions.digitalExp_steps;

import com.digitalExperience.pages.digitalExpUI_pages.SearchPage;
import com.digitalExperience.utilities.BrowserUtils;
import com.digitalExperience.utilities.ConfigurationReader;
import com.digitalExperience.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class SearchBarSmokeStepDefs {

    WebDriver driver = Driver.getDriver();
    SearchPage search = new SearchPage();
    SearchPage searchPage = new SearchPage();
    String platform = ConfigurationReader.getProperty("platform");

    @Then("User sends {string} in search bar")
    public void sendValue(String searchValue) {
        search.searchBar.sendKeys(searchValue);
        search.searchIcon.click();
    }

    @Given("User clicks on search icon")
    public void clickOnSearchIcon() {
        BrowserUtils.waitForClickAbility(search.searchIcon, Duration.ofSeconds(5)).click();
    }

    @When("User should see url ending with {string}")
    public void verifyUrlEndpoint(String expectedHeader) {
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedHeader));
    }

    @Then("User should see total amount is more than 0")
    public void verifyTotalCount() {
        Assert.assertTrue(search.productCount.getText().length() > 0);
        String totalItemsFound = search.productCount.getText().substring(10, 14);
        System.out.println("Total items found: " + totalItemsFound);
    }

    @When("User search's {string} in search bar")
    public void userSearchesInSearchBar(String item) {
        if (platform.equals("desktop")) {
            BrowserUtils.waitForClickAbility(searchPage.searchBar, Duration.ofSeconds(10));
            searchPage.searchBar.sendKeys(item + Keys.ENTER);
        } else {
            BrowserUtils.waitForClickAbility(searchPage.searchBarMob, Duration.ofSeconds(10));
            searchPage.searchBarMob.sendKeys(item + Keys.ENTER);
        }
    }

    @Then("User types {string} in search bar")
    public void userTypesInSearchBar(String searched) {
        if (platform.equals("desktop")) {
            searchPage.searchBar.click();
            searchPage.searchBar.sendKeys(searched);
        } else {
            searchPage.searchBarMob.click();
            searchPage.searchBarMob.sendKeys(searched);
        }
    }
}
