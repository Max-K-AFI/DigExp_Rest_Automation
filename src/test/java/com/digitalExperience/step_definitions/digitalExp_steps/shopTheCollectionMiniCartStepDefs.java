package com.digitalExperience.step_definitions.digitalExp_steps;

import com.digitalExperience.pages.digitalExpUI_pages.ProductDetailPage;
import com.digitalExperience.utilities.BrowserUtils;
import com.digitalExperience.utilities.ConfigurationReader;
import com.digitalExperience.utilities.Driver;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class shopTheCollectionMiniCartStepDefs {
    WebDriver driver = Driver.getDriver();
    ProductDetailPage productDetailPage = new ProductDetailPage();

    @Then("User Clicks plus button for {string} in shop the collection")
    public void userClicksPlusButtonForInShopTheCollection(String sku) {
        if (ConfigurationReader.getProperty("platform").equals("tablet") || ConfigurationReader.getProperty("platform").equals("desktop")) {
            driver.findElement(By.cssSelector("div[data-itemid='" + sku + "']  [class='plus']")).click();
        } else if (ConfigurationReader.getProperty("platform").equals("mobile")) {
            BrowserUtils.scrollToElement(driver.findElement(By.xpath("//div[@class='bundle-cards']")));
            driver.findElement(By.cssSelector("div[data-itemid='" + sku + "']  [class='plus']")).click();
        }
    }

    @Then("User clicks on Add Item to Cart PDP scroll")
    public void userClicksOnAddItemToCartPdpScroll() {
        if (ConfigurationReader.getProperty("platform").equals("tablet") || ConfigurationReader.getProperty("platform").equals("desktop"))  {
            BrowserUtils.clickWithJS(productDetailPage.addToCartLarge);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }  else if (productDetailPage.addToCartSmall.isDisplayed()) {
            BrowserUtils.scrollToElement(productDetailPage.addToCartSmall);
            productDetailPage.addToCartSmall.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
    }

    @Then("User Clicks Add to Cart in Shop the Collection for {string}")
    public void userClicksAddToCartInShopTheCollectionFor(String sku) {
        if (ConfigurationReader.getProperty("platform").equals("tablet") || ConfigurationReader.getProperty("platform").equals("desktop")) {
            BrowserUtils.clickWithJS(driver.findElement(By.xpath("//label[@for='bundle-anchor-atc-" + sku + "']")));

//            BrowserUtils.scrollToElement(productDetailPage.addtocart);
        }
        if (ConfigurationReader.getProperty("platform").equals("mobile")) {
            BrowserUtils.scrollToElement(productDetailPage.shopTheCollectionBundledCards);
            driver.findElement(By.xpath("//label[@for='bundle-anchor-atc-" + sku + "']")).click();
            BrowserUtils.scrollToElement(productDetailPage.addToCartSmall);
        }
    }
}
