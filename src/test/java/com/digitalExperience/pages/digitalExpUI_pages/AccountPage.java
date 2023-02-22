package com.digitalExperience.pages.digitalExpUI_pages;

import com.digitalExperience.utilities.ConfigurationReader;
import com.digitalExperience.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    public AccountPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "(//button[@name='dwfrm_login_register'])[2]")
    public WebElement createAccount;

    @FindBy(xpath = "//button[@class='mobile-register-btn hide-for-medium deliverypage-hide']")
    public WebElement createAccountMobile;

    @FindBy(xpath = "//input[@id='dwfrm_profile_customer_firstname']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@id='dwfrm_profile_customer_lastname']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='dwfrm_profile_customer_email']")
    public WebElement email;

    @FindBy(xpath = "//input[@id='dwfrm_profile_customer_emailconfirm']")
    public WebElement confEmail;

    @FindBy(xpath = "//input[@id='dwfrm_profile_customer_phoneMobile']")
    public WebElement phone;

    @FindBy(css = "input[id='dwfrm_profile_customer_phoneHome']")
    public WebElement altPhone;

    @FindBy(xpath = "//input[@id='dwfrm_profile_login_passwordconfirm']")
    public WebElement confPassword;

    @FindBy(xpath = "//label[@id='dwfrm_profile_customer_ageconsent-label']")
    public WebElement verifyAge;

    @FindBy(css = "button[name='dwfrm_profile_confirm']")
    public WebElement submitForm;

    @FindBy(xpath = "//div[.='Hi, Kalla']")
    public WebElement userName;

    @FindBy(xpath = " //font[@class='sticky-top-bar-disclaimer']")
    public WebElement startShop;

    @FindBy(name = "dwfrm_login_login")
    public WebElement loginBtn;

    @FindBy(xpath = "//input[@id='dwfrm_login_username']")
    public WebElement usernameLogin;

    @FindBy(xpath = "//input[@id='dwfrm_profile_login_password']")
    public WebElement passwordNew;

    @FindBy(xpath = "//input[@id='dwfrm_login_password']")
    public WebElement passwordLogin;


    public void login(String username, String password) {
        if (!username.equalsIgnoreCase("username") && !password.equalsIgnoreCase("password")) {
            this.usernameLogin.sendKeys(username);
            this.passwordLogin.sendKeys(password);
        } else {
            this.usernameLogin.sendKeys(ConfigurationReader.getProperty("username"));
            this.passwordLogin.sendKeys(ConfigurationReader.getProperty("password"));
        }
        loginBtn.click();
    }

    @FindBy(xpath = "//input[@id='dwfrm_profile_address_addressid']")
    public WebElement addressNameAdd;

    @FindBy(xpath = " //input[@class='input-text letters-hypen-only no-spaces  required']")
    public WebElement firstNameAddressAdd;

    @FindBy(xpath = "//input[@class='input-text last-name-valid letters-hypen-only no-spaces  required']")
    public WebElement lastNameAddressAdd;

    @FindBy(xpath = "//input[@class='input-text address-valid po-box-invalid  required']")
    public WebElement fullAddressAdd;
    @FindBy(xpath = "//input[@id='dwfrm_profile_address_city']")
    public WebElement cityAddressAdd;
    @FindBy(xpath = "//option[@label='Florida']")
    public WebElement stateAddressAdd;
    @FindBy(xpath = "//select[@id='dwfrm_profile_address_states_state']")
    public WebElement stateSelectionAddressAdd;
    @FindBy(xpath = "//input[@class='input-text numbers-hypen-only  required']")
    public WebElement zipCodeAddressAdd;
    @FindBy(xpath = "//input[@class='input-text  check-phone phone required']")
    public WebElement phoneNumberAddressAdd;
    @FindBy(xpath = " //button[@class='apply-button quaternary']")
    public WebElement applyButtonAddressAdd;
    @FindBy(xpath = "//button[@class='submit-button']")
    public WebElement submitButtonAddressAdd;

}
