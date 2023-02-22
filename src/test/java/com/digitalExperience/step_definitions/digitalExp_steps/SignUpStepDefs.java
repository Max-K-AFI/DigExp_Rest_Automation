package com.digitalExperience.step_definitions.digitalExp_steps;

import com.digitalExperience.pages.digitalExpUI_pages.AccountPage;
import com.digitalExperience.pages.digitalExpUI_pages.HomeSmokePage;
import com.digitalExperience.utilities.BrowserUtils;
import com.digitalExperience.utilities.ConfigurationReader;
import com.digitalExperience.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SignUpStepDefs {
    WebDriver driver = Driver.getDriver();
    HomeSmokePage homeSmokePage = new HomeSmokePage();
    AccountPage signUp = new AccountPage();
    Actions actions = new Actions(driver);

    @When("User clicks on login button")
    public void userClicksOnLoginLink() {
        if (ConfigurationReader.getProperty("platform").equals("desktop")) {
            homeSmokePage.loginButton.click();
        }
        if (ConfigurationReader.getProperty("platform").equals("mobile") || ConfigurationReader.getProperty("platform").equals("tablet")) {
            homeSmokePage.mobileMenu.click();
            homeSmokePage.mobileLoginBtn.click();
        }
    }

    @Then("User then clicks on Login link")
    public void userThenClicksOnLogInLink() {
        if (ConfigurationReader.getProperty("platform").equals("desktop")) {
            homeSmokePage.loginLink.click();
        } else {
            System.out.println("Mobile/Tablet views will skip this step");
        }
    }

    @And("User clicks Create account link")
    public void userClicksCreateAccountLink() {
        if (ConfigurationReader.getProperty("platform").equals("desktop") || ConfigurationReader.getProperty("platform").equals("tablet")) {
            actions.moveToElement(signUp.createAccount).build().perform();
            signUp.createAccount.click();
        }
        if (ConfigurationReader.getProperty("platform").equals("mobile")) {
            signUp.createAccountMobile.click();
        }
    }

    @Then("User enters personal information")
    public void userEnterPersonalInformationWithFollowingData() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.name().username() + "@gmail.com";
        String phone = "4126010000";
        String password = "M1" + faker.name().nameWithMiddle() + "#";
        actions.moveToElement(signUp.passwordNew).build().perform();
        signUp.firstName.sendKeys(firstName);
        signUp.lastName.sendKeys(lastName);
        signUp.email.sendKeys(email);
        signUp.confEmail.sendKeys(email);
        signUp.phone.sendKeys(phone);
        signUp.altPhone.sendKeys(phone);
        signUp.passwordNew.sendKeys(password);
        signUp.confPassword.sendKeys(password);
        BrowserUtils.sleep(1);
    }

    @Then("User confirms age")
    public void userConfirmsAge() {
        signUp.verifyAge.click();
        BrowserUtils.sleep(2);
    }

    @Then("User clicks on Submit button if the Environment is non-production")
    public void userClicksOnSubmitButton() {
        String url = System.getProperty("url", ConfigurationReader.getProperty("url"));
        if (url.contains("staging") || url.contains("development")) {
            signUp.submitForm.click();
            BrowserUtils.waitForPageToLoad(5);
            Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("ashleyfurniture.com/account/"));
        }
    }
}
