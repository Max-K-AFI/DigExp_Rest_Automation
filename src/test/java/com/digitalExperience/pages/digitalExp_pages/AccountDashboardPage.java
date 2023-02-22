package com.digitalExperience.pages.digitalExp_pages;

import com.digitalExperience.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountDashboardPage {
    public AccountDashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "button[class$='active  mt-6 ']")
    public WebElement addNewAddressBtn;
    @FindBy(xpath= "(//input[@class='svelte-1x4yuy2'])[3]")
    public WebElement stateDropDown;
    @FindBy(css= "p[class='header-04 font-bold svelte-14ooqda']")
    public WebElement customerGreeting;
    @FindBy(css= "h1[class='header-04 font-bold svelte-14ooqda']")
    public WebElement accountDashboard;
    @FindBy(xpath= "(//button[@type='button'])[11]")
    public WebElement canselBtn;
    @FindBy(xpath= "//button[@type='submit']")
    public WebElement submitAddressBtn;
    @FindBy(xpath= "//p[.='Ashley Tester']")
    public List<WebElement> newCreatedLabelNames;







}
