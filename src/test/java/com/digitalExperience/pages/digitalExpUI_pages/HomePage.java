package com.digitalExperience.pages.digitalExpUI_pages;

import com.digitalExperience.utilities.BrowserUtils;
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

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    WebDriver driver = Driver.getDriver();

    @FindBy(xpath = "//iframe[contains(@id,'fcopt-offer')]")
    public WebElement iframe;
    @FindBy(xpath = "//span[.='X']")
    public WebElement closeFrame;
    @FindBy(css = "li[id='header-user-info']")
    public WebElement mainLoginLink;
    @FindBy(css = "a[class='redesign-button']")
    public WebElement mainLoginBtn;
    @FindBy(tagName = "header")
    public WebElement header;
    @FindBy(css = "footer[id='footer']")
    public WebElement footer;
    @FindBy(css = "span[class='hamburger-box']")
    public WebElement mobileMenu;
    @FindBy(xpath = "(//a[@class='user-account'])[2]")
    public WebElement mobileLoginBtn;
    @FindBy(xpath = "//div[@class='mdc-layout-grid']//li/a")
    public List<WebElement> subCategoryElems;
    @FindBy(xpath = "//div[contains(@class, '--span-4-sm ')]/a/button")
    public WebElement countryFlag;
    @FindBy(xpath = "//div[@class='hidden w-full justify-between xl:inline-flex']/div/a")
    public List<WebElement> topLevelContainer;
    @FindBy(xpath = "//div[@class='flex'][1]/a")
    public List<WebElement> topLevelCategoriesOnLeft;
    @FindBy(css = "input[placeholder='Enter email address']")
    public WebElement footerEmailBox;
    @FindBy(css = "form[class$='enter  undefined']>button")
    public WebElement footerSignUpBtn;

    @FindBy(xpath = "//button[@aria-label='Toggle Menu']")
    public WebElement tabletMenu;
    @FindBy(xpath = "//p[@class='paragraph']")
    public WebElement storeLocator;
    @FindBy(css = "div[class$='cell--span-4 ']")
    public WebElement topLeftHeaderGrid;
    @FindBy(xpath = "(//span[@class='flex-col flex-auto items-center'])[2]")
    public WebElement storeLocatorMobile;
    @FindBy(css = "div[class='flex']>div")
    public WebElement locatorSearchBar;
    @FindBy(css = "button[type='submit']")
    public WebElement locatorUpdateSearchBtn;
    @FindBy(css = "h2[class='text-base']")
    public WebElement locatorClosestZipCode;
    @FindBy(xpath = "//p[.='store-locator.no-store-found']")
    public WebElement locatorNoStoreFound;



    public void closeIframe() {
        try {
            BrowserUtils.waitForVisibility(iframe, Duration.ofSeconds(5));
            driver.switchTo().frame(iframe);
            BrowserUtils.waitForClickAbility(closeFrame, Duration.ofSeconds(5));
            BrowserUtils.clickWithJS(closeFrame);
            driver.switchTo().defaultContent();
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    public void clickOn_A_Link(String element) {
        String aLinkLocator = "//a[.='"+ element +"']";
        WebElement aLinksElement = Driver.getDriver().findElement(By.xpath(aLinkLocator));
        BrowserUtils.clickWithJS(aLinksElement);
        BrowserUtils.waitForPageToLoad(3);
    }

    public void clickOnLinkWithText(String linkWithText) {
        WebElement textLink = driver.findElement(By.xpath("//*[.='"+linkWithText+"']"));
        BrowserUtils.clickWithJS(textLink);
    }

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
            ex.printStackTrace();
        }
    }
}
