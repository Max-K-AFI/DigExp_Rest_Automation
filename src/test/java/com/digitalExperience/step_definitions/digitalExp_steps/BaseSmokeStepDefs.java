package com.digitalExperience.step_definitions.digitalExp_steps;

import com.digitalExperience.pages.digitalExpUI_pages.BaseSmokePage;
import com.digitalExperience.pages.digitalExpUI_pages.HomeSmokePage;
import com.digitalExperience.pages.digitalExpUI_pages.ProductDetailPage;
import com.digitalExperience.pages.digitalExpUI_pages.SearchPage;
import com.digitalExperience.utilities.BrowserUtils;
import com.digitalExperience.utilities.ConfigurationReader;
import com.digitalExperience.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;

public class BaseSmokeStepDefs {

    static WebDriver driver = Driver.getDriver();
    BaseSmokePage baseSmokePage = new BaseSmokePage();
    SearchPage searchPage = new SearchPage();
    HomeSmokePage homeSmokePage = new HomeSmokePage();
    ProductDetailPage productDetailPage = new ProductDetailPage();
    String mainWindowHandle;
    String platform = ConfigurationReader.getProperty("platform");

    @When("User finds closest store by {string}")
    public void findClosestStore(String zipcode) {
        if (platform.equals("desktop")) {
            BrowserUtils.waitForPageToLoad(10);
            baseSmokePage.chooseLocalStore.click();
            baseSmokePage.zipCodeBox.sendKeys(zipcode);
            baseSmokePage.zipCodeUpdate.click();
        } else if (platform.equals("mobile") || (platform.equals("tablet"))) {
            homeSmokePage.mobileMenu.click();
            baseSmokePage.mobStoreLink.click();
            baseSmokePage.zipCodeBox.sendKeys(zipcode + Keys.ENTER);
        }
    }

    @When("User searches for SKU {string}")
    public void searchAnItem(String item) {
        WebElement searchBar;
        String currentUrl;
        if (platform.equals("desktop")) {
            if (!baseSmokePage.searchBarLarge.isDisplayed()) {
                driver.navigate().refresh();
            }
            BrowserUtils.waitForVisibility(baseSmokePage.searchBarLarge, Duration.ofSeconds(20));
            baseSmokePage.searchBarLarge.sendKeys(item + Keys.ENTER);
        } else {
            if (!baseSmokePage.searchBarSmall.isDisplayed()) {
                driver.navigate().refresh();
            }
            BrowserUtils.waitForVisibility(baseSmokePage.searchBarSmall, Duration.ofSeconds(10));
            searchBar = baseSmokePage.searchBarSmall;
        }
//        searchBar.sendKeys(item + Keys.ENTER);
        currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(item));
    }

    @When("User search for a SKU {string} and clicks on item 1 in result set")
    public void searchItemResult(String Item) {
        WebElement searchBar;
        searchBar = BrowserUtils.waitForVisibility(baseSmokePage.searchBarLarge, Duration.ofSeconds(5));
        searchBar.sendKeys(Item);
        baseSmokePage.searchBarResultOne.click();
    }

    @When("User navigates to cart page")
    public void clickOnMiniCart() {
        WebElement cart = BrowserUtils.waitForVisibility(baseSmokePage.miniCartIcon, Duration.ofSeconds(5));
        cart.click();
    }

    @Then("User removes Protection Plan")
    public void userRemovesProtectionPlan() {
    driver.findElement(By.cssSelector("label[class='add-pp']")).click();
    }

    @When("User navigate back to cart page")
    public void clickOnBackToCart() {
        WebElement backToCart = BrowserUtils.waitForVisibility(baseSmokePage.backToCartIcon, Duration.ofSeconds(5));
        backToCart.click();
    }

    @When("User closes Caddipay window by clicking on X")
    public void closeCaddipayWindow() {
        WebElement closeCaddiPay = baseSmokePage.closeCaddipayX;
        closeCaddiPay.click();
        BrowserUtils.sleep(2);
    }

    @Then("User clicks search icon")
    public void clickOnSearchIcon() {
        searchPage.searchIcon.click();
    }

    @Then("User clicks on Heart Icon in plp")
    public void clickOnHeartIconInPLP() {
        BrowserUtils.hover(productDetailPage.addToWishList);
        productDetailPage.addToWishList.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public void CartPageSize(int expectedNum) {
        int actualCartQty = Integer.parseInt(baseSmokePage.miniCartValue.getText());
        Assert.assertEquals(expectedNum, actualCartQty);
    }
}