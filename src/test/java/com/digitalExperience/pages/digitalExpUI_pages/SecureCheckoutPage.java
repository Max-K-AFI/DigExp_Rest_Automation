package com.digitalExperience.pages.digitalExpUI_pages;

import com.digitalExperience.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecureCheckoutPage {

    public SecureCheckoutPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='creditcard-logos']/img[1]")
    public WebElement cclogoimg1;
    @FindBy(xpath = "//div[@class='creditcard-logos']/img[2]")
    public WebElement cclogoimg2;
    @FindBy(xpath = "//label[@id='dwfrm_billing_paymentMethods_creditCard_owner-label']")
    public WebElement label_NameOnCard;
    @FindBy(xpath = "//label[@id='dwfrm_billing_paymentMethods_creditCard_number-label']")
    public WebElement label_CC_number;
    @FindBy(xpath = "//div[@class='expdatemonthfield']/label")
    public WebElement label_expdate;
    @FindBy(xpath = "//div[@class='form-row cvn required']/label")
    public WebElement label_cvv;
    @FindBy(xpath = "(//img[@alt='Ashley Advantage'])[1]")
    public WebElement ashleyAdvtglogoImg;
    @FindBy(xpath = "(//h1[@class='payment-method-title'])[2]")
    public WebElement aatitle;
    @FindBy(xpath = "//div[@class='cc-logos synchrony-logo']")
    public WebElement synchronylogo;
    @FindBy(xpath = "//div[@class='cc-logos genesis-logo']")
    public WebElement genesislogo;
    @FindBy(xpath = "//div[@class='cc-logos gafco-logo']")
    public WebElement gafcologo;
    @FindBy(xpath = "//label[@id='dwfrm_financeterms_cardnumber-label']")
    public WebElement label_aaNumber;
    @FindBy(xpath = "//div[@class='caddi-pay-logo-wrapper']/img")
    public WebElement caddipayLogo;
    @FindBy(xpath = "//div[@class='ashley-finance-logo-wrapper']/img")
    public WebElement acimaLogo;
    @FindBy(xpath = "//img[@alt='Progressive Leasing']")
    public WebElement progressiveLeasingLogo;
    @FindBy(xpath = "//div[@class='progressive-title-container']/h1")
    public WebElement progressiveLeasingTitle;
    @FindBy(css = "div[class*='ashley-financing-phonenumber']")
    public WebElement progresLeasPhnNumb;
    @FindBy(xpath = "//label[@id='dwfrm_financeterms_progressivelastfourdigitsofssn-label']")
    public WebElement lable_pl_SSN4;
    @FindBy(xpath = "//button[@id='view-progressive-offers']/span")
    public WebElement btn_pl_view_dtls;
    @FindBy(css = "div[class$='paypal-billing']")
    public WebElement payPalLogo;
    @FindBy(css = "a[class='paypal-checkout-close']")
    public WebElement payPalWindowClose;
    @FindBy(xpath = "//input[@id='email']")
    public WebElement paypalUserName;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement paypalPassword;
    @FindBy(xpath = "//button[@class='button actionContinue scTrack:unifiedlogin-login-submit']")
    public WebElement paypalLoginBtn;
    @FindBy(xpath = "//button[@id='payment-submit-btn']")
    public WebElement paypalContReviewOrder;
    @FindBy(xpath = "(//div[@class='progressive-modal-box'])[2]/div[@class='content-asset ca-online-only']")
    public WebElement PrgsvPopupMsg;
    @FindBy(xpath = "(//div[@class='progressive-handy-box'])[2]/div[1]")
    public WebElement PrgsvPopupMsg_handy;
    @FindBy(xpath = "(//div[@class='progressive-handy-FPP-box'])[2]/div[1]")
    public WebElement PrgsvPopupMsg_FppHandy;
    @FindBy(xpath = "(//button[@class='primary-alt progressive-acceptance'])[2]")
    public WebElement PrgsvPopupContinueBtn;
    @FindBy(xpath = "(//button[@class='primary-alt progressive-FPP-handy-acceptance'])[2]")
    public WebElement PrgsvPopupContinueBtnFPPHandy;
    @FindBy(xpath = "(//button[@class='primary-alt progressive-handy-acceptance'])[2]")
    public WebElement PrgsvPopupContinueBtnHandy;
    @FindBy(xpath = "//div[@class='font-bold']")
    public WebElement TaxLabelSecureCheckOutBilling;
    @FindBy(xpath = "//td[@class='order-sales-tax-value']")
    public WebElement taxValueSecureCheckoutBilling;
    @FindBy(xpath = "//input[@name='warehouse-zip']")
    public WebElement zipcodevalueBilling;
    @FindBy(xpath = "//tr[@id='order-state-recycling-fee']/td[@class='font-bold']")
    public WebElement recycleFeeLabelBilling;
    @FindBy(xpath = "//tr[@id='order-state-recycling-fee']/td[2]")
    public WebElement recycleFeeValueBilling;


    @FindBy(xpath = "//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_firstName']")
    public WebElement fname;
    @FindBy(xpath = "//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_lastName']")
    public WebElement lname;
    @FindBy(xpath = "//input[@class='input-text address-valid po-box-invalid  required']")
    public WebElement addresstextbox;
    @FindBy(xpath = "//a[@class='address-option ']")
    public WebElement addressOptions;
    @FindBy(xpath = "//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_address1']")
    public WebElement address1;
    @FindBy(xpath = "//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_address2']")
    public WebElement address2;
    @FindBy(xpath = "//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_city']")
    public WebElement city;
    @FindBy(xpath = "//select[@id='dwfrm_singleshipping_shippingAddress_addressFields_states_state']")
    public WebElement state;
    @FindBy(css = "input[id='dwfrm_singleshipping_shippingAddress_addressFields_postal']")
    public WebElement zip;
    @FindBy(xpath = "//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_phone']")
    public WebElement customerphone;
    @FindBy(xpath = "//input[@id='dwfrm_singleshipping_email_emailAddress']")
    public WebElement customeremail;
    @FindBy(xpath = "//button[@class='continue']")
    public WebElement contAsGuest;
    @FindBy(xpath = "//div[@class='oldAddress']/form/button[@class='submit-button']")
    public WebElement useoriginal;
    @FindBy(xpath = "//div[@class='font-bold']")
    public WebElement taxLableSecureChkoutCustInfo;
    @FindBy(xpath = "//td[@class='order-sales-tax-value']")
    public WebElement taxValueSecureChkoutCustInfo;

    @FindBy(xpath = "//button[@id='shipping']")
    public WebElement ContinueBilling;
    @FindBy(xpath = "//div[@class='font-bold']")
    public WebElement TaxLabelSecureCheckOutShipping;
    @FindBy(xpath = "//input[@name='warehouse-zip']")
    public WebElement zipcodevalue;
    @FindBy(xpath = "//tr[@class='order-sales-tax ']/td/div/div[2]")
    public WebElement zipSecureCheckoutShipping;
    @FindBy(xpath = "//td[@class='order-sales-tax-value']")
    public WebElement taxValueSecureCheckoutShipping;
    @FindBy(xpath = "//tr[@id='order-state-recycling-fee']/td[@class='font-bold']")
    public WebElement recycleFeeLabelShipping;
    @FindBy(xpath = "//tr[@id='order-state-recycling-fee']/td[2]")
    public WebElement recycleFeeValueShipping;
    @FindBy(xpath = "//div[@class='mattress-delivery-msg']")
    public WebElement recycleTakeBackMsgShipping;
    @FindBy(xpath = "//label[@for='is-YES']")
    public WebElement takebackRadioBtnYES;
    @FindBy(xpath = "//label[@for='is-NO']")
    public WebElement takebackRadioBtnNO;

    @FindBy(xpath = "//span[@class='sales-order-number-label']")
    public WebElement salesOrderNumber;
    @FindBy(xpath = "((//div[@class='button-wrap-modal'])[3]/button/div)[2]")
    public WebElement PrgsvPopupDiffPayMethodBtn;
    @FindBy(xpath = "//span[@class='ui-button-icon ui-icon ui-icon-closethick']")
    public WebElement PrgsvPopupCloseX;
    @FindBy(xpath = "(//button[@name='submit'])[1]")
    public WebElement placeOrderBtn;
    @FindBy(xpath = "(//div[@class='checkout-menu-title'])[2]")
    public WebElement BP_subtitle;
    @FindBy(xpath = "//div[@class='creditcard-logo-container']")
    public WebElement cclogocontainer;
    @FindBy(xpath = "//img[@alt='AcimaLeasing']")
    public WebElement acimaLeasingLogo;
    @FindBy(xpath = "//button[@class='manual-address-entry']")
    public WebElement manualAddressBtn;
    @FindBy(xpath = "//button[@class='continue']")
    public WebElement continueBtnCkOut;
    @FindBy(xpath = "(//img[@alt='Ashley Advantage'])[1]")
    public WebElement aalogoimg;
    @FindBy(xpath = "//input[@id='dwfrm_financeterms_cardnumber']")
    public WebElement aaAcountNumberfield;
    @FindBy(xpath = "//button[@id='view-available-offers']")
    public WebElement viewFinancingBtn;
    @FindBy(xpath = "//button[@id='btn-step1']")
    public WebElement continueBtnAA;
    @FindBy(xpath = "//button[@class='button primary accept']")
    public WebElement AcceptBtnSynchrony;
    @FindBy(xpath = "//button[@name='dwfrm_addForm_useOrig']")
    public WebElement useAddressAsEntered;
    @FindBy (xpath = "//input[@class='input-text owner special-characters required']")
    public WebElement crediCardNameInputField;
    @FindBy(xpath = "//input[@class='input-text creditcard required']")
    public WebElement crediCardNumberInputField;
    @FindBy(xpath = "//select[@id='dwfrm_billing_paymentMethods_creditCard_expiration_month']")
    public WebElement expDateMonthField;
    @FindBy(xpath = "//select[@id='dwfrm_billing_paymentMethods_creditCard_expiration_year']")
    public WebElement expDateYearField;
    @FindBy(xpath = "//input[@id='dwfrm_billing_paymentMethods_creditCard_cvn']")
    public WebElement cvvField;
    @FindBy(xpath = "//button[@id='billing']")
    public WebElement continueBtnOnBilling;

    @FindBy(css = "iframe[id='iframe']")
    public WebElement acimaIframe;
    @FindBy(css = "input[id='last-four-ssn']")
    public WebElement acimaLast4Ssn;
    @FindBy(css = "button[class='btn btn-block mt-3 ']")
    public WebElement acimaSubmitSsn;
    @FindBy(css = "input[id='view-ssn']")
    public WebElement acimaFullSsn;
    @FindBy(css = "input[id='ssn-confirm']")
    public WebElement acimaFullSsnConfirm;
    @FindBy(xpath = "//button[.='Next']")
    public WebElement acimaNexBtntAfterSsn;
    @FindBy(xpath = "//button[.='Submit']")
    public WebElement acimaSubmit;
    @FindBy(css = "label[class='form-check-label']")
    public WebElement acimaCheckBox;
    @FindBy(css = "input[class='form-control signature-input ']")
    public WebElement acimaCignature;
    @FindBy(css = "button[class='btn btn-block btn-accept ']")
    public WebElement acimaAcceptAndSign;
    @FindBy(css = "input[name='cardNumber']")
    public WebElement acimaCardNumber;
    @FindBy(css = "p[class='section-description']")
    public WebElement acimaNonApproval;

    @FindBy(css = "select[id='credit_card_expMonth']")
    public WebElement acimaCardMonth;
    @FindBy(css = "select[id='credit_card_expYear']")
    public WebElement acimaCardYear;
    @FindBy(css = "div[class='ccservice_cvv_value ccservice_value']")
    public WebElement acimaCardCvv;
    @FindBy(css = "button[class='btn btn-block']")
    public WebElement acimaFinishPayment;



}
