package com.digitalExperience.step_definitions.digitalExp_StepDefs;

import com.digitalExperience.pages.digitalExp_pages.AccountDashboardPage;
import com.digitalExperience.utilities.BrowserUtils;
import com.digitalExperience.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class AccountDashBoardStepDefs {

    WebDriver driver = Driver.getDriver();
    AccountDashboardPage dashboardPage = new AccountDashboardPage();

    @Given("User verifies {string} customer name and {string} displays")
    public void user_verifies_and_displays_in_lower_case(String expectedGreetingText, String expectedDashboardText) {
        String actualGreeting = dashboardPage.customerGreeting.getText();
        Assert.assertTrue(actualGreeting.contains(expectedGreetingText));
        String actualDashboardText = dashboardPage.accountDashboard.getText();
        Assert.assertEquals(expectedDashboardText, actualDashboardText);
    }

    @Given("User verifies below options displayed as list and as card in columns")
    public void user_verifies_below_displayed_as_list(List<String> listOptions) {
        for (String eachAsListText : listOptions) {
            WebElement asListTextElem = driver.findElement(By.xpath("(//p[.='" + eachAsListText + "'])[1]"));
            if (asListTextElem.getText().equals(eachAsListText)) {
                Assert.assertTrue(asListTextElem.isDisplayed());
            }
        }
        for (String eachAsCardText : listOptions) {
            WebElement asCardTextElem = driver.findElement(By.xpath("(//p[.='" + eachAsCardText + "'])[2]"));
            if (asCardTextElem.getText().equals(eachAsCardText)) {
                Assert.assertTrue(asCardTextElem.isDisplayed());
            }
        }
    }

    @And("User clicks on {string} button")
    public void userClicksOnAddANewAddressButton(String expectedBtn) {
        String submitAddress = dashboardPage.addNewAddressBtn.getText();
        String cancelAddress = dashboardPage.canselBtn.getText();
        System.out.println(cancelAddress);
        if (expectedBtn.equals(submitAddress)) {
            dashboardPage.addNewAddressBtn.click();
        } else if (cancelAddress.equals(expectedBtn)) {
            dashboardPage.canselBtn.click();
        } else {
            Throwable ex = new Exception();
            ex.printStackTrace();
        }
        BrowserUtils.waitForVisibility(dashboardPage.accountDashboard, Duration.ofSeconds(5));
        Assert.assertTrue(dashboardPage.accountDashboard.isDisplayed());
    }

    @Then("User fills up address info with below credentials")
    public void userFillsUpAddressInfoWithBelowCredentials(Map<String, String> values) {
        int i = 0;
        for (String key : values.keySet()) {
            driver.findElement(By.cssSelector("input[id='" + key + "']")).sendKeys(values.get(key));
            i++;
        }
    }

    @And("User chooses state as {string} from dropdown")
    public void userChoosesStateAsFLFromDropdown(String state) {
        dashboardPage.stateDropDown.sendKeys(state + Keys.ENTER);
    }

    @Then("User verifies presence of {string} button and clicks on it")
    public void userVerifiesPresenceOfSubmitButtonAndClicksOnIt(String expectedBtn) {
        WebElement submitElem = dashboardPage.submitAddressBtn;
        WebElement cancelElem = dashboardPage.canselBtn;
        boolean isSubmitDisplayed = submitElem.isDisplayed();
        boolean isCancelDisplayed = cancelElem.isDisplayed();
        if (submitElem.getText().equals(expectedBtn)) {
            Assert.assertTrue(isSubmitDisplayed);
            submitElem.click();
        } else if (cancelElem.getText().equals(expectedBtn)) {
            Assert.assertTrue(isCancelDisplayed);
            cancelElem.click();
        } else {
            Throwable ex = new Exception();
            ex.printStackTrace();
        }
    }

    @Then("User validates if new address has been created with {string} label name")
    public void userValidatesThatNewAddressHasBeenCreated(String name) {
        List<WebElement> labelNames = dashboardPage.newCreatedLabelNames;
        String newLabelName = "";
        for (WebElement eachLabelName : labelNames) {
            if (eachLabelName.getText().equals(name)) {
                newLabelName = eachLabelName.getText();
            }
        }
        Assert.assertEquals(newLabelName, name);
    }

    @Then("User verifies cancelled address entry does not show up with label {string}")
    public void userVerifiesCancelledAddressEntryDoesNotShowUp(String expectedLabel) {
        List<WebElement> labelNames = dashboardPage.newCreatedLabelNames;
        String newLabelName = "";
        for (WebElement eachLabelName : labelNames) {
            if (eachLabelName.getText().equals(expectedLabel)) {
                newLabelName = eachLabelName.getText();
            }
        }
        Assert.assertNotEquals(newLabelName, expectedLabel);
    }
}
