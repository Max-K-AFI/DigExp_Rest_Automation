package com.digitalExperience.pages.digitalExpUI_pages;

import com.digitalExperience.utilities.ConfigurationReader;
import com.digitalExperience.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BaseSmokePage {

    public BaseSmokePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//*[@id='q'])[1]t']")
    public WebElement searchBarLarge;
    @FindBy(xpath = "(//form[@role='search'])[2]")
    public WebElement searchBarSmall;
    @FindBy(xpath = "//div[@class='unbxd-as-popular-product-image-container']")
    public WebElement searchBarResultOne;
    @FindBy(xpath = "//a[@class='mini-cart-link']")
    public WebElement miniCartIcon;
    @FindBy(css = "span[class='minicart-quantity']")
    public WebElement miniCartValue;
    @FindBy(xpath = "(//a[@id='js-local-pricing-link'])[1]")
    public WebElement chooseLocalStore;
    @FindBy(xpath = "//*[@id='zip-code-entry-form']/fieldset/div[2]/button")
    public WebElement zipCodeUpdate;
    @FindBy(xpath = "(//div[@class='local-pricing-zip-code'])[2]")
    public WebElement mobStoreLink;
    @FindBy(xpath = "//input[@id='dwfrm_zipcodeentry_postal']")
    public WebElement zipCodeBox;
    @FindBy(xpath = "//h1[@id='headerText']")
    public WebElement paypalHeader;
    @FindBy(xpath = "//div[@class='navbar-icon']")
    public WebElement closeCaddipayX;
    @FindBy(css = "#desktop-header-search > form > button > svg")
    public WebElement searchIcon;
    @FindBy(xpath = "//a[@class='mini-cart-link']")
    public WebElement backToCartIcon;


    public static class AccountPage {

        public AccountPage() {
            PageFactory.initElements(Driver.getDriver(), this);
        }

        @FindBy(xpath = "//input[@id='dwfrm_login_username']")
        public WebElement email;
        @FindBy(id = "dwfrm_login_password")
        public WebElement password;
        @FindBy(name = "dwfrm_login_login")
        public WebElement loginBtn;

        public void login(String username, String password) {
            if (!username.equalsIgnoreCase("email") && !password.equalsIgnoreCase("password")) {
                this.email.sendKeys(username);
                this.password.sendKeys(password);
            } else {
                this.email.sendKeys(ConfigurationReader.getProperty("email"));
                this.password.sendKeys(ConfigurationReader.getProperty("password"));
            }
            loginBtn.click();
        }

    }
}
