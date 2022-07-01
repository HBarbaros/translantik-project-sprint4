package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@id='user-menu']/a")
    public WebElement fullName;

    //@FindBy(xpath = "//a[.='Logout']")
    @FindBy(linkText = "Logout")
    public WebElement logOutLink;

    @FindBy(xpath = "//div[@id='breadcrumb']")
    public WebElement breadcrumb;

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    public WebElement pageHeading;




    public void logout(){
        fullName.click();
        logOutLink.click();
    }





}
