package com.digitalExperience.step_definitions.digitalExp_steps;

import com.digitalExperience.pages.digitalExpUI_pages.AccountPage;
import com.digitalExperience.pages.digitalExpUI_pages.CartPage;
import com.digitalExperience.pages.digitalExpUI_pages.DataFieldPage;
import com.digitalExperience.pages.digitalExpUI_pages.ProductDetailPage;
import com.digitalExperience.utilities.BrowserUtils;
import com.digitalExperience.utilities.ConfigurationReader;
import com.digitalExperience.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class CartPageSmokeStepDefs {

    CartPage cartPage = new CartPage();
    WebDriver driver = Driver.getDriver();
    ProductDetailPage productDetailPage = new ProductDetailPage();
    String platform = ConfigurationReader.getProperty("platform");
    AccountPage accountPage = new AccountPage();
    DataFieldPage dataFieldPage = new DataFieldPage();

    @When("User clicks on Confirm button to confirm the zip code")
    public void confirmZipcodeButton() {
        cartPage.confirmZipPopUp.isDisplayed();
        cartPage.btnConfirmZip.click();
        BrowserUtils.waitForPageToLoad(5);
    }

    @When("User uncheck Protection Plan check box")
    public void userUncheckPPCheckbox() {
        BrowserUtils.waitForPageToLoad(5);
        if (cartPage.pp_checkbox.isSelected()) {
            BrowserUtils.clickWithJS(cartPage.pp_checkbox_cont);
            BrowserUtils.waitForPageToLoad(5);
        }
    }

    @When("User check Protection Plan check box")
    public void userCheckPPCheckbox() {
        if (cartPage.pp_checkbox.isSelected()) {
            System.out.println("do nothing");
        } else
            cartPage.pp_checkbox.click();
        BrowserUtils.waitForPageToLoad(5);
    }

    @When("User uncheck Handy Item check box")
    public void userUncheckHandyCheckbox() {
        if (cartPage.handy_checkbox.isSelected()) {
            cartPage.handy_checkbox.click();
            BrowserUtils.waitForPageToLoad(5);
        }
    }

    @When("User check Handy Item check box")
    public void userCheckHandyCheckbox() {
        if (cartPage.handy_checkbox.isSelected()) {
            System.out.println("do nothing");
        } else
            BrowserUtils.clickWithJS(cartPage.handy_checkbox);
        BrowserUtils.waitForPageToLoad(5);
    }

    @When("User verifies that {string} is added to cart")
    public void userVerifiesThatFPPAddedCart(String ProtectionPlan) {
        Assert.assertEquals("Furniture $59.99", cartPage.pplink1.getText());
        Assert.assertEquals("Outdoor $239.99", cartPage.pplink2.getText());
        Assert.assertEquals("Adjustable Base $149.99", cartPage.pplink3.getText());
        Assert.assertEquals("King Adjustable Base $299.99", cartPage.pplink4.getText());
    }

    @When("User verifies that Protection Plan is not available")
    public void userVerifiesThatFPPUnavailable() {
        Assert.assertEquals("OUR APOLOGIES: Protection plans are currently unavailable", cartPage.nofpp.getText());
    }

    @When("User verifies that protection plan is available on cart")
    public void userVerifiesThatProtectionPlanIsAvailableOnCart() {
        Assert.assertEquals("Protect your items from the unexpected", cartPage.PPlabel1.getText());
        Assert.assertEquals("Protect your items from the unexpected", cartPage.PPlabel2.getText());
        Assert.assertEquals("Protect your items from the unexpected", cartPage.PPlabel3.getText());
        Assert.assertEquals("Protect your items from the unexpected", cartPage.PPlabel4.getText());
    }

    @When("User verifies that protection plan is selected")
    public void userVerifiesPPSelected() {
        Assert.assertTrue(cartPage.ppckbx1.isSelected());
    }

    @When("User verifies that protection plan is unselected")
    public void userVerifiesPPUnselected() {
        Assert.assertFalse(cartPage.ppckbx1.isSelected());
        Assert.assertFalse(cartPage.ppckbx2.isSelected());
        Assert.assertFalse(cartPage.ppckbx3.isSelected());
        Assert.assertFalse(cartPage.ppckbx4.isSelected());
    }

    @When("User clicks on Secure Check out button")
    public void clickSecureCheckoutButton() {
        BrowserUtils.scrollToElement(cartPage.secureCkoutBtn);
        cartPage.secureCkoutBtn.click();
    }


    @Then("User changes Qty from {string} to {string} in cart")
    public void userChangesQtyFromToInCart(String qtyNumberStart, String qtyNumberChange) {
        if (ConfigurationReader.getProperty("platform").equals("desktop") || ConfigurationReader.getProperty("platform").equals("tablet")) {
            cartPage.qtySelect.click();
            BrowserUtils.scrollToElement(cartPage.qtySelect);
            driver.findElement(By.xpath("//select[@name='dwfrm_cart_shipments_i0_items_i0_quantity'] /option[@value='" + qtyNumberChange + "']")).click();
        } else if (ConfigurationReader.getProperty("platform").equals("mobile")) {
            JavascriptExecutor Js1 = (JavascriptExecutor) driver;
            Js1.executeScript("window.scrollBy(0,400)");
            BrowserUtils.sleep(3);
            cartPage.qtySelect.click();
            BrowserUtils.scrollToElement(cartPage.qtySelect);
            driver.findElement(By.xpath("//select[@name='dwfrm_cart_shipments_i0_items_i0_quantity'] /option[@value='" + qtyNumberChange + "']")).click();
        }
    }

    @Then("Assert cart is reflecting {string} QTY change")
    public void assertCartIsReflectingQtyChange(String expectedQty) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        String MyCart = driver.findElement(By.xpath("//h1[@class='cart-title']")).getText();
        Assert.assertEquals(expectedQty, MyCart);
    }

    @When("User Removes item from cart")
    public void userRemovesItemFromCart() {
        if (ConfigurationReader.getProperty("platform").equals("desktop")) {
            cartPage.removeItem.click();
            cartPage.removeItem_YesBtn.click();
        } else if (ConfigurationReader.getProperty("platform").equals("tablet")) {
            cartPage.removeItem_BtnMobileTablet.click();
            cartPage.removeItem_YesBtn.click();
        } else if (ConfigurationReader.getProperty("platform").equals("mobile")) {
            BrowserUtils.scrollToElement(cartPage.removeItem_BtnMobileTablet);
            BrowserUtils.clickWithJS(cartPage.removeItem_BtnMobileTablet);
            cartPage.removeItem_YesBtn.click();
        }
    }

    @Then("User Validates cart is {int} qty")
    public void userValidatesCartIsQty(Integer int1) {
        String actualQty = driver.findElement(By.xpath("//div[@class='cart-empty']")).getText();
        String expectedQty = "Your Shopping Cart is Empty";
        Assert.assertTrue(expectedQty, actualQty.contains("Your Shopping Cart is Empty"));
    }

    @And("User Logs in")
    public void userLogsIn() {
        BrowserUtils.sleep(3);
        productDetailPage.EmailAddressLogin.click();
        productDetailPage.EmailAddressLogin.sendKeys("jguitron@ashleyfurniture.com");
        productDetailPage.PassWordLogin.click();
        productDetailPage.PassWordLogin.sendKeys("Tester123!");
        BrowserUtils.sleep(3);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//span[@style='font-weight:bold;']")));
        driver.findElement(By.name("dwfrm_login_login")).click();
    }

    @Then("User asserts {string} saved items with {string}")
    public void userAssertsSavedItemsWith(String SavedItem, String assertSaved) {
        String savedItem = driver.findElement(By.xpath("//h2 /*[contains(@href,'" + assertSaved + "')]")).getText();
        Assert.assertTrue(SavedItem.contains(savedItem));
    }

    @Then("User asserts {string} saved items in cart")
    public void userAssertsSavedItemsInCart(String SavedItem) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        BrowserUtils.waitForPageToLoad(5);
        String savedItem = driver.findElement(By.xpath("//div[@class='name'] /div /a[@title='Go to Product: " + SavedItem + "']")).getText();
        Assert.assertTrue(SavedItem.contains(savedItem));
    }

    @Then("User asserts {string} saved items in cart mobile skip")
    public void userAssertsSavedItemsInCartMobileSkip(String item) {
        if (ConfigurationReader.getProperty("platform").equals("desktop") || ConfigurationReader.getProperty("platform").equals("tablet")) {
            String SavedItem = cartPage.savedInCart.getText();
            String expectedItem = item;
            Assert.assertEquals(expectedItem, SavedItem);
        }
    }

    @Then("User clicks save for later button")
    public void userClicksSaveForLaterButton() {
        if (ConfigurationReader.getProperty("platform").equals("mobile") || ConfigurationReader.getProperty("platform").equals("tablet")) {
            JavascriptExecutor Js1 = (JavascriptExecutor) driver;
            Js1.executeScript("window.scrollBy(0,700)");
            productDetailPage.SaveItemMobile.click();
        } else if (ConfigurationReader.getProperty("platform").equals("desktop")) {
            BrowserUtils.clickWithJS(productDetailPage.SaveItem);
        }
    }

    @Then("User validates the tax amount on CartPage")
    public void userValidateTaxOnCart() {
        BrowserUtils.sleep(2);
        if (platform.equals("desktop")) {
            String zipcode = cartPage.cartzipcodelink.getText();
            String taxvalue = cartPage.taxValueCart.getText();
            taxvalue = taxvalue.replace("$", "");
            double finaltaxvalue = Double.parseDouble(taxvalue);
            BrowserUtils.scrollToElement(cartPage.taxesCart);
            if (zipcode.startsWith("97") || zipcode.startsWith("99") || zipcode.startsWith("19") || zipcode.startsWith("59") || zipcode.startsWith("03")) {
                Assert.assertTrue(finaltaxvalue == 0.00);
            } else {
                Assert.assertTrue(finaltaxvalue > 0);
            }
        }
        if (platform.equals("mobile") || (platform.equals("tablet"))) {
            String zipcode = cartPage.cartzipcodelinkMob.getText();
            String taxvalue = cartPage.taxValueCart.getText();
            taxvalue = taxvalue.replace("$", "");
            double finaltaxvalue = Double.parseDouble(taxvalue);
            BrowserUtils.scrollToElement(cartPage.taxesCart);
            if (zipcode.startsWith("97") || zipcode.startsWith("99") || zipcode.startsWith("19") || zipcode.startsWith("59") || zipcode.startsWith("03")) {
                Assert.assertTrue(finaltaxvalue == 0.00);
            } else {
                Assert.assertTrue(finaltaxvalue > 0);
            }
        }
    }

    @Then("User changes the delivery {string} by clicking on zipcode link from Cart Page")
    public void userChangeTheZipcodeInCart(String zipcode) {
        BrowserUtils.waitForPageToLoad(5);
        if (platform.equals("desktop")) {
            BrowserUtils.sleep(2);
            BrowserUtils.scrollToElement(cartPage.cartzipcodelink);
            BrowserUtils.clickWithJS(cartPage.cartzipcodelink);
            BrowserUtils.sleep(3);
            BrowserUtils.clickWithJS(cartPage.changeLocationZipCodePopUpTextBox);
            BrowserUtils.sleep(3);
            cartPage.changeLocationZipCodePopUpTextBox.sendKeys(zipcode + Keys.ENTER);
            BrowserUtils.sleep(1);
        }
        if (platform.equals("mobile") || (platform.equals("tablet"))) {
            BrowserUtils.sleep(3);
            BrowserUtils.scrollToElement(cartPage.cartzipcodelinkMob);
            BrowserUtils.clickWithJS(cartPage.cartzipcodelinkMob);
            BrowserUtils.sleep(3);
            cartPage.changeLocationZipCodePopUpTextBox.sendKeys(zipcode + Keys.ENTER);
            BrowserUtils.sleep(1);
        }
    }

    @Then("User clicks {string} add to cart from Wish List")
    public void userClicksAddToCartFromWishList(String itemname) {
        driver.findElement(By.xpath("//button[@aria-label='add " + itemname + " to cart']")).click();
    }

    @Then("User asserts user name on account page reflects {string}")
    public void userAssertsUserNameOnAccountPageReflects(String userName) {
        String onPageUserName = cartPage.userNameOnAccount.getText().trim();
        Assert.assertTrue(onPageUserName.contains(userName));
    }

    @Then("User asserts email-address on account page reflects {string}")
    public void userAssertsEmailAddressOnAccountPageReflects(String email) {
        String emailOnPage = cartPage.emailOnAccount.getText();
        Assert.assertEquals(email, emailOnPage);
    }

    @Then("User asserts phone number on account page reflects {string}")
    public void userAssertsPhoneNumberOnAccountPageReflects(String phoneNumber) {
        String phoneNumberOnPage = cartPage.phoneNumberOnAccount.getText();
        Assert.assertEquals(phoneNumber, phoneNumberOnPage);
    }

    @When("User inputs generated new address data into fields")
    public void userInputsGeneratedNewAddressDataIntoFields() {
        Faker faker = new Faker();
        dataFieldPage.setAddressName(faker.address().firstName());
        dataFieldPage.setFirstName(faker.name().firstName());
        dataFieldPage.setLastName(faker.name().lastName());
        dataFieldPage.setAddress(faker.address().streetAddressNumber());
        dataFieldPage.setCity(faker.address().city());
        dataFieldPage.setZipCode(faker.address().zipCode());
    }

    @When("User enters personal information into create new address tab")
    public void userEntersPersonalInformationIntoCreateNewAddressTab() {
        accountPage.addressNameAdd.sendKeys(dataFieldPage.getAddressName());
        accountPage.firstNameAddressAdd.sendKeys(dataFieldPage.getFirstName());
        accountPage.lastNameAddressAdd.sendKeys(dataFieldPage.getLastName());
        accountPage.fullAddressAdd.sendKeys(dataFieldPage.getAddress());
        accountPage.cityAddressAdd.sendKeys(dataFieldPage.getCity());
        accountPage.stateSelectionAddressAdd.click();
        accountPage.stateAddressAdd.click();
        accountPage.zipCodeAddressAdd.sendKeys(dataFieldPage.getZipCode());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        accountPage.zipCodeAddressAdd.sendKeys(dataFieldPage.getZipCode());
        accountPage.phoneNumberAddressAdd.sendKeys("(800) 275-8777");
        accountPage.applyButtonAddressAdd.click();
        accountPage.submitButtonAddressAdd.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String nameValidation = driver.findElement(By.xpath("//*[contains(text(),'" + dataFieldPage.getAddressName() + "')]")).getText();
        Assert.assertEquals(nameValidation, dataFieldPage.getAddressName());
    }

    @When("User deletes saved address")
    public void userDeletesSavedAddress() {
        driver.findElement(By.xpath("//a[contains(@href, 'Delete?AddressID=" + dataFieldPage.getAddressName() + "')]")).click();
        driver.switchTo().alert().accept();
    }
}
