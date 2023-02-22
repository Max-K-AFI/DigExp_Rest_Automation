package com.digitalExperience.step_definitions.digitalExp_steps;

import com.digitalExperience.pages.digitalExpUI_pages.HomePage;
import com.digitalExperience.utilities.BrowserUtils;
import com.digitalExperience.utilities.ConfigurationReader;
import com.digitalExperience.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class FooterItemsStepDefs {

    WebDriver driver = Driver.getDriver();
    HomePage homePage = new HomePage();
    String platform = ConfigurationReader.getProperty("platform");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @When("User scrolls down to footer")
    public void scrollToFooter() {
        wait.until(ExpectedConditions.visibilityOf(homePage.footer));
        BrowserUtils.scrollToElement(homePage.footer);
    }

    @And("If platform is mobile user clicks on below category")
    public void clickOnCategory(List<String> categoryName) {
        if (platform.equals("mobile")) {
            for (String eachCategoryName : categoryName) {
                WebElement categoryElem = driver.findElement(By.xpath("//span[.='" + eachCategoryName + "']"));
                if (categoryElem.getText().equalsIgnoreCase(eachCategoryName)) {
                    BrowserUtils.clickWithJS(categoryElem);
                }
            }
        }
    }

    @Then("User verifies {string} opens {string} page")
    public void verifyFooterSubLinks(String subCategory, String expectedPage) {
        List<WebElement> allSubCatElems = homePage.subCategoryElems;
        for (WebElement eachSubCategory : allSubCatElems) {
            String linkTextName = eachSubCategory.getText();
            if (linkTextName.trim().equalsIgnoreCase(subCategory.trim())) {
                BrowserUtils.clickWithJS(eachSubCategory);
            break;
            }
        }
        wait.until(ExpectedConditions.urlContains(expectedPage));
        String newTabUrl = driver.getCurrentUrl();
        Assert.assertTrue(newTabUrl.toLowerCase().contains(expectedPage.toLowerCase()));
    }

    @When("User clicks on country selector link")
    public void userClicksOnCountrySelectorLink(String countryName) {
        Assert.assertEquals(countryName, homePage.countryFlag.getText());
        homePage.countryFlag.click();
    }

    @Then("User verifies page title includes {string}")
    public void userVerifiesPageTitleIncludes(String expectedTitle) {
        boolean condition;
        String actualTitle = driver.getCurrentUrl().toLowerCase();
        if (actualTitle.contains(expectedTitle)) {
            condition = true;
        } else {
            condition = false;
        }
        Assert.assertTrue(condition);
    }

    @When("User verifies Email entry box exists")
    public void verifyEmailEntryBoxExists() {
        Dimension emailBoxDimension;
        emailBoxDimension = homePage.footerEmailBox.getRect().getDimension();
        Assert.assertTrue(homePage.footerEmailBox.isDisplayed());
        Assert.assertTrue(emailBoxDimension.getWidth() > 0 && emailBoxDimension.getHeight() > 0);
    }

    @Then("User verifies {string} button is shown")
    public void verifySignUpButtIsShown(String signUpBtn) {
        Dimension signUpBtnDimension;
        signUpBtnDimension = homePage.footerSignUpBtn.getRect().getDimension();
        Assert.assertEquals(homePage.footerSignUpBtn.getText().trim(), signUpBtn);
        Assert.assertTrue(signUpBtnDimension.getWidth() > 0 && signUpBtnDimension.getHeight() > 0);

    }
}


