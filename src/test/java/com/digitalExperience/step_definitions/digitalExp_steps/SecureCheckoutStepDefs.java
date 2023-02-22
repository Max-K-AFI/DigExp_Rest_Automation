package com.digitalExperience.step_definitions.digitalExp_steps;

import com.digitalExperience.pages.digitalExpUI_pages.BaseSmokePage;
import com.digitalExperience.pages.digitalExpUI_pages.SecureCheckoutPage;
import com.digitalExperience.utilities.BrowserUtils;
import com.digitalExperience.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class SecureCheckoutStepDefs {
    SecureCheckoutPage checkoutPage = new SecureCheckoutPage();
    WebDriver driver = Driver.getDriver();
    BaseSmokePage baseSmokePage = new BaseSmokePage();

    @Given("User is on {string} Page")
    public void userIsOnCheckoutPage(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Then("User verifies Credit card Payment options are available")
    public void creditCardPaymentOptionIsAvailable() {
        BrowserUtils.scrollToElement(checkoutPage.cclogoimg1);
        BrowserUtils.sleep(1);
        Assert.assertTrue(checkoutPage.cclogoimg1.isDisplayed());
        Assert.assertTrue(checkoutPage.cclogoimg2.isDisplayed());
        Assert.assertTrue(checkoutPage.label_NameOnCard.isDisplayed());
        Assert.assertTrue(checkoutPage.label_CC_number.isDisplayed());
        Assert.assertTrue(checkoutPage.label_expdate.isDisplayed());
        Assert.assertTrue(checkoutPage.label_cvv.isDisplayed());
    }

    @Then("User verifies Ashley Advantage Payment option and clicks on it")
    public void verifyAshleyAdvantageAndClick() {
        BrowserUtils.sleep(1);
        Assert.assertTrue(checkoutPage.ashleyAdvtglogoImg.isDisplayed());
        BrowserUtils.clickWithJS(checkoutPage.ashleyAdvtglogoImg);
    }

    @Then("User verifies Ashley Advantage logos and fields are displayed")
    public void verifyAshleyAdvantagePaymentOptionFieldsAreDisplayed() {
        BrowserUtils.sleep(1);
        Assert.assertTrue(checkoutPage.synchronylogo.isDisplayed());
        Assert.assertTrue(checkoutPage.genesislogo.isDisplayed());
        Assert.assertTrue(checkoutPage.gafcologo.isDisplayed());
    }

    @Then("User verifies Progressive leasing Payment and clicks on ot")
    public void verifyProgressiveLeasingAndClick() {
        BrowserUtils.sleep(1);
        Assert.assertTrue(checkoutPage.progressiveLeasingLogo.isDisplayed());
        BrowserUtils.clickWithJS(checkoutPage.progressiveLeasingLogo);
    }

    @Then("User verifies Progressive leasing Payment logos and fields")
    public void verifyProgressiveLeasingPaymentOptionFieldsAreDisplayed() {
        Assert.assertTrue(checkoutPage.progressiveLeasingTitle.isDisplayed());
        Assert.assertEquals("Progressive Leasing™", checkoutPage.progressiveLeasingTitle.getText());
        Assert.assertTrue(checkoutPage.progresLeasPhnNumb.isDisplayed());
        Assert.assertTrue(checkoutPage.lable_pl_SSN4.isDisplayed());
        Assert.assertTrue(checkoutPage.btn_pl_view_dtls.isDisplayed());
    }

    @Then("Caddipay Payment option is available and clicks on it")
    public void verifyCaddipayAndClick() {
        BrowserUtils.sleep(1);
        Assert.assertTrue(checkoutPage.caddipayLogo.isDisplayed());
        BrowserUtils.clickWithJS(checkoutPage.caddipayLogo);
    }

    @When("User verifies that Caddipay page is launched then close the window")
    public void verifyCaddipayWindow() {
        BrowserUtils.sleep(3);
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String ChildWindow : allWindows) {
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                Assert.assertEquals("Caddipay", driver.getTitle());
            }
        }
        baseSmokePage.closeCaddipayX.click();
        BrowserUtils.sleep(1);
        driver.switchTo().window(mainWindowHandle);
    }

    @Then("User verifies Paypal Payment option and clicks on it")
    public void verifyPayPalAndClick() {
        Assert.assertTrue(checkoutPage.payPalLogo.isEnabled());
        BrowserUtils.waitForClickAbility(checkoutPage.payPalLogo, Duration.ofSeconds(5)).click();
    }

    @When("User verifies that Paypal login page is launched")
    public void verifyPayPalWindow() {
        BrowserUtils.waitForPageToLoad(5);
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String eachWindow : allWindows) {
            if (!mainWindowHandle.equalsIgnoreCase(eachWindow)) {
                driver.switchTo().window(eachWindow);
                BrowserUtils.waitForPageToLoad(5);
                Assert.assertTrue("Log in to your PayPal account", driver.getTitle().contains("PayPal"));
            }
        }
        driver.navigate().refresh();
        BrowserUtils.sleep(1);
        driver.switchTo().window(mainWindowHandle);
    }

    @When("User logs into paypal account and review order")
    public void loginPaypalAccount() {
        BrowserUtils.waitForPageToLoad(5);
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String eachWindow : allWindows) {
            if (!mainWindowHandle.equalsIgnoreCase(eachWindow)) {
                driver.switchTo().window(eachWindow);
                BrowserUtils.waitForPageToLoad(5);
                Assert.assertTrue("Log in to your PayPal account", driver.getTitle().contains("PayPal"));
                checkoutPage.paypalUserName.clear();
                checkoutPage.paypalUserName.sendKeys("BSA_Buyer4@ashleyfurniture.com");
                checkoutPage.paypalPassword.sendKeys("BSABuyer4!");
                checkoutPage.paypalLoginBtn.click();
                BrowserUtils.waitForPageToLoad(5);
                checkoutPage.paypalContReviewOrder.click();
            }
        }
        driver.navigate().refresh();
        BrowserUtils.sleep(1);
        driver.switchTo().window(mainWindowHandle);
    }

    @Then("Acima Payment option is available")
    public void verifyAcimaPaymentOptionIsAvailable() {
        BrowserUtils.scrollToElement(checkoutPage.acimaLogo);
        Assert.assertTrue(checkoutPage.acimaLogo.isDisplayed());
    }

    @When("User clicks on Use Original button on PopUp window")
    public void clickOnUseOriginal() {
        checkoutPage.useoriginal.click();
    }

    @Then("User validates the tax amount on SecureCheckout CustomerInfo Page")
    public void validateTaxOnSecureCheckoutCustomerInfo() {
        BrowserUtils.sleep(2);
        String zipcode = checkoutPage.zip.getAttribute("value");
        System.out.println(zipcode);
        BrowserUtils.scrollToElement(checkoutPage.taxLableSecureChkoutCustInfo);
        String taxvalue = checkoutPage.taxValueSecureChkoutCustInfo.getText();
        taxvalue = taxvalue.replace("$", "");
        double finaltaxvalue = Double.parseDouble(taxvalue);
        if (zipcode.startsWith("97") || zipcode.startsWith("99") || zipcode.startsWith("19") || zipcode.startsWith("59") || zipcode.startsWith("03")) {
            Assert.assertTrue(finaltaxvalue == 0.00);
        } else {
            Assert.assertTrue(finaltaxvalue > 0);
        }
    }

    @When("User enters customer info on Secure Checkout Delivery Page")
    public void enterCustomerInfoOnSecureCheckoutDeliveryPage(List<String> info) {
        for (int i = 0; i < info.size(); i++) {
            String customerInfo = info.get(i);
            if (i == 0) {
                checkoutPage.fname.sendKeys(customerInfo);
            }
            if (i == 1) {
                checkoutPage.lname.sendKeys(customerInfo);
            }
            if (i == 2) {
                checkoutPage.address1.sendKeys(customerInfo);
            }
            if (i == 3) {
                checkoutPage.address2.sendKeys(customerInfo);
            }
            if (i == 4) {
                checkoutPage.city.sendKeys(customerInfo);
            }
            if (i == 5) {
                checkoutPage.state.sendKeys(customerInfo);
            }
            if (i == 6) {
                checkoutPage.zip.clear();
                checkoutPage.zip.sendKeys(customerInfo);
            }
            if (i == 7) {
                checkoutPage.customerphone.sendKeys(customerInfo);
            }
            if (i == 8) {
                checkoutPage.customeremail.sendKeys(customerInfo);
            }
        }
    }

    @When("User fills in customer and shipping info using auto address selection")
    public void customerInfoAutoAddressSelection(List<String> info) {
        WebElement firstName, lastName, addressBox, addressOptions;
        for (int i = 0; i < info.size(); i++) {
            String customerInfo = info.get(i);
            if (i == 0) {
              firstName = BrowserUtils.waitForVisibility(checkoutPage.fname, Duration.ofSeconds(10));
              firstName.sendKeys(customerInfo);
            }
            if (i == 1) {
              lastName = BrowserUtils.waitForVisibility(checkoutPage.lname, Duration.ofSeconds(10));
              lastName.sendKeys(customerInfo);
            }
            if (i == 2) {
                addressBox = BrowserUtils.waitForVisibility(checkoutPage.addresstextbox, Duration.ofSeconds(10));
                addressBox.click();
                checkoutPage.addresstextbox.sendKeys(customerInfo);
                BrowserUtils.sleep(2);
            }
            if (i == 3) {
                addressBox = BrowserUtils.waitForVisibility(checkoutPage.addresstextbox, Duration.ofSeconds(10));
                addressBox.click();
                checkoutPage.addresstextbox.sendKeys(customerInfo);
                BrowserUtils.sleep(2);
            }
        }
        addressOptions = BrowserUtils.waitForClickAbility(checkoutPage.addressOptions, Duration.ofSeconds(15));
        addressOptions.click();
        checkoutPage.customerphone.sendKeys("6123542589");
        checkoutPage.customeremail.sendKeys("test@test.com");
    }

    @When("User clicks on Continue as Guest button")
    public void clickOnContAsGuest() {
        BrowserUtils.waitForClickAbility(checkoutPage.contAsGuest, Duration.ofSeconds(10)).click();
    }



    @Then("User validates the tax amount on SecureCheckout Shipping Page")
    public void validateTaxOnSecureCheckoutShipping() {
        BrowserUtils.scrollToElement(checkoutPage.TaxLabelSecureCheckOutShipping);
        Assert.assertTrue(checkoutPage.zipSecureCheckoutShipping.isDisplayed());
        String zipcode = checkoutPage.zipcodevalue.getAttribute("value");
        String taxValue = checkoutPage.taxValueSecureCheckoutShipping.getText().replace("$", "");
        double finalTaxValue = Double.parseDouble(taxValue);
        if (zipcode.startsWith("97") || zipcode.startsWith("99") || zipcode.startsWith("19") || zipcode.startsWith("59") || zipcode.startsWith("03")) {
            Assert.assertEquals(0.00, finalTaxValue, 0.0);
        } else {
            Assert.assertTrue(finalTaxValue > 0);
        }
    }

    @When("User Verifies Recycle Fee is displayed on SecureCheckOut Shipping Page only for CA store")
    public void verifyRecycleFeeDisplayedShippingPage() {
        BrowserUtils.waitForPageToLoad(10);
        String zipcode = checkoutPage.zipcodevalue.getAttribute("value");
        if (zipcode.startsWith("90")) {
            BrowserUtils.scrollToElement(checkoutPage.recycleFeeLabelShipping);
            BrowserUtils.sleep(1);
            Assert.assertTrue(checkoutPage.recycleFeeLabelShipping.isDisplayed());
            BrowserUtils.sleep(1);
            String recycleFee = checkoutPage.recycleFeeValueShipping.getText().replace("$", "");
            double recycleFeeAmount = Double.parseDouble(recycleFee);
            Assert.assertTrue(recycleFeeAmount > 0);
            Assert.assertEquals("Would you like a pickup of your used mattress and/or foundation to be recycled, at no additional cost? (required) Learn More", checkoutPage.recycleTakeBackMsgShipping.getText());
            BrowserUtils.scrollToElement(checkoutPage.takebackRadioBtnYES);
            Assert.assertTrue(checkoutPage.takebackRadioBtnYES.isDisplayed());
            Assert.assertTrue(checkoutPage.takebackRadioBtnNO.isDisplayed());
            BrowserUtils.clickWithJS(checkoutPage.takebackRadioBtnYES);
            BrowserUtils.sleep(1);
        } else {
            List<WebElement> elements = driver.findElements(By.xpath("//tr[@id='order-state-recycling-fee']/td[2]"));
            Assert.assertEquals(0, elements.size());
        }
    }

    @When("User clicks on continue to billing and payment button")
    public void clickOnContToBilling() {
        WebElement contBilling = BrowserUtils.waitForClickAbility(checkoutPage.ContinueBilling, Duration.ofSeconds(5));
        contBilling.click();
        BrowserUtils.waitForPageToLoad(5);
    }

    @When("User Verifies Recycle Fee is displayed on SecureCheckOut Billing Page only for CA store")
    public void userVerifiesRecycleFeeDisplayedBillingPage() {
        BrowserUtils.sleep(1);
        String zipcode = checkoutPage.zipcodevalueBilling.getAttribute("value");
        if (zipcode.startsWith("90")) {
            BrowserUtils.scrollToElement(checkoutPage.recycleFeeLabelBilling);
            Assert.assertTrue(checkoutPage.recycleFeeLabelBilling.isDisplayed());
            String recyclefee = checkoutPage.recycleFeeValueBilling.getText();
            recyclefee = recyclefee.replace("$", "");
            double recyclefeeamount = Double.parseDouble(recyclefee);
            Assert.assertTrue(recyclefeeamount > 0);
            BrowserUtils.sleep(1);
        } else {
            WebDriver driver = Driver.getDriver();
            List<WebElement> elements = driver.findElements(By.xpath("//tr[@id='order-state-recycling-fee']/td[2]"));
            Assert.assertTrue(elements.size() == 0);
        }
    }

    @Then("User verifies that Progressive Popup for ProtectionPlan is displayed")
    public void verifyProgressivePopupProtectionPlanIsDisplayed() {
        Assert.assertEquals("Thank you for selecting Progressive Leasing\n" +
                "\n" +
                "We noticed you have added a protection plan(s).\n" +
                "Protection Plans cannot be added to items that are leased.\n" +
                "\n" +
                "If you wish to keep the protection plan(s), choose another payment option.", checkoutPage.PrgsvPopupMsg.getText());
    }

    @Then("User verifies that Progressive Popup for FPP and Handy Item is displayed")
    public void verifyProgressivePopupProtectionPlanAndHandyIsDisplayed() {
        Assert.assertEquals("Thank you for selecting Progressive Leasing\n" +
                "\n" +
                "We noticed you added a Protection Plan(s) and Furniture Assembly by Handy.\n" +
                "These services cannot be added to leased items.\n" +
                "\n" +
                "If you wish to keep your Expert Assembly & Installation by Handy, please choose a different payment method.", checkoutPage.PrgsvPopupMsg_FppHandy.getText());
    }

    @Then("User verifies that Progressive Popup for Handy Item is displayed")
    public void verifyProgressivePopupHandyIsDisplayed() {
        Assert.assertEquals("Thank you for selecting Progressive Leasing\n" +
                "\n" +
                "We noticed you added Furniture Assembly by Handy.\n" +
                "This service cannot be added to leased items.\n" +
                "\n" +
                "If you wish to keep your Furniture Assembly by Handy, please choose a different payment method..", checkoutPage.PrgsvPopupMsg_handy.getText());
    }

    @Then("User click on Continue with Progressive Leasing button in Progressive popup msg")
    public void clickOnContinueWithPL() {
        checkoutPage.PrgsvPopupContinueBtn.click();
        BrowserUtils.waitForPageToLoad(4);
    }

    @Then("User click on Continue with Progressive Leasing button in Progressive FPP and Handy popup msg")
    public void userClicksOnContinueWithPLFPPHandy() {
        checkoutPage.PrgsvPopupContinueBtnFPPHandy.click();
        BrowserUtils.waitForPageToLoad(4);
    }

    @Then("User click on Continue with Progressive Leasing button in Progressive Handy popup msg")
    public void userClicksOnContinueWithPLHandy() {
        checkoutPage.PrgsvPopupContinueBtnHandy.click();
        BrowserUtils.waitForPageToLoad(4);
    }

    @Then("User validates the tax amount on SecureCheckout Billing Page")
    public void userValidateTaxOnSecureCheckoutBilling() {
        BrowserUtils.sleep(2);
        BrowserUtils.scrollToElement(checkoutPage.TaxLabelSecureCheckOutBilling);
        Assert.assertTrue(checkoutPage.TaxLabelSecureCheckOutBilling.isDisplayed());
        String zipcode = checkoutPage.zipcodevalueBilling.getAttribute("value");
        String taxvalue = checkoutPage.taxValueSecureCheckoutBilling.getText();
        taxvalue = taxvalue.replace("$", "");
        double finaltaxvalue = Double.parseDouble(taxvalue);
        if (zipcode.startsWith("97") || zipcode.startsWith("99") || zipcode.startsWith("19") || zipcode.startsWith("59") || zipcode.startsWith("03")) {
            Assert.assertTrue(finaltaxvalue == 0.00);
        } else {
            Assert.assertTrue(finaltaxvalue > 0);
        }
    }


}
