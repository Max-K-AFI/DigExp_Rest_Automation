package com.digitalExperience.step_definitions.digitalExp_steps;

import com.digitalExperience.pages.digitalExpUI_pages.CartPage;
import com.digitalExperience.pages.digitalExpUI_pages.HomeSmokePage;
import com.digitalExperience.utilities.BrowserUtils;
import com.digitalExperience.utilities.ConfigurationReader;
import com.digitalExperience.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePageSmokeStepDefs {

    WebDriver driver = Driver.getDriver();
    String platform = ConfigurationReader.getProperty("platform");
    HomeSmokePage homeSmokePage = new HomeSmokePage();
    CartPage cartPage = new CartPage();

    @When("User gets each available link from main page")
    public void getAllUrls() {
        if (platform.equals("desktop")) {
            List<String> totalLinks = new ArrayList<>();
            List<WebElement> linkElements = homeSmokePage.allLinks;
            for (WebElement eachLink : linkElements) {
                totalLinks.add(eachLink.getText());
            }
            System.out.println("Total links available on the page: " + totalLinks.size() + "!");
        } else {
            homeSmokePage.hamburgerBox.click();
            List<String> totalLinks = new ArrayList<>();
            List<WebElement> linkElements = homeSmokePage.allLinks;
            for (WebElement eachLink : linkElements) {
                totalLinks.add(eachLink.getText());
            }
            System.out.println("Total links available on the page: " + totalLinks.size() + "!");
        }
    }

    @When("User hovers over each contentType items")
    public void hoverOnEachContentType() {
        int num = 3;
        while (num <= 15) {
            num++;
            WebElement temp = Driver.getDriver().findElement(By.xpath("(//li[@data-container-level])[" + num + "]"));
            BrowserUtils.waitForClickAbility(temp, Duration.ofSeconds(10));
            BrowserUtils.hover(temp);
            BrowserUtils.sleep(1);
        }
    }

    @When("User clicks on the {string} Menu link")
    public void clickOnLink(String furniture) {
        homeSmokePage.furniture.click();
        homeSmokePage.furniture.getText();
        if (platform.equals("desktop")){
            Assert.assertTrue(driver.getCurrentUrl().endsWith(furniture + "/"));}
        else{
             Assert.assertEquals("Furniture",driver.findElement(By.xpath("//div[@class='submenu-header mobile header']/a[@data-cgid='furniture']")).getText());
             Assert.assertEquals("Browse All",driver.findElement(By.xpath("//div/a[@href=\"https://staging.ashleyfurniture.com/c/furniture/\"]")).getText());
        }

    }

    @Then("User clicks on cart icon")
    public void userClicksOnCartIcon() {
        BrowserUtils.sleep(3);
        BrowserUtils.waitForClickAbility(homeSmokePage.cartIconDeskTopNew, Duration.ofSeconds(3));
        BrowserUtils.clickWithJS(homeSmokePage.cartIconDeskTopNew);
    }

    @Then("User hovers on mini cart icon")
    public void userHoversOnMiniCartIcon() {
        BrowserUtils.waitForPageToLoad(5);
        BrowserUtils.hover(homeSmokePage.cartIconDeskTopNew);
    }

    @Then("User asserts in search bar for search suggestions returns top results for {string}")
    public void userAssertsInSearchBarForSearchSuggestionsReturnsTopResultsFor(String Item) {
        String searchResults = homeSmokePage.searchSugesstions.getText();
        Assert.assertTrue(searchResults.contains(Item));
    }

    @When("User clicks on {string} in account tab")
    public void userClicksOnInAccountTab(String tabbedPage) {
        String url = System.getProperty("url", ConfigurationReader.getProperty("url"));
        if (ConfigurationReader.getProperty("platform").equals("desktop")) {
            homeSmokePage.userNameDisplayed.click();
            driver.findElement(By.xpath("//a[@href='" + url + tabbedPage + "/']")).click();
            BrowserUtils.waitForPageToLoad(2);
        } else if (ConfigurationReader.getProperty("platform").equals("mobile") || ConfigurationReader.getProperty("platform").equals("tablet")) {
            homeSmokePage.hamburgerBox.click();
            homeSmokePage.accountTabMobileView.click();
            homeSmokePage.accountTabOpenMobileView.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            homeSmokePage.accountWishListMobile.click();
        }
    }

    @Then("User verifies that {string} in Wish List is clickable with url text {string}")
    public void userVerifiesThatInWishListIsClickableWithUrlText(String itemName, String urlName) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        String wishListItem = driver.findElement(By.xpath("//div /h2 /*[contains(@href, '" + urlName + "')]")).getAttribute("href");
        driver.findElement(By.xpath("//img[@alt='" + itemName + "']")).click();
        String Url = driver.getCurrentUrl();
        Assert.assertTrue(Url.contains(wishListItem));
    }

    @Then("User verify view details button for {string} in Wish list")
    public void userVerifyViewDetailsButtonForInWishList(String itemSaved) {
        String wishListViewDetails = driver.findElement(By.xpath("// h2 /*[contains(@title, 'Darcy Sofa')]")).getAttribute("href");
        driver.findElement(By.xpath("//h2 /a[@title='" + itemSaved + "']")).click();
        String Url = driver.getCurrentUrl();
        Assert.assertTrue(Url.contains(wishListViewDetails));
    }

    @Then("User clicks on remove button in Wish List for {string}")
    public void userClicksOnRemoveButtonInWishListFor(String removedItem) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//button[@aria-label='Remove " + removedItem + "']")).click();
    }

    @Then("User Asserts {string} is not in wishlist")
    public void userAssertsIsNotInWishlist(String AssertItemRemoved) {
        List<WebElement> items = driver.findElements(By.xpath("//div /h2 /*[contains(@href, '" + AssertItemRemoved + "')]"));
        Assert.assertTrue(items.isEmpty());
    }

    @When("User clicks on {string} in account")
    public void userClicksOnInAccount(String savedAddressTab) {
        BrowserUtils.clickWithJS(driver.findElement(By.xpath("//a[@href='/" + savedAddressTab + "/']")));
    }

    @Then("User clicks on {string} button in saved address")
    public void userClicksOnButtonInSavedAddress(String field) {
        BrowserUtils.clickWithJS(driver.findElement(By.xpath("//li[@class='address-tile  ']  /a[@class='address-" + field + "']")));
    }

    @Then("User edits First Name and Last Name in edit address to {string}, {string}")
    public void userEditsFirstNameAndLastNameInEditAddressTo(String firstName, String lastName) {
        driver.findElement(By.xpath("//input[@name='dwfrm_profile_address_firstname']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@class='input-text last-name-valid  required']")).sendKeys(lastName);
    }

    @Then("User asserts field change in address tab")
    public void userAssertsFieldChangeInAddressTab() {

    }

    @Then("User makes edited address to {string}")
    public void userMakesEditedAddressTo(String string) {

    }

    @Then("User asserts created address is now primary address")
    public void userAssertsCreatedAddressIsNowPrimaryAddress() {

    }

    @When("User creates new address in account tab")
    public void userCreatesNewAddressInAccountTab() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        BrowserUtils.waitForClickAbility(homeSmokePage.createAddressButton, Duration.ofSeconds(5));
        BrowserUtils.clickWithJS(homeSmokePage.createAddressButton);
    }
}