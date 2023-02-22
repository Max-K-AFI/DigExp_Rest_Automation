package com.digitalExperience.step_definitions.digitalExp_StepDefs;

import com.digitalExperience.pages.digitalExp_pages.HomePage;
import com.digitalExperience.pages.digitalExp_pages.PDPPage;
import com.digitalExperience.utilities.BrowserUtils;
import com.digitalExperience.utilities.ConfigurationReader;
import com.digitalExperience.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PDPStepDefs {

    WebDriver driver = Driver.getDriver();
    PDPPage pdpPage = new PDPPage();
    HomePage homePage = new HomePage();
    String platform = ConfigurationReader.getProperty("platform");
    Set<String> windowHandles;

    @And("User clicks on {string} link to get instructions")
    public void downloadInstructions(String download) {
        BrowserUtils.waitForVisibility(pdpPage.downloadPDF, Duration.ofSeconds(3));
        BrowserUtils.scrollToElement(pdpPage.downloadPDF);
        homePage.clickOn_A_Link(download);
    }

    @When("User should see new Tab opening with download link")
    public void userBeingTakenToNewTab() {
        BrowserUtils.waitForPageToLoad(10);
        windowHandles = driver.getWindowHandles();
        Assert.assertTrue(windowHandles.size() > 1);
    }

    @When("User clicks on main Zardoni Sofa image")
    public void clickOnMainZardoniSofaImage() {
        BrowserUtils.clickWithJS(pdpPage.heroImageHolder);
    }

    @And("User verifies popup window image includes {string}")
    public void verifyIfSofaImageIsShownInPopupWindow(String expectedImage) {
        BrowserUtils.waitForVisibility(pdpPage.zardoniInPopup, Duration.ofSeconds(3));
        Assert.assertEquals(expectedImage, pdpPage.zardoniInPopup.getText());
    }

    @Then("User verifies title holds: {string}")
    public void verifyTitle(String expectedTitle) {
        String currentTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, currentTitle);
    }

    @When("User verifies by default on page load it will be the first image in the image set")
    public void verifyDefaultImageOnLoad() {
        List<WebElement> tempImages = new ArrayList<>();
        if (platform.equals("mobile")) {
            BrowserUtils.waitForVisibility(pdpPage.thumbnailSm, Duration.ofSeconds(3));
            tempImages.addAll(pdpPage.imageThumbnailsSm);
        } else {
            BrowserUtils.waitForPageToLoad(5);
            tempImages.addAll(pdpPage.imageThumbnailsLg);
        }
        List<WebElement> arrayOfImages = new ArrayList<>();
        BrowserUtils.scrollToElement(pdpPage.heroImageHolder);
        BrowserUtils.verifyElementDisplayed(pdpPage.heroImageHolder);
        for (WebElement eachImage : tempImages) {
            BrowserUtils.scrollToElement(eachImage);
            arrayOfImages.add(eachImage);
        }
        String mainImg = pdpPage.heroImageHolder.getAttribute("src");
        String firstImg = arrayOfImages.get(0).getAttribute("src");
        Assert.assertEquals(mainImg, firstImg);
    }

    /**
     * HeroImage should be located:
     * On DesktopView: on the left of product description
     * On Tablet and MobileViews: on the top of product description
     */
    @When("User verifies the location of Hero image placeholder")
    public void verifyLocationOfHeroImagePlaceholder() {
        int heroImageLocation;
        int prodDescriptionLocation;
        if (platform.equals("desktop")) {
            heroImageLocation = pdpPage.heroImageHolder.getRect().getX();
            prodDescriptionLocation = pdpPage.prodDescriptionHolder.getRect().getX();
            Assert.assertTrue(heroImageLocation < prodDescriptionLocation);
        } else {
            heroImageLocation = pdpPage.heroImageHolder.getRect().getY();
            prodDescriptionLocation = pdpPage.prodDescriptionHolder.getRect().getY();
            Assert.assertTrue(heroImageLocation < prodDescriptionLocation);
        }
    }

    @Then("User verifies the location of image thumbnails")
    public void verifyLocationOfImageThumbnails() {
        int thumbnail, imagePlaceholder;
        if (platform.equals("mobile")) {
            thumbnail = pdpPage.thumbnailSm.getRect().getY();
            imagePlaceholder = pdpPage.heroImageHolder.getRect().getY();
            Assert.assertTrue(thumbnail > imagePlaceholder);
        } else {
            thumbnail = pdpPage.thumbnailsLg.getRect().getX();
            imagePlaceholder = pdpPage.heroImageHolder.getRect().getX();
            Assert.assertTrue(thumbnail < imagePlaceholder);
        }
    }

    @When("User verifies scrolling modal X-close icon and collection name: {string} displayed")
    public void user_verifies_scrolling_modal_fields_icon_and_collection_name(String collectionName) {
        BrowserUtils.waitForVisibility(pdpPage.XCloseModal, Duration.ofSeconds(3));
        Assert.assertTrue(pdpPage.XCloseModal.isDisplayed());
        WebElement collectionElement = driver.findElement(By.xpath("//h2[.='" + collectionName + "']"));
        Assert.assertTrue(collectionElement.isDisplayed());
    }

    @When("User verifies list of product names and prices")
    public void user_verifies_list_of_products_product_names_and_prices() {
        for (WebElement eachName : pdpPage.scrollingModalItemsNames) {
            BrowserUtils.scrollToElement(eachName);
            Assert.assertTrue(BrowserUtils.waitForVisibility(eachName, Duration.ofSeconds(3)).isDisplayed());
        }
        for (WebElement eachPrice : pdpPage.scrollingModalItemsPrices) {
            BrowserUtils.scrollToElement(eachPrice);
            Assert.assertTrue(BrowserUtils.waitForVisibility(eachPrice, Duration.ofSeconds(3)).isDisplayed());
        }
    }

    @Then("User clicks on X-close to close the scrolling modal")
    public void user_clicks_on_to_close_the_scrolling_modal() {
        BrowserUtils.scrollToElement(pdpPage.XCloseModal);
        pdpPage.XCloseModal.click();
    }

    @Given("User clicks on {string} by name")
    public void user_clicks_on(String linkName) {
        WebElement product = driver.findElement(By.name(linkName));
        BrowserUtils.waitForClickAbility(product, Duration.ofSeconds(4));
        product.click();
    }

    @And("User clicks on {string} text link")
    public void userClicksOnProductOverviewText(String linkWithText) {
        BrowserUtils.waitForPageToLoad(5);
        homePage.clickOnLinkWithText(linkWithText);
    }

    @When("User verifies X-close icon, {string} title, {string} title are displayed")
    public void user_verifies_x_close_icon_title_are_displayed(String prodOverview, String description) {
        BrowserUtils.waitForVisibility(pdpPage.XCloseModal, Duration.ofSeconds(3));
        WebElement productOverview = driver.findElement(By.xpath("//h2[.='" + prodOverview + "']"));
        WebElement descriptionElem = driver.findElement(By.xpath("//p[.='" + description + "']"));
        Assert.assertTrue(pdpPage.XCloseModal.isDisplayed());
        Assert.assertTrue(productOverview.isDisplayed());
        Assert.assertTrue(descriptionElem.isDisplayed());
    }

    @When("User verifies Description text is present")
    public void user_verifies_description_text_is_present() {
        BrowserUtils.waitForVisibility(pdpPage.prodOverviewDescriptionText, Duration.ofSeconds(3));
        Assert.assertTrue(pdpPage.prodOverviewDescriptionText.isDisplayed());
    }

    @When("User verifies availability of scrolling modal elements")
    public void userVerifiesAvailabilityOfScrollingModalElements() {
        BrowserUtils.waitForVisibility(pdpPage.scrollingModalCartItemName, Duration.ofSeconds(3));
        Assert.assertTrue(pdpPage.scrollingModalCartTitle.isDisplayed());
        Assert.assertTrue(pdpPage.scrollingModalCartItemImage.isDisplayed());
        Assert.assertTrue(pdpPage.scrollingModalCartItemName.isDisplayed());
        Assert.assertTrue(pdpPage.scrollingModalCartItemQty.isDisplayed());
        Assert.assertTrue(pdpPage.scrollingModalCartItemPrice.isDisplayed());
        Assert.assertTrue(pdpPage.inCartViewShoppingCartText.isDisplayed());
    }

    @When("User verifies frequently bought together title and elements")
    public void userVerifiesFrequentlyBoughtTogetherTitleAndElements() {
        Assert.assertTrue(pdpPage.boughtTogetherText.isDisplayed());
        for (WebElement eachImage : pdpPage.boughTogetherItemImages) {
            BrowserUtils.scrollToElement(eachImage);
            Assert.assertTrue(BrowserUtils.waitForVisibility(eachImage, Duration.ofSeconds(3)).isDisplayed());
        }
        for (WebElement eachName : pdpPage.scrollingModalItemsNames) {
            BrowserUtils.scrollToElement(eachName);
            Assert.assertTrue(BrowserUtils.waitForVisibility(eachName, Duration.ofSeconds(3)).isDisplayed());
        }
        for (WebElement eachPrice : pdpPage.scrollingModalItemsPrices) {
            BrowserUtils.scrollToElement(eachPrice);
            Assert.assertTrue(BrowserUtils.waitForVisibility(eachPrice, Duration.ofSeconds(3)).isDisplayed());
        }
    }

    @When("User verifies presence of available image Numbers and Expand image icon")
    public void userVerifiesPresenceOfAvailableImageNumbersAndExpandImageIcon() {
        Assert.assertTrue(pdpPage.avlblImgNums.isDisplayed());
        Assert.assertTrue(pdpPage.expandImgIcon.isDisplayed());
    }

    @And("User verifies functionality of numbers in set of numbers shown")
    public void userVerifiesFunctionalityOfNumbersInSetOfNumbersShown() {
        Assert.assertTrue(pdpPage.avlblImgNums.getText().contains("of"));
    }

    @And("User verifies clicking on numbers shows correct image from given set of images")
    public void userVerifiesClickingOnNumbersShowsCorrectImageFromGivenSetOfImages() {
        List<WebElement> thumbnails;
        if (ConfigurationReader.getProperty("platform").equals("mobile")) {
            thumbnails = pdpPage.imageThumbnailsSm;
        } else {
            thumbnails = pdpPage.imageThumbnailsLg;
        }
        String totalImagesCount = pdpPage.avlblImgNums.getText();
        int imagesCount = thumbnails.size();
        int shownTotalNum = (Integer.parseInt(totalImagesCount.substring(5).trim()));
        Assert.assertEquals(imagesCount, shownTotalNum);
        int num = 0;
        for (WebElement eachImage : thumbnails) {
            eachImage.click();
            num++;
            int newTotalImgCount = Integer.parseInt(pdpPage.avlblImgNums.getText().substring(0, 2).trim());
            if (num < 10) {
                Assert.assertEquals(newTotalImgCount, num);
            }
        }
    }

    //TODO=============================TODO: ABOVE STEPS ARE FROM OLD APOLLO TEST CASES ====================================


    @When("User verifies thumbnail images set on right of hero image are displayed")
    public void user_verifies_thumbnail_images_set_on_right_of_hero_image_are_displayed() {

    }

    @When("User verifies amount of thumbnail images shown are {int}")
    public void user_verifies_amount_of_thumbnail_images_shown_are(Integer int1) {

    }

    @When("User verifies additional images are shown with {string} under 3rd image")
    public void user_verifies_additional_images_are_shown_with_under_3rd_image(String string) {

    }

    @When("User hovers over on each thumbnail image which changes and shows as Hero image")
    public void user_hovers_over_on_each_thumbnail_image_which_changes_and_shows_as_hero_image() {

    }

    @Then("User clicks on thumbnail image and sees selected image as Hero slot in opened image modal")
    public void user_clicks_on_thumbnail_image_and_sees_selected_image_as_hero_slot_in_opened_image_modal() {

    }


}
