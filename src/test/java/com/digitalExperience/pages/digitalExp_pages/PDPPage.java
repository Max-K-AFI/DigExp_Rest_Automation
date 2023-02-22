package com.digitalExperience.pages.digitalExp_pages;

import com.digitalExperience.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class PDPPage {

    public PDPPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[.='Zardoni Sofa']/h2")
    public WebElement zardoniInPopup;
    @FindBy(css = "button[class='m-auto']>picture>img")
    public WebElement heroImageHolder;
    @FindBy(css = "div[class='hidden md:flex md:flex-col md:flex-auto']>div>picture>img")
    public List<WebElement> imageThumbnailsLg;
    @FindBy(css = "div[class$='flex-row md:hidden ']>div>picture>img")
    public List<WebElement> imageThumbnailsSm;
    @FindBy(css = "div[class$='svelte-1cqoh3x']")
    public WebElement prodDescriptionHolder;
    @FindBy(css = "div[class$='cell--span-1 ']")
    public WebElement thumbnailsLg;
    @FindBy(css = "div[class$='md:hidden ']")
    public WebElement thumbnailSm;
    @FindBy(xpath = "//a[.='Download PDF']")
    public WebElement downloadPDF;
    @FindBy(css = "div[class$='g svelte-1pqt00w']>svg")
    public WebElement XCloseModal;
    @FindBy(css = "p[class$='light text-sm']")
    public List<WebElement> scrollingModalItemsNames;
    @FindBy(css = "p[class='paragraph text-sm']")
    public List<WebElement> scrollingModalItemsPrices;
    @FindBy(xpath = "//p[@class='pt-3'][1]")
    public WebElement prodOverviewDescriptionText;

    @FindBy(xpath = "//h2[.='Added to Cart']")
    public WebElement scrollingModalCartTitle;
    @FindBy(xpath = "//img[@alt='image']")
    public WebElement scrollingModalCartItemImage;
    @FindBy(xpath = "(//p[.='Zardoni Sofa'])[2]")
    public WebElement scrollingModalCartItemName;
    @FindBy(xpath = "//div[@class='grid grid-cols-2 gap-4']//p[2]")
    public WebElement scrollingModalCartItemQty;
    @FindBy(xpath = "//div[@class='grid grid-cols-2 gap-4']//p[3]")
    public WebElement scrollingModalCartItemPrice;
    @FindBy(css = "button[name='View Shopping Cart']")
    public WebElement inCartViewShoppingCartText;
    @FindBy(xpath = "//h2[.='Frequently Bought Together']")
    public WebElement boughtTogetherText;
    @FindBy(css = "img[alt='Image of Couch']")
    public List<WebElement> boughTogetherItemImages;

    @FindBy(css = "p[class$='text-ui-05 ml-4']")
    public WebElement avlblImgNums;
    @FindBy(css = "div[class$='1pqt00w text-lg']")
    public WebElement expandImgIcon;


}
