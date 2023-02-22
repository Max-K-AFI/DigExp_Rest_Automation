package com.digitalExperience.step_definitions.digitalExp_steps;

import com.digitalExperience.pages.digitalExpUI_pages.AccountPage;
import com.digitalExperience.pages.digitalExpUI_pages.HomeSmokePage;
import com.digitalExperience.utilities.BrowserUtils;
import com.digitalExperience.utilities.ConfigurationReader;
import com.digitalExperience.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSmokeStepDefs {

    WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    AccountPage accountPage = new AccountPage();
    HomeSmokePage homeSmokePage = new HomeSmokePage();
    String url;

    @Given("User opens expected {string}")
    public void openExpectedURL(String url) {
        if (url.equals("URL")) {
            this.url = System.getProperty("URL", ConfigurationReader.getProperty("URL"));
            if (this.url.contains("staging")) {
                driver.get("https://storefront:afweb2017@staging.ashleyfurniture.com/");
            } else if (this.url.contains("development")) {
                driver.get("https://storefront:afweb2017@development.ashleyfurniture.com/");
            } else {
                String actualUrl = System.getProperty("URL", ConfigurationReader.getProperty("URL"));
                driver.get(actualUrl);
            }
        } else {
            driver.get(url);
        }
        BrowserUtils.waitForPageToLoad(20);
        homeSmokePage.closeIframe();
        homeSmokePage.confirmQMSelection();
        wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));
        String activeUrl = driver.getCurrentUrl();
        Assert.assertFalse(activeUrl.isEmpty());
    }

    @And("User clicks on login link on different views")
    public void clickOnLoginSmoke() {
        String platform = ConfigurationReader.getProperty("platform");
        if (platform.equals("desktop")) {
            BrowserUtils.waitForClickAbility(homeSmokePage.mainLoginLink, Duration.ofSeconds(10));
            BrowserUtils.clickWithJS(homeSmokePage.mainLoginLink);
            BrowserUtils.clickWithJS(homeSmokePage.mainLoginBtn);
        } else if (platform.equals("mobile") || (platform.equals("tablet"))) {
            BrowserUtils.clickWithJS(homeSmokePage.mobileMenu);
            BrowserUtils.clickWithJS(homeSmokePage.mobileLoginBtn);
        } else {
            homeSmokePage.mainLoginLink.click();
            homeSmokePage.mainLoginBtn.click();
        }
    }

    @And("User logs in with {string} and {string} smoke")
    public void loginSmoke(String username, String password) {
        accountPage.login(username, password);
    }

    @Then("User logs in with {string} and {string} mobile skip")
    public void logInWithAndMobileSkip(String username, String password) {
        if (ConfigurationReader.getProperty("platform").equals("desktop") || ConfigurationReader.getProperty("platform").equals("tablet")) {
            accountPage.login(username, password);
        }
    }

    @Then("User should be able to see user dashboard")
    public void verifyUserDashboard() {
        System.out.println("Current title: " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("account"));

    }
}
