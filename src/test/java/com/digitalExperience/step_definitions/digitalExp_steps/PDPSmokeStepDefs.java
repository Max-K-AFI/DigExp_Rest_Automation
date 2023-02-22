package com.digitalExperience.step_definitions.digitalExp_steps;

import com.digitalExperience.pages.digitalExpUI_pages.HomeSmokePage;
import com.digitalExperience.pages.digitalExpUI_pages.ProductDetailPage;
import com.digitalExperience.pages.digitalExpUI_pages.ProductListPage;
import com.digitalExperience.utilities.BrowserUtils;
import com.digitalExperience.utilities.ConfigurationReader;
import com.digitalExperience.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import java.util.List;

public class PDPSmokeStepDefs {
    ProductDetailPage productDetailPage = new ProductDetailPage();
    ProductListPage listPage = new ProductListPage();
    WebDriver driver = Driver.getDriver();
    String platform = ConfigurationReader.getProperty("platform");
    HomeSmokePage homePage = new HomeSmokePage();

    @When("User Select King bed size")
    public void selectBedSize() {
        BrowserUtils.clickWithJS(productDetailPage.iconkingsize);
        BrowserUtils.sleep(3);
    }

    @When("User verifies that FPP available on PDP")
    public void userVerifiesFPPAvailableInPDP() {
        BrowserUtils.scrollToElement(productDetailPage.pdp_FURNPRO);
        if (platform.equals("desktop")) {
            Assert.assertEquals("5 Year Furniture Protection Plan (add plan in cart)", productDetailPage.pdp_FURNPRO.getText());
        } else if (platform.equals("mobile") || (platform.equals("tablet"))) {
            Assert.assertEquals("5 Year Furniture Protection Plan", productDetailPage.pdp_FURNPRO.getText());
        }
    }

    @When("User verifies that OUTDoorPP available on PDP")
    public void userVerifiesOutPPAvailableInPDP() {
        BrowserUtils.scrollToElement(productDetailPage.pdp_OUTDRF);
        if (platform.equals("desktop")) {
            Assert.assertEquals("5 Year Outdoor Protection Plan (add plan in cart)", productDetailPage.pdp_OUTDRF.getText());
        } else if (platform.equals("mobile") || (platform.equals("tablet"))) {
            Assert.assertEquals("5 Year Outdoor Protection Plan", productDetailPage.pdp_OUTDRF.getText());
        }
    }

    @When("User verifies that Adjustable PP available on PDP")
    public void userVerifiesAdjstPPAvailableInPDP() {
        BrowserUtils.scrollToElement(productDetailPage.pp_ADJPRO);
        if (platform.equals("desktop")) {
            Assert.assertEquals("10 Year Adjustable Base Protection Plan (add plan in cart)", productDetailPage.pp_ADJPRO.getText());
        } else if (platform.equals("mobile") || (platform.equals("tablet"))) {
            Assert.assertEquals("10 Year Adjustable Base Protection Plan", productDetailPage.pp_ADJPRO.getText());
        }
    }

    @When("User verifies that KingAdjustable available on PDP")
    public void userVerifiesKAdjustPPAvailableInPDP() {
        BrowserUtils.scrollToElement(productDetailPage.ppLableContainer);
        if (platform.equals("desktop")) {
            Assert.assertEquals("10 Year Adjustable Base Protection Plan (add plan in cart)", productDetailPage.pp_KADJPRO.getText());
        } else if (platform.equals("mobile") || (platform.equals("tablet"))) {
            Assert.assertEquals("10 Year Adjustable Base Protection Plan", productDetailPage.pp_KADJPRO.getText());
        }
    }

    @When("User clicks on Add Item to Cart")
    public void clickOnAddItemToCart() {
        if (platform.equals("desktop")) {
            WebElement addToCart = BrowserUtils.waitForClickAbility(productDetailPage.addToCartLarge, Duration.ofSeconds(5));
            BrowserUtils.scrollToElement(addToCart);
            addToCart.click();
            BrowserUtils.sleep(2);
            int cartSize = Integer.parseInt(driver.findElement(By.cssSelector("span[class='minicart-quantity']")).getText());
            Assert.assertTrue(cartSize > 0);
        } else if (productDetailPage.addToCartSmall.isDisplayed()) {
            BrowserUtils.scrollToElement(productDetailPage.addToCartSmall);
            productDetailPage.addToCartSmall.click();
            BrowserUtils.sleep(2);
            productDetailPage.contShoppingBtnAddItmPopUp.click();
        }
    }

    @Then("User clicks on Add Item to Cart tablet and desktop skip")
    public void userClicksOnAddItemToCartTabletAndDesktopSkip() {
        if (ConfigurationReader.getProperty("platform").equals("mobile")) {
            BrowserUtils.scrollToElement(productDetailPage.addToCartSmall);
            productDetailPage.addToCartSmall.click();
        }
    }

    @Then("User clicks on Add Item to Cart mobile skip")
    public void userClicksOnAddItemToCartMobileSkip() {
        if (ConfigurationReader.getProperty("platform").equals("desktop") || ConfigurationReader.getProperty("platform").equals("tablet")) {
            BrowserUtils.scrollToElement(productDetailPage.addToCartLarge);
            productDetailPage.addToCartLarge.isDisplayed();
            BrowserUtils.clickWithJS(productDetailPage.addToCartLarge);
        }
    }

    @Then("User asserts items in popup is {string} qty or item")
    public void userAssertsItemsInPopupIsQtyItem(String inputAssert) {
        if (ConfigurationReader.getProperty("platform").equals("mobile")) {
            String ItemName = driver.findElement(By.xpath("(//a[@title='Go to Product: " + inputAssert + "'])[3]")).getText();
            Assert.assertEquals(inputAssert, ItemName);
        }
    }

    @Then("User change qty from {int} to {int} in PDP")
    public void userChangeQtyFromToInPdp(Integer qty1, Integer qty2) {
        productDetailPage.pdpQTYIncrease.click();
    }

    @Then("User change qty from {int} to {int} in PDP tablet and desktop skip")
    public void userChangeQtyFromToInPdpTabletAndDesktopSkip(Integer int1, Integer int2) {
        if (ConfigurationReader.getProperty("platform").equals("mobile")) {
            productDetailPage.pdpQTYIncrease.click();
        }
    }

    @When("User asserts {string} bed size displayed on PDP")
    public void userAssertsBedSizeDisplayedOnPdp(String mattressSize) {
        if (ConfigurationReader.getProperty("platform").equals("desktop") || ConfigurationReader.getProperty("platform").equals("tablet")) {
            String mattressSelected = driver.findElement(By.xpath("//li[@class='selectable selected'] /a[@class='swatchanchor " + mattressSize + "']")).getText();
            String mattressOnPage = driver.findElement(By.cssSelector("h1[itemprop]")).getText();
            Assert.assertTrue(mattressOnPage.contains(mattressSelected));
        } else if (ConfigurationReader.getProperty("platform").equals("mobile")) {
            JavascriptExecutor Js1 = (JavascriptExecutor) driver;
            Js1.executeScript("window.scrollBy(0,700)");
            String mattressSelected = driver.findElement(By.xpath("//li /a[@class='swatchanchor " + mattressSize + "']")).getText();
            Assert.assertTrue(mattressSelected.toUpperCase().contains(mattressSize.toUpperCase()));
        }
    }

    @Then("User changes bed size in PDP to ones not currently displayed mattress and asserts change")
    public void userChangesBedSizeInPdpToOnesNotCurrentlyDisplayedMattressAndAssertsChange(List<String> size) {
        for (String eachSize : size) {
            BrowserUtils.clickWithJS(driver.findElement(By.xpath("//li /a[@class='swatchanchor " + eachSize + "']")));
            BrowserUtils.sleep(2);
            String mattressOnPage = driver.findElement(By.cssSelector("h1[itemprop]")).getText();
            Assert.assertTrue(mattressOnPage.toUpperCase().contains(eachSize.toUpperCase()));
        }
    }

    @When("User asserts {string} color displayed on PDP")
    public void userAssertsColorDisplayedOnPdp(String color) {
        if (ConfigurationReader.getProperty("platform").equals("desktop") || ConfigurationReader.getProperty("platform").equals("tablet")) {
            String colorSelected = driver.findElement(By.xpath("//li[@class='selectable selected'] /a[@title='Select Color: " + color + "']")).getText();
            String colorOnPage = driver.findElement(By.xpath("//div[@class='dimension-image']/img[@alt='Darcy Loveseat, " + color + ", large']")).getText();
            Assert.assertTrue(colorOnPage.contains(colorSelected));
        } else if (ConfigurationReader.getProperty("platform").equals("mobile")) {
            JavascriptExecutor Js1 = (JavascriptExecutor) driver;
            Js1.executeScript("window.scrollBy(0,800)");
            String colorSelected = driver.findElement(By.xpath("//li[@class='selectable selected'] /a[@title='Select Color: " + color + "']")).getText();
            String colorOnPage = driver.findElement(By.xpath("(//img[@alt='Darcy Loveseat, " + color + ", large'])[2]")).getText();
            Assert.assertTrue(colorOnPage.contains(colorSelected));
        }
    }

    @Then("User changes color scheme in PDP to ones not currently displayed by colors different colors and asserts change")
    public void userChangesColorSchemeInPdpToOnesNotCurrentlyDisplayedByDifferentColorsAndAssertsChange(List<String> colors) {
        if (ConfigurationReader.getProperty("platform").equals("desktop") || ConfigurationReader.getProperty("platform").equals("tablet")) {
            for (String eachColor : colors) {
                driver.findElement(By.xpath("//ul[@class='swatches clearfix color'] /li /a[@title='Select Color: " + eachColor + "']")).click();
                BrowserUtils.sleep(2);
                JavascriptExecutor Js1 = (JavascriptExecutor) driver;
                Js1.executeScript("window.scrollBy(0,400)");
                BrowserUtils.sleep(2);
                driver.findElement(By.xpath("//button[@class='toggle-attribute-values']")).click();
                BrowserUtils.sleep(2);
                String colorOnPage = driver.findElement(By.xpath("//div[@class='label'] /span[@class='selected-variant']")).getText();
                Assert.assertTrue(colorOnPage.contains(eachColor));
            }
        } else if (ConfigurationReader.getProperty("platform").equals("mobile")) {
            for (String eachColor : colors) {
                driver.findElement(By.xpath("//ul[@class='swatches clearfix color'] /li /a[@title='Select Color: " + eachColor + "']")).click();
                BrowserUtils.sleep(2);
                JavascriptExecutor Js1 = (JavascriptExecutor) driver;
                Js1.executeScript("window.scrollBy(0,700)");
                driver.findElement(By.xpath("//button[@class='toggle-attribute-values']")).click();
                BrowserUtils.sleep(2);
                String colorOnPage = driver.findElement(By.xpath("//div[@class='label'] /span[@class='selected-variant']")).getText();
                String colorSelected = driver.findElement(By.xpath("//li[@class='selectable selected'] /a[@title='Select Color: " + eachColor + "']")).getText();
                Assert.assertTrue(colorOnPage.contains(colorSelected));
            }
        } else {
            System.out.println("Not in display");
        }
    }

    @Then("User verifies visibility of Quick view text and clicks on it")
    public void userClicksOnQuickViewAltImage() {
        BrowserUtils.waitForVisibility(listPage.quickViewTextLink, Duration.ofSeconds(10));
        Assert.assertTrue(listPage.quickViewTextLink.isDisplayed());
        listPage.quickViewTextLink.click();
    }

    @Then("User clicks on right arrow switching between products on QuickView")
    public void userClicksOnArrowsSwitchingBetweenProductsInPlp() {
        if (platform.equals("desktop") || platform.equals("tablet")) {
            String prodOne = listPage.quickViewProdName.getText();
            listPage.quickViewNextIcon.click();
            BrowserUtils.sleep(1);
            String prodTwo = BrowserUtils.waitForVisibility(listPage.quickViewProdName, Duration.ofSeconds(10)).getText();

            Assert.assertNotEquals(prodOne, prodTwo);
        } else {
            System.out.println("Testable in desktop-view only!");
        }
    }

    @Then("User navigates to {string} using next arrow in QuickView")
    public void userNavigatesToUsingNextArrowInQuickView(String expectedProd) {
        String actualProd;
        do {
            BrowserUtils.clickWithJS(listPage.quickViewNextIcon);
            BrowserUtils.sleep(1);
            actualProd = listPage.quickViewProdName.getText();
        }
        while (!expectedProd.equals(actualProd));
        Assert.assertEquals(expectedProd, actualProd);
    }

    @Then("User changes color scheme in quick view and asserts change")
    public void userChangesColorSchemeInQuickViewAndAssertsChangeMobileSkipIncluded(List<String> colors) {
        if (platform.equals("desktop") || platform.equals("tablet")) {
            if (listPage.avlblColorsInQuickView.isDisplayed()) {
                for (String eachColor : colors) {
                    driver.findElement(By.xpath("//ul[@class='swatches clearfix color'] /li /a[@title='Select Color: " + eachColor + "']")).click();
                    BrowserUtils.sleep(1);
                    String chosenColor = driver.findElement(By.xpath("//div[@class='label'] /span[@class='selected-variant']")).getText();
                    Assert.assertTrue(chosenColor.contains(eachColor));
                }
            } else {
                System.out.println("No additional colors available!");
            }
        } else System.out.println("Not in display");
    }


    @Then("User clicks on learn more and closes")
    public void userClicksOnLearnMoreAndCloses() {
        if (platform.equals("desktop")) {
            listPage.learnMoreOpen.click();
            String LearnMorePopUp = listPage.learnMorePopUpDeskTop.getText();
            String PopUpVerify = "Available Delivery Options";
            Assert.assertEquals(LearnMorePopUp, PopUpVerify);
            listPage.learnMoreClose.click();
        } else if (platform.equals("tablet")) {
            listPage.learnMoreOpen.click();
            String LearnMorePopUp = listPage.learnMorePopUp.getText();
            String PopUpVerify = "No-Hassle Delivery + Assembly";
            Assert.assertEquals(LearnMorePopUp, PopUpVerify);
        }
    }

    @Then("User hovers over on first found item's hero image")
    public void userHoversOverOnFirstItemSHeroImage() {
        BrowserUtils.waitForVisibility(listPage.firstFoundItemImage, Duration.ofSeconds(10));
        Assert.assertTrue(listPage.firstFoundItemImage.isDisplayed());
        BrowserUtils.hover(listPage.firstFoundItemImage);
    }

    @Given("User clicks on Heart Icon in pdp")
    public void userClicksOnHeartIconInPdp() {
        if (ConfigurationReader.getProperty("platform").equals("desktop") || ConfigurationReader.getProperty("platform").equals("tablet")) {
            productDetailPage.heartIconPDPDeskTopTablet.click();
        } else if (ConfigurationReader.getProperty("platform").equals("mobile")) {
            productDetailPage.heartIconPDPMobile.click();
        }
    }

    @Then("User changes qty from {int} to {int} in PLP quick view")
    public void userChangeQtyFromToInPlpQuickView(Integer int1, Integer int2) {
        if (platform.equals("desktop") || platform.equals("tablet")) {
            BrowserUtils.waitForClickAbility(listPage.quickViewIncreaseQty, Duration.ofSeconds(5)).click();
        } else System.out.println("Not in display");
    }

    @Then("User clicks on Add Item to Cart in quick view")
    public void userAddItemToCartInPlpQuickView() {
        if (platform.equals("desktop") || platform.equals("tablet")) {
            BrowserUtils.waitForClickAbility(listPage.quickViewAddItemToCart, Duration.ofSeconds(5)).click();
        }
    }

    @Then("User clicks X to exit quick view and asserts items in mini cart is {string} qty")
    public void userClicksXToExitQuickViewAndAssertsItemsInMiniCartIsQty(String expectedQty) {
        if (platform.equals("desktop") || platform.equals("tablet")) {
//            if (listPage.quickViewClose.isDisplayed()) {
            BrowserUtils.waitForClickAbility(listPage.quickViewClose, Duration.ofSeconds(5)).click();
//            }
            BrowserUtils.waitForVisibility(homePage.miniCartQty, Duration.ofSeconds(10));
            String actualQty = homePage.miniCartQty.getText();
            Assert.assertEquals(expectedQty, actualQty);
        } else {
            System.out.println("Not in display");
        }
    }
}
