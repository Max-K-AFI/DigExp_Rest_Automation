package com.digitalExperience.step_definitions.digitalExp_steps;

import com.digitalExperience.pages.digitalExpUI_pages.AccountPage;
import com.digitalExperience.pages.digitalExpUI_pages.SearchPage;
import com.digitalExperience.utilities.BrowserUtils;
import com.digitalExperience.utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingStepDefs {
    SearchPage shoppingPage = new SearchPage();
    AccountPage signUp = new AccountPage();
    WebDriver driver = Driver.getDriver();

    @Given("User clicks on Start Shopping link")
    public void userClicksOnStartShoppinglink() {
        signUp.startShop.click();
        BrowserUtils.waitForPageToLoad(5);
    }

    @When("User hovers over on {string} and clicks on {string}")
    public void userHoversOverToFurnitureChoosesTvStandAndClicks(String topNavItem, String subNavItem) {
//        driver.navigate().refresh();
        BrowserUtils.hover(driver.findElement(By.xpath("(//a[@data-cgid='"+topNavItem.toLowerCase()+"'])[1]")));
        driver.findElement(By.xpath("//li[*='"+subNavItem+"']")).click();
    }

    @Then("User clicks Quick View on top of the First Product")
    public void userClicksQuickViewOnTopOfTheFirstProduct() {
        BrowserUtils.hover(driver.findElement(By.xpath("(//div[@class='product-image'])[1]")));
        driver.findElement(By.cssSelector("a[id='quickviewbutton']")).click();
    }

    @When("User navigates to last page")
    public void userNavigatesToLastPage() {
        BrowserUtils.scrollToElement(shoppingPage.lastPageBtn);
        shoppingPage.lastPageBtn.click();
    }

    @Then("User chooses last available product and clicks on it")
    public void userChoosesLastAvailableProductAndClicksOnIt() {
        BrowserUtils.scrollToElement(shoppingPage.lastTvStand);
        BrowserUtils.waitForPageToLoad(3);
        shoppingPage.lastTvStand.click();
    }

    @Then("User adds 2 products to his cart")
    public void userAddsMaxAmountAllowedProductToHisCart() {
        shoppingPage.qty.click();
        BrowserUtils.sleep(1);
        shoppingPage.addToCart.click();
    }

    @Then("User checks his cart with total amount")
    public void userChecksHisCartWithTotalAmount() {
        shoppingPage.cart.click();
        String itemCount = shoppingPage.totalCount.getText();
        System.out.println("Total price for " + itemCount + "items: " + shoppingPage.totalPrice.getText());
    }

}
