package com.digitalExperience.step_definitions.digitalExp_steps;

import com.digitalExperience.pages.digitalExpUI_pages.BaseSmokePage;
import com.digitalExperience.pages.digitalExpUI_pages.HomePage;
import com.digitalExperience.utilities.BrowserUtils;
import com.digitalExperience.utilities.ConfigurationReader;
import com.digitalExperience.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginStepDefs {

    WebDriver driver = Driver.getDriver();
    BaseSmokePage.AccountPage accountPage = new BaseSmokePage.AccountPage();
    HomePage homePage = new HomePage();
    String platform = ConfigurationReader.getProperty("platform");

    @And("User clicks on login link on different viewports")
    public void clickOnLogin() {
        switch (platform) {
            case "desktop":
            case "tablet":
                homePage.closeIframe();
                break;
            case "mobile":
                BrowserUtils.sleep(5);
                try {
                    if (homePage.iframe.isDisplayed()) {
                        driver.navigate().refresh();
                    }
                } catch (Throwable exc) {
                    System.out.println("IFrame is not shown at headless mode!");
                }
                break;
        }
        switch (platform) {
            case "desktop":
                homePage.mainLoginLink.click();
                homePage.mainLoginBtn.click();
                break;
            case "tablet":
            case "mobile":
                homePage.mobileMenu.click();
                homePage.mobileLoginBtn.click();
                break;
        }
    }

    @And("User logs in with {string} and {string}")
    public void userLogin(String username, String password) {
        accountPage.login(username, password);
    }

    @Then("User should see user dashboard")
    public void verifyUserDashboard() {
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("account"));
    }
}
