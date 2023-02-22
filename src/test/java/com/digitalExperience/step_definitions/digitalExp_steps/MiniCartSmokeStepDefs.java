package com.digitalExperience.step_definitions.digitalExp_steps;

import com.digitalExperience.pages.digitalExpUI_pages.CartPage;
import com.digitalExperience.pages.digitalExpUI_pages.HomeSmokePage;
import com.digitalExperience.pages.digitalExpUI_pages.ProductDetailPage;
import com.digitalExperience.utilities.BrowserUtils;
import com.digitalExperience.utilities.ConfigurationReader;
import com.digitalExperience.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class MiniCartSmokeStepDefs {
    WebDriver driver = Driver.getDriver();
    CartPage cartPage = new CartPage();
    ProductDetailPage productDetailPage = new ProductDetailPage();
    HomeSmokePage homeSmokePage = new HomeSmokePage();

    @Then("User Removes item from mini cart")
    public void userRemovesItemFromMiniCart() {
        BrowserUtils.hover(homeSmokePage.cartIconDeskTopNew);
        BrowserUtils.clickWithJS(cartPage.removeItemMiniCart);
        BrowserUtils.clickWithJS(cartPage.removeItem_YesBtn);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }

    @Then("User clicks on save for later mini cart")
    public void userClicksOnSaveForLaterMiniCart() {
        if (ConfigurationReader.getProperty("platform").equals("desktop") || ConfigurationReader.getProperty("platform").equals("tablet")) {
            cartPage.saveItem.isDisplayed();
            BrowserUtils.clickWithJS(cartPage.saveItem);
//            cartPage.saveItem.click();
        }
    }

    @Then("User asserts items in mini cart is {string} qty")
    public void userAssertsItemsInMiniCartIsQty(String Item) {
        if (ConfigurationReader.getProperty("platform").equals("desktop") || ConfigurationReader.getProperty("platform").equals("tablet")) {
            BrowserUtils.sleep(5);
            BrowserUtils.waitForVisibility(homeSmokePage.miniCartQty, Duration.ofSeconds(4));
            String CartQty = homeSmokePage.miniCartQty.getText();
            Assert.assertEquals(Item, CartQty);
        }
    }

    @Then("User asserts {string} saved items in cart with {string} mobile skip")
    public void userAssertsSavedItemsInCartWithMobileSkip(String SavedItem, String assertSaved) {
        if (ConfigurationReader.getProperty("platform").equals("desktop") || ConfigurationReader.getProperty("platform").equals("tablet")) {
            BrowserUtils.waitForPageToLoad(4);
            String savedItem = driver.findElement(By.xpath("//h2 /*[contains(@href,'" + assertSaved + "')]")).getText();
            Assert.assertTrue(SavedItem.contains(savedItem));
        }
    }
}
