package com.cydeo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage {

    @FindBy(xpath = "//h2[.='Forgot Password']")
    public WebElement forgotPasswordHeader;

    @FindBy(id = "prependedInput")
    public WebElement usernameOrEmailBox;


    @FindBy(xpath = "//a[.='« Return to Login']")
    public WebElement returnToLoginLink;

    @FindBy(xpath = "//button[.='Request']")
    public WebElement requestButton;

    @FindBy(xpath = "//div[@class='alert alert-warn']")
    public WebElement confirmationMessage;

}
