package com.digitalExperience.pages.digitalExpUI_pages;

import com.digitalExperience.utilities.BrowserUtils;
import com.digitalExperience.utilities.ConfigurationReader;
import com.digitalExperience.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class HomeSmokePage {

    public HomeSmokePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    WebDriver driver = Driver.getDriver();

    @FindBy(xpath = "//div[*='Log In']")
    public WebElement loginButton;
    @FindBy(xpath = "//a[.='Log in or Create an Account']")
    public WebElement loginLink;
    @FindBy(xpath = "//div[@class='fcopt-offers']//iframe")
    public WebElement iFrame;
    @FindBy(xpath = "//button[@title='Close Dialog']")
    public WebElement closeFrame;
    @FindBy(xpath ="(//a[@data-cgid='furniture'])[1]")
    public WebElement furniture;
    @FindBy(tagName = "a")
    public List<WebElement> allLinks;
    @FindBy(xpath = "//div[@class='closeBtn']")
    public WebElement closeOffer;
    @FindBy(xpath = "//li[@class='unbxd-as-header unbxd-as-popular-product-header'] /strong")
    public WebElement searchSugesstions;

    @FindBy(css = "div[class='account-text-container'] div")
    public WebElement userNameDisplayed;
    @FindBy(xpath = "//span[@class='hamburger-box']")
    public WebElement hamburgerBox;
    @FindBy(xpath = "//a[@class='user-account user-account-registered']")
    public WebElement accountTabMobileView;
    @FindBy(xpath = "//a[@class='user-account-show']")
    public WebElement accountTabOpenMobileView;
    @FindBy(xpath = "//a[@href='/wishlist/']")
    public WebElement accountWishListMobile;
    @FindBy(xpath = "//div[@id='mini-cart'] /div /a")
    public WebElement cartIconDeskTopNew;
    @FindBy(xpath = "//a[@class='mini-cart-link']")
    public WebElement cartIconItemAdded;
    @FindBy(xpath = "//a[@class='mini-cart-link mini-cart-empty']")
    public WebElement cartIconZeroItems;
    @FindBy(xpath = "//span[@class='minicart-quantity']")
    public WebElement miniCartQty;
    @FindBy(xpath = "//a[@class='section-header-note address-create']")
    public WebElement createAddressButton;

//    @FindBy(xpath = "//iframe[contains(@id,'fcopt-offer')]")
//    public WebElement iframe;
//    @FindBy(css = "button[title='Close Dialog']")
//    public WebElement closeFrame;
    @FindBy(css = "button[class='offer-control close '] span")
    public WebElement closeFrameNew;
    @FindBy(css = "li[id='header-user-info']")
    public WebElement mainLoginLink;
    @FindBy(css = "a[class='redesign-button']")
    public WebElement mainLoginBtn;
    @FindBy(tagName = "header")
    public WebElement header;
    @FindBy(tagName = "footer")
    public WebElement footer;
    @FindBy(css = "span[class='hamburger-box']")
    public WebElement mobileMenu;
    @FindBy(xpath = "(//a[@class='user-account'])[2]")
    public WebElement mobileLoginBtn;
    public WebElement countryFlag;

    public void closeIframe() {
        String platform = ConfigurationReader.getProperty("platform");
        try {
            BrowserUtils.waitForVisibility(iFrame, Duration.ofSeconds(10));
            switch (platform) {
                case "desktop":
                case "tablet":
                    driver.switchTo().frame(iFrame);
                    BrowserUtils.clickWithJS(closeFrame);
                    driver.switchTo().defaultContent();
                    break;
                case "mobile":
                    BrowserUtils.sleep(5);
                    if (iFrame.isDisplayed()) {
                        driver.navigate().refresh();
                    }
                    break;
                default:
                    driver.navigate().refresh();
            }
        } catch (Throwable exc) {
            System.out.println("IFrame was not shown!");
        }
    }

    public void confirmQMSelection(){
        if(driver.findElement(By.xpath("//div[@id='ui-id-1']")).isDisplayed()) {
        driver.findElement(By.xpath("(//button[@class='cookie-radio-yes checked']/input[@name=\"Yes\"])[2]")).click();
        driver.findElement(By.xpath("(//div[@id='cookie-modal-btn'])[2]")).click();}
        else{
            System.out.println("QM dialog it not displayed");
        }
    }

//    public void closeIframenew() {
//        BrowserUtils.sleep(1);
//        driver.navigate().refresh();
//        driver.switchTo().frame(iframe);
//        BrowserUtils.scrollToElement(closeFrame);
//        closeFrame.click();
//        driver.switchTo().defaultContent();
//        BrowserUtils.waitForPageToLoad(1);
//    }

    public void verifyBrokenLinks(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
            httpURLConnect.setConnectTimeout(2000);
            httpURLConnect.connect();
            if (httpURLConnect.getResponseCode() > 400) {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - Broken Link");
            } else {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
            }
        } catch (Exception ex) {
        }
    }

    public void footerCategoryClick(String expectedCategory) {
        List<WebElement> categoryName = driver.findElements(By.xpath("//p[@class='flex-auto']"));
        for (WebElement each : categoryName) {
            if (each.getText().equalsIgnoreCase(expectedCategory)) {
                BrowserUtils.clickWithJS(each);
            }
        }
    }

    public void mobileMenuClick() {
        if (mobileMenu.isDisplayed()) {
            System.out.println("Mobile or Tablet view is open");
            try {
                mobileMenu.click();
            } catch (NoSuchElementException ex) {
                System.out.println("Mobile view is displayed, but couldn't click on Menu btn");
            }
        }
    }
}
