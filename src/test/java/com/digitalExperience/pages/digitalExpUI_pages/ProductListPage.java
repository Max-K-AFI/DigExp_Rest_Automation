package com.digitalExperience.pages.digitalExpUI_pages;

import com.digitalExperience.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListPage {
    public ProductListPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@aria-label='Add to Wishlist']")
    public WebElement heartIcon;
    @FindBy(xpath = "//span[@class='as-low-as-period']")
    public WebElement learnHowButton;
    @FindBy(css = "span[class='ui-button-icon ui-icon ui-icon-closethick']")
    public WebElement learnHowButtonClose;
    @FindBy(xpath = "//a[@id='quickviewbutton']")
    public WebElement quickViewTextLink;
    @FindBy(xpath = "//a[@href] /h1")
    public WebElement quickViewProdName;
    @FindBy(xpath = "//button[@title='Add Item to Cart']")
    public WebElement quickViewAddItemToCart;
    @FindBy(xpath = "//i[@class='quickview-next']")
    public WebElement quickViewNextIcon;
    @FindBy(xpath = "//input[@name='plus']")
    public WebElement quickViewIncreaseQty;
    @FindBy(xpath = "//button[@title='Close']")
    public WebElement quickViewClose;
    @FindBy(xpath = "(//span[@class='delivery-msg'])[17]")
    public WebElement learnMorePopUp;
    @FindBy(xpath = "//a[@class='breadcrumb-element clear-all']")
    public WebElement clearAllFilters;
    @FindBy(xpath = "(//div[@class='product-image'])[1]")
    public WebElement firstFoundItemImage;
    @FindBy(xpath = "//a[@class='as-low-as-learn-more']")
    public WebElement asLowAsLearnMore;
    @FindBy(xpath = "//li[@class='current-page']")
    public WebElement currentPageListQty;
    @FindBy(xpath = "//img[@alt='Last page of Results']")
    public WebElement lastPageResults;
    @FindBy(xpath = "//img[@alt='Next page of Results']")
    public WebElement nextPageResults;
    @FindBy(xpath = "//a[@class='pdp-threshold-modal']")
    public WebElement learnMoreOpen;
    @FindBy(xpath = "(//button[@class='ui-button ui-corner-all ui-widget ui-button-icon-only ui-dialog-titlebar-close'])[2]")
    public WebElement learnMoreClose;
    @FindBy(xpath = "//span[@id='ui-id-3']")
    public WebElement learnMorePopUpDeskTop;
    @FindBy(xpath = "//ul[@class='swatches clearfix color']")
    public WebElement avlblColorsInQuickView;

    @FindBy(xpath = "//button[@title='Add Item to Cart']")
    public WebElement quickViewAddItem;

    @FindBy(xpath = "//img[@class='primary-image']")
    public WebElement quickViewHover;
    @FindBy(xpath = "//a[@id='quickviewbutton']")
    public WebElement quickViewButton;
    @FindBy(xpath = "//a[@href] /h1")
    public WebElement quickViewItem;
    @FindBy(xpath = "//div[@class='accordion-menu'] /*[contains(@class,'refinement')]")
    public WebElement filtersPLP;












}
