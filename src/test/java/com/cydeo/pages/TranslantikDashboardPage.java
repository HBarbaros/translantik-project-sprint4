package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TranslantikDashboardPage {
    public TranslantikDashboardPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@id='user-menu']/a")
    public WebElement fullName;

    //@FindBy(xpath = "//a[.='Logout']")
    @FindBy(linkText = "Logout")
    public WebElement logOutLink;

    public void logout(){
        fullName.click();
        logOutLink.click();
    }





}
