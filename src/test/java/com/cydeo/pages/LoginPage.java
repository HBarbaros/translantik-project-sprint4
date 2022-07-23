package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends BasePage{
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="prependedInput")
    public WebElement userName;

    @FindBy(id="prependedInput2")
    public WebElement password;

    @FindBy(name = "_submit")
    public WebElement submit;

    @FindBy (css = ".btn.btn-primary")
    public List<WebElement> buttons;

    @FindBy (xpath = "//div[@class='alert alert-error']")
    public WebElement alertMessage;

    @FindBy (linkText = "Forgot your password?")
    public WebElement forgotPasswordLink;

    @FindBy (xpath = "//span[@class='custom-checkbox__icon']")
    public WebElement rememberCheckBox;

    @FindBy (xpath = "//span[@class='custom-checkbox__text']")
    public WebElement textOfRememberCheckBox;


    public void login(String userNameStr, String passwordStr) {
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        submit.click();
        // verification that we logged
    }

    public void loginAsStoreManager(){
        String username= ConfigurationReader.getProperty("store_manager_username");
        String pwd=ConfigurationReader.getProperty("store_manager_password");

        userName.sendKeys(username);
        password.sendKeys(pwd);
        submit.click();
    }

}
