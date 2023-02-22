package com.digitalExperience.step_definitions.digitalExp_steps;

import com.digitalExperience.pages.digitalExpUI_pages.SecureCheckoutPage;
import com.digitalExperience.utilities.BrowserUtils;
import com.digitalExperience.utilities.ConfigurationReader;
import com.digitalExperience.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class PaymentTypesStepDefs {

    SecureCheckoutPage secureCheckOutPage = new SecureCheckoutPage();
    WebDriver driver = Driver.getDriver();

    @When("User manually enters customer info in all fields on Secure Checkout Delivery Page")
    public void enterCustomerInfoOnSecureCheckoutDeliveryPage(List<String> info) {
        String customerInfo;
        for (int i = 0; i < info.size(); i++) {
            customerInfo = info.get(i);
            if (i == 0) {
                secureCheckOutPage.fname.sendKeys(customerInfo);
            }
            if (i == 1) {
                secureCheckOutPage.lname.sendKeys(customerInfo);
            }
            if (i == 2) {
                BrowserUtils.clickWithJS(secureCheckOutPage.addresstextbox);
                secureCheckOutPage.addresstextbox.sendKeys(customerInfo);
                BrowserUtils.sleep(2);
                secureCheckOutPage.addresstextbox.sendKeys(Keys.SPACE);
                BrowserUtils.sleep(2);
                BrowserUtils.clickWithJS(secureCheckOutPage.manualAddressBtn);
                BrowserUtils.sleep(2);
            }
            if (i == 3) {
                continue;
//                secureCheckOutPage.address2.sendKeys(customerInfo);
            }

            if (i == 4) {
                secureCheckOutPage.city.sendKeys(customerInfo);
            }
            if (i == 5) {
                secureCheckOutPage.state.sendKeys(customerInfo);
            }
            if (i == 6) {
                secureCheckOutPage.zip.sendKeys(customerInfo);
            }
            if (i == 7) {
                secureCheckOutPage.customerphone.sendKeys(customerInfo);
            }
            if (i == 8) {
                secureCheckOutPage.customeremail.sendKeys(customerInfo);
            }
        }
    }

    @When("User clicks on Continue button after filling in address info on check-out page")
    public void clickOnContAsGuest() {
        secureCheckOutPage.continueBtnCkOut.click();
    }

    @Given("User is on Billing and Payment Page")
    public void userIsOnBillingAndPaymentPage() {
        Assert.assertEquals("Payment Info", secureCheckOutPage.BP_subtitle.getText());
    }

    @Then("User clicks on Ashley Advantage Payment option")
    public void userClicksOnAaLogo() {
        BrowserUtils.scrollToElement(secureCheckOutPage.aalogoimg);
        BrowserUtils.clickWithJS(secureCheckOutPage.aalogoimg);
    }

    @Then("User enters AA Synchrony account number {string} on Billing page")
    public void enterSynchronyInfo(String accountNmb) {
        secureCheckOutPage.aaAcountNumberfield.sendKeys(accountNmb);
    }

    @Then("User clicks on View Financing Offers Button on Billing Page")
    public void userClicksOnViewFinOffersBtn() {
        secureCheckOutPage.viewFinancingBtn.click();
        BrowserUtils.sleep(2);
    }

    @Then("User selects {string} financing term and click on continue button on Billing page")
    public void selectFinOfferandClickContinue(String term) {
//        checkoutBilling.sixMonthFin.click();
        driver.findElement(By.xpath("//label[text()='" + term + "']")).click();
        BrowserUtils.sleep(1);
        secureCheckOutPage.continueBtnAA.click();
    }

    @Then("User clicks on Accept button on Billing page")
    public void clicksSynchronyAcceptBtn() {
        BrowserUtils.clickWithJS(secureCheckOutPage.AcceptBtnSynchrony);
        BrowserUtils.sleep(2);
    }

    @Then("User clicks on Place Order button")
    public void userClicksOnPlaceOrderButton() {
        secureCheckOutPage.placeOrderBtn.click();
        BrowserUtils.sleep(10);
    }

    @Then("User enters last four digits of SSN as {string} in Acima popup and clicks Submit")
    public void user_enters_last_four_digits_of_ssn_as_in_acima_popup_and_clicks_submit(String last4SSN) {
        driver.switchTo().frame(secureCheckOutPage.acimaIframe);
        secureCheckOutPage.acimaLast4Ssn.sendKeys(last4SSN);
        secureCheckOutPage.acimaSubmit.click();
        BrowserUtils.waitForPageToLoad(5);
    }

    @Then("User clicks Continue on Verification Page")
    public void user_clicks_continue_on_verification_page() {
        secureCheckOutPage.acimaSubmitSsn.click();
        BrowserUtils.waitForPageToLoad(5);
    }

    @Then("User enters full SSN as {string} and Confirms entry one more time")
    public void user_enters_full_ssn_as_and_confirms_entry_more_time(String fullSSN) {
        BrowserUtils.scrollToElement(secureCheckOutPage.acimaFullSsn);
        secureCheckOutPage.acimaFullSsn.sendKeys(fullSSN);
        secureCheckOutPage.acimaFullSsnConfirm.sendKeys(fullSSN);
        secureCheckOutPage.acimaNexBtntAfterSsn.click();
    }

    @Then("User clicks Submit, confirms information and clicks Submit again")
    public void user_clicks_submit_confirms_information_and_clicks_submit_again() {
        secureCheckOutPage.acimaSubmit.click();
        BrowserUtils.waitForPageToLoad(10);
        secureCheckOutPage.acimaSubmit.click();
        BrowserUtils.waitForPageToLoad(10);
    }

    @Then("User clicks on CheckBox to agree to Disclosure and clicks on Sign Agreement")
    public void user_clicks_on_check_box_to_agree_to_disclosure_and_clicks_on_sign_agreement() {
        String nonApprovalText = " ";
        if (secureCheckOutPage.acimaNonApproval.isDisplayed()) {
            nonApprovalText = secureCheckOutPage.acimaNonApproval.getText();
            System.out.println(nonApprovalText);
        } else {
            secureCheckOutPage.acimaCheckBox.click();
            secureCheckOutPage.acimaAcceptAndSign.click();
        }
        Assert.assertEquals(" ", nonApprovalText);
    }

    @Then("User types {string} as user name and clicks on Accept and Sign")
    public void user_types_as_user_name_and_clicks_on_accept_and_sign(String signature) {
        secureCheckOutPage.acimaCignature.sendKeys(signature);
        secureCheckOutPage.acimaAcceptAndSign.click();
        BrowserUtils.waitForPageToLoad(10);
    }

    @Then("User clicks on CheckBox to enable AutoPay and enters Card info")
    public void user_clicks_on_check_box_to_enable_auto_pay_and_enters_card_info(List<Map<String, String>> cardInfo) {
        secureCheckOutPage.acimaCheckBox.click();
        BrowserUtils.waitForPageToLoad(10);
        secureCheckOutPage.acimaCardNumber.sendKeys(cardInfo.get(0).get("CardNumber"));
        secureCheckOutPage.acimaCardMonth.sendKeys(cardInfo.get(1).get("Month"));
        secureCheckOutPage.acimaCardYear.sendKeys(cardInfo.get(2).get("Year"));
        secureCheckOutPage.acimaCardCvv.sendKeys(cardInfo.get(3).get("Cvv"));
    }

    @Then("User clicks on Make Payment")
    public void user_clicks_on_make_payment() {
        secureCheckOutPage.acimaFinishPayment.click();
        BrowserUtils.waitForPageToLoad(15);
    }

    @Then("User verifies successful order submission")
    public void userVerifiesOrderSubmission() {
        String environment = ConfigurationReader.getProperty("URL");
        Assert.assertTrue(secureCheckOutPage.salesOrderNumber.isDisplayed());
        System.out.println("Current Environment: " + environment + "\nSales Order Number is: " + secureCheckOutPage.salesOrderNumber.getText());
    }

    @When("User clicks on Use Address as Entered button on PopUp window")
    public void clickOnUseAddressAsEntered() {
        secureCheckOutPage.useAddressAsEntered.click();
    }

    @Then("User clicks on Credit Card Payment option")
    public void userClicksOnCCLogo() {
        secureCheckOutPage.cclogocontainer.click();
    }

    @Then("User enters Credit card Info on Billing page")
    public void enterCreditCardInfo(List<String> info) {
        String creditcardinfo;
        for (int i = 0; i < info.size(); i++) {
            creditcardinfo = info.get(i);
            if (i == 0) {
                secureCheckOutPage.crediCardNameInputField.sendKeys(creditcardinfo);
            }
            if (i == 1) {
                secureCheckOutPage.crediCardNumberInputField.sendKeys(creditcardinfo);
            }
            if (i == 2) {
                secureCheckOutPage.expDateMonthField.sendKeys(creditcardinfo);
            }
            if (i == 3) {
                secureCheckOutPage.expDateYearField.sendKeys(creditcardinfo);
            }
            if (i == 4) {
                secureCheckOutPage.cvvField.sendKeys(creditcardinfo);
            }
        }
    }

    @Then("User clicks on Continue Button on Billing Page")
    public void userClicksOnContinueBtn() {
        BrowserUtils.waitForClickAbility(secureCheckOutPage.continueBtnOnBilling, Duration.ofSeconds(10));
        secureCheckOutPage.continueBtnOnBilling.click();
        BrowserUtils.sleep(2);
    }

    @Then("User clicks on Acima Leasing Logo as Payment option")
    public void userClicksOnAcimaLeasingLogoAsPaymentOption() {
        secureCheckOutPage.acimaLeasingLogo.click();
    }

}
