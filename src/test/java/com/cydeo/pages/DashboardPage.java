package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

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

    @FindBy(xpath = "//input[@placeholder='Username or Email']")
    public WebElement usernamePlaceHolder;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement passwordPlaceHolder;



    public void logout(){
        BrowserUtils.sleep(2);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(fullName));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click()", fullName);
        wait.until(ExpectedConditions.elementToBeClickable(logOutLink));
        js.executeScript("arguments[0].click()", logOutLink);
    }







}
