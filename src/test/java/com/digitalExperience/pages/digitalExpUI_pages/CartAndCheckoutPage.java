package com.digitalExperience.pages.digitalExpUI_pages;


import com.digitalExperience.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartAndCheckoutPage {

    public CartAndCheckoutPage(){
     PageFactory.initElements(Driver.getDriver(), this);
}

    @FindBy(xpath = "//button[@class='button-fancy-large desktop-opc']")
    public WebElement placeOrderBtn;

}
