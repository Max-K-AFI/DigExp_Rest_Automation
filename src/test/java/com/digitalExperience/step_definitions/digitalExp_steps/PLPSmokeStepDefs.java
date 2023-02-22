package com.digitalExperience.step_definitions.digitalExp_steps;

import com.digitalExperience.pages.digitalExpUI_pages.HomeSmokePage;
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

public class PLPSmokeStepDefs {
    WebDriver driver = Driver.getDriver();
    ProductListPage productListPage = new ProductListPage();
    HomeSmokePage homeSmokePage = new HomeSmokePage();

    @Given("User clicks on PLP Show {string} per page button")
    public void userClicksOnPlpShowPerPageButton(String qtyShowPerPage) {
        if (ConfigurationReader.getProperty("platform").equals("desktop")) {
            driver.findElement(By.xpath("//select[@id='grid-paging-header'] /*[contains(@value,'" + qtyShowPerPage + "')]")).click();
            BrowserUtils.waitForPageToLoad(5);
        }
    }

    @When("User chooses {string} in plp")
    public void userChoosesOnInPdp(String itemName) {
        BrowserUtils.waitForPageToLoad(10);
        for (int i = 0; i < 100; i++) {
            if (driver.findElements(By.xpath("//img[@alt='" + itemName + "']")).isEmpty()) {
                BrowserUtils.waitForVisibility(productListPage.nextPageResults, Duration.ofSeconds(2));
                BrowserUtils.clickWithJS(productListPage.nextPageResults);

            }
        }
        BrowserUtils.clickWithJS(driver.findElement(By.xpath("//img[@alt='" + itemName + "']")));
    }

    @Then("User clicks on item filters in PLP and asserts change with filters")
    public void userClicksOnItemFiltersInPlpAndAssertsChangeWithFilters(List<String> filters) {
        for (String eachFilter : filters) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            BrowserUtils.clickWithJS(driver.findElement(By.xpath("//a[contains(@href, '" + eachFilter + "')]")));
            BrowserUtils.sleep(4);
            BrowserUtils.clickWithJS(driver.findElement(By.xpath("//div[@class='accordion-menu'] /div[@class='refinement " + eachFilter + "'] /span")));
            String filterOnScreen = driver.findElement(By.xpath("//a[contains(@id,'" + eachFilter + "')] /span /span")).getText();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            List<WebElement> pLPFilteredQty = (driver.findElements(By.xpath("//div[@class='product-name']")));
            int numberOfElements = pLPFilteredQty.size();
            String fixedValue = String.valueOf(numberOfElements);
            Assert.assertTrue(filterOnScreen.contains(fixedValue));
            BrowserUtils.clickWithJS(productListPage.clearAllFilters);
            BrowserUtils.waitForPageToLoad(5);
        }
    }

    @Then("User checks for {string} button is present")
    public void userChecksForButtonIsPresent(String Learn) {
        BrowserUtils.scrollToElement(productListPage.heartIcon);
        BrowserUtils.clickWithJS(productListPage.learnHowButton);
        BrowserUtils.sleep(2);
        String learnHow = productListPage.asLowAsLearnMore.getText();
        Assert.assertEquals(learnHow, Learn);
    }

    @Then("User asserts {string} in learn how popup with {string}")
    public void userAssertsInLearnHowPopupWith(String button, String Asserted) {
        String textOnScreen = driver.findElement(By.xpath("//a[@class='as-low-as-" + button + "-now as-low-as-learn-more ss-synch-set']")).getText();
        Assert.assertTrue(textOnScreen.contains(Asserted));
        BrowserUtils.clickWithJS(productListPage.learnHowButtonClose);
    }

    @Then("User asserts next button to {string} is {string}")
    public void userAssertsNextButtonToIs(String pageDesired, String pageNumber) {
        driver.findElement(By.xpath("//a[@class='" + pageDesired + "']")).click();
        BrowserUtils.sleep(2);
        String currentPage = productListPage.currentPageListQty.getText();
        Assert.assertTrue(pageNumber.contains(currentPage));
    }

    @Then("User clicks second page of inventory and asserts that {string} is {string}")
    public void userClicksSecondPageOfInventoryAndAssertsThatIs(String pageDesired, String pageNumber) {
        driver.findElement(By.xpath("//a[@class='" + pageDesired + "']")).click();
        BrowserUtils.sleep(5);
        String currentPage = productListPage.currentPageListQty.getText();
        Assert.assertTrue(pageNumber.equals(currentPage));

    }

    @Then("User clicks next button icon and lands user on page {string}")
    public void userClicksNextButtonIconAndLandsUserOnPage(String pageDesired) {
        productListPage.nextPageResults.click();
        BrowserUtils.sleep(5);
        String currentPage = productListPage.currentPageListQty.getText();
        Assert.assertTrue(pageDesired.contains(currentPage));
    }

    @Then("User clicks on last page of inventory and asserts page")
    public void userClicksOnLastPageOfInventoryAndAssertsPage() {
        productListPage.lastPageResults.click();
        BrowserUtils.sleep(5);
        if (driver.findElements(By.xpath("//a[@class='page-switcher page-last']")).isEmpty()) {
            System.out.println("Not present");
        }
    }

    @Then("User clicks on quick view in PLP")
    public void userClicksOnQuickViewInPlp() {
        if (ConfigurationReader.getProperty("platform").equals("desktop")) {
            BrowserUtils.scrollToElement(productListPage.quickViewHover);
            BrowserUtils.hover(productListPage.quickViewHover);
            productListPage.quickViewButton.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        } else if (ConfigurationReader.getProperty("platform").equals("tablet")) {
            JavascriptExecutor Js1 = (JavascriptExecutor) driver;
            Js1.executeScript("window.scrollBy(0,800)");
            BrowserUtils.hover(productListPage.quickViewHover);
            productListPage.quickViewButton.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        }
    }

    @Then("User clicks on arrows switching between products in PLP on QuickView")
    public void userClicksOnArrowsSwitchingBetweenProductsInPlp() {
        if (ConfigurationReader.getProperty("platform").equals("desktop") || ConfigurationReader.getProperty("platform").equals("tablet")) {
            BrowserUtils.waitForClickAbility(productListPage.quickViewItem, Duration.ofSeconds(5));
            String item1 = productListPage.quickViewItem.getText();
            BrowserUtils.clickWithJS(productListPage.quickViewNextIcon);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
            String item2 = productListPage.quickViewItem.getText();
            Assert.assertNotSame(item1, item2);
        } else System.out.println("Not in display");
    }

    @Then("User change qty from {int} to {int} in PLP quick view")
    public void userChangeQtyFromToInPlpQuickView(Integer int1, Integer int2) {
        if (ConfigurationReader.getProperty("platform").equals("desktop")) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
            productListPage.quickViewIncreaseQty.click();
        } else if (ConfigurationReader.getProperty("platform").equals("tablet")) {
            JavascriptExecutor Js1 = (JavascriptExecutor) driver;
            Js1.executeScript("window.scrollBy(0,400)");
            productListPage.quickViewIncreaseQty.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        } else System.out.println("Not in display");
    }

   @Then("User clicks x to exit quick view")
    public void userClicksXToExitQuickView() {
        if (ConfigurationReader.getProperty("platform").equals("desktop") || ConfigurationReader.getProperty("platform").equals("tablet")) {
            if (productListPage.quickViewClose.isDisplayed())
            {
                productListPage.quickViewClose.click();
            }
        } else System.out.println("Not in display");
    }

    @Then("User clicks x to exit quick view and asserts items in mini cart is {string} qty")
    public void userClicksXToExitQuickViewAndAssertsItemsInMiniCartIsQty(String Item) {
        if (ConfigurationReader.getProperty("platform").equals("desktop") || ConfigurationReader.getProperty("platform").equals("tablet")) {
            if (productListPage.quickViewClose.isDisplayed())
            {
                productListPage.quickViewClose.click();
                BrowserUtils.sleep(5);
                BrowserUtils.waitForVisibility(homeSmokePage.miniCartQty, Duration.ofSeconds(4));
                String CartQty = homeSmokePage.miniCartQty.getText();
                Assert.assertEquals(Item, CartQty);
            }
        } else System.out.println("Not in display");
    }
}
