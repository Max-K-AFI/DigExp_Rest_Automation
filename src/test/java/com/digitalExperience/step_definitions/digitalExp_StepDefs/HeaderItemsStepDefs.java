package com.digitalExperience.step_definitions.digitalExp_StepDefs;

import com.digitalExperience.pages.digitalExp_pages.HomePage;
import com.digitalExperience.utilities.BrowserUtils;
import com.digitalExperience.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class HeaderItemsStepDefs {

    HomePage homePage = new HomePage();
    String platform = ConfigurationReader.getProperty("platform");
    Integer storeLocatorXCord;
    Integer leftHeaderGridXCord;

    @When("User verifies store-locator located on top of header and right side of header grid")
    public void verifyLocationOfTheTopHeaderItem() {
        if (platform.equals("desktop")) {
            storeLocatorXCord = homePage.storeLocator.getRect().getX();
            leftHeaderGridXCord = homePage.topLeftHeaderGrid.getRect().getX();
            Assert.assertTrue(storeLocatorXCord > leftHeaderGridXCord);
        } else {
            System.out.println("Functionality available on DESKTOP viewport only!");
        }
    }

    @When("User verifies Top Level Categories for visual navigation in below order")
    public void verifyTopLevelCategories(List<String> topLevelCategory) {
        if (platform.equals("desktop")) {
            for (WebElement eachElem : homePage.topLevelCategoriesOnLeft) {
                for (String eachCategory : topLevelCategory) {
                    if (eachElem.getText().trim().equalsIgnoreCase(eachCategory)) {
                        Assert.assertEquals(eachElem.getText().trim(), eachCategory);
                    }
                }
            }
        } else {
            System.out.println("Testable on DESKTOP viewport only!!!");
        }
    }

    @When("User verifies {string} is located at same grid line and on right side of {string}")
    public void verifyIfItemLocatedAtSameGridLine(String mainText, String comparedText) {
        if (platform.equals("desktop")) {
            int textXCord = 0;
            int comparedTextXCord = 0;
            for (WebElement eachElem : homePage.topLevelContainer) {
                if (eachElem.getText().trim().equalsIgnoreCase(mainText)) {
                    Assert.assertEquals(mainText, eachElem.getText().trim());
                }
                break;
            }
            for (WebElement topRightGridItem : homePage.topLevelContainer) {
                if (topRightGridItem.getText().trim().equals(mainText)) {
                    textXCord = topRightGridItem.getRect().getY();
                } else if (topRightGridItem.getText().trim().equals(comparedText)) {
                    comparedTextXCord = topRightGridItem.getRect().getY();
                }
            }
            Assert.assertEquals(comparedTextXCord, textXCord);
        } else {
            System.out.println("Testable on DESKTOP viewport only!!!");
        }
    }

    @When("If platform is mobile or tablet user clicks on hamburger menu")
    public void ifPlatformIsMobileOrTabletUserClicksOnHamburgerMenu() {
        if (platform.equals("tablet") || platform.equals("mobile")) {
            BrowserUtils.waitForClickAbility(homePage.tabletMenu, Duration.ofSeconds(3)).click();
        }
    }

    @And("User clicks Store Locator link within header")
    public void userClicksStoreLocatorLinkWithinHeader() {
        if (platform.equals("desktop")) {
            homePage.storeLocator.click();
        } else {
            BrowserUtils.waitForClickAbility(homePage.storeLocatorMobile, Duration.ofSeconds(3)).click();
        }
    }

    @Then("User verifies 'search bar', 'update button', 'closest to' and 'no-store-found' fields availability in popup")
    public void userVerifiesDataEntryFieldsAvailabilityInPopup() {
        Assert.assertTrue(homePage.locatorSearchBar.isEnabled());
        Assert.assertTrue(homePage.locatorUpdateSearchBtn.isEnabled());
        Assert.assertTrue(homePage.locatorClosestZipCode.isEnabled());
        Assert.assertTrue(homePage.locatorNoStoreFound.isEnabled());

    }
}